/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package streaming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction2;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.Time;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public final class JavaSqlNetworkWordCount {
  private static final Pattern SPACE = Pattern.compile(" ");

  public static void main(String[] args) throws Exception {
    SparkConf sparkConf = new SparkConf().setAppName("JavaSqlNetworkWordCount").setMaster("local[*]");
    JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(1));

    JavaReceiverInputDStream<String> lines = ssc.socketTextStream(
        "localhost", 9999, StorageLevels.MEMORY_AND_DISK_SER);
    JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
      public Iterator<String> call(String x) {
        return Arrays.asList(SPACE.split(x)).iterator();
      }
    });

    words.foreachRDD(new VoidFunction2<JavaRDD<String>, Time>() {
      public void call(JavaRDD<String> rdd, Time time) {
        SparkSession spark = JavaSparkSessionSingleton.getInstance(rdd.context().getConf());

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
      instance = SparkSession
        .builder()
        .config(sparkConf)
        .getOrCreate();
    }
    return instance;
  }
}
