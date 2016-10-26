import java.util.*;
public class Solu {
	char []check(char arr[]){
		char ch;
		int j=arr.length-1;
	    for(int i=0;i<arr.length/2;i++)
		{
			ch=arr[i];
			arr[i]=arr[j];
			arr[j]=ch;
			j--;
		}
	    return arr;
	}
	
	
	static Scanner scan=new Scanner(System.in);
	
    public static void main(String args[]){
    	int t=scan.nextInt();
    	for(int j=0;j<t;j++){
       String str=scan.next();
       char arr[]=str.toCharArray();
       
       Solu o=new Solu();
       int k=arr.length-1;
       char rev[]=new char[arr.length];
       for(int i=0;i<arr.length;i++)
       {
    	   rev[k]=arr[i];
    	   k--;
       }
       boolean b=false;
       for(int i=0;i<arr.length/2-1;i++)
       {
    	   if((int)arr[i+1]-(int)arr[i]!=(int)rev[i+1]-(int)rev[i]){
    		   b=true;
    		   break;
    	   }
    	   }
        if(b)
        	System.out.println("Not Funny");
        else System.out.println("Funny");
    	}
    	}
    }

