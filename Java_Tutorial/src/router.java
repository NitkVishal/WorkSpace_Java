import java.util.*;
public class router{
	public static void main(String args[]){
		
		Scanner scan=new Scanner(System.in);
		int node=scan.nextInt();
		int x,y,z;
		for(int i=0;i<node;i++)
		{
			z=i/64;
			x=(i/8)-(z*8);
			y=i%8;
			
			System.out.println(" X axis"+x+"  Y axis"+y+"  Z axis"+z);
		}
		
	}
	
}