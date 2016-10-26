


public class App{
	public static void main(String args[]){
		Person person1= new Person("vishal chak",24);
		Person person2= new Person("Ramesh Chandra",50);
		person2.getData();
		
	}
	
}
class Person {
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public void getData(){
		System.out.println(this.name+"  "+this.age);
		
	}
}
