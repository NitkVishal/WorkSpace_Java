package candies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Candies {
	int canPrice[];
	public static void main(String args[]){
		Candies can = new Candies();
		can.priceWriter();
	}
	
	public void priceWriter(){
		BufferedReader br;
		BufferedWriter wr;
		int friends = 0, can=0, res=0,count=0;
		String temp[];
		String inputLine;
		try {
			br = new BufferedReader(new FileReader(new File("src/candies/input.txt")));
			for(int i=0;i<2;i++){
				inputLine = br.readLine();
				temp = inputLine.split(" ");
				if(i==0){
					friends = Integer.parseInt(temp[0]);
					can = Integer.parseInt(temp[1]);
				} else {
					canPrice = new int[can];
					for(int j=0;j<can;j++){
						canPrice[j]= Integer.parseInt(temp[j]);
					}
				}
			}
			
			qsort(0, can-1);
			
			int j=0;
			count=friends;
			for(int i= can-1;i>=0;i--){
				if(count==0){
					j++;
					count=friends;
				}
				count--;
				res += (j+1)*canPrice[i]; 
			}
			wr = new BufferedWriter(new FileWriter(new File("src/candies/output.txt")));
			wr.write(Integer.toString(res));
			wr.close();
			System.out.println("File Saved!!");
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IOException io) {
			System.err.println(io.getMessage());
		}
	}
	
	
	public void qsort(int l,int r){
		if(l<r){
			int p = partition(l,r);
			qsort(l, p-1);
			qsort(p+1, r);
		}
	}
	
	
	public int partition(int l,int r){
		int  i = l,j = r,m =canPrice[l],temp;
		while(i<j){
			while(canPrice[i]<=m  && i<j)
				i++;
			while(canPrice[j]> m)
				j--;
			if(i<j){
				temp = canPrice[i];
				canPrice[i]= canPrice[j];
				canPrice[j] = temp;
			}
		}
		canPrice[l]= canPrice[j];
		canPrice[j] = m;
		return j;
	}
	
}


