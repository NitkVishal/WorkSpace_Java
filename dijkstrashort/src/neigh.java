import java.util.*;
import java.io.*;
public class neigh {

   int vert;
   int dist;
   Scanner in = new Scanner(System.in);
   public void set_vert()
   {
    System.out.println("enter the id of vertex");
    vert = in.nextInt();

   }
   public void set_dist()
   {
   
    System.out.println("enter the distance to vertex with id = "+vert);
    dist = in.nextInt();
    
   }
   public int get_vert()
   {
    return vert;
   }
   public int get_dist()
   {
     return dist;

   } 



}
