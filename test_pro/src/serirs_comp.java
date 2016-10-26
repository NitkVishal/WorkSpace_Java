import java.io.*;
import java.util.*;
public class serirs_comp {
	public static void main(String arg[])
	{
		Scanner scan=new Scanner (System.in);
		int A,D,R,Lim;
		System.out.println("enter A");
		A=scan.nextInt();
		System.out.println("enter D");
		D=scan.nextInt();
		System.out.println("enter R");
		R=scan.nextInt();
		System.out.println("enter Lim");
		Lim=scan.nextInt();
		cheek(A,D,R,Lim);
		
	}
	public static void cheek(int a,int d,int r,int lim)
	{
		int n=(lim-a)/d+1;
		int arr[] =new int [n];
		arr[0]=a;
		for (int i=1;i<n;i++)
		{
			arr[i]=arr[i-1]+d;
		}
		int t=a;
		System.out.println(a);
        while(lim>=t)
        {
        	t=t*r;
        	for (int i=0;i<arr.length;i++)
        	{
        		if(t==arr[i])
        			System.out.println(arr[i]);
        	}
        }
	 
	}

}
