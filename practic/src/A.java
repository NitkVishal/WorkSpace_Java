import java.util.*;
public class A {

	public static void main(String []args){
	Scanner scan =new Scanner(System.in);
	String str=scan.nextLine();
	A o=new A();
	
	}
	
	void rev(String str){
		char []arr=str.toCharArray();
		int x=0,y=0;
		boolean b=false;
		for (int i=0;i<str.length();i++)
		{
			if(arr[i]==' '&&b==false)
			{
				y=i-1;
				x=0;
			}
			if(arr[i]==' ')
			{
				x=y+2;
				y=i-1;
				
			}
			for(int j=y;j>=x;j--)
			{
				System.out.print(arr[j]);
			}
			System.out.print("\t");
		}
	}
	}
