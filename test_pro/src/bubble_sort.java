import java.util.*;
public class bubble_sort {

	public void sort(int []ary)
	{
		for(int i=0;i<ary.length;i++)
		{
			for(int j=0;j<ary.length-1;j++){
			if(ary[j]>ary[j+1])
			{
				int t=ary[j];
				ary[j]=ary[j+1];
				ary[j+1]=t;
			}
			
		}
			}
		System.out.print("sorted arry is =");
		for(int i=0;i<ary.length;i++)
		{
			System.out.print(ary[i]+",");
		}
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter no. of element");
		int n= scan.nextInt();
		int []arr=new int[n];
		System.out.println("enter elements");
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		bubble_sort bs=new bubble_sort();
		bs.sort(arr);
		scan.close();
		}

}
