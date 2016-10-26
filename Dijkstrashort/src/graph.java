import java.util.*;
import java.io.*;
public class graph {

   public ArrayList<vertex>  readgraph()
   {
     Scanner in = new Scanner(System.in);
     ArrayList<vertex> list_vertices = new ArrayList<vertex>();
     System.out.println("enter the no of vertices");
     int no_vertices = in.nextInt();
     for(int i = 0;i<no_vertices;i++)
     {  
        System.out.println("enter the details of "+(i+1)+" vertex");
        list_vertices.add(new vertex());
        list_vertices.get(i).set_id();

     }
     for(int i = 0;i<no_vertices;i++)
     {
        
        list_vertices.get(i).set_neighbours();

     }
     vertex v;
     for(int i = 0;i<no_vertices;i++)
     {
        
       v = list_vertices.get(i);
       System.out.println("vetex id =="+v.id);
       System.out.println("no of neighbours of vetex =="+v.no_neighbour);
       for(int w=0;w<v.no_neighbour;w++)
       {
         System.out.println(v.neighbours.get(w).get_vert()+"  "+v.neighbours.get(w).get_dist());


       }

     }
      return list_vertices;
   }





}
