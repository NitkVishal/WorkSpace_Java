import java.io.*;
import java.util.*;
public class Solution_game_of_thrones1 {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		Solution_game_of_thrones1 t=new Solution_game_of_thrones1();
		t.check(str);
	}
	
	void check(String str)
	{
		boolean t=true;
		
        String str1="YES";
		
		char arr[]=str.toCharArray();
		
		char c1 = '\0';
		for(int i=0;i<arr.length;i++)
		{
			int cou=0;
			char c=arr[i];
			for(int j=0;j<arr.length;j++)
			{
				if(c==arr[j])
				{
					cou=cou+1;
				}
			}
			System.out.println(cou);
			if(cou%2!=0&&t==true)
			{
				t=false;
				c1=c;
			}
			
			else if(cou%2!=0&&c1!=c&&t==false)
			{
				str1="NO";
				break;
			}
			//System.out.println(c1);
			}
		System.out.println(str1);
	}
}

