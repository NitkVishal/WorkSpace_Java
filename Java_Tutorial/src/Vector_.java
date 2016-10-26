import java.util.Vector;
public class Vector_{
	public static void main(String args[]){
		Vector v=new Vector(10,5);
		for(int i=0;i<10;i++){
			v.addElement(i);
		}
		System.out.println(v.capacity());
		v.addElement(3);
		System.out.println(v.capacity());
		
	}
	
		
}