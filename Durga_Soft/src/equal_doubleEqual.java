import java.io.*;
public class equal_doubleEqual {
	public static void main(String...agrs)
	{
		String s1=new String("Vishal");
		String s2=new String("Vishal");
		System.out.println(s1==s2);//reference Comparision.... False
		System.out.println(s1.equals(s2));//Content Comparision...True
	}

}
