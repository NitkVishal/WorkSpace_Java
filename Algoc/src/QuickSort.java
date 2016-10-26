import java.io.*;
import java.util.*;

public class QuickSort
{
	int x,i,j;
	int partition(int a[],int p,int r)
	{
		x=a[p];
		i=p-1;
		j=r+1;

		while(true)
		{
			do{j--;}while(a[j]>x);
			
			do{i++;}while(a[i]<x);
			
			
			if(i<j)
			{
				int t;
				t=a[i];a[i]=a[j];a[j]=t;
			}
			else
			return j;
			
		}	
	}

	void sort(int a[],int p,int r)
	{
		QuickSort obj1=new QuickSort();
		int q;
		if(p<r)
		{
			q=obj1.partition(a,p,r);
			obj1.sort(a,p,q);
			obj1.sort(a,(q+1),r);	
		}
	}

	public static void main(String rn[])
	{	
		int ab[],ip=0,w,z,f,s,x;

		System.out.println("Enter the Range for Input...");		
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		ip=Integer.parseInt(str);
	
		ab=new int[ip];
		Random r=new Random();		
		w=(ip-1);z=ip;x=(ip-1);				
// File Create:
		String filein = "in.txt";
		String fileout = "out.txt";
		FileWriter fw=new FileWriter(filein);
	        BufferedWriter bb=new BufferedWriter(fw);

		System.out.println("Enter your Choice:");
		System.out.println("1:Worst Case");
		System.out.println("2:Avg Case");
		String str1=br.readLine();
		s=Integer.parseInt(str1);
		switch(s)
		{
			case 1: {
				for(f=0;f<ip;f++)
				{
		        		bb.write(""+f);bb.newLine();
				}
				bb.close();
				System.out.println("WORST CASE:");
				}break;
			case 2: {
				for(f=0;f<ip;f++)
				{
					int t=r.nextInt(z);			
		        		bb.write(""+t);bb.newLine();
				}
				bb.close();
				System.out.println("AVG CASE:");
				}break;
			default:{System.out.println("your Choice is wrong..");}
		}				
//File Read:
		FileReader fr =new FileReader(filein);
                BufferedReader brr =new BufferedReader(fr);
		for(f=0;f<ip;f++)
			ab[f]=Integer.parseInt(brr.readLine());		
		brr.close();

//Sort the file:
		QuickSort obj=new QuickSort();		
		for(f=0;f<ip;f++)System.out.println(ab[f]);
		long start=System.currentTimeMillis();  obj.sort(ab,0,x);  long end=System.currentTimeMillis();	
		System.out.println("SORTED OUTPUT:");for(f=0;f<ab.length;f++)System.out.println(ab[f]);
		System.out.println("Best case Execution Time="+(end-start));

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