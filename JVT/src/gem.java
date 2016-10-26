import java.util.*;
public class gem {
	int arr[]=new int [26];
	static Scanner scan =new Scanner(System.in);
  public static void main(String args[]){
	  gem o=new gem();
	  int t=scan.nextInt();
	  for(int j=0;j<t;j++)
	  {
	   String str =scan.next();
	   for(int i=0;i<str.length();i++)
		   if(o.arr[((int)str.charAt(i)-97)]<(i+1))
	          o.arr[((int)str.charAt(i)-97)]++;
	  }
	   int count =0;
	   for(int i=0;i<26;i++){
		  if(o.arr[i]>=t)
			  count++;
	   } 
	   System.out.println(count);
	 
	}
}
