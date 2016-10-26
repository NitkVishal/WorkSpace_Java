import java.util.Vector;
import java.util.Enumeration;
public class Enumetor_Tester{
	public static void main(String args[]){
		Enumeration days;
		Vector dnames= new Vector();
		
		dnames.add("Sunday");
		dnames.add("Monday");
		dnames.add("Tuesday");
		dnames.add("Wenusday");
		dnames.add("Thursday");
		dnames.add("Friaday");
		dnames.add("Saturday");
		days =dnames.elements();
		while(days.hasMoreElements()){
			System.out.println(days.nextElement());
		}
		
		}
	}
