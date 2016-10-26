

import java.util.*;
public class Solution{
	
	String reverse(String str){
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
			rev+=str.charAt(i);
		
		return rev;
	}
	
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
		Solution o=new Solution();
		int t=scan.nextInt();
		int p,q;
		for(int i=0;i<t;i++)
		{
			boolean b=false;
			String str=scan.next();
			String rev=o.reverse(str);
			for(int j=1;j<str.length();j++)
			{
				p=str.charAt(j)-str.charAt(j-1);
				if(p<0)
					p=p*-1;
				q=rev.charAt(j)-rev.charAt(j-1);
				if(q<0)
					q=q*-1;
				if(p!=q)
				{
					b=true;
					break;
				}
			}
			if(b)
				System.out.println("Not Funny");
			else
				System.out.println("Funny");
		}
	}
}