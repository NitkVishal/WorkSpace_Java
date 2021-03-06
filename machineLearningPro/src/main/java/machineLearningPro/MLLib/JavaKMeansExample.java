package machineLearningPro.MLLib;



import org.apache.spark.SparkConf;
// $example on$
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.mllib.clustering.KMeans;
import org.apache.spark.mllib.clustering.KMeansModel;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

public class JavaKMeansExample {
  public static void main(String[] args) {

    SparkConf conf = new SparkConf().setAppName("JavaKMeansExample").setMaster("local[*]");
    JavaSparkContext jsc = new JavaSparkContext(conf);

    // $example on$
    // Load and parse data
    String path = "/home/augment/MLData/kmeans_data.txt";
    JavaRDD<String> data = jsc.textFile(path);
    JavaRDD<Vector> parsedData = data.map(
      new Function<String, Vector>() {
        public Vector call(String s) {
        	System.out.println(s);
          String[] sarray = s.split(" ");
          double[] values = new double[sarray.length];
          for (int i = 0; i < sarray.length; i++) {
//        	  System.out.println(sarray[i]);
            values[i] = Double.parseDouble(sarray[i]);
          }
          return Vectors.dense(values);
        }
      }
    );
    parsedData.cache();
    
    
    // Cluster the data into two classes using KMeans
    int numClusters = 2;
    int numIterations = 20;
    final KMeansModel clusters = KMeans.train(parsedData.rdd(), numClusters, numIterations);

    System.out.println("Cluster centers:");
    for (Vector center: clusters.clusterCenters()) {
      System.out.println(" " + center);
    }
    double cost = clusters.computeCost(parsedData.rdd());
    System.out.println("Cost: " + cost);

    // Evaluate clustering by computing Within Set Sum of Squared Errors
    double WSSSE = clusters.computeCost(parsedData.rdd());
    System.out.println("Within Set Sum of Squared Errors = " + WSSSE);
    
    
//    System.out.println(clusters.predict(Vectors.dense(10, 25)));
    
//    JavaRDD<String> res = jsc.textFile("/home/augment/MLData/test.txt");
//    res.foreach(new VoidFunction<String>() {
//		
//		public void call(String str) throws Exception {
//			double[] values = new double[1];
//			values[0] = 10;
//			
//			int x= clusters.predict(Vectors.dense(values));
//			System.out.println(x);
//			
//		}
//	});
    
    
//   clusters.
//    clusters.save(jsc.sc(), "target/org/apache/spark/JavaKMeansExample/KMeansModel");
//    KMeansModel sameModel = KMeansModel.load(jsc.sc(),
//      "target/org/apache/spark/JavaKMeansExample/KMeansModel");
//

//    jsc.stop();
  }
}