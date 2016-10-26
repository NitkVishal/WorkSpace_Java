import java.util.*;
public class TestClass {
	static Scanner scan=new Scanner(System.in);
    public static void main(String args[] ) throws Exception {
       int t=scan.nextInt();
       for(int i=0;i<t;i++)
       {
       	int r=0,k=0;
       	String str=scan.next();
       	for(int j=0;j<str.length();j++)
       	 {
       	 	if(str.charAt(j)=='R')
       	 	r++;
       	 	else
       	 	k++;
       	 }
       	  //System.out.println(r  +" "+k);
       	 if(k%2==0)
       	 System.out.println(r+k);
       	 else System.out.println(r+k-1);
       }
    }
}
