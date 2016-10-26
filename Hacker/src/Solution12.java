import java.util.*;
public class Solution12{
	static Scanner scan=new Scanner(System.in);
	public static void main(String []args){
		int t=scan.nextInt();
		for(int i=0;i<t;i++){
			String str=scan.next();
			int k=str.length()-2;
			boolean b=false;
			for(int j=1;j<str.length();j++)
			{
				if(Math.abs(str.charAt(j)-str.charAt(j-1))!=Math.abs(str.charAt(k)-str.charAt(k+1))){
					
					
					b=true;
					break;
				}
				k--;
				
			}
			if(b)
				System.out.println("Not Funny");
			else 
				System.out.println("Funny");
		}
		
	}
}