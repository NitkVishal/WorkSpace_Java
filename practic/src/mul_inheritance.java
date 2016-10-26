import java.util.*;
public class mul_inheritance {

	public static void main(String []args){
	Scanner scan =new Scanner(System.in);
	String str=scan.nextLine();
	mul_inheritance o=new mul_inheritance();
	o.rev(str);
	
	}
	
	void rev(String str){
		//System.out.println(str);
		char []arr=str.toCharArray();
		int x=0,y=0;
		boolean b=false;
		for (int i=0;i<str.length();i++)
		{
			if((arr[i]==' '||arr[i]=='0')&&b==false)
			{
				y=i-1;
				x=0;
				for(int j=y;j>=x;j--)
				{
					System.out.print(arr[j]);
				}
			}
			if(arr[i]==' ')
			{
				x=y+2;
				y=i-1;
				for(int j=y;j>=x;j--)
				{
					System.out.print(arr[j]);
				}
				
			}
			
			//System.out.print(arr[i]);
		}
	}
	}