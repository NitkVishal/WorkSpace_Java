import java.util.*;
public class factorial {
		
public static void main(String [] args)
{
	Scanner scan =new Scanner(System.in);
	int x=scan.nextInt();
	factorial o=new factorial();
	int z=o.ser(x);
	System.out.println(z);
	}

int ser(int x){
	factorial ob=new factorial();
	if(x==0||x==1)
		return 1;
	return x*ob.ser(x-1);
}
}
