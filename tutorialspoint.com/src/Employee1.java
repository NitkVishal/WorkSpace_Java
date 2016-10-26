import java.io.*;

public class Employee1{
   // salary  variable is a private static variable
   private static double salary=4545;

   // DEPARTMENT is a constant
   public static final String DEPARTMENT = "Development ";

   public static void main(String args[]){
      salary = 1000;
      salary=500;
      System.out.println(DEPARTMENT+"average salary:"+salary);
   }
}