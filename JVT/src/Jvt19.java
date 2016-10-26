import java.util.regex.*;


public class Jvt19 {
	public static void main(String args[]){
		String str1=" 12345 Vishal Emaid Address id 12345 is vishalbabu.in@gmail.com";
		String str2="Ajj Di****{{{{{ ^^^^&";
		
		raxChech("\\s\\d{5}\\s",str1);
		
	}
	
	public static void raxChech(String str1,String str2){
	Pattern crax=Pattern.compile(str1);
	Matcher matrax= crax.matcher(str2);
	while(matrax.find()){
		if(matrax.group().length()!=0){
			System.out.println(matrax.group().trim());
		}
		//System.out.println(matrax.start());
		//System.out.println(matrax.end());
	}
	}

}
