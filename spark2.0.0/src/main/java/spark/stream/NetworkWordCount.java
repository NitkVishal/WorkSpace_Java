
package spark.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

import scala.Tuple2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public final class NetworkWordCount {
  private static final Pattern SPACE = Pattern.compile(" ");

  public static void main(String[] args) throws Exception {
	  SparkConf sparkConf = new SparkConf().setAppName("JavaNetworkWordCount").setMaster("local[*]");
	  JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(1));

	  JavaReceiverInputDStream<String> lines = ssc.socketTextStream(
            "localhost", 9999, StorageLevels.MEMORY_AND_DISK_SER);
	  JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
      public Iterator<String> call(String x) {
        return Arrays.asList(SPACE.split(x)).iterator();
      }
    });
    JavaPairDStream<String, Integer> wordCounts = words.mapToPair(
      new PairFunction<String, String, Integer>() {
        public Tuple2<String, Integer> call(String s) {
          return new Tuple2(s, 1);
        }
      }).reduceByKey(new Function2<Integer, Integer, Integer>() {
        public Integer call(Integer i1, Integer i2) {
          return i1 + i2;
        }
      });
    wordCounts.saveAsHadoopFiles("wordcount", ".txt");
    wordCounts.print();
    //wordCounts.save
    ssc.start();
    ssc.awaitTermination();
  }
}
