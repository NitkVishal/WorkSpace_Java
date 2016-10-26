import java.util.*;
import java.io.*;

public class Heap_sort
{
	
	static void heapify(int a[],int i,int heap_size)
	{
		int l,r,largest;
		l=2*i; r=(2*i)+1;
		if(l<=heap_size && a[l]>a[i])
			largest=l;
		else
			largest=i;
		if(r<=heap_size && a[r]>a[largest])
			largest=r;
		if(largest != i)
		{
			int temp;
			temp=a[i]; a[i]=a[largest]; a[largest]=temp;
			heapify(a,largest,heap_size);
		}	
	}

	static void build_heap(int a[])
	{
		int heap_size=a.length;	
		for(int i=((heap_size-1)/2);i>=0;i--)
			heapify(a,i,heap_size-1);

	} 

	void heap_sort(int a[])
	{
		build_heap(a);
		for(int i=(a.length-1);i>=0;i--)
		{
			int temp;
			temp=a[0]; a[0]=a[i]; a[i]=temp;
			heapify(a,0,i-1);
		}
	}

	public static void main(String rn[])
	{	

		int ab[],ip=0,w,z,f,s,za,zb;
		System.out.println("Enter the size of array...");		
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();		
		ip=Integer.parseInt(str);
		System.out.println("Enter the range of input...");
		String str1=br.readLine();
		z=Integer.parseInt(str1);

		Heap_sort obj=new Heap_sort();				

		ab=new int[ip];
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
		System.out.println("HEAP SORT:");
//File Read:
		FileReader fr =new FileReader(filein);
                BufferedReader brr =new BufferedReader(fr);
		for(f=0;f<ip;f++)
			ab[f]=Integer.parseInt(brr.readLine());		
		brr.close();

//Sort the file:
		
		//for(f=0;f<ip;f++)System.out.println(ab[f]);
		long start=System.currentTimeMillis();  obj.heap_sort(ab);  long end=System.currentTimeMillis();	
		System.out.println("SORTED OUTPUT:");/*for(f=0;f<ab.length;f++)System.out.println(ab[f]);*/
		System.out.println("Execution Time="+(end-start));

//Create Sorted File:		
		FileWriter fbb=new FileWriter(fileout);
	        BufferedWriter bbb=new BufferedWriter(fbb);					
		bbb.write("Sorted Output:");		
            	bbb.newLine();
		for(f=0;f<ab.length;f++)
		{
			int t=ab[f];
		        bbb.write(""+t);		
            		bbb.newLine();
		}
		bbb.close();
		}	
		catch(Exception e){System.out.println(e);}		
		
	}

}	