import java.util.*;

public class faboncci_series {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		System.out.println("enter length of series :");
		int t=scan.nextInt();
		int y0=0,y1=1;
		System.out.println("series is");
		System.out.print(y0+" ");
		System.out.print(y1+" ");
		for(int i=1;i<=t;i++)
		{
			int y=y0+y1;
			y0=y1;
			y1=y;
			System.out.print(" "+y);
		}
		scan.close();
		}

}
