import java.util.*;

public class Solution9{
	static Scanner scan=new Scanner(System.in);
	static char arr[];
	
	static int partition(int l,int r){
		int i=l,j=r;
		char ch=arr[l];
		while(i<j){
			while((int)arr[i]<=(int)ch)
				i++;
			while(arr[j]>ch)
				j--;
			if(i<j){
				char temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		arr[l]=arr[j];
		arr[j]=ch;
		return j;
	}
	
	
	 static void qsort(int l,int r){
		 if(l<r){
			 int m=partition(l,r);
			 qsort(l,m-1);
			 qsort(m+1,r);
		 }
		
	}
	
	
	public static void main(String args[]){
		int t=scan.nextInt();
		
		for(int i=0;i<t;i++){
		  String str=scan.next();
		  arr=str.toCharArray();
		  qsort(0,str.length());
		  for(int j=0;j<arr.length;j++){
			  System.out.println(arr[j]);
		  }
		}
		
	}
}