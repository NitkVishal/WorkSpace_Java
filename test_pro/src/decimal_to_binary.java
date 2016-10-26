

import java.util.Scanner;

public class decimal_to_binary {

	private static Scanner scan;

	public static void main(String[] args)
	{
		scan = new Scanner(System.in);
		System.out.println("enter no.");
		int x=scan.nextInt();
		String bs=Integer.toBinaryString(x);
		System.out.println(bs);


	}

}
