import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class char_repeat {
	public static void main (String arg[]) throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		System.out.println(str);
		String[] ary = str.split("");
		for(int i=0;i<ary.length;i++)
		{
			System.out.println(ary[i]);	
		}
	}

}
