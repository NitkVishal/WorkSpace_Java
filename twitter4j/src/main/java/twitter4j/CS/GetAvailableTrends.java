package twitter4j.CS;

import twitter4j.*;
import twitter4j.auth.AccessToken;


public final class GetAvailableTrends {
   
    public static void main(String[] args) {
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(Configigration.consumerKey, Configigration.consumerSecret);
        	twitter.setOAuthAccessToken(new AccessToken(Configigration.accessToken, Configigration.accessTokenSecret));
            
            ResponseList<Location> locations;
            locations = twitter.getAvailableTrends();
            System.out.println("Showing available trends");
            for (Location location : locations) {
                System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
            }
            System.out.println("done.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            System.exit(-1);
        }
    }
}