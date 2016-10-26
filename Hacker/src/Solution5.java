import java.util.*;
public class Solution5 {
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
      int t=scan.nextInt(),x,count;
      for(int i=0;i<t;i++)
      {
    	  count=0;
    	  x=scan.nextInt();
    	  if(x%2==0)
    	  {
    		  count=1;
    		  for(int j=1;j<=x/2;j++){
    			  if(x%j==0)
    				  if(j%2==0)
    					  count++;
    		  }
    		  System.out.println(count);
    	  }
    	  else
    		  System.out.println(count);
    	  
    	  
      }
	}

}
