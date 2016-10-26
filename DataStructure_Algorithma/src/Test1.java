import java.util.*;


class Data1{
	private int data;
	Data1 next;
	 Data1(int x){
		 data=x;
		 next=null;
	 }
	 public int getData(){
		 return this.data;
	 }
}


class Hash{
	public Data1 arr[];
	int size;
	 Hash(int n){
		 arr=new Data1[n];
		 size=n;
	 }
	 
	 
	 public void display(){
		 for(int i=0;i<size;i++)
		    System.out.print(arr[i].getData()+" ");
		 }
	 
	 private int hashFuc(int x){
		 return x%size;
	 }
	 
	 
	 public void insert(int x, Data1 dt){
		 int i=0;
		 int hf=hashFuc(x+i);
		 while(arr[hf]!=null&&i<size){
			 hf=hashFuc(x+(i++));
		 }
		 if(arr[hf]==null){
			 arr[hf]=dt;
		 }
	 }
	 
	 
	 public int search(int x){
		 int hf=hashFuc(x),i=0;
		 
		 while(arr[hf].getData()!=x&& i<size){
			   hf=hashFuc(x+(i++));
		 }
		 if(arr[hf].getData()==x)
		 return arr[hf].getData();
		 else return -1;
	 }
}

public class Test1{
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
		int n=scan.nextInt(),x;
		Hash hs=new Hash(n);
		for(int i=0;i<n;i++){
			x=scan.nextInt();
			Data1 dt=new Data1(x);
			hs.insert(x, dt);
		}
		hs.display();
		
		
	}
}