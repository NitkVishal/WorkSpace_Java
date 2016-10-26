import java.util.*;


class Data{
private int data;
  Data(int x){
	  data=x;
	  }
  
  public int get(){
	  return this.data;
	  }
  
  public void set(int x){
	  this.data=x;
  } 
}



class HeapT {
   private Data arr[];
   private int size,csize;
   
   HeapT(int n){
	   arr=new Data[n];
	   size=n;
	   csize=0;
   }
   
   
   public boolean isEmpty(){
	   return csize==0;
   }
   
   
   public void trickleUp(int index){
	   int par=(index-1)/2;
	   Data bottom = arr[index];
	   
	   
	   while(index>0 && arr[par].get()<bottom.get()){
		   arr[index]=arr[par];
		   index=par;
		   par=(par-1)/2;
		   
		   
	   }
   }
   
   public boolean insert(int key){
	   if(csize==size)
		   return false;
	   
	   Data dt=new Data(key);
	   arr[csize]=dt;
	   trickleUp(csize++);
	   return true;
   }
   
   public void diplay(){
	   for(int i=0;i<size;i++){
		   if(arr[i]!=null)
			   System.out.print(arr[i]+" ");
		   }
   }
}


public class HeapTest{
	static Scanner scan=new Scanner(System.in);
	public static void main(String...agrs){
		int n=scan.nextInt(),t,x;
		 
		HeapT hs=new HeapT(n);
		do{
			System.out.println("1.Insert 2. Display");
			t=scan.nextInt();
			switch(t){
			case 1:
				hs.insert(scan.nextInt());
				break;
			case 2:
				hs.diplay();
				break;
			}
		}while(t<3);
	}
}