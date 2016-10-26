import java.util.*;

class Link{
	private int data;
	Link next;
	
	Link(int x){
		data=x;
		next=null;
	}
	
	public int get(){
		return this.data;
	}
	
}


class Hasht{
	public Link []arr;
	public int size;
	
	Hasht(int n){
		arr=new Link[n];
		size =n;
	}
	
	
	
	
	public int  hashf(int x){
		return x%size;
	}
	
	
	public void insert(int x){
		Link ll=new Link(x);
		int hs=hashf(x);
		if(arr[hs]==null)
			arr[hs]=ll;
		else
		    chain(arr[hs],ll);
		}
	

    public void chain(Link root,Link temp){
        if(root.next==null)
        	root.next=temp;
        else
        	chain(root.next,temp);
    }
    
    private void print(Link root){
    	if(root!=null)
    	{
    		System.out.print(root.get()+" ");
    		print(root.next);
    	}
    	
    	/*while(root!=null){
    		System.out.print(root.get()+"VIshal ");
    	}*/
    }
    
    public void display(){
    	for(int i=0;i<size;i++)
    	{
    		if(arr[i]!=null)
    		{
    			print(arr[i]);
    			System.out.println();
    		}
    		else
    			System.out.println("**");
    	}
    }
    
    public int find(Link ll,int x){
    	if(ll!=null){
    		if(ll.get()==x)
    			return x;
    		else 
    			return find(ll.next,x);
    	}
    	else return -1;
    }
    
    public int  search(int x){
    	int hs=hashf(x);
    	if(arr[hs]==null)
    		return -1;
    	else 
    		return find(arr[hs],x);
    }

}

public class Seperate {
  static Scanner scan=new Scanner(System.in);
  public static void main(String...args){
	  int n=scan.nextInt(),t,x,key;
	  Hasht hs=new Hasht(n);
	  do{
		  System.out.println("\n1.Insert\n2. Display\n 3.Search");
		  t=scan.nextInt();
		  switch(t){
		  case 1:
			  x=scan.nextInt();
			  hs.insert(x);
			  break;
		  case 2:
			  hs.display();
			  break;
		  case 3:
              key=scan.nextInt();
              x=hs.search(key);
              if(x==-1)
            	  System.out.println("Not found");
              else 
            	  System.out.println("Find");
			  break;
		  }
	  }while(t<4);
  }
}
