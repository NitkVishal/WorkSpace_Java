import java.util.*;
public class Solution14 {

	static Scanner scan=new Scanner(System.in);
	static int []arr={3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,46,2,6,4,3,3,8,3,3};
	public static void main(String args[]){
		int t=scan.nextInt();
		for(int i=0;i<t;i++){
			int k=0,temp=0;
			boolean b=true;
			String str=scan.next();
			for(int j=0;j<str.length();j++){
				if(str.charAt(j)==' '){
					if(temp==arr[k]){
						k++;
						temp=0;
					}
					else {
						b=false;
						temp=0;k=0;
						break;
					}
				
				}
				else if(j==str.length()-1){
					if(temp+1==arr[k])
						b=true;
				}
				else 
				{
					temp++;
				}
				}
			if(b==false )
				System.out.println("Yes");
			else System.out.println("No");
	  } 
     }
	}
