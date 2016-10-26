import java.util.*;
import java.text.DateFormat;
public class jvt17 extends Thread {
	public void run(){
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		DateFormat dateFormatter;
		String timeOutput, dateOut;
		for(int i=0;i<=20;i++)
		{
			rightNow = new Date();
			currentLocale = new Locale("India");
			timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT,currentLocale);
			timeOutput=timeFormatter.format(rightNow);
			
		}
	}
	

}
