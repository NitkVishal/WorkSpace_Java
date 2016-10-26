import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class dup_char {
	public void find(String str)
	{
		char [] ary=str.toCharArray();
		for(int i=0;i<ary.length;i++)
		{
			char c=ary[i];
			for(int j=i+1;j<ary.length;j++)
			{
			if(c==ary[j])
			{
				System.out.println(c);
				break;
			}	
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		System.out.println("enter string");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		dup_char dup=new dup_char();
		dup.find(str);
	}
}
