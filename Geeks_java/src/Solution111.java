import java.io.*;
import java.util.*;
public class Solution111 
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner (System.in);
		int l=scan.nextInt();
		int r=scan.nextInt(),y=0;
		if(l<=r){
		//int arr[]=new int [x];
		for(int i=l;i<=r;i++)
		{
			for(int j=i;j<=r;j++)
			{
				int x=i^j;
				if(x>y)
				{
					y=x;
				}
			}
			
		}
		System.out.println(y);
		}
    }
	}
