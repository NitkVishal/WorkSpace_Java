import java.io.*;
import java.util.*;

public class CountingSort
{
	public void sort(int a[],int b[],int k)
	{
		int[] c=new int[(k+1)];
		for(int i=0;i<=k;i++)
			c[i]=0;
		for(int j=0;j<a.length;j++)
			c[(a[j])]=c[(a[j])]+1;		
		for(int i=1;i<=k;i++)
			c[i]=c[i]+c[i-1];					
		for(int j=a.length-1;j>=0;j--)
			{
				b[c[a[j]]]=a[j];
				c[(a[j])]=c[(a[j])]-1;
			}					
	}

	public static void main(String rn[])
	{	
		int ab[],aa[],ip=0,y,z,f;
		String filein = "in.txt";
		String fileout = "out.txt";

		System.out.println("Enter the size of array a=");		
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		ip=Integer.parseInt(str);
		System.out.println("Enter the maximum range of elements k=");
		String str1=br.readLine();
		y=Integer.parseInt(str1); 	

		aa=new int[ip];ab=new int[ip+1];
		Random r=new Random();		
		z=0;			
//Create Unsorted File:
		FileWriter fw=new FileWriter(filein);
	        BufferedWriter bb=new BufferedWriter(fw);				
		for(f=0;f<ip;f++)
		{
			int t=r.nextInt(y-z)+z;			
		        bb.write(""+t);		
            		bb.newLine();

		}
		bb.close();
		
//File Read:
		FileReader fr =new FileReader(filein);
                BufferedReader brr =new BufferedReader(fr);
		for(f=0;f<ip;f++)	
			aa[f]=Integer.parseInt(brr.readLine());
		brr.close();

		CountingSort obj=new CountingSort();		

		System.out.println("COUNTING SORT:");for(f=0;f<ip;f++)System.out.println(aa[f]);		
		long astart=System.currentTimeMillis();  obj.sort(aa,ab,y+1);  long aend=System.currentTimeMillis();
		System.out.println("SORTED OUTPUT:");for(f=1;f<ab.length;f++)System.out.println(ab[f]);
		System.out.println("Average case Execution Time="+(aend-astart));

//Create Sorted File:		
		FileWriter fbb=new FileWriter(fileout);
	        BufferedWriter bbb=new BufferedWriter(fbb);					
		bbb.write("Sorted Output:");		
            	bbb.newLine();
		for(f=1;f<ab.length;f++)
		{
			int t=ab[f];
		        bbb.write(""+t);		
            		bbb.newLine();
		}
		bbb.close();

		
		}	
		catch(Exception e){}				
	}
}