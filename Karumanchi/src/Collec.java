import java.util.*;
public class Collec {

	static Scanner scan=new Scanner (System.in);
	public static void main(String args[]){
    
		
	/////--------------Collection_Interface--------------////
	//-----------List_Interface------------//
		List al=new ArrayList();
		ArrayList al1=new ArrayList();
    
		List ll=new LinkedList();
		LinkedList ll1=new LinkedList();
    
		List v=new Vector();
		Vector v1=new Vector();
    
		Vector v2=new Stack();
		Stack stk=new Stack();
		List stk2= new Stack();
    
    
	//-------Set_inteface-----------//
		Set hs=new HashSet();
		HashSet hs1=new HashSet();
    
		Set lhs=new LinkedHashSet();
		HashSet lhs1= new LinkedHashSet();
		
		Set ts=new TreeSet();
		SortedSet ts1=new TreeSet();
		NavigableSet ts2=new TreeSet();
		TreeSet ts3=new TreeSet();
        
	//------Queue_Interface-------//
		
		Queue qe=new PriorityQueue();
		Queue qu1=new LinkedList();
		
     /////------------Map_interface-----------////
		//-- Map Interface Is not Child interface of collection  interface-------//
		
		
		Map hp=new HashMap();
		HashMap hm1=new HashMap();
		
		Map lhm=new LinkedHashMap();
		HashMap lhm1=new LinkedHashMap();
		LinkedHashMap lhm2=new LinkedHashMap();
		
		Map whm=new WeakHashMap();
		WeakHashMap whm1= new WeakHashMap();
		
		
		Map ihm=new IdentityHashMap();
		IdentityHashMap ihm1=new IdentityHashMap();
		
		
		Map ht=new Hashtable();
		
		
	}
}
