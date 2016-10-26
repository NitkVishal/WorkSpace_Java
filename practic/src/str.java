import java.io.*;
public class str {
public static void main(String arg[]){
	String str="vishal babu";
	char arr[]=str.toCharArray();
	char c;
    int x,z = 0;	
	for(int i=0;i<str.length();i++)
	{
	if(arr[i]==0)
	{
		if(arr[i-1]=='z'||arr[i-1]=='y')
		{
			x=i;
			for(int j=x;j>0;j++)
			{
				if(arr[j]=='\0')
				{
					z=j;
				}
			}
			for(int j=z;j<x;j++)
			{
				
			}
		}
		
		
	}
	
	
	}

	
}
}
