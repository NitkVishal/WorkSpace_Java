import java.util.*;
public class degit_sum {

	public static void main(String[] args) 
	{
		System.out.println("enter no.");
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		int x=0;
		while(t>0)
		{
			x=x+t%10;
			t=t/10;
		}
		System.out.println(x);
		scan.close();
		}

}
