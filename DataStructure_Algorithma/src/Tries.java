import java.util.*;


class TrieNode{
	char ch;
	TrieNode [] links;
    boolean full;
    
    TrieNode(char ch,boolean s){
    	this.ch=ch;
    	this.full=s;
    }
    
    
}



public class Tries{
	static Scanner scan=new Scanner(System.in);
	public static void main(String...args){
		String [] arr;
		int n=scan.nextInt();
		arr=new String[n];
		for(int i=0;i<n;i++){
			arr[i]=scan.next();
		}
	}
	
	
}