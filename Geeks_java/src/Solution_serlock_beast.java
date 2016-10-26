import java.io.*;
import java.util.*;
public class Solution_serlock_beast {

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		
		Solution_serlock_beast o =new Solution_serlock_beast();
        int x=scan.nextInt();
        for(int i=0;i<x;i++){
              int n=scan.nextInt();
		      o.check(n);
        }
		
		
	}
	void check(int n)
	{
		//System.out.println("-1");
		//String str="";
		int x=n,y=0;
		boolean t=false;
		if(n%3==0)
			t=true;
		else
		{
		while(x>2)
		{
			x=x-5;
			y=y+1;
			if (x%3==0)
			{
				t=true;
				break;
			}
		}
		}
		if(t==true)
		{
			for(int i=0;i<(n-y*5);i++)
			{
				//str=str+'5';
				System.out.print(5);
			}
			for(int i=0;i<y*5;i++)
			{
				System.out.print(3);
				//str=str+'3';
			}
			System.out.println();
		}
			
		else
			System.out.println("-1");
		
	}
}
