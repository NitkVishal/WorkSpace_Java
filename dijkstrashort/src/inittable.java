import java.util.*;
import java.io.*;
public class inittable {

  ArrayList<vertex> list_vertex;
  ArrayList<tableentry> list_tableentry = new ArrayList<tableentry>();
    public ArrayList<tableentry> initialize_table(int start )
    {

       graph g = new graph();
       list_vertex = g.readgraph();
       for(int i=0;i<list_vertex.size();i++)
       {
           list_tableentry.add(new tableentry());
           list_tableentry.get(i).set_known(false);
           list_tableentry.get(i).set_path(list_vertex.get(i));
           list_tableentry.get(i).set_header(list_vertex.get(i));
           if(list_vertex.get(i).id == start)
           {
             list_tableentry.get(i).set_distance(0);
           }
           else
           {
              list_tableentry.get(i).set_distance(Double.POSITIVE_INFINITY);
           }
           


       }
      return list_tableentry;
    }



}
