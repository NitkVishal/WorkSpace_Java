import java.util.*;
public class Ending {
	public static void main (String args[]){
		String str ="";
		Scanner scan=new Scanner (System.in);
		str=scan.nextLine();
		check o=new check();
		o.end(str);
	}
    
}
class check{
	public void end(String str){
		char []arr=new char[str.length()];
		arr=str.toCharArray();
		for (int i=0;i<str.length();i++){
			//System.out.println(arr[i]);
		}
		int y=0,z=0;
		for (int i=0;i<str.length();i++){
			//char c=arr[i];
			if(arr[i]=='\0'||arr[i]==' '){
				//System.out.println(arr[i-1]);
				if(arr[i-1]=='y')
					y++;
				
				if(arr[i-1]=='z')
					z++;
				
			}
			
			}
		if(arr[str.length()-1]=='y')
			y++;
		else if(arr[str.length()-1]=='z')
			z++;
		System.out.println(y+""+z);
		
	}
}