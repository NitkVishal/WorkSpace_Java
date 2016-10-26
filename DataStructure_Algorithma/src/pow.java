import java.util.*;
public class pow {
	static Scanner scan =new Scanner(System.in);
	public char arr[];
	
	public static int power(int x,int y){
		if(y==1)
			return x;
		else{
			if(y%2==0)
				return power(x,y/2)*power(x,y/2);
			else return (x*power(x,y-1));
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean check(char arr[]){
		int j=arr.length-1;
	     for(int i=0;i<arr.length/2;i++){
			if(arr[i]!=arr[j])
				return false;
			j--;
			}
	     return true;
	}
	
    public static int next(int x){
      String str=Integer.toString(x);
      char arr[]=str.toCharArray();
      int j,i,mid;
      if(arr.length %2!=0)
      {
    	  mid=str.length()/2;
    	 // arr[mid] =  (char) (Character.getNumericValue(arr[mid]) + 1);
    	  arr[mid]++;
    	  j = 0;
    	  while(j <=mid)
    	  {
    		  System.out.println("H");
    		  arr[mid+j] = arr[mid-j];
    		  j++;
    	  }
    	  
      }
      else{
    	  mid=str.length()/2;
    	  if(arr[mid-1]<arr[mid])
    		 arr[mid]=arr[mid-1]++;
    	  else if(arr[mid-1]>arr[mid])
    		  arr[mid]=arr[mid-1];
    	  j=1;
    	  while(j<mid){
    		  arr[mid+j]=arr[mid-1-j];
    		  j++;
    	  }
      }
    	  
      
      str=new String(arr);
      return Integer.parseInt(str);

    }
	
	
	public static void main(String...args){
		int x=scan.nextInt();
		//y=scan.nextInt();
		//x=power(x,y);
		int y=next(x);
		System.out.println(y);
		//System.out.println(x);
	}
}
