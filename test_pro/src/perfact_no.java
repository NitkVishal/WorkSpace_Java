

import java.util.Scanner;

public class perfact_no {
	
	public static void main(String arg[])
	{
		int y=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no");
		int x=scan.nextInt();
		for(int i=1;i<=x;i++)
		{
			if(x%i==0)
				 y=y+x/i;
		}
		if (y/2==x)
		System.out.println("yes");
		else
			System.out.println("nope");
		scan.close();
		}
}
