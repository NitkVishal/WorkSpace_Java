package spark.streaming;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.twitter.TwitterUtils;

import twitter4j.Status;
import twitter4j.api.TweetsResources;

public class twittertag {
	public static void main(String args[]){
		System.setProperty("twitter4j.oauth.consumerKey", "cth5PNmAdAYpzatXQiheJseB7");
		System.setProperty("twitter4j.oauth.consumerSecret", "TPoTw0jy7kk5LFYLSEbZtSybUG10vqaiqxS7TnSdfQMGHyLbI0");
		System.setProperty("twitter4j.oauth.accessToken", "1571251572-T4co74z62n99mzYwqHF7hYThS516bRboaQ6nnZG");
		System.setProperty("twitter4j.oauth.accessTokenSecret", "eInmdomcyjji6WISMkANH12fzsDZMNs5skt6IijrCqtq8");
		
		
		SparkConf conf=new SparkConf().setMaster("local[*]").setAppName("PopularTweets");
		JavaStreamingContext jsc=new JavaStreamingContext(conf,Durations.seconds(1));
		String[] query="modi,cricket,india".split(",");
		
		JavaDStream<Status> tweets = TwitterUtils.createStream(jsc, query);
		
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
//	  tweets.print();
	  status.print();
//	  hashTags.print();
	}
	
}