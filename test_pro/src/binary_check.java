import java.util.*;
public class binary_check {
	
	public boolean check( int x)
	{
		while(x>0)
		{
			int t=x%10;
			if(t>1)
				return false;
			x=x/10;
				}
		return true;
	}

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter");
		int x =scan.nextInt();
		binary_check bc=new binary_check();
		boolean y=bc.check(x);
		System.out.println("it's  _"+y);
		scan.close();
		}
	
	}
