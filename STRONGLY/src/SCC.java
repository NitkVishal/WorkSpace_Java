
import java.util.*;

class Node {
	int value;
	String colour;
	int parent;
	int startTime;
	int finishTime;	
}
class AdjArray {
    public  LinkedList< Integer > adjList=new LinkedList<Integer>();
}
public class SCC {

	public static int time=0;
	private static Scanner scan;
	
	public static Node[] initGraph(int v)
	{
		Node vertexSet[]=new Node[v];
		for(int i=0;i<v;i++)
		{			
			vertexSet[i]=new Node();
			vertexSet[i].value=i;
			vertexSet[i].parent=-1;
			vertexSet[i].colour="WHITE";			
		}
		return vertexSet;
	}
	public static void createAdjList(AdjArray lg[],AdjArray lgt[],Node vertexSet[])
	{
		scan = new Scanner(System.in);		
		for(int i=0;i<lg.length;i++)			
			lg[i]=new AdjArray();
		
		
		for(int i=0;i<lgt.length;i++)
			lgt[i]=new AdjArray();
		
		String sMoreFlg="Y";
		for(int i=0;i<vertexSet.length*(vertexSet.length-1);i++)
		{
			System.out.println("Enter Edge Y/N");
			sMoreFlg=scan.nextLine();
			if(sMoreFlg.equals("N"))
				break;
			System.out.println("For directed edge v1 to v2");
			String v1s=scan.nextLine();
			String v2s=scan.nextLine();			
			
			int v1=Integer.parseInt(v1s);
			int v2=Integer.parseInt(v2s);
			lg[v1].adjList.add(v2);
			lgt[v2].adjList.add(v1);			
		}

		//printing the adj list of G
		System.out.println("Graph G: Edges: ");
		for(int i=0;i<lg.length;i++)
		{
			Iterator<Integer> iterator=lg[i].adjList.iterator();
			while(iterator.hasNext())
				System.out.print(i + " to " + iterator.next() + ", ");
		}
		
		//printing the adj list of G transpose
		System.out.println();
		System.out.println("Graph G transpose: Edges: ");
		for(int i=0;i<lgt.length;i++)
		{
			Iterator<Integer> iterator=lgt[i].adjList.iterator();
			while(iterator.hasNext())
				System.out.print(i + " to " + iterator.next() + ", ");
		}
		
	}
	
	public static LinkedList<Integer> dfs(Node vertexSet[],AdjArray lg[])
	{
		String sFlg="dfs";
		LinkedList< Integer > sortedDescFinishTimeList=new LinkedList<Integer>();
		for(int i=0;i<vertexSet.length;i++)
		{
			if(vertexSet[i].colour=="WHITE")
			{
				dfsVisit(vertexSet,lg,vertexSet[i].value,sortedDescFinishTimeList,sFlg);
				System.out.println();
			}										
		}
		return sortedDescFinishTimeList;
	}


	public static void dfst(Node vertexSet[],AdjArray lgt[],LinkedList< Integer > sortedDescFinishTimeList)
	{	
		String sFlg="dfst";
		Iterator<Integer> i=sortedDescFinishTimeList.iterator();
		int u;
		while(i.hasNext())
		{
			u=i.next();
			if(vertexSet[u].colour=="WHITE")
			{				
				dfsVisit(vertexSet,lgt,vertexSet[u].value,sortedDescFinishTimeList,sFlg);
				System.out.println();
			}										
		}
	}


	public static void dfsVisit(Node vertexSet[],AdjArray lg[],int u,LinkedList<Integer> sortedDescFinishTimeList,String sFlg)
	{
		vertexSet[u].colour="GREY";		
		time++;
		vertexSet[u].startTime=time;
		Iterator<Integer> j=lg[u].adjList.iterator();
		while(j.hasNext())
		{
			int v=j.next();
			
			if(vertexSet[v].colour=="WHITE")
			{
				vertexSet[v].parent=u;				
				dfsVisit(vertexSet,lg,v,sortedDescFinishTimeList,sFlg);
			}
		}
		vertexSet[u].colour="BLACK";
		time++;
		vertexSet[u].finishTime=time;
		System.out.print(u + " ");
		
		//add to the head of the linked list which stores vertices in desc order of finishing times
		//only add in case dfsVisit is called from dfs to prevent modification of list when dfsVisit is called from dfst
		if(sFlg=="dfs")
		{
			sortedDescFinishTimeList.addFirst(u);
		}
	}
	
	public static void main(String args[])
	{
		//input number of vertices of graph
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of vertices");		
		int v=s.nextInt();
		
		AdjArray lg[],lgt[];
		lg=new AdjArray[v];		
		lgt=new AdjArray[v];
		
		//initialize the vertices of graph
		Node vertexSet[]=initGraph(v);
		
		//create adj lists for G and G transpose while taking inputs from user for edges
		createAdjList(lg,lgt,vertexSet);
		
		//execute dfs on G
		System.out.println();
		System.out.println("Printing DFS in ascending order of finishing times:");
		LinkedList<Integer> sortedDescFinishTimeList=dfs(vertexSet,lg);
		
		//reinitialize the vertices of graph for G transpose
		vertexSet=initGraph(v);
		
		//execute dfs on G transpose using desc order of finishing times list returned from dfs on G
		System.out.println("Printing Strongly Connected Components:");
		dfst(vertexSet,lgt,sortedDescFinishTimeList);		
	}

}

