 import java.util.*;
public class prime_check {
 
	public String ipn(int number){
         
        for(int i=2; i<=number/2; i++)
        {
            if(number % i == 0)
            {
                return "not_prime";
            }
        }
        return "prime";
    }
     
    public static void main(String a[])
    {
    	System.out.println("enter no.");
    	Scanner scan = new Scanner (System.in);
    	int t= scan.nextInt();
    	prime_check p=new prime_check();
    	String str=p.ipn(t);
    	System.out.println(str);
    	scan.close();
       }
}