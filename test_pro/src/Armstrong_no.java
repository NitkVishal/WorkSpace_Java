import java.util.*;
public class Armstrong_no 
{
	
	public static int check (int t)
	{
		int x=0;
	 while(t>0)
	 {
		x=x+(t%10)*(t%10)*(t%10);
		t=t/10;
		 }	
	 return x;
	}
	public static void main(String[] args)
	{
		System.out.println("enter no");
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		int x=check(t);
		if(x==t)
			System.out.println("yes_Armstrong");
		else
			System.out.println("not_Armstrong");
		scan.close();
		}

}
