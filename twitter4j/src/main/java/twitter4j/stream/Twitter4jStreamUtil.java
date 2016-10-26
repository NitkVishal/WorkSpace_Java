package twitter4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import machineLearningPro.NaiveBayesClassifier.Classifier;
import machineLearningPro.NaiveBayesClassifier.Model;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter4jStreamUtil{
	
	
	
	public static Classifier<String, String> bayes;
	public static List<String> analysisList;
	
	public static void main(String args[]){
		startStraming();
//		Scanner scan = new Scanner(System.in);
//		startStraming();
//		while(true){
//			System.out.println("1 for print");
//			scan.nextInt();
//			refreshList();
//		}
	}
	
	
	public static void refreshList(){
		System.out.println(analysisList);
		analysisList.clear();
	}
	
	public static void startStraming(){
		 TwitterStream twitterStream = new TwitterStreamFactory(configuration().build()).getInstance();
		 
		 twitterStream.addListener(new StatusListener() {
			
			public void onException(Exception ex) {
				// TODO Auto-generated method stub
				
			}
			
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStatus(Status status) {
				String testData = status.getText().toString();
//				System.out.println(testData);
				KafkaOutChannel.writeToKafka(testData, "TopicPub");
			}
			
			public void onStallWarning(StallWarning warning) {
				// TODO Auto-generated method stub
				
			}
			
			public void onScrubGeo(long userId, long upToStatusId) {
				// TODO Auto-generated method stub
				
			}
			
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				// TODO Auto-generated method stub
				
			}
		});

		 
		 FilterQuery tweetFilterQuery = new FilterQuery();
		 tweetFilterQuery.language(new String[]{"en"});
		 tweetFilterQuery.track(new String[]{"modi", "india","cricket"});
		 tweetFilterQuery.language(new String[]{"en"});
		 twitterStream.filter(tweetFilterQuery);
	}
	
	public static ConfigurationBuilder configuration(){
		 ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
	        configurationBuilder.setOAuthConsumerKey("cth5PNmAdAYpzatXQiheJseB7")
	                .setOAuthConsumerSecret("TPoTw0jy7kk5LFYLSEbZtSybUG10vqaiqxS7TnSdfQMGHyLbI0")
	                .setOAuthAccessToken("1571251572-T4co74z62n99mzYwqHF7hYThS516bRboaQ6nnZG")
	                .setOAuthAccessTokenSecret("eInmdomcyjji6WISMkANH12fzsDZMNs5skt6IijrCqtq8");
	        return configurationBuilder;
	 }
}