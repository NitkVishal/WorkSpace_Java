import java.util.*;
import java.io.*;
public class tableentry {

   vertex header;
   boolean known;
   double distance;
   vertex path;
   public void set_header(vertex v)
   {
    header = v;

   }
   public vertex get_header()
   {
    return header;

   }
   public void set_known(boolean dd)
   {
    known = dd;

   }
   public boolean get_known()
   {
    return known;

   }
   public void set_distance(double d)
   {
    distance = d;

   }
   public double get_distance()
   {
    return distance;

   }
    public void set_path(vertex v)
   {
    path = v;

   }
   public vertex get_path()
   {
    return path;

   }
   
}



