import java.util.*;
import java.io.*;
public class Solution_game_of_th {
	public static void main(String args[])
	{
		Scanner scan=new Scanner (System.in);
		String str=scan.nextLine();
		Solution_game_of_th o = new Solution_game_of_th();
		o.check(str);
	}

	
	void check(String str)
	{
		boolean t=false,t2=false;
		char arc[]= str.toCharArray();
		int arr[]=new int[26];
		for(int i=0;i<str.length();i++)
		{
			int x=arc[i]%97;
			arr[x]=arr[x]+1;
		}
		
		
		for(int i=0;i<26;i++)
		{
			if(arr[i]%2!=0&&t==false)
			{
				t=!t;
			}
			else if(arr[i]%2!=0&&t==true)
			{
				t2=true;
				break;
			}
			
		}
		if(t2==false)
		{
			System.out.println("YES");
		}
		else
			System.out.println("NO");
	}
}
