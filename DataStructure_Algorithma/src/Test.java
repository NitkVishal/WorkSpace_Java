import java.util.*;


class RBNode{
	RBNode left,right;
	int ele, color;
	
	RBNode(int element){
		this(element,null,null);
	}
	
	RBNode(int theElement, RBNode lt, RBNode rt){
		left =lt;
		right = rt;
		ele = theElement;
		color = 1; 
		}
}

class RBTree{
	
	
	private RBNode cur,par,grand,great,head;
	private static RBNode nullNode;
	
	
	static {
		nullNode = new RBNode(0);
		nullNode.left = nullNode;
		nullNode.right = nullNode;
	}
	
	
	static final int black =1;
	static final int red =0;
	
	RBTree(int x){
		head = new RBNode(x);
		head.left=null;
		head.right=null;
		}
	
	public boolean isEmpty(){
		return head.right == nullNode;
	}
	
	
	public void makeEmpty(){
		head.right= nullNode;
	}
	
	public void insert(int item){
		cur = par = grand = head;
		nullNode.ele=item;
		
		
		while(cur.ele!= item){
			great=grand;
			grand =par;
			par=cur;
			cur = item < cur.ele ? cur.left : cur.right;
			
			//if(cur.left.color == red && cur.right.color ==red)
		}
	}
	
	
	
	}



public class Test{
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String...args){
		
	}
}