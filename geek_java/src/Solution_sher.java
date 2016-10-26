import java.io.*;
import java.util.*;
public class Solution_sher {
	
	public static void main(String args[])
	{
		Scanner scan =new Scanner (System.in);
        int x=scan.nextInt();
        for(int i=0;i<x;i++)
        {
		int n=scan.nextInt();
		Solution_sher o=new Solution_sher();
		o.check(n);
        }
	}
	
	

	void check(int n)
	{
		String str="";
		int x=n,y=0,co=0;
		boolean t=false;
		if(n%3==0)
		{
			y=n;
			t=true;
			}
		else if(n%3!=0)
		{
			while(x>2&&t==false)
			{
				x=x-5;
				co=co+1;
				if(x%3==0&&x>2)
				{
					t=true;
					y=n-co*5;
					break;
				}
			}
			
		}
		if(n%5==0&&n%3!=0)
		{
			t=true;
		}
		
		if(t==false)
		{
			
			System.out.println("-1");
			}
		
		else
		{
			for(int i=0;i<y;i++)
			{
				str=str+"5";
			}
			
			
			for(int i=0;i<n-y;i++)
			{
				str=str+"3";
			}
			System.out.println(str);
		}
		
		
		
			}
}
