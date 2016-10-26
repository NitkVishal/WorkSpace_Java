
import java.util.Scanner;

public class reverse_no 
{
	public static void main(String arg[])
	{
		System.out.println("enter no");
		Scanner scan = new Scanner(System.in);
		int x=scan.nextInt();
		int reverse = 0;
		while(x!=0)
		{
			reverse=(reverse*10)+(x%10);
			x=x/10;
		}
		System.out.println(reverse);
		scan.close();
	}
	

}
