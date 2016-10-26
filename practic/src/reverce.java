import java.util.*;
public class reverce {
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	String str="";
	str=scan.nextLine();
	reverce o=new reverce();
	o.check(str);
}
void check(String str){
	int x=0,y=0;
	boolean b=false;
	char []arr= str.toCharArray();
	for (int i=str.length()-1;i>=0;i--)
		{
	    //System.out.println(arr[i]);
	    if(arr[i]==' '&&b==false)
	    {
	    	b=true;
	    	y=str.length();
	    	x=i+1;
	    	for(int j=x;j<y;j++)
	    	System.out.print(arr[j]);
	    	System.out.print(" ");
	    }
	    else if(arr[i]==' ')
	    {
	    	y=x-1;
	    	x=i+1;
	    	for(int j=x;j<y;j++)
		    	System.out.print(arr[j]);
	    	System.out.print(" ");
	    }
	    else if (i==0)
	    {
	    	y=x-1;
	    	x=0;
	    	for(int j=x;j<y;j++)
		    	System.out.print(arr[j]);
	    	
	    }
	    
		}
	}

}
