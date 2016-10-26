package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String agrs[]){
		List<String> list = new ArrayList<String>();
		list.add(new String("Vishal"));
		list.add(new String("Babu"));
		list.add(new String("Chak"));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
	
	public void setList(ArrayList<?> list){
		
	}
	
	public static Set union(Set s1, Set s2) {
		Set result = new HashSet(s1);
		result.addAll(s2);
		
		return result;
		}
}

interface Stack<E> {
//	public Stack() {}
	public void push(E e);
	public E pop();
	public boolean isEmpty();
}


class stk implements Stack{

	public void push(Object e) {
		// TODO Auto-generated method stub
		
	}

	public Object pop() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}