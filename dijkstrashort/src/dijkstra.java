import java.util.*;
import java.io.*;
public class dijkstra {
  
    int vid = -1;
    int wid = -1;
    public ArrayList<tableentry> start_dijkstra()
    {
    vertex v,w;
    Scanner in = new Scanner(System.in);
    System.out.println("enter the id of the source node");
    int start = in.nextInt();
    inittable t = new inittable();
    ArrayList<tableentry> table = t.initialize_table(start);
    while(true)
               {
                vid = -1;
                v = find_smallest(table);
                if((v == null)||(vid == -1)){break;}
                table.get(vid).set_known(true);
                for(int k=0;k<v.no_neighbour;k++)
                {
                  wid = get_vid(table,v.neighbours.get(k).get_vert());
                  if(!table.get(wid).get_known())
                      {
                         if((table.get(vid).get_distance()+v.neighbours.get(k).get_dist())<(table.get(wid).get_distance()))
                         {
                           table.get(wid).set_distance((table.get(vid).get_distance()+v.neighbours.get(k).get_dist()));
                           table.get(wid).path = v;

                         }
                      }

                }
                
                
               }
     return table;
    }
    public vertex find_smallest(ArrayList<tableentry> table)
    {
      double min = Double.POSITIVE_INFINITY;
      vertex v = null;
      for(int i=0;i<table.size();i++)
      {
        if((table.get(i).get_distance()<min)&&(table.get(i).get_known()== false))
        {
          min = table.get(i).get_distance();
          v = table.get(i).get_header();
          vid = i;
        }



      }

     return v;
    }
    public int get_vid(ArrayList<tableentry> table,int identity)
    {
       int j;
       for(j=0;j<table.size();j++)
      {
         if(table.get(j).get_header().id == identity)
         { break;}
            
      }
     return j;
    }

}




