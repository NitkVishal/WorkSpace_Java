import java.io.*;
import java.util.*;
public class Solution_lovelatter_mistry
{
public static void main(String args[])
{
	Solution_lovelatter_mistry o=new Solution_lovelatter_mistry();
	Scanner scan=new Scanner (System.in);
	//System.out.println("enter no");
	int x=scan.nextInt();
	String str;
	for(int i=0;i<x;i++)
	{
		//System.out.println("enter no");
		str=scan.next();
		o.check(str);
	}
	}
void check(String str)
{
     char []arr=str.toCharArray();
     int j=str.length()-1,count =0;
     char x;
     for(int i=0;i<str.length()/2;i++)
     {
    	while(arr[i]!=arr[j])
    	{
    		if(arr[i]<=arr[j])
    			arr[j]--;
    		else
    			arr[i]--;
    		count++;
    	}
    	 j--;
     }
    System.out.println(count);
     
	}
}
