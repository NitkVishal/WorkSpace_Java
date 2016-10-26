import java.util.Scanner;
import java.util.Stack;

public class st
{
        public static void main(String args[])
        {
        	Stack s = new Stack();
            Scanner scan=new Scanner(System.in);
            int x;
             do
             {
            	 System.out.println("1.Push\n2.Pop\n3.Display");
            	 x=scan.nextInt();
            	 switch(x)
            	 {
            	 case 1:
            		 s.push(new Integer(scan.nextInt()));
            		 break;
            	 case 2:
            		 s.pop();
            		 break;
            	 case 3:
            		 System.out.println(s);
            	 }
             }while(x<4);
        }
        }