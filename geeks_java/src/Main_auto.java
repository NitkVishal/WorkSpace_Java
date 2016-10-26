class Base_auto	 {
  Base_auto() {
    System.out.println("Base Class Constructor Called ");
  }
}
 
class Derived_auto extends Base_auto {
  Derived_auto() {
    System.out.println("Derived Class Constructor Called ");
  }
}
 
public class Main_auto {
  public static void main(String[] args) { 
    Derived_auto d = new Derived_auto();
  }
}