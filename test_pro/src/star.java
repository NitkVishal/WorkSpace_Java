import java.util.*;
public class star {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("how many no of lines do u want");
		int x=scan.nextInt();
		int y=0,z=0;
		while(y<x)
		{
		for(int i=0;i<z;i++)
		{   
			System.out.print(" ");
			
		}
		for(int j=0;j<x;j++)
		{
			System.out.print("* ");
		}
		System.out.println();
		x--;
		z=z+1;
		}
		scan.close();
		}
	

}
