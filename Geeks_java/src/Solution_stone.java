import java.io.*;
import java.util.*;
public class Solution_stone {
public static void main(String args[])
{
	Scanner scan=new Scanner(System.in);
	Solution_stone o=new Solution_stone();
	int x=scan.nextInt();
	for(int i=0;i<x;i++)
	{
		int n=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		o.check(n,a,b);
	}
	
	}
void check(int n,int a,int b)
{
	int j=n-1,z=0;
	
	if(b<a)
	{
		int t=a;
		a=b;
		b=t;
	}
	
	for(int i=0;i<n;i++)
	{
		int x=j*a+i*b;
		j--;
		
		if(z!=x)
		{
		System.out.print(x+" ");
		}
		z=x;
	}
	System.out.println();
	}

}
