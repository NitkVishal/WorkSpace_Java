import java.util.*;


public class Solution1{
	
	int check(String str){
		int j=str.length()-1;
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(j))
				{
				if(str.charAt(i+1)==str.charAt(j))
					return i;
				else return j;
				}
					
			
		}
		return -1;
	}
	
	
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
		Solution1  o=new Solution1();
		int t=scan.nextInt(),x;
		for(int i=0;i<t;i++)
		{
			String str=scan.next();
			System.out.println(o.check(str));
		}
	}
}