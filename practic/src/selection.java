import java.*;
import java.util.*;
public class selection {
	void check(int [] arr)
	{
		for (int i=0;i<arr.length-1;i++)
		{
			int y=arr[i];
			for(int j=i+1;j<arr.length;j++)
			{
				if(y>arr[j])
				{
					int temp=y;
					y=arr[j];
					arr[j]=temp;
					arr[i]=y;
				}
			
			}
			System.out.println(arr[i]);
		}
		System.out.println(arr[arr.length-1]);
	}
	
	
	
	public static void main(String [] agrs)
	{
		Scanner scan =new Scanner (System.in);
		int x=scan.nextInt();
		int []arr=new int[x];
		for(int i=0;i<x;i++)
		{
			arr[i]=scan.nextInt();
		}
		selection o=new selection();
		o.check(arr);
	}
	

}
