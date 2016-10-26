class Test2 {
   int i;
   Test2 t;
   boolean b;
   byte bt;
   float ft;
}
 
public class final_privte {
    public static void main(String args[]) {
      Test2 t = new Test2(); // default constructor is called.
      System.out.println(t.i+""+t.b+""+t.t+""+t.bt+""+t.ft);
     
    }
}