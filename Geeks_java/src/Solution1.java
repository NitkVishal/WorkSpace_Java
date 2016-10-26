import java.io.*;
import java.util.*;
public class Solution1 {
public static void main(String args[])
{
	Scanner scan=new Scanner(System.in);
    
   
    for(int i=0;i<2;i++)
    {
    	int x=scan.nextInt();
         check(x);
        }
     
    
}
    
    
    public static void check(int x)
    {
        int h=1;
	for(int i=0;i<x;i++)
	{
		if(i%2==0)
		{
			h=h*2;
		}
		else
			h=h+1;
	}
	System.out.println(h);
	}
 }

