import java.io.*;
import java.util.*;
public class Solution_game_of_thrones {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		Solution_game_of_thrones t=new Solution_game_of_thrones();
		t.check(str);
	}
	void check(String str)
	{
		boolean t=true;
		int p=0;
		char arr[]=str.toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			
			char c=arr[i];
			for(int j=i;j>0;j++)
			{
				if(c==arr[j])
					break;
			}
			for(int j=i+1;j<arr.length;j++)
			{
				
			}
			
		}
		System.out.println(t);
	}

}
