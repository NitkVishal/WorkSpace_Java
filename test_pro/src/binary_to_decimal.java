import java.util.*;
public class binary_to_decimal {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter binary no");
		
		//boolean [] b=new boolean[6];
		String str=scan.next();
		int x=0,y=1;
		char []ary=str.toCharArray();
		for(int i=ary.length-1;i>=0;i--)
		{
			if(ary[i]=='1')
			{
				
				x=x+y;
			}
			y=y*2;
		}
		System.out.println("decimal val of "+str+"= "+x);
		scan.close();
		}

}
