import java.util.*;


class Vertex{
  	public char label;
  	public boolean status;
  	
  	
  	Vertex(char label){
  		this.label=label;
  		status= false;
  	}
  }


class GraphTest{
	private final int max_ver=20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVer;
	
	
	GraphTest(){
		vertexList=new Vertex[max_ver];
		adjMat= new int[max_ver][max_ver];
		nVer=0;
		
		for(int i=0;i<max_ver;i++){
			for(int j=0;j<max_ver;j++){
				adjMat[i][j]=0;
			}
		}
	}
	
	
	public void addVertex(char lab){
		Vertex vr=new Vertex(lab);
		vertexList[nVer++]=vr;
	}
	
	public void addEdge(int s,int e){
		adjMat[s][e]=1;
		adjMat[e][s]=1;
	}
	
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
}


public class Test3 {

}
