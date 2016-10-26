import java.io.*;
import java.util.*;
public class Solution_filling_jar2 {

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		
		//Solution_filling_jar1 o =new Solution_filling_jar1();
		int n=scan.nextInt();
		int x=scan.nextInt();
		long  z=0;
		
		for(int i=0;i<x;i++)
		{
			int a=scan.nextInt();
			int b=scan.nextInt();
			int s=scan.nextInt();
			z=z+(b-a+1)*s;
			
			
		}
		System.out.println(z/n);
		
	}
}