import java.util.*;
public class Solution2 {
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[])
	{
		String str1=scan.next(),str2=scan.next();
		int arr1[]=new int [26];
		int arr2[]=new int[26];
		int count=0;
		for(int i=0;i<str1.length();i++)
			arr1[str1.charAt(i)-97]++;
		for(int i=0;i<str2.length();i++)
			arr2[str2.charAt(i)-97]++;
		for(int i=0;i<26;i++)
		{
			if(arr1[i]>arr2[i])
				count+=arr1[i]-arr2[i];
			else
				count+=arr2[i]-arr1[i];
		}
		System.out.println(count);
	}

}
