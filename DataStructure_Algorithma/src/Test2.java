import java.util.*;

class Data2{
	private int data;
	
	Data2(int  x){
		data=x;
	}
	
	public int get(){
		return data;
	}
	
	public void set(int x){
		data=x;
	}
}



class HeapTr {
   private Data2 []arr;
   private int size,csize;
   
   HeapTr(int n){
	   size=n;
	   arr=new Data2[n];
	   csize =0;
   }
   
   public boolean isEmpty(){
	   return csize==0;
   }
   
   public boolean insert(int x){
	   if(csize==size)
		   return false;
	   Data2 dt=new Data2(x);
	   arr[csize]= dt;
	   trickleUp1(csize++);
	   return true;
   }
   
   public void trickleUp(int index){
	   int par=(index-1)/2;
	   Data2 bottom=arr[index];
	   
	   
	   while(index>0 && arr[par].get()> bottom.get()){
		   index=par;
		   par=(par-1)/2;
		   arr[index]=arr[par];
		   
	   }
	   arr[par]=bottom;
   }
   
   
   
   public void trickleUp1(int index){
	   int par=(index-1)/2;
	   Data2 bottom =arr[index];
	   while(arr[par].get()>bottom.get() && index>0){
		   arr[index]=arr[par];
		   index=par;
		   par=(par-1)/2;
		   //bottom=arr[par];
		   }
	   arr[par]=bottom;
   }
   
   public void remove(){
	   Data2 dt=arr[0];
	   arr[0]=arr[--csize];
	   trickleD(0);
   }
   
   
  
   
   public void trickleD(int index){
	   int smallC;
	   Data2 top=arr[index];
	   while(index <csize/2){
		   int leftC=2*index+1;
		   int rightC = leftC+1;
		   if(rightC<csize  && arr[leftC].get()<arr[rightC].get()){
			   smallC=leftC;
		   }
		   else 
			   smallC=rightC;
		   if(top.get() > arr[smallC].get())
			   {
			   arr[index]=arr[smallC];
			   index=smallC;
			   }
		   else break;
		   }
	   arr[index]=top;
	   
   }

   
   public void display(){
	   System.out.print("Heap Array: ");
	   for(int i=0;i<csize;i++){
		   if(arr[i]!=null)
			   System.out.print(arr[i].get()+" ");
		   else 
			   System.out.print("--");
	   }
	   System.out.println();
   }
}



public class Test2{
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
		int n=scan.nextInt(),t,x;
		HeapTr hs=new HeapTr(n);
		do{
			System.out.print("1.Insert 2.DiplayHeap  3. Remove\n");
			t=scan.nextInt();
			switch(t){
			case 1:
				hs.insert(scan.nextInt());
				break;
			case 2:
				hs.display();
				break;
			case 3:
				hs.remove();
				break;
			}
		}while(t<4);
	}
}
