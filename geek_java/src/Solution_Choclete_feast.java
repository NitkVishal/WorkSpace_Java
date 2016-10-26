import java.io.*;
import java.util.*;
public class Solution_Choclete_feast {

	public static void main(String args[])
	{
		Scanner scan=new Scanner( System.in);
		int t=scan.nextInt();
		Solution_Choclete_feast o=new Solution_Choclete_feast();
		for(int i=0;i<t;i++)
		{
		int n=scan.nextInt();
		int c=scan.nextInt();
		int m=scan.nextInt();
		o.check(n,c,m);
		}
		
		
	}
	
	void check(int n,int c,int m)
	{
		int x=n/c;
		int y=x,z=0;
		while(y>=m)
		{
			z=z+y/m;
			y=(y/m)+y%m;
	
		}
		x=x+z;
		System.out.println(x);
	}
}
