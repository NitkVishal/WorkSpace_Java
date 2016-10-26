
package spark.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction2;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.Time;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public final class SqlNetworkWordCount {
  private static final Pattern SPACE = Pattern.compile(" ");

  public static void main(String[] args) throws Exception {
    SparkConf sparkConf = new SparkConf().setAppName("JavaSqlNetworkWordCount").setMaster("local[*]");
    JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
    JavaReceiverInputDStream<String> lines = ssc.socketTextStream("localhost", 9999, StorageLevels.MEMORY_AND_DISK_SER);
    JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
      public Iterator<String> call(String x) {
        return Arrays.asList(SPACE.split(x)).iterator();
      }
    });
    
    
    
    
    words.foreachRDD(new VoidFunction2<JavaRDD<String>, Time>() {
      public void call(JavaRDD<String> rdd, Time time) {
        SparkSession spark = JavaSparkSessionSingleton.getInstance(rdd.context().getConf());
//        
//        String schemaString = "name";
//        List< StructField> fields = new ArrayList<StructField>(); 
//        fields.add(DataTypes.createStructField("name", DataTypes.StringType, true));
////        for(String fieldname : schemaString.split(" ")){
////	    	fields.add(DataTypes.createStructField(fieldname, DataTypes.StringType, true));
////	    }
//        
//        StructType schema = DataTypes.createStructType(fields);
//        
//        JavaRDD<Row> row = rdd.map(new Function<String, Row>() {
//        	public Row call (String records){
//        		String[] fields  = records.split(",");
//        		return RowFactory.create(fields[0], fields[1].trim());
//        	}
//        });
//        
//        Dataset<Row> wordsDataFrame = spark.createDataFrame(row, schema);
//        wordsDataFrame.createOrReplaceTempView("words");
//        DataFrame peopleDataFrame = sqlContext.createDataFrame(rowRDD, schema);
        JavaRDD<JavaRecord> rowRDD = rdd.map(new Function<String, JavaRecord>() {
          public JavaRecord call(String word) {
            JavaRecord record = new JavaRecord();
            record.setWord(word);
            return record;
          }
        });
        
        
        
        Dataset<Row> wordsDataFrame = spark.createDataFrame(rowRDD, JavaRecord.class);
        wordsDataFrame.createOrReplaceTempView("words");

        Dataset<Row> wordCountsDataFrame =
            spark.sql("select word, count(*) as total from words group by word");
        System.out.println(time + "..........................");
        wordCountsDataFrame.show();
      }
    });

    
    ssc.start();
    ssc.awaitTermination();
  }
}

class JavaSparkSessionSingleton {
  private static transient SparkSession instance = null;
  public static SparkSession getInstance(SparkConf sparkConf) {
    if (instance == null) {
      instance = SparkSession.builder().config(sparkConf).getOrCreate();
    }
    return instance;
  }
}



   class Person implements Serializable {
	  private String name;
	  private int age;

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public int getAge() {
	    return age;
	  }

	  public void setAge(int age) {
	    this.age = age;
	  }
}