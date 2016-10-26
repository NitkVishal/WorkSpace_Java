import java.io.*;
import java.util.*;

public class Insertion_sort
{
	public static void main(String rn[])
	{	
		int ab[],aw[],aa[],ip=0,w,z,f;
		System.out.println("Enter the Range for Input...");		
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		ip=Integer.parseInt(str);
	
		aa=new int[ip];ab=new int[ip];aw=new int[ip];
		Random r=new Random();		
		w=(ip-1);z=ip;				
		for(f=0;f<ip;f++)
		{
			ab[f]=f;	
			aw[f]=w;w--;
			aa[f]=r.nextInt(z);			

		}
		Insertion_sort obj=new Insertion_sort();		
		//best
		System.out.println("BEST CASE:");
		for(f=0;f<ip;f++)System.out.println(ab[f]);
		long start=System.currentTimeMillis();
		obj.sort(ab);  long end=System.currentTimeMillis();	
		System.out.println("SORTED OUTPUT:");
		for(f=0;f<ab.length;f++)System.out.println(ab[f]);
		System.out.println("Best case Execution Time="+(end-start));

		//worst
		System.out.println("WORST CASE:");for(f=0;f<ip;f++)System.out.println(aw[f]);		
		long wstart=System.currentTimeMillis();  obj.sort(aw);  long wend=System.currentTimeMillis();
		System.out.println("SORTED OUTPUT:");for(f=0;f<aw.length;f++)System.out.println(aw[f]);
		System.out.println("Worst case Execution Time="+(wend-wstart));
		
		//avg
		System.out.println("AVERAGE CASE:");for(f=0;f<ip;f++)System.out.println(aa[f]);		
		long astart=System.currentTimeMillis();  obj.sort(aa);  long aend=System.currentTimeMillis();
		System.out.println("SORTED OUTPUT:");for(f=0;f<aa.length;f++)System.out.println(aa[f]);
		System.out.println("Average case Execution Time="+(aend-astart));
		
		}	
		catch(Exception e){}		
		
	}

	void sort(int a[])
	{
		int i,j,k;
		for(i=1;i<a.length;i++)
		{
			k=a[i];
			j=i-1;
			while(j>=0&&a[j]>k)
			{   
				a[j+1]=a[j];
		     		j=j-1; 
        		}
			a[j+1]=k;		
		}
		
	}
}