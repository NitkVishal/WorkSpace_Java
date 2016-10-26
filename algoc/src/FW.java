import java.io.*;
import java.util.*;

class FW
{
	public static void main(String rn[])
	{
		int w[][],d[][],t[][],p[][],q[][],n,i,j,k,l;	
								//consider infinity=999 and NIL=0;
		
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
			System.out.print("Enter the total no of nodes of graph:");
			n=Integer.parseInt(br.readLine());

			w=new int[n+1][n+1];
			d=new int[n+1][n+1];
			t=new int[n+1][n+1];		
			p=new int[n+1][n+1];		
			q=new int[n+1][n+1];		
	
			for(i=1;i<=n;i++)
			{
				System.out.println("Enter the distance from node "+i);
				for(j=1;j<=n;j++)
				{
					System.out.print("to node "+j+" is=");	
					w[i][j]=Integer.parseInt(br.readLine());
				}
				System.out.println("");
			}
			
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					d[i][j]=w[i][j];
	
					if(i==j || w[i][j]==999)
						p[i][j]=0;

					if(i!=j)
						p[i][j]=i;			
				}
			}			
			
			

			for(k=1;k<=n;k++)
			{
				for(i=1;i<=n;i++)
				{
					for(j=1;j<=n;j++)
					{
						if((d[i][j])<(d[i][k]+d[k][j]))
							t[i][j]=d[i][j];
						else
							t[i][j]=(d[i][k]+d[k][j]);					
					
						if((d[i][j])<=(d[i][k]+d[k][j]))
							q[i][j]=p[i][j];
						else
							q[i][j]=p[k][j];
					}
				}
			
			
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					d[i][j]=t[i][j];
					p[i][j]=q[i][j];
				}
			}
		
			}

			System.out.println("Distance Matrix:");
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					System.out.print(d[i][j]+"  ");
				}
				System.out.println("");
			}	

			System.out.println("");
			System.out.println("Path Matrix:");
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					System.out.print(p[i][j]+"  ");
				}
				System.out.println("");
			}		
			
			System.out.println("");
			System.out.println("You want to find path between any two vertices???");
			System.out.println("1. Yes");
			System.out.println("2. No");
				
			int c=Integer.parseInt(br.readLine());
			switch(c)
			{
				case  1:
					{
						System.out.println("Enter the starting vertex:");
						int s=Integer.parseInt(br.readLine());
						System.out.println("Enter the end vertex:");			
						int e=Integer.parseInt(br.readLine());
						int m=e;
						System.out.println("");
						System.out.println("The path from node "+s+" to node "+e+" :");
						System.out.println("");
						while(s!=m)
						{
							System.out.print(+m+"<---");	
							m=p[s][m];
							
						}
						System.out.print(s);
						System.out.println("");
						System.out.println("The total cost of path = "+d[s][e]);
		
					}break;
				case  2:
					{
					
					}break;
				default:
					{
						System.out.println("Wrong Choice...");
					}
			}	

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}