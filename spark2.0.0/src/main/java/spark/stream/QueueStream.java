
package spark.stream;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import scala.Tuple2;

import com.google.common.collect.Lists;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public final class QueueStream {
  private QueueStream() {
  }

  public static void main(String[] args) throws Exception {

    SparkConf sparkConf = new SparkConf().setAppName("JavaQueueStream").setMaster("local[*]");

    JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, new Duration(1000));

    Queue<JavaRDD<Integer>> rddQueue = new LinkedList<JavaRDD<Integer>>();

    List<Integer> list = Lists.newArrayList();
    for (int i = 0; i < 1000; i++) {
      list.add(i);
    }

    for (int i = 0; i < 30; i++) {
      rddQueue.add(ssc.sparkContext().parallelize(list));
    }

    JavaDStream<Integer> inputStream = ssc.queueStream(rddQueue);
    JavaPairDStream<Integer, Integer> mappedStream = inputStream.mapToPair(
        new PairFunction<Integer, Integer, Integer>() {
          public Tuple2<Integer, Integer> call(Integer i) {
            return new Tuple2(i, 1);
          }
        });
    JavaPairDStream<Integer, Integer> reducedStream = mappedStream.reduceByKey(
      new Function2<Integer, Integer, Integer>() {
        public Integer call(Integer i1, Integer i2) {
          return i1 + i2;
        }
    });

    reducedStream.print();
    ssc.start();
    ssc.awaitTermination();
  }
}
