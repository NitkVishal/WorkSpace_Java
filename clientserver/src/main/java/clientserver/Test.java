package clientserver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {
	public static void main(String args []){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String str = dateFormat.format(date);
		System.out.println(str); //2014/08/06 15:59:48
//		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
//			createRandomInteger(1000000000, 9999999999L, random);
////			System.out.println(random.nextInt(99999999));
//		}
	}
	
	   private static void createRandomInteger(int aStart, long aEnd, Random aRandom){
		    if ( aStart > aEnd ) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		    }
		    long range = aEnd - (long)aStart + 1;
		    long fraction = (long)(range * aRandom.nextDouble());
		    long randomNumber =  fraction + (long)aStart;
		    System.out.println(randomNumber);

		  }
	   
	   
}
