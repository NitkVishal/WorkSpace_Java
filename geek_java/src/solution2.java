import java.util.*;
import java.io.*;
public class solution2 {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		for (int i=0;i<x;i++)
		{
			String str=scan.nextLine();
			check(str);
		}
	  }
	
	
	public static void check(String str)
	{
		char crr[] =str.toCharArray();
		int j=str.length()-1;
		for(int i=0;i<str.length()/2;i++)
		{
			
			while((crr[j]=='a')||(crr[i]!=crr[j]))
			{
				crr[j]--;
			}
			j--;
		}
		for(int i=0;i<str.length();i++)
		{
			System.out.println(crr[i]);
		}
	}

}
