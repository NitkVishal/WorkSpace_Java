import java.util.*;
public class Solution11 {
 static Scanner scan=new Scanner(System.in);
 public static void main(String args[]){
	 String str1=scan.next();
	 String str2=scan.next();
	 int sum=0; 
	 sum=str1.charAt(0);
	 for(int i=1;i<str1.length();i++)
		 sum=sum^str1.charAt(i);
	 for(int i=0;i<str2.length();i++)
		 sum=sum^str2.charAt(i);
	 System.out.println(sum);
 }
}
