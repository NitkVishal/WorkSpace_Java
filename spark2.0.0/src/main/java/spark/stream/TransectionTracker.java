package spark.stream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class TransectionTracker {
	public static void main(String args[]) throws InterruptedException{
		run();
	}
	public static JavaReceiverInputDStream<String> lines;
	public static void run() throws InterruptedException{
		 SparkConf sparkConf = new SparkConf().setAppName("JavaSqlNetworkWordCount").setMaster("local[*]");
		    JavaStreamingContext jsc = new JavaStreamingContext(sparkConf, Durations.seconds(1));
		    lines = jsc.socketTextStream("localhost", 9999, StorageLevels.MEMORY_AND_DISK_SER);
		    
		    JavaDStream<String> wiDStream = lines.window(Durations.seconds(10),Durations.seconds(1));
		    
		    List<StructField> fields = new ArrayList<StructField>();
		    fields.add(DataTypes.createStructField("accountnumber", DataTypes.LongType, true));
		    fields.add(DataTypes.createStructField("transectionid", DataTypes.LongType, true));
		    fields.add(DataTypes.createStructField("amount", DataTypes.LongType, true));
		    fields.add(DataTypes.createStructField("acctype", DataTypes.StringType, true));
		    fields.add(DataTypes.createStructField("channel", DataTypes.StringType, true));
		    fields.add(DataTypes.createStructField("location", DataTypes.StringType, true));
		    fields.add(DataTypes.createStructField("timestamp", DataTypes.TimestampType, true));
		    final StructType schema = DataTypes.createStructType(fields);
		    
		    
		    wiDStream.foreachRDD(new VoidFunction<JavaRDD<String>>() {
				
				public void call(JavaRDD<String> rdd) throws Exception {
					JavaRDD<Row> rowRdd = rdd.map(new Function<String, Row>() {

						public Row call(String nodeStr) throws Exception {
							String node [] = nodeStr.split(",");
							Long accountnumber = Long.parseLong(node[0].substring(node[0].indexOf(":")+1));
							Long transectionid = Long.parseLong(node[1].substring(node[1].indexOf(":")+1));
							Long amount = Long.parseLong(node[2].substring(node[2].indexOf(":")+1));
					    	String accType = node[3].substring(node[3].indexOf(":")+1);
					    	String channel= node[4].substring(node[4].indexOf(":")+1);
					    	String geolocation= node[5].substring(node[5].indexOf(":")+1);
					    	SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
					    	Date date = fromUser.parse(node[6].substring(node[6].indexOf(":")+1));
					    	java.sql.Timestamp sqlTimestamp= new java.sql.Timestamp(date.getTime()); 
					    	Row row  = new RowFactory().create(accountnumber,transectionid,amount,accType,channel,geolocation,sqlTimestamp);
							return row;
						}
					});
					SQLContext sqlContext = JavaSQLContextSingleton.getInstance(rdd.context());
					Dataset<Row> dataFrame = sqlContext.createDataFrame(rowRdd, schema);
					dataFrame.createOrReplaceTempView("mytable");
					Dataset<Row> sql = sqlContext.sql("SELECT SUM(amount) FROM mytable ");
					sql.foreach(new ForeachFunction() {
						public void call(Object arg0) throws Exception {
							KafkaOutChannel.writeToKafka(arg0.toString()+"["+System.currentTimeMillis()+"]", "MyTopic");
						}
					});
				}
			});
		    
		    jsc.start();
		    jsc.awaitTermination();
	}
}
