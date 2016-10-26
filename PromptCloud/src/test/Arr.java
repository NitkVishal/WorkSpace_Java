package test;

import java.util.HashMap;
import java.util.Scanner;

public class Arr {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[]= new int[n];
		int key = 100;
		for(int i= 0;i<n;i++){
			arr[i] =scan.nextInt();
		}
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i=0;i<n;i++){
			if(map.get(arr[i])==null)
				map.put(arr[i], true);
		}
		int x;
		for(int temp: map.keySet()){
			x= 100-temp;
			if(map.containsKey(x))
				System.out.println(temp +"  "+map.containsKey(x));
		}
	}
}
