//import java.io.*;
public class String_StringBuffer {
	public static void main(String...args)
	{
		String s= new String ("Vishal");
		s.concat(" babu");
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer("vishal");
		sb.append(" babu");
		System.out.println(sb);
	}

}
