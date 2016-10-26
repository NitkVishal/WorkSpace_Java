import java.util.*;
import java.io.*;
public class vertex {

   int id;
   boolean known = false;
   int no_neighbour;
   Scanner in = new Scanner(System.in);
   ArrayList<neigh> neighbours = new ArrayList<neigh>();
   public void set_id()
   {
   System.out.println("enter the id of the vertex ");
   id = in.nextInt();
   }
   public void set_neighbours()
   {
    
    System.out.println("enter the no of neighbours of vertex id = "+id);
    no_neighbour = in.nextInt();
    for(int i =0 ;i<no_neighbour;i++)
    {
      neighbours.add(new neigh());
      neighbours.get(i).set_vert();
      neighbours.get(i).set_dist();
    }
   }




}
