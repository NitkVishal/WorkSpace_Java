package predecessor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Predecessor {
	public static void main(String args[]){
		String list1[]=null,list2[]=null,temp[],first="",sec="";
		int count =0,length;
		BufferedReader br;
		BufferedWriter wr;
		try {
			br = new BufferedReader(new FileReader(new File("src/predecessor/input.txt")));
			String inputLine;
			while((inputLine=br.readLine())!=null){
				if(count==0)
					list1 = inputLine.split(",");
				else if(count==1)
					list2  = inputLine.split(",");
				else {
					temp = inputLine.split(",");
					first= temp[0];
					sec= temp[1];
				}
				count++;
			}
			wr = new BufferedWriter(new FileWriter("src/predecessor/output.txt"));
			if(list1.length<=list2.length)
				length=list1.length;
			else length= list2.length;
			for(int i=0; i<length;i++){
				if(!list1[i].equals(list2[i]) && i==0){
					wr.write("Common Predecessor: "+ "Not Found");
					break;
				} else if(list1[i].equals(list2[i]) && list1[i].equals(first) ){
					wr.write("Common Predecessor: "+ first);
					break;
				} else if( list1[i].equals(list2[i]) && list2[i].equals(sec)){
					wr.write("Common Predecessor: "+ sec);
					break;
				} else if(!list1[i].equals(list2[i]) && i>0){
					wr.write("Common Predecessor: "+ list1[i-1]);
					break;
				} 
			}
			wr.close();
			System.out.println("File Saved!!");
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IOException io) {
			System.err.println(io.getMessage());
		}
	}
	
	
	
}
