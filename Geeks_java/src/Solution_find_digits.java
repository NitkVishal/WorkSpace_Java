import java.io.*;
import java.util.*;


public class Solution_find_digits { 
public static void main(String args[])throws IOException
     {
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        for(int i=0;i<x;i++)
        {
        	int y=scan.nextInt();
        	
        	check(y);
        }
     }
public static void check(int x)throws IOException
{
        int t=x,co=0;
        while(t>0)
        {
        	int y=t%10;
        	if(x%y==0)
        	{
        		co=co+1;
        	}
        	t=t/10;
        }
        System.out.println(co);
    }
}