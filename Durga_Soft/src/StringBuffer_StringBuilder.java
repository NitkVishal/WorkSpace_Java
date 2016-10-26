
public class StringBuffer_StringBuilder {
   //StringBuilder    java 1.5
	public static void main(String...args)
	{
		//StringBuffer...  
		//1.  Every method is synchronized
		//2. String Bulder Object are thread safe
		//3. performance is low.
		// introduce in java 1.0
		System.out.println("StringBuffer.. \n  1. Every method is synchronized" +
				"\n  2. String Bulder Object are thread safe" +
				"\n  3. performance is low." +
				"\n  4. introduce in java 1.0");
		
		//StringBuilder...
		//1. Not Synchronized
		//2.thread safety is not there(Multiple thread are allow to operate on StringBuilder )
		//3. perfprmance is high
		//introduce in java 1.5
	}
}
