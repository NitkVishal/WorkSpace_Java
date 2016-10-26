package emailrAndD.twitter;


import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TrackTweet{
	public static void main(String args[]){
		track();
	}
	
	
	public static void track(){
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
				System.out.println(status.getUser());
				System.out.println(status.getId());
				System.out.println(testData);
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
		 tweetFilterQuery.track(new String[]{"@vishalbabu01", "augmentIq","vishal Babu"});
		 tweetFilterQuery.follow(new long[] { 1571251572 });
		 twitterStream.filter(tweetFilterQuery);
	}
	
	public static ConfigurationBuilder configuration(){
		 ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
	        configurationBuilder.setOAuthConsumerKey(Configigration.consumerKey)
	                .setOAuthConsumerSecret(Configigration.consumerSecret)
	                .setOAuthAccessToken(Configigration.accessToken)
	                .setOAuthAccessTokenSecret(Configigration.accessTokenSecret);
	        return configurationBuilder;
	 }
}