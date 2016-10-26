import java.util.*;
public class Solution16 {

	static Scanner scan=new Scanner (System.in);
	public static void main(String []args){
		int t=scan.nextInt(),a,b,n,i,sum;
		for(int j=0;j<t;j++){
			a=scan.nextInt();b=scan.nextInt();n=scan.nextInt();
			i=0;sum=a;
			while(i<n){
				sum += (int)(Math.pow(2, i)*b);
				System.out.print(sum+" ");
				i++;
			}
			
		}		
		
		
	}
}
