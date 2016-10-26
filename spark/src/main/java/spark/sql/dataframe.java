package spark.sql;

import org.apache.spark.SparkConf;

//import org.apache.spark.sql.SparkSession;

public class dataframe {
	public static void main(String args[]){
		SparkConf conf = new SparkConf().setAppName("2.0.0").setMaster("local[*]");
	}

}
