import java.util.regex.*;
import java.util.Scanner;
public class Test2 {
	static Scanner scan=new Scanner (System.in);
	
public static void main(String args[]){
	
	String str=" Vishal Babu ambedkar nagar CA Ajetmal Auraiya UP 206121 Email vishalbabu.in@gmail.com " +
			"   and vishalbabu_in@hotmail.com   Mob 9980945210 ";
	String str2=" ABCDS1234Y ";
	str2=scan.next();
	raxCheker("\\s[A-Z]{5}+[0-9]{4}+[A-Z]{1}\\s",str2);
}

public static void raxCheker(String str1,String str2){
	Pattern ptn= Pattern.compile(str1);
	Matcher rem=ptn.matcher(str2);
	
	while(rem.find()){
		if(rem.group().length()!=0){
			System.out.println(rem.group().trim());
		}
		//System.out.println(rem.start());
		//System.out.println(rem.end());
	}
}
}
