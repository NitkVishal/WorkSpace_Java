import java.io.*;
import java.util.*;
public class Solution_gem_stone {
	public static void main(String args[])throws IOException
	{
	Scanner scan=new Scanner (System.in);
	int x=scan.nextInt();
	
	Solution_gem_stone o=new Solution_gem_stone();
	for(int i=0;i<x;i++)
	{
		long n=scan.nextLong();
	o.check(n);
	}
	
	
	}
	void check(long n)
	{
		boolean t=false;
		long x=1;
		long z;
	    long y=0;
		if (n==0)
			t=!t;
		else if(n==1)
			t=!t;
		else
		    while(x<n&&t==false)
			{
		    	z=y;
		    	y=x;
		    	x=z+y;
				if(x==n)
				{
					t=!t;
					}
				}
			if(t==false)
				System.out.println("IsNotFibo");
			else
				System.out.println("IsFibo");
	}
}
