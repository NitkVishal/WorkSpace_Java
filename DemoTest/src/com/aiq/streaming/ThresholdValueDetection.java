package com.aiq.streaming;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hadoop.hdfs.server.namenode.status_jsp;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.DataFrame;
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

public class ThresholdValueDetection {
	public static void main(String args[]){
		run();
	}
	public static JavaReceiverInputDStream<String> lines;
	public static void run(){
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
		    fields.add(DataTypes.createStructField("timestamp", DataTypes.TimestampType, true));
		    final StructType schema = DataTypes.createStructType(fields);
		    
		    
		    wiDStream.foreachRDD(new Function<JavaRDD<String>, Void>() {
				public Void call(JavaRDD<String> rdd) throws Exception {
					JavaRDD<Row> rowRdd  = rdd.map(new Function<String, Row>() {
						public Row call(String nodeStr) throws Exception {
							
							String node [] = nodeStr.split(",");
							Long accountnumber = Long.parseLong(node[0].substring(node[0].indexOf(":")+1));
							Long transectionid = Long.parseLong(node[1].substring(node[1].indexOf(":")+1));
							Long amount = Long.parseLong(node[2].substring(node[2].indexOf(":")+1));
					    	String accType = node[3].substring(node[3].indexOf(":")+1);
					    	String channel= node[4].substring(node[4].indexOf(":")+1);
					    	SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
					    	Date date = fromUser.parse(node[5].substring(node[5].indexOf(":")+1));
					    	java.sql.Timestamp sqlTimestamp= new java.sql.Timestamp(date.getTime()); 
					    	Row row  = new RowFactory().create(accountnumber,transectionid,amount,accType,channel,sqlTimestamp);
							return row;
						}
					});
					
					SQLContext sqlContext = JavaSQLContextSingleton.getInstance(rdd.context());
					DataFrame dataFrame = sqlContext.createDataFrame(rowRdd, schema);
					dataFrame.registerTempTable("mytable");
//					dataFrame.show();
					
//					DataFrame sql = sqlContext.sql("SELECT MAX(timestamp) mx, min(timestamp) mn, count(timestamp) cnt from mytable");
//					DataFrame sql = sqlContext.sql("SELECT SUM(amount) from mytable");
					
//					SELECT * FROM mytable WHERE accountnumber IN ( SELECT accountnumber FROM mytable GROUP BY accountnumber HAVING COUNT(*) > 1 )
					
					DataFrame sql = sqlContext.sql("SELECT * FROM mytable  WHERE accountnumber IN ( SELECT accountnumber FROM mytable )");
					sql.show();
//					
//					
//					sql.javaRDD().foreach(new VoidFunction<Row>() {
//						
//						@Override
//						public void call(Row rowStr) throws Exception {
//							System.out.println(rowStr.toString());
////							KafkaOutChannel.writeToKafka(rowStr.toString(), "MyTopic");
//							
//						}
//					});
					System.out.println("This is Count");
					return null;
				}
			});
		    jsc.start();
		    jsc.awaitTermination();
	}
}


//class Analysis{
//	public static  String  fraudTransection(String node){
//		
//	}
//}