package machineLearningIITKH.regrassion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Node{
	int x,y;
}


public class Lenier {

	public static void main(String[] args) {
		List<Node> list = new ArrayList<Node>();
		int x;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("1For Tranning 2 for test");
			x=scan.nextInt();
			
			switch(x){
			case 1:
				System.out.println("nter x and y");
				Node node = new Node();
				node.x = scan.nextInt();
				node.y=scan.nextInt();
				list.add(node);
				break;
				
			case 2:
				
			}
			
		
		}while(x>2);
			
	}
	public static int test(int data, List<Node> list){
		Iterator<Node> iterator =list.iterator();
		List<Integer> x=new ArrayList<Integer>(),y= new ArrayList<Integer>(), xy = new ArrayList<Integer>();
		List<Integer> x2 = new ArrayList<Integer>();
		Node node;
		int n= list.size();
		while(iterator.hasNext()){
			node = iterator.next();
			x.add(node.x);
			y.add(node.y);
			xy.add(node.x * node.y);
			x2.add(node.x^2);
		}
		int b1 = ( n *(sumetion(xy)) - sumetion(x) * sumetion(y) ) / (n * sumetion(x2) - sumetion(x)^2);
		return b1;
	}
	
	public static int sumetion(List<Integer> list){
		Iterator<Integer> iterator = list.iterator();
		int sum=0;
		while(iterator.hasNext()){
			sum+=iterator.next();
		}
		return sum;
	}
}
