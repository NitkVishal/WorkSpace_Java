import java.io.*;
import java.util.*;
public class Solution_services_lane
{
	public static void main(String args[]){
	Scanner scan=new Scanner(System.in);
	System.out.println("enter n and t");
	int x=scan.nextInt();
	int y=scan.nextInt();
	int arr[]=new int[x];
	System.out.println("enter n's element");
	for(int i=0;i<x;i++)
	{
		arr[i]=scan.nextInt();
	}
	System.out.println("enter coditions");
	for(int i=0;i<y;i++)
	{
		int a=scan.nextInt();
		int b=scan.nextInt();
		Solution_services_lane t=new Solution_services_lane();
		t.check(arr,a,b);
	}
	}
	public void check(int arr[],int a,int b)
	{
		int x=arr[a];
	for(int i=a;i<=b;i++)
	{
		if(x>arr[i])
		{
			x=arr[i];
		}
	}
	System.out.println(x);
	}
}