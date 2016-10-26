package demoStreaming.TwitterSentiment;

import java.util.Arrays;

import org.apache.kafka.common.message.KafkaLZ4BlockOutputStream;
import org.apache.spark.SparkConf;import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.twitter.TwitterUtils;

import scala.language;
import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.api.TweetsResources;

public class TwitterStreaming {
	public static void main(String args[]){
		System.setProperty("twitter4j.oauth.consumerKey", "cth5PNmAdAYpzatXQiheJseB7");
		System.setProperty("twitter4j.oauth.consumerSecret", "TPoTw0jy7kk5LFYLSEbZtSybUG10vqaiqxS7TnSdfQMGHyLbI0");
		System.setProperty("twitter4j.oauth.accessToken", "1571251572-T4co74z62n99mzYwqHF7hYThS516bRboaQ6nnZG");
		System.setProperty("twitter4j.oauth.accessTokenSecret", "eInmdomcyjji6WISMkANH12fzsDZMNs5skt6IijrCqtq8");
		
		
		SparkConf conf=new SparkConf().setMaster("local[*]").setAppName("PopularTweets");
		JavaStreamingContext jsc=new JavaStreamingContext(conf,Durations.seconds(1));
		String[] query="modi,india,cricket,j&k".split(",");
		FilterQuery tweetFilterQuery = new FilterQuery(); 
		 tweetFilterQuery.track(new String[]{"modi", "india","cricket"});
		 tweetFilterQuery.language(new String[]{"en"});
		JavaDStream<Status> tweets = TwitterUtils.createStream(jsc, query).filter(new Function<Status, Boolean>() {
			public Boolean call(Status arg0) throws Exception {
				if (!arg0.getLang().equals("en"))
					return false;
				else return true;
				
			}
		});
		
		JavaDStream<String> status = tweets.map(new Function<Status, String>() {
			public String call  (Status status) {
				
				return status.getText();
			}
		});
		
		new TweetTransformation(tweets);
//		tweets.print();
		jsc.start();
		jsc.awaitTermination();
		
	}
	
	
}

class TweetTransformation{
	public static JavaDStream<Status> tweets;
	public TweetTransformation  (JavaDStream<Status> tweets){
		this.tweets = tweets;
		getTextFromTweet();
	}
	
	public static void getTextFromTweet(){
		JavaDStream<String> status = tweets.map(new Function<Status, String>() {
			public String call  (Status status) {
				
				return status.getText();
			}
		}); 
		
	  JavaDStream<String> words = status.flatMap(new FlatMapFunction<String, String>() {
		  public Iterable<String> call (String in){
			  return Arrays.asList(in.split(" "));
		  }
	   });
	  
	  JavaDStream<String> hashTags = words.filter(new Function<String, Boolean>() {
		  public Boolean call (String word){
		  return word.startsWith("#");}
	   });
	  
//	  tweetsets.print();
	  status.print();
//	  hashTags.print();
	}
}