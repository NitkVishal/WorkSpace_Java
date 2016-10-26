package clientserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

public class Simple{  
	 public static void main(String args[])throws Exception{  
	  File file = new File("/home/augment/Trigger2.txt");
	  readFile1(file);
	 }
	 
	 private static void readFile1(File fin) throws IOException {
			FileInputStream fis = new FileInputStream(fin);
		 
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//			JSONParser parser = new JSONParser();
//			JSONObject json = (JSONObject) parser.parse(stringToParse);
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		 
			br.close();
		}
	 
	}
