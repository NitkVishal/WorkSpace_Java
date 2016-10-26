
import java.util.*;

class data{
	public int arr[];
	public int size;
	
	public void  setSize(int x){
		arr=new int[x];
		size=x;
	}
	
	
	public int find(int key,int l,int r){
		int cur=(l+r)/2;
		if(arr[cur]==key)
			return cur;
		else if(l>r)
			return arr.length;
		else{
			if(arr[cur]>key)
				return find(key,l,cur-1);
			else
				return find(key,cur+1,r);
			}
		}
	
	public void toh(int n,char x,char y,char z){
		if(n>0)
	    {
	        toh(n-1,x,z,y);
	        System.out.println("Disk "+(n-1)+" from "+ x+" to "+y);
	        toh(n-1,z,y,x);
	    }
	}
	
	
	public void sort(int l,int r){
		if(l<r){
			
		}
	}
	

}

class Bin{
	static Scanner scan=new Scanner(System.in);
	
	
	public static void main(String...args){
		int n,x,key,t;
		
		
		System.out.println("Hello");
		
		do{
			System.out.println("\n1.Binary\n2.toh\n3.Merge");
			x=scan.nextInt();
			switch(x){
			case 1:
				n=scan.nextInt();
				data d=new data();
				d.setSize(x);
				for(int i=0;i<n;i++)
					d.arr[i]=scan.nextInt();
				key=scan.nextInt();
				t=d.find(key, 0, n-1);
				if(t<n)
					System.out.println("Yes at"+ t );
				else
					System.out.println("NO.. not Found" );
				break;
			case 2:
				t=scan.nextInt();
				data d1=new data();
				d1.toh(t, 'A', 'B', 'C');
				break;
			case 3:
				n=scan.nextInt();
				data d2=new data();
				d2.setSize(x);
				for(int i=0;i<n;i++)
					d2.arr[i]=scan.nextInt();
				}
			}while(x<3);
	}
}