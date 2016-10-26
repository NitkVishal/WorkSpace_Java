import java.util.*;

public class tes{
	 String eliminate(String str){
		int arr[]=new int [26];
		for(int i=0;i<str.length();i++)
		{
			if(arr[str.charAt(i)-97]==0)
			arr[str.charAt(i)-97]++;
		}
		String str1="";
		for(int i=0;i<26;i++)
		{
			if(arr[i]>0)
			str1=str1+(char)(97+i);
		}
		//System.out.println(str1);
		return str1;
	}
	
	
	
	static Scanner scan=new Scanner (System.in);
	public static void main(String args[]){
	   int t=scan.nextInt();
	
	   tes o=new tes();
	  
	   for(int i=0;i<t;i++)
	   {
		   boolean b=false;
		   String str1=scan.next(),str2=scan.next();
		   str1=o.eliminate(str1);
		   str2=o.eliminate(str2);
		   int arr[]=new int [26];
		   for(int j=0;j<str1.length();j++)
			   arr[str1.charAt(j)-97]++;
		   for(int j=0;j<str2.length();j++)
			   arr[str2.charAt(j)-97]++;
		   
		   for(int j=0;j<26;j++)
			   if(arr[j]>1)
			   {
				   b=true;
				   break;
			   }
		   if(b)
			   System.out.println("YES");
		   else
			   System.out.println("NO");
	   }
	   
	   
		
	}
	
} 