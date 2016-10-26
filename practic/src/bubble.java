import java.util.*;
public class bubble {
	void sort(int [] arr)
	
	{
		
		for(int i=0;i<arr.length-1;i++)
		{
			for (int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		for (int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String [] args)
	{
		Scanner scan=new Scanner (System.in);
		bubble o =new bubble();
		int x=scan.nextInt();
		int [] arr=new int[x];
		//System.out.println(arr.length);
		for (int i=0;i<x;i++)
		{
			arr[i]=scan.nextInt();
		}
		o.sort(arr);
	}

}
