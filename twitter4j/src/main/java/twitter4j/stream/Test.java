package twitter4j.stream;

public class Test {
	public static void main(String args[]){
		KafkaOutChannel.writeToKafka("Hello", "TopicPub");
	}
}
