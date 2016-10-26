import java.io.*;
import java.util.*;

class graph
{ 
 int v,e,w,a,b;
 int d[],p[],visited[];
 int m[][];
 
 
 void creategraph()
 {
  
 Scanner kbd=new Scanner(System.in);
 
 System.out.println("enter the no. of nodes ");
 v=kbd.nextInt();
 System.out.println("enter the no. of edges ");
 e=kbd.nextInt();
 m=new int[v+1][v+1];
 for(int i=1;i<=v;i++)
 {
  for(int j=1;j<=v;j++)
  m[i][j]=0; 
 }
 
 for(int i=1;i<=e;i++)
 {
 
  System.out.println("enter 1st node ");
  a=kbd.nextInt();
  System.out.println("enter 2nd node ");
  b=kbd.nextInt();
  System.out.println("enter the weight ");
  w=kbd.nextInt();
  m[a][b]=m[b][a]=w;
 
 }
 for(int i=1;i<=v;i++)
 {
  for(int j=1;j<=v;j++)
  System.out.print(m[i][j]+" ");
  System.out.println();
   
 } 
 }
 void calldj()
 {
  d=new int[v+1];
  p=new int[v+1];
  visited=new int[v+1];
 
 
 //System.out.println("enter src ");
 //src=kbd.nextInt();
 
  for(int i=1;i<=v;i++)
  {
   p[i]=visited[i]=0;
  }
  for(int i=1;i<=v;i++)
  {
   d[i]=32762;
  }
    
  di();
 }
 void di()
 {
  int current,dest,source;
  Scanner kbd=new Scanner(System.in);
  System.out.println("enter dest ");
  dest=kbd.nextInt();
  
  current = 1;
  visited[current]=1;
  d[current]=0;
  while(current!=dest)
  {
   int dc = d[current];
   for(int i=1;i<=v;i++)
   {
  
    if(m[current][i] != 0 && visited[i] != 1)
    {
      if(m[current][i] + dc < d[i])
     {
      d[i]=m[current][i]+dc;
      p[i]=current;
     }
    }
    
   }
   int min=32762;
   for(int i=1;i<=v;i++)
   { 
    
    if(visited[i]!=1 && d[i]<min)
    {
     min=d[i];
     current=i;
    }
   }
   visited[current]=1;
  }
  System.out.println("sortest distance from " + d[dest] );
  
 }
 
}

class dijkstra
{
 public static void main(String arg[])
 {
  graph g=new graph();
  g.creategraph();
  g.calldj();
 }
}
