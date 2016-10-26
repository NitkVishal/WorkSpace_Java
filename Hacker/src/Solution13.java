import java.util.*;

public class Solution13{
	static Scanner scan=new Scanner (System.in);
	
	
	
	public static void main(String []args){
		int t=scan.nextInt(),m,n,sum,j,k;
		for(int i=0;i<t;i++){
			
			sum=0;
			n=scan.nextInt();
			m=scan.nextInt();
			j=n-1;
			k=m-1;
			while(j>0){
				sum+=m*k;
				k--;j--;
			}
			
			System.out.println(sum);
		}
				
	}
}