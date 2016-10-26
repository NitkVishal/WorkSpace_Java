package com.aiq.streaming;

import java.util.Random;

import kafka.Kafka;

public class test {
	public static void main(String args[]){
		Random random = new Random();
		for(int i=0;i<10 ;i++){
			System.out.println(createRandomInteger(0, 20));
		}
//		KafkaOutChannel.writeToKafka("Hello", "MyTopic");
	}
	
	private static String createRandomInteger(int aStart, long aEnd){
	    Random aRandom = new Random();
    	if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    long range = aEnd - (long)aStart + 1;
	    long fraction = (long)(range * aRandom.nextDouble());
	    long randomNumber =  fraction + (long)aStart;
	    return Long.toString(randomNumber);
	  }
}
