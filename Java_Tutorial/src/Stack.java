import java.util.*;
public class Stack {
	int top= -1;
	int arr[];
	public static void main(String args []){
		int x,y,z; 
		Scanner scan= new Scanner (System.in);
		x=scan.nextInt();
		Stack o=new Stack (); 
		o.arr = new int[x];
		do{
			System.out.println("1.push\n2.pop\n3.display\n");
			y=scan.nextInt();
			switch (y){
			case 1:
				if(o.top==x-1)
					System.out.println("OverFlow");
				else{
					z=scan.nextInt();
					o.push(z);
				}
				break;
			case 2:
				if(o.top<0)
					System.out.println("underFlow");
				else
				    o.pop();
				break;
			case 3:
				o.display();
				break;
				
			}
		}while(y<4);
 }
	
	public int push(int x){
		top++;
		arr[top]=x;
		return 0;
	}
	
	public Integer pop(){
		arr[top]='\0';
		return top--;
		}
	public void display(){
		for(int i=0;i<=top;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
