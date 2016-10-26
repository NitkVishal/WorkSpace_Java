import java.util.Scanner;


public class t_o_h 
{
public static void main(String agr[])
{
	t_o_h to=new t_o_h();
	Scanner scan=new Scanner (System.in);
	System.out.println("enter no of disk");
	int n=scan.nextInt();
	int x=to.tower(n);
	System.out.println(x);
}

public static int tower (int n)
{
	t_o_h to=new t_o_h();
	if (n==1)
		return 1;
	else 
	return 2*to.tower(n-1)+1;
	}
	}

