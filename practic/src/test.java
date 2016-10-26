import java.io.*;
import java.util.*;
public class test {
	
	private int [] data;
	public static void main (String args[])
	{
		//int x=10;
		//x=x>>3;
		int x=1;
		x=0>>0;
		x=x&10;
		
		int a[]={0,1,1,1,1,1,1,};
		a[0]>>=2;
		
		/*Random rand=new Random();
		for(int i=0;i<32;i++)
		{
			a[i]=rand.nextInt(2);
		}*/
		test t=new test();
		//String str=t.toString(a);
		//int x=rand.nextInt(32);
		System.out.println(a[1]);
	}
	
	
	public String toString(int a[])
	{
		int x;
		String s="";
		for(int i=0;i<a.length;i++)
		{
			s+=Integer.toString(a[i]);
		}
		return s;
	}

}
