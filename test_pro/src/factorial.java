import java.util.Scanner;

public class factorial 
{
	public static void main (String args[])
	{
		Scanner scan =new Scanner (System.in);
		System.out.println("enter no.");
		int x=scan.nextInt();
		int y=recu(x);
		System.out.println(y);
	} 
	public static int recu(int x)
	{
		int y;
		if (x==1)
				return 1;
		else
			y=x*recu(x-1);
		return y;
		
				
	}

}
