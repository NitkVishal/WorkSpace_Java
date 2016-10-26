import java.util.*;

class DataItem{
	
	
	private int data;
	
	
	DataItem(int x){
		data=x;
	}
	
	
	public int getKey(){
		return data;
	}
}



class HashTable{
	
	
	private DataItem arr[];
	private int arrSize;
	private DataItem nonItem;
	
	
	HashTable(int size){
		arrSize=size;
		arr=new DataItem[size];
		nonItem=new DataItem(-1);
		
		
	}
	
	public void displaytable(){
		for(int i=0;i<arrSize;i++){
			if(arr[i]!=null)
				System.out.println(arr[i].getKey()+" ");
			else
				System.out.println("** ");
		}
	}
	
	
	public int hashFuc(int key ){
		return key%arrSize;
	}
	
	
	public void insert(int x,DataItem item){
		int hashVal=hashFuc(x);
		
		
		while(arr[hashVal]!=null  && arr[hashVal].getKey()!=-1){
            	hashVal++;
            	hashVal%=arrSize;
            }
		arr[hashVal]=item;
	}
	
}




public class HashTablea{
	static Scanner scan=new Scanner(System.in);
   public static void main(String...args){
	   int n=scan.nextInt();
	   HashTable ht=new HashTable(n);
	   for(int i=0;i<n;i++){
		   int x=scan.nextInt();
		   DataItem temp=new DataItem(x);
		   ht.insert(x,temp);
	   }
	   
	   ht.displaytable();
	   
   }	
}