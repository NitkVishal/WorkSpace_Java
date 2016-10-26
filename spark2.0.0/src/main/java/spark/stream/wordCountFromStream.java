package spark.stream;

import java.sql.Time;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;


class reciverDetails{
	String hostName;
	int  port;
}

public class wordCountFromStream {
	public static void main(String args[]) throws InterruptedException{
		Scanner scan = new Scanner(System.in);
//		System.out.println("Press \n1 For Default \n2 for manual confi");
//		int x= scan.nextInt();
		SparkConf config  = new SparkConf().setAppName("TCP/IP LocalHost").setMaster("local[*]");
		JavaStreamingContext jsc = new JavaStreamingContext(config,Durations.seconds(2));
		JavaReceiverInputDStream<String> lines = null;
		JavaReceiverInputDStream<String> lines1 = null;
		lines = jsc.socketTextStream("localhost",9999, StorageLevels.MEMORY_AND_DISK_SER);
		lines1= jsc.socketTextStream("192.168.1.147", 9999, StorageLevels.MEMORY_AND_DISK_SER);
		new serialized(lines1);
		new serialized(lines);
//		if(x==2){
//			System.out.println("Enter No of reciver");
//			int listener = scan.nextInt();
//			config  = new SparkConf().setAppName("TCP/IP LocalHost").setMaster("local["+listener+1+"]");
//			for(int i=0;i<listener;i++){
//				System.out.println("Enter hostname and port for reciver "+i);
//				String hostname = scan.next();
//				int port = scan.nextInt();
//				lines = jsc.socketTextStream(hostname,port, StorageLevels.MEMORY_AND_DISK_SER);
//				new serialized(lines);
//			}
//		} else {
//			lines = jsc.socketTextStream("localhost", 9999, StorageLevels.MEMORY_AND_DISK_SER);
//			new serialized(lines);
////			jsc.socketTextStream("192.168.1.126", 12345, StorageLevels.MEMORY_AND_DISK_SER);
////			new serialized(lines);
//		}
//		
//		
		
		
		
//		JavaReceiverInputDStream<String> lines = jsc.socketTextStream("localhost", 9999, StorageLevels.MEMORY_AND_DISK_SER);
//
//		serialized srl = new serialized(lines);	

		
		
		//		JavaReceiverInputDStream<String> AdityaPC = jsc.socketTextStream("192.168.1.126", 12345, StorageLevels.MEMORY_AND_DISK_SER);
//		
//		JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
//			public Iterable<String> call(String x){
//				return Arrays.asList(x.split(" "));
//			}
//		});
//		
//		JavaDStream<String> Awords = AdityaPC.flatMap(new FlatMapFunction<String, String>() {
//			public Iterable<String> call(String x){
//				return Arrays.asList(x.split(" "));
//			}
//		});
//		
//		JavaPairDStream<String, Integer> pairs  = words.mapToPair(new PairFunction<String, String, Integer>() {
//			public Tuple2<String, Integer> call(String s){
//				return new Tuple2<String, Integer>(s,1);
//			}
//		});
//		
//		JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
//			public Integer call(Integer v1, Integer v2) throws Exception {
//				return v1+v2;
//			}
//		});
		
	/*	wordCountFromStream wcfs = new wordCountFromStream();
		JavaDStream<String> wordsOops  = wcfs.getWordsDStream(lines);
		JavaPairDStream<String, Integer> pairsOops = wcfs.getPairDStream(wordsOops);
		JavaPairDStream<String, In1
		teger> wordsCountOOPS =wcfs.getWordCount(pairsOops); 
 	*/	
		
//		jsc.textFileStream("/home/augment/AIQ_DataScience/Viiii.txt"); /// For reading the file from the streaming and save the your local location ...
//		wordsCountOOPS.print();
//		wordCounts.print();
//	    Awords.print();
		
	    jsc.start();
	    jsc.awaitTermination();
		
	}
}


   class serialized {
	 private static  JavaReceiverInputDStream<String> lines;
	 private static final Pattern SPACE = Pattern.compile(" ");
	 public serialized(JavaReceiverInputDStream<String> lines) {
		 this.lines = lines;
		 compute();
	 }
	 
	 private static void compute (){
		 JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			 public Iterator<String> call(String x) {
			        return Arrays.asList(SPACE.split(x)).iterator();
			      }
			});
		 
		 JavaPairDStream<String, Integer> pairs  = words.mapToPair(new PairFunction<String, String, Integer>() {
				public Tuple2<String, Integer> call (String s){
					return new Tuple2<String, Integer>(s,1);
				}
			});
		 JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
				public Integer call(Integer v1, Integer v2) throws Exception {
					return v1+v2;
				}
			});
		 
		 
//		  30 second window..t up
		 
//		 Function2<Integer, Integer, Integer> reduceFunc = new Function2<Integer, Integer, Integer>() {
//			 public Integer call(Integer i1, Integer i2) {
//			    return i1 + i2;
//			  }
//			};
//		 JavaPairDStream<String, Integer> windowedWordCounts = pairs.reduceByKeyAndWindow(reduceFunc, Durations.seconds(20), Durations.seconds(10));
//		 
//		 windowedWordCounts.print();
		wordCounts.print();
//		 wordCounts.saveAsHadoopFiles("test", "txt");
//		 saveRDD(wordCounts);
		 wordCounts.print();
			
		
	 }
	 
//	 public static void saveRDD(JavaPairDStream<String, Integer>wordCounts ){
//		 wordCounts.saveAsHadoopFiles("chak", ".txt");
//	 }
}
