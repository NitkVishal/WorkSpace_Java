import java.util.*;



class Node {
 int data ;
 public Node left,right;
}


public class Tree{
	static Scanner scan=new Scanner(System.in);
	public static void main(String...args){
		Node root=null,temp;
		int n=scan.nextInt();
		for(int i=0;i<n;i++){
			temp=newNode();
			if(root==null)
				root=temp;
			else insert(root,temp);
		}
		
		in(root);
		System.out.println();
		pre(root);
		System.out.println();
		post(root);
		System.out.println();
		int x=max(root);
		System.out.println(x+" Is max");
		x=min(root);
		System.out.println(x+" Is Min");
		x=ele(root);
		System.out.println(x+" nodes");
		
		
		x=height(root);
		System.out.println("Height is "+x);
		temp=successor(root,scan.nextInt());
		System.out.println("successor is "+temp.data);
	}
	
	
	
	
	public static int height(Node root){
		if(root!=null)
			return 1+maxh(height(root.left),height(root.right));
		else return 0;
	}
	
	public static Node successor(Node temp,int x){
	    while(temp.data!=x){
	    	temp=temp.right;
	    }	
	    if(temp.right!=null){
	    	temp=temp.right;
	    	while(temp.left!=null){
	    		temp=temp.left;
	    	}
	    }
	    return temp;
	    
	}
	
	public static void delete(Node root,int x){
		
		Node temp;
		if(root!=null){
			if(root.data==x){
				temp=parent(root,x);
			}
			
		}
		
	}
	
	public static Node parent(Node root,int x)
	{
		if(root!=null){
			if(root.left.data==x||root.right.data==x)
				return root;
			else if(root.data<x)
				return parent(root.right,x);
			else
				return parent(root.left,x);
		}
		else return null;
		
	}
	
	
	public static int maxh(int x,int y){
		if(x>=y)
			return x;
		else return y;
	}
	public static int ele(Node root){
		if(root!=null){
			return 1+ele(root.left)+ele(root.right);
		}
		else return 0;
	}
	
	public static int max(Node root){
		if(root!=null){
			if(root.right==null)
				return root.data;
			else
				return max(root.right);
		}
		else
			return -1;
	}
	
	public static void in(Node root){
		if(root!=null){
			in(root.left);
			System.out.print(root.data+" ");
			in(root.right);
		}
	}
	
	
	
	public static void pre(Node root){
		if(root!=null)
		{
			System.out.print(root.data+" ");
			pre(root.left);
			pre(root.right);
		}
	}
	
	
	
	
	public static void post(Node root){
	    if(root!=null){
	    	post(root.left);
	    	post(root.right);
	    	System.out.print(root.data+" ");
	    }
	}
	
	
	public static int min(Node root){
		if(root!=null){
			if(root.left==null)
				return root.data;
			else
				return min(root.left);
			
		}
		else return -1;
	}
	
	public static void insert(Node root,Node temp){
		if(root.data>=temp.data){
			if(root.left==null)
				root.left=temp;
			else 
				insert(root.left,temp);
			}
		else if(root.data<temp.data)
		{
			if(root.right==null)
				root.right=temp;
			else
				insert(root.right,temp);
		}
			
	}
	
	
	public static Node newNode(){
		Node temp=new Node();
		temp.data=scan.nextInt();
		temp.left=null;
		temp.right=null;
		return temp;
	}
}

