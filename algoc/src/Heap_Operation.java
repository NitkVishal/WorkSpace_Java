import java.io.*;
import java.util.*;

public class Heap_Operation
{

	public static int ab[],at[],ip=0,w,z,f,s,za,zb;

	public static void main(String rn[])
	{	

		
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
		String heapfile="max_heap.txt";

		FileWriter fw=new FileWriter(filein);
	        BufferedWriter bb=new BufferedWriter(fw);

		for(f=0;f<ip;f++)
		{
			int t=r.nextInt(z);			
		        bb.write(""+t);bb.newLine();
		}
		bb.close();

//Read File:
		FileReader fr =new FileReader(filein);
                BufferedReader brr =new BufferedReader(fr);
		for(f=0;f<ip;f++)
			ab[f]=Integer.parseInt(brr.readLine());		
		brr.close();


//Build Heap:

		build_heap(ab);
		
//Write Heap:		
		FileWriter fbb=new FileWriter(heapfile);
	        BufferedWriter bbb=new BufferedWriter(fbb);					
		bbb.write("Max heap:");		
            	bbb.newLine();
		for(f=0;f<ab.length;f++)
		{
			int t=ab[f];
		        bbb.write(""+t);		
            		bbb.newLine();
		}
		bbb.close();

		System.out.println("Enter your choice...");		
		System.out.println("1. Insert a key.");
		System.out.println("2. Find maximum key.");
		System.out.println("3. Extract maximum key.");
		System.out.println("4. Increase value of key.");
		String choice=br.readLine();
		int ch=Integer.parseInt(choice);
		switch(ch)
		{
			case 1:{
					System.out.println("Enter the key...");
					String str2=br.readLine();
					int key=Integer.parseInt(str2);
					insert(key);
					System.out.println("Insert successfully...");			
				}break;
			case 2:{
					System.out.println("Maximum key is...");
					int max=maximum();
					System.out.println(max);

				}break;
			case 3:{
					int max=extract_max();
					System.out.println("Maximum key is..."+max);
					System.out.println("Extract maximum key successfully...");
				}break;
			case 4:{
															
					System.out.println("Enter the key position..");
					String str3=br.readLine();
					int pos=Integer.parseInt(str3);
					System.out.println("Enter the value by which key is increases...");
					String str4=br.readLine();
					int val=Integer.parseInt(str4);
					increase_key(pos,val);
					System.out.println("Increase Successfully...");					
				}break;
			default:{System.out.println("wrong choice...");}
		}			

		}	
		catch(Exception e){System.out.println(e);}		
		
	}

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

	static void insert(int key)
	{	
		int heap_size,i;
		heap_size=ab.length;
		heap_size=heap_size+2;
		at=new int[heap_size];
		for(int m=0;m<ab.length;m++)
			at[m+1]=ab[m];		
		i=heap_size-1;
				
		while(i>1 && at[(i/2)]<key)
		{	
			at[i]=at[(i/2)];
			i=(i/2);
		}
		at[i]=key;
		
//Write File:	
		try{
		String fileout = "output.txt";	
		FileWriter fwb=new FileWriter(fileout);
	        BufferedWriter wbb=new BufferedWriter(fwb);					
		wbb.write("Output:");		
            	wbb.newLine();
		for(f=1;f<=(heap_size-1);f++)
		{
			int t=at[f];
		        wbb.write(""+t);		
            		wbb.newLine();
		}
		wbb.close();
		}catch(Exception e){System.out.println(e);};

	}
		
	static int maximum()
	{
		return ab[0];			
	}

	static int extract_max()
	{
		int max,heap_size=ab.length;
		if(heap_size<1)
			System.out.println("Error: Heap Underflow");
		max=ab[0];
		ab[0]=ab[(heap_size-1)];
		heap_size--;
		at=new int[heap_size];
		for(int m=0;m<heap_size;m++)
			at[m]=ab[m];
		
		heapify(at,0,heap_size);


		try{
		String fileout = "output.txt";	
		FileWriter fwb=new FileWriter(fileout);
	        BufferedWriter wbb=new BufferedWriter(fwb);					
		wbb.write("Output:");		
            	wbb.newLine();
		
		for(f=0;f<heap_size;f++)
		{
			int t=at[f];
		        wbb.write(""+t);		
            		wbb.newLine();
		}
		wbb.close();
		}catch(Exception e){System.out.println(e);};


		return max;			
	}
		
	static void increase_key(int p,int v)
	{
		int heap_size=ab.length;
		
		ab[p]=ab[p]+v;
				
		build_heap(ab);


		try{
		String fileout = "output.txt";	
		FileWriter fwb=new FileWriter(fileout);
	        BufferedWriter wbb=new BufferedWriter(fwb);					
		wbb.write("Output:");		
            	wbb.newLine();
		
		for(f=0;f<heap_size;f++)
		{
			int t=ab[f];
		        wbb.write(""+t);		
            		wbb.newLine();
		}
		wbb.close();
		}catch(Exception e){System.out.println(e);};


		
	}
}