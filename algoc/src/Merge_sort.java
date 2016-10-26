
import java.io.*;
import java.util.*;

public class Merge_sort
{
	public static void main(String rn[])
	{	

		int ab[],aw[],aa[],ip=0,w,z,f,s,za,zb;
		System.out.println("Enter the size of array...");		
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		ip=Integer.parseInt(str);
		System.out.println("Enter the range of input...");
		String str1=br.readLine();
		z=Integer.parseInt(str1);

		Merge_sort obj=new Merge_sort();				
		System.out.println("Eneter the ratio p:r");
		System.out.print(" p=");
		String str2=br.readLine();
		za=Integer.parseInt(str2);
		System.out.print(" r=");
		String str3=br.readLine();
		zb=Integer.parseInt(str3);

		aa=new int[ip];ab=new int[ip];aw=new int[ip];
		Random r=new Random();		
		w=(ip-1);				
// File Create:
		String filein = "input.txt";
		String fileout = "output.txt";
		FileWriter fw=new FileWriter(filein);
	        BufferedWriter bb=new BufferedWriter(fw);

		for(f=0;f<ip;f++)
		{
			int t=r.nextInt(z);			
		        bb.write(""+t);bb.newLine();
		}
		bb.close();
		System.out.println("AVG CASE:");
//File Read:
		FileReader fr =new FileReader(filein);
                BufferedReader brr =new BufferedReader(fr);
		for(f=0;f<ip;f++)
			ab[f]=Integer.parseInt(brr.readLine());		
		brr.close();

//Sort the file:
		
		//for(f=0;f<ip;f++)System.out.println(ab[f]);
		long start=System.currentTimeMillis();  obj.sort(ab,0,(ip-1),za,zb);  long end=System.currentTimeMillis();	
		//System.out.println("SORTED OUTPUT:");for(f=0;f<ab.length;f++)System.out.println(ab[f]);
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

	public void sort(int a[],int p,int r,int za,int zb)
	{
		int ta=za,tb=zb;
		if(p<r && ta<=tb)
		{
			Merge_sort o=new Merge_sort();				
			int t=((r-p+1)*ta)/(ta+tb);
			int q=p+t;
			o.sort(a,p,q,ta,tb);
			o.sort(a,q+1,r,ta,tb);
			o.merge(a,p,q,r);
		}
		
	}

	
	public void merge(int a[],int p,int q,int r)
	{
		int n1,n2,i,j;
		n1=q-p+1;
		n2=r-q;

		int[] ll=new int[(n1+1)];
		int[] rr=new int[(n2+1)];
		for(i=0;i<n1;i++)
			ll[i]=a[p+i];
		for(j=0;j<n2;j++)
			rr[j]=a[q+j+1];
	
		ll[n1]=10000000;
		rr[n2]=10000000;

		i=0;j=0;
		for(int t=p;t<=r;t++)
		{
			if(ll[i]<rr[j])
			{
				a[t]=ll[i];
				i++;
			}
			else
			{
				a[t]=rr[j];
				j++;
			}
		}
	}

}