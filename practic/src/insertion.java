import java.util.*;
public class insertion {
	public static void main(String[] args)
	{
		Scanner scan=new Scanner (System.in);
		int x=scan.nextInt();
		int []arr=new int[x];
		for(int i=0;i<x;i++)
		{
			arr[i]=scan.nextInt();

		}
		insertion o=new insertion();
		o.sort(arr);
	}
	
	void sort(int [] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			int x=arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>x)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=x;
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
