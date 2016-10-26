public class p1 implements p2 {
	public void eat()
	{
	   System.out.println("Eat");
	}
	
	public void travel(){
		System.out.println("Travel");
	}
	
	
	public void trip(){
		
	}
	public void kerla(){}
	
	
	public static void main(String...args){
		p1 o=new p1();
	o.travel();
	o.eat();
	}
}

interface p2 extends p3 ,p4{
	public void eat();
	public void travel();
	public int x=90;
}
interface p3{
	public void trip();
}
interface p4{
	public void kerla();
}