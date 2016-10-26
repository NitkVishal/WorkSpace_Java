package emailrAndD.twitter;



import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public final class creatTweet {
    
    public static void main(String[] args) {
    	System.out.println(tweet("vishalbabu01", "Test8"));
    }
    
    public static String tweet (String user, String message){
    	Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(Configigration.consumerKey, Configigration.consumerSecret);
    	twitter.setOAuthAccessToken(new AccessToken(Configigration.accessToken, Configigration.accessTokenSecret));
    	if (!user.startsWith("@"))
    		user = "@"+user;
    	try {
    		twitter.updateStatus(user+"  "+ message);
    		return "Done";
		} catch (TwitterException te) {
			return te.getMessage();
		}
    }
}