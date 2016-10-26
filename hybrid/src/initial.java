
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class initial {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter plain text");
		String s =br.readLine();
		byte[] b = s.getBytes();
		String str="";
		int[] ret = new int[b.length];
	    for (int i = 0; i < b.length; i++)
	    {
	        ret[i] = b[i] & 0xff;   
	    }
		for(int j=0;j<=ret.length-1;j++)
		{
			if(ret[j]>=65 && ret[j]<=77)
			{
				ret[j]=ret[j]+45;
				}
			else if(ret[j]>=78 && ret[j]<=90)
			{
				ret[j]=ret[j]+19;
			}
			else if(ret[j]>=97 && ret[j]<=109)
			{
				ret[j]=ret[j]-19;
			}
			else if(ret[j]>=110 && ret[j]<=122)
			{
				ret[j]=ret[j]-45;
			}
			else if(ret[j]==49)
			{
				ret[j]=51;
			}
			else if(ret[j]==50)
			{
				ret[j]=53;
			}
			else if(ret[j]==51)
			{
				ret[j]=55;
			}
			else if(ret[j]==52)
			{
				ret[j]=57;
			}
			else if(ret[j]==53)
			{
				ret[j]=49;
			}
			else if(ret[j]==54)
			{
				ret[j]=50;
			}
			else if(ret[j]==55)
			{
				ret[j]=52;
			}
			else if(ret[j]==56)
			{
				ret[j]=54;
			}
			else if(ret[j]==57)
			{
				ret[j]=56;
			}
		}
		for(int j=0;j<=ret.length-1;j++)
		{
			str=str+(char)ret[j];
			
		}
		System.out.println("After Initial_encription cp is :");
		System.out.println(str);
		System.out.println();
		ive ve=new ive();
		ve.length(str);
	}
	

}
