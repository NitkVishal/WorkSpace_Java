import java.util.*;
public class insertion_sort {
	
	public void sort(int[]ar)
	{
		for(int i=1;i<ar.length;i++)
		{
			int j=i-1;
			int y=ar[i];
			while(j>=0&&ar[j]>y)
			{
				ar[j+1]=ar[j];
				j--;
			}
			ar[j+1]=y;
		}
		System.out.println("sorted array is :");
		for(int i=0;i<ar.length;i++)
		{
			System.out.print(" "+ar[i]);
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("how many no want to sort");
		Scanner scan = new Scanner(System.in);
		int x=scan.nextInt();
		System.out.println("enter no.s");
		int [] ar=new int[x];
		for(int i=0;i<x;i++)
		{
			ar[i]=scan.nextInt();
		}
		insertion_sort is=new insertion_sort();
		is.sort(ar);
		scan.close();
	}

}
