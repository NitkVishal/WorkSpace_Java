package streamingdemo.kafka;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


public class KafkaOutChannel {
	private static Logger LOGGER = Logger.getLogger(KafkaOutChannel.class
			.toString());
	/** The props. */
	static Properties props = new Properties();

	/** The producer. */
	static KafkaProducer<String, String> producer;

	/** The topic. */
	static String topic;

	static String value;

	/** The producer record. */
	static ProducerRecord<String, String> producerRecord;

	public static void writeToKafka(String convertObjectToJSON, String topic) {
		configure();
		producerRecord = new ProducerRecord<String, String>(topic,
				convertObjectToJSON);
		producer.send(producerRecord);
		LOGGER.log(Level.INFO, "SENDING MESSAGE TO : "
				+ topic);
		producer.close();
	}
	
	private static void configure() {
		//LOGGER.log(Level.INFO,"TRYING TO INITIAIZE KAFKA !");
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class.getName());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class.getName());
		producer = new KafkaProducer<String, String>(props);
		//LOGGER.log(Level.INFO , "KAFKA INITIALIZED!");
		System.out.println("Kafka Initialized!!!");
	}

}
