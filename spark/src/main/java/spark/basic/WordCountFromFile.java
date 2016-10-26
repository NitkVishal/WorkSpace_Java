package spark.basic;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class WordCountFromFile {
	private static JavaSparkContext sc;

	public static void main(String args[]){
		SparkConf config = new SparkConf().setAppName("NetworkWordCount").setMaster("local");
		sc = new JavaSparkContext(config);
		JavaRDD<String> lines = sc.textFile("/home/augment/AIQ_DataScience/Links.txt");
		
		JavaRDD<String> words = lines.flatMap( new FlatMapFunction<String, String>() {
		    public Iterable<String> call(String s) {
		    	return Arrays.asList(s.split(" "));
		    }
		  }
		);
		System.out.println("No Of words in file....."+words.count()+"............"+words.collect());
		
		JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
			public Tuple2<String, Integer> call(String s) {
			      return new Tuple2<String, Integer>(s, 1);
			    }
		});
		
		JavaPairRDD<String, Integer> counter = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
			public Integer call(Integer v1, Integer v2) throws Exception {
				return v1 +v2;
			}
		});
		System.out.println("After Reducer...."+ counter.count() +"..."+counter.collect());
	}
}
