package generic;

import java.util.ArrayList;

public class TypeSafety {
	public static void main(String args[]){
		
	}
	
	public static void arryList(){
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("pqr");
		list.add(new Integer(10));
		
		
	}
	
	public static void array(){
		String strArr [] = new String[1200];
		strArr[0] = "abc";
		strArr[1] = "xyz";
//		strArr[2] = new Integer(10);
	}
}
