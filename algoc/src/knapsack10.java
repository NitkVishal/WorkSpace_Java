import java.io.*;  
  
class knapsack10  
{  
  public static void main(String args[])   throws IOException  
  {  
    int capacity,n;  
      
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
    System.out.println ("\n Enter the number of items u want to enter:");  
    n= Integer.parseInt(br.readLine());  
    float p[]=new float[n+1];  
    float x[]=new float[n+1];  
    int i,j,k,w;  
    int WEIGHT[]=new int[n+1],PROFIT[]=new int[n+1];  
    WEIGHT[0]=0;  
    PROFIT[0]=0;  
    for(i=1;i<=n;i++)  
    {  
      System.out.println ("\n Enter the weight and profit of "+i+" : item ");  
      WEIGHT[i]= Integer.parseInt(br.readLine());      
      PROFIT[i]= Integer.parseInt(br.readLine());  
      p[i]=0;  
    x[i]=0;  
    }  
    System.out.println ("\n Enter the capacity of the knapsack : ");  
    capacity = Integer.parseInt(br.readLine());   
    float c[][]=new float [n+1][capacity+1];  
    for(i=0;i<=n;i++)  
      for(j=0;j<=capacity;j++)  
      c[i][j] = 0;  
    for(i=1;i<=n;i++)  
    for(w=1;w<=capacity;w++)  
    if(WEIGHT[i]<=w){  
      if ((PROFIT[i]+c[i-1][w-WEIGHT[i]])>c[i-1][w])  
      {  
    c[i][w] = PROFIT[i] + c[i-1][w-WEIGHT[i]];  
    p[i] = 1;  
      }  
      else  
      {  
     c[i][w]=c[i-1][w];  
     p[i] = 0;  
      }}  
    else  
      {  
     c[i][w]=c[i-1][w];  
     p[i] = 0;  
      }  
      
    float temp=0;  
    int t=0;  
    for(j=1;j<=capacity;j++)  
    {  
       temp = c[n-1][j]-c[n-1][j-1];  
       for(i=1;i<n;i++)  
          if(temp==PROFIT[i])  
          t=i;  
       x[t] = 1;  
  
      
    }  
    for(j=0;j<=n;j++)  
        System.out.println (j+" "+x[j] );  
    System.out.println ("The profit obtained is "+c[n][capacity]);  
  }  
}  