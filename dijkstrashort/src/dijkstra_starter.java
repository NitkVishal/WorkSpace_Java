import java.util.*;
import java.io.*;
public class dijkstra_starter {

 public static void main(String args[])
 {
  dijkstra w = new dijkstra(); 
  ArrayList<tableentry> table;
  table = w.start_dijkstra(); 
  System.out.println("table size = " + table.size());
  for(int i =0;i<table.size();i++)
  {
   System.out.println("V ");
    System.out.print(table.get(i).get_header().id);
    System.out.print("  "+table.get(i).get_known());
    System.out.print("  "+table.get(i).get_distance());
    System.out.print("  v"+table.get(i).get_path().id);

  }



 }


}



