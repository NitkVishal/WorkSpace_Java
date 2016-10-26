import java.io.*;
import java.util.*;
public class Solution_filling_jar

{
	public static void main(String args[])
	{
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	long x=0;
	long arr[]=new long[n];
	
	
	int t=scan.nextInt();
	for(int i=0;i<t;i++)
	{
		int a=scan.nextInt();
		int b=scan.nextInt();
		int k=scan.nextInt();
		for(int j=a-1;j<b;j++)
		{
			arr[j]=arr[j]+k;
		}
		
	}
	for(int i=0;i<n;i++)
	{
		x=x+arr[i];
	}
	x=x/n;
	System.out.println(x);
	}
	
	}
