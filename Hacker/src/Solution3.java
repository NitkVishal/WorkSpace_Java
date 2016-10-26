import java.util.*;
public class Solution3 {

	static Scanner scan=new Scanner (System.in);
	public static void main(String args[]){
		int t=scan.nextInt();
		for(int i=0;i<t;i++)
		{
			
			int count=0;
			String str=scan.next();
			if(str.length()%2!=0)
				System.out.println(-1);
			else
			{
				int arr[]=new int[26];
				for(int j=0;j<str.length();j++)
				    arr[str.charAt(j)-97]++;
				for(int j=0;j<26;j++)
					if(arr[j]%2!=0)
						count++;
				System.out.println(count/2);
			}
		}
	}
}
