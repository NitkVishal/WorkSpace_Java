import java.util.*;

public class Solution7{
	static Scanner scan=new Scanner(System.in);
	public static void main(String []args){
		int n=scan.nextInt();
		for(int i=0;i<n;i++){
			int arr[]=new int[26],count=0;
			String str=scan.next();
			if(str.length()%2!=0)
				System.out.println(-1);
			else {
				for(int j=0;j<str.length()/2;j++){
					arr[str.charAt(j)-97]++;	
				}
				for(int j=str.length()/2;j<str.length();j++){
				   arr[str.charAt(j)-97]--;
				}
				for(int j=0;j<26;j++){
					count+=Math.abs(arr[j]);
				//System.out.println(arr[j]);
					
				}
				System.out.println(count/2);
				
			}
		}
	}
}