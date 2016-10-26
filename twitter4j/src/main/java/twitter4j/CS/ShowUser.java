package twitter4j.CS;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;


public final class ShowUser {
    
    public static void main(String[] args) {
        

    	
        try {
        	Twitter twitter = new TwitterFactory().getInstance();
        	twitter.setOAuthConsumer(Configigration.consumerKey, Configigration.consumerSecret);
        	twitter.setOAuthAccessToken(new AccessToken(Configigration.accessToken, Configigration.accessTokenSecret));
        	User user = twitter.showUser("narendramodi");
            User user2  = twitter.showUser("vishalbabu01");
            twitter.updateStatus("Hello World @vishalbabu01");
            if (user.getStatus() != null) {
                System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
                System.out.println(user.getId());
                System.out.println(user2.getId());
            } else {
                // the user is protected
                System.out.println("@" + user.getScreenName());
            }
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to delete status: " + te.getMessage());
            System.exit(-1);
        }
    }
}