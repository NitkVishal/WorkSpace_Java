import java.util.*;
public class Solution10 {
	static Scanner scan=new Scanner(System.in);
	static int arr[];
	public static void main(String []args){
	  int t =scan.nextInt();
	  for(int i=0;i<t;i++){
		  int n=scan.nextInt();
		  arr=new int[n];
		  for(int j=0;j<n;j++)
			  arr[j]=scan.nextInt();
		  int l=0,r=0,p=0,q=n-1;
		  boolean b=false;
		  l+=arr[p];
		  r+=arr[q];
		  while(p<q){
			  if(l==r&&p+2==q&&arr[p+1]==l)
			  {
				  b=true;
				  break;
			  }
			  else if(l<=r)
			  {
				  p++;
				  l+=arr[p];
			  }
				  
			  else{
				  q--;
				  r+=arr[q];
			  } 
			  
		  }
		  if(b==true)
			  System.out.println("YES");
		  else
			  System.out.println("NO");
		  }
	  }
}
