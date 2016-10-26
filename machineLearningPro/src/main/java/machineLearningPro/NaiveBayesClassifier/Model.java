package machineLearningPro.NaiveBayesClassifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Model {
	public static void main(String args[]) throws FileNotFoundException{
		Classifier<String, String> bayes = getModel();
		Scanner scan = new Scanner(System.in);
		String data;
		while (true){
			System.out.println("Enter Data For Test");
			data = scan.nextLine();
			System.out.println(bayes.classify(Arrays.asList(data.split(" "))).getCategory());
			System.out.println();
		}
		 
	}
	
	public static Classifier<String, String> getModel(){
		String positiveTraingSet = "/home/augment/SentimantAnalysis/positive-words.txt";
		String negativeTraningSet = "/home/augment/SentimantAnalysis/negative-words.txt";
		Classifier<String, String> bayes = new BayesClassifier<String, String>();
		try {
			bayes.learn("positive", getList(positiveTraingSet));
			bayes.learn("negative" , getList(negativeTraningSet));
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		}

		System.out.println("Model has been prepared");
		return bayes;
	} 
	
	public static List<String> getList(String path) throws FileNotFoundException{
		List<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(new File(path));
		while(scan.hasNext()){
			list.add(scan.next());
		}
		return list;
	}
}
