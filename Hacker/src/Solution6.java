import java.util.*;

public class Solution6 {
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
		int t=scan.nextInt();
		long a,m;
		for(int i=0;i<t;i++)
		{
			a=scan.nextLong();
			m=scan.nextLong();
			long x=((long)Math.pow(a, (m-1)/2))%m;
			if(x==1)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}

}
