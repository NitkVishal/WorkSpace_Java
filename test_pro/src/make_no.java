import java.util.Scanner;


public class make_no {

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner (System.in);
		System.out.println("enter no of coins");
		int n=scan.nextInt();
		int [] ar=new int [n];
		System.out.println("enter conis");
		for(int i=0;i<n;i++)
		{
			ar[i]=scan.nextInt();
		}
		System.out.println("enter no that u want");
		int x=scan.nextInt();
		int y=0,z=0,t,u=0;
		for(int i=0;i<n;i++)
		{
			z=z+ar[i];
		 if(y<ar[i])
			 y=ar[i];
		}
		while(true)
		{
			if(x>z)
				t=x-z;
			while(u<x)
			{
				u=u+y;
			}
		}

	}

}
