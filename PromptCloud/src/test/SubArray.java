package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SubArray {

	public int arr[];
	public static void main(String args[]){
		SubArray sa= new SubArray();
		Scanner scan = new Scanner(System.in);
		int sum=0;
		int n= scan.nextInt();
		sa.arr =new int[n];
		for(int i=0;i<n;i++){
			sa.arr[i] = scan.nextInt();
		}
		for(int i=0;i<n;i++)
			sum+=sa.arr[i];
		if(sum%2!=0)
			System.out.println("Not Possible");
		else if(sa.isSum(n-1, sum/2)){
			System.out.println("Possible");
			sa.list = new LinkedList<>();
			sa.isSum("", n-1, sum/2);
			for(int i=0;i<sa.list.size();i++){
				System.out.println(sa.list.get(i));
			}
		}
	}
	
	ArrayList<String> alist;
	public void loopMethod(int n,int halfSum){
		int sum;
		String str;
		list = new ArrayList<>();
		for(int i=0;i<n;i++){
			sum=0;
			str = "";
			for(int j=0;j<i;j++){
				sum +=arr[j];
				if(j==0)
					str += arr[j];
				else str+=","+arr[j];
			}
			if(sum == halfSum )
				list.add(str);
		}
	}
	public boolean isSum(int n,int sum){
		if(sum==0)
			return true;
		if(n==0 && sum !=0 )
			return false;
		if(arr[n]>sum)
			return isSum(n-1, sum);
		return isSum(n-1, sum-arr[n]) || isSum(n-1, sum);
	}
	
	List<String> list;
	public void isSum(String str , int n,int sum){
		if(n>=0){
			if(sum==0)
				list.add(str);
			if(arr[n]>sum)
				isSum(str,n-1, sum);
			if(str.length()==0)
				isSum(str+arr[n-1],n-1, sum-arr[n-1]);
			else 
				isSum(str+","+arr[n-1], n-1, sum-arr[n-1]);
			isSum(str, n-1, sum);
		}
	}
}
