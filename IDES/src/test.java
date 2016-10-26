import java.io.IOException;


public class test {

	public static void main(String args[])throws IOException
	{
		int con=0;
		String str1="";
		
		int[] ar= new int [8];
		int[] kt= {1,1,0,1,1,0,1,1,  1,0,1,1,1,1,0,0,  1,1,0,1,1,1,1,1,  1,1,1,1,0,0,0,1,
				   1,0,0,1,1,0,1,1,  1,0,1,1,1,1,0,0,  1,1,0,1,1,1,1,1,  1,1,1,1,0,0,0,1,
				   0,0,0,0,1,0,0,1,  0,0,1,1,0,1,0,0,  0,1,0,1,0,1,1,1,  0,1,1,1,1,0,0,1,
				   1,0,0,0,1,0,0,1,  0,0,1,1,0,1,0,0,  0,1,0,1,0,1,1,1,  0,1,1,1,1,0,0,1,};
		for (int j=0;j<kt.length/8;j++)
		{
			String str="";
		    for(int i=0;i<8;i++)
		    {
			
		    ar[i]=kt[con+i];
		    str=str+ar[i];
		   }
		    int deci = Integer.parseInt(str, 2);
		    char cha = (char)deci;
		    
			//System.out.println(cha);
			str1=str1+cha;
			con=con+8;
		}
		System.out.println(str1);
		
	}
	
}
