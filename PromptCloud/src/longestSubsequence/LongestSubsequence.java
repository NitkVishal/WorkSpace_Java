package longestSubsequence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LongestSubsequence {
	public static void main(String args[]){
		BufferedReader br;
		BufferedWriter wr;
		String res1,res2,str;
		LongestSubsequence ls= new LongestSubsequence();
		try {
			br = new BufferedReader(new FileReader(new File("src/longestSubsequence/input.txt")));
			str =br.readLine();
			res1 = ls.twoPointer(str);
			res2 = ls.withOutDP(str);
			br.close();
			wr = new BufferedWriter(new FileWriter(new File("src/longestSubsequence/output.txt")));
			if(res1.length()>res2.length())
				wr.write(res1);
			else wr.write(res2);
			wr.close();
			System.out.println("File Saved!!");
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IOException io) {
			System.err.println(io.getMessage());
		}
	}

	 public String withOutDP(String str){
		 int ones=0,zero=0;
		 String curstr="",maxstr="";
		 for(int i=0;i<str.length();i++){
			 if(str.charAt(i)=='1') {
				 ones++; 
			 } else {
				 zero++;
			 }
			 curstr+=str.charAt(i);
			 
			 if(ones==zero && curstr.length()>maxstr.length())
				 maxstr= curstr;
		 } 
		 return maxstr;
	 }
	
	public String twoPointer(String str){
		int one=0,zero=0,length= str.length();
		int start=0,ends=length-1;
		for(int i = 0 ;i<length;i++){
			if(str.charAt(i)=='1')
				one++;
			else if(str.charAt(i)=='0')
				zero++;
		}
		while(one!=zero && start<ends){
			if(one>zero){
				if(str.charAt(start)=='1'){
					start++;
					one--;
				} else if(str.charAt(ends)=='1'){
					ends--;
					one--;
				} else{
					start++;
					zero = zero-1;
				}
			}
			if(zero>one){
				if(str.charAt(start)=='0'){
					start++;
					zero--;
				} else if(str.charAt(ends)=='0'){
					ends--;
					zero--;
				} else{
					ends--;
					one = one-1;
				}
			}
		}
		return str.substring(start,ends+1);
	}
}
