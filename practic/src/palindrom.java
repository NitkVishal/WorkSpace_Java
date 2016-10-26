import java.util.*;

public class palindrom {
	public static void main(String args[])
	{
		Scanner scan =new Scanner (System.in);
		String str=scan.nextLine();
		palindrom o=new palindrom();
		o.check(str);
		
	}

	void check(String str)
	{
		int x=0;
		char [] arr=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			x=x^arr[i];
		}
		if(x==0)
			System.out.println("palin"+x);
	}
}
