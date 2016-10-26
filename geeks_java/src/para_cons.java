class Base1 {
    private int b;
    Base1(int x) {
        b = x;
        System.out.println("Base constructor called");
    }               
}
  
class Derived1 extends Base1 {
    private int d;
    Derived1(int x, int y) {
        // Calling parent class parameterized constructor
        // Call to parent constructor must be the first line in a Derived class
        super(x);
        d = y;
        System.out.println("Derived constructor called");
    }                   
}
  
public class para_cons{
    public static void main(String[] args) {
      Derived1 obj = new Derived1(1,2);
    }
}