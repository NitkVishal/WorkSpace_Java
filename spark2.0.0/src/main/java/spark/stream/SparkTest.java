package spark.stream;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.scheduler.SparkListener;
//import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
//import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SparkTest {

	public static SparkConf conf = null;
	public static JavaSparkContext context = null;
	public static SparkListener listener = null;
	public static SQLContext sqlContext = null;
	
	public static List<StructField> fields = new ArrayList<StructField>();

	public static void main(String[] args) {

		conf = new SparkConf().setAppName("SparkApp");
		conf.setMaster("local");
		context = new JavaSparkContext(conf);
		sqlContext = new SQLContext(context);

		JavaRDD<String> people = null;
		StringBuilder inPaths = new StringBuilder();

//		for(int i = 1 ; i<args.length; i++){
//			System.out.println(args[i]);
//			if(inPaths.length() == 0)
//				inPaths.append(args[i]);
//			else inPaths.append(","+args[i]);
//		}
		inPaths.append("name");
		inPaths.append(",age");
//		System.out.println(args[0]);
		System.out.println(inPaths);
		JavaRDD<String> schemaJavaRDD = context.textFile("schema.txt");

		people = context.textFile(inPaths.toString());

		schemaJavaRDD.foreach(new VoidFunction<String>() {

		public void call(String schemaRecord) throws Exception {
				String[] split = StringUtils.splitPreserveAllTokens(schemaRecord, "|");
				System.out.println(split[0] + " , " + split[1]);
				if(split[1].equalsIgnoreCase("double")){
					fields.add(DataTypes.createStructField(split[0], DataTypes.DoubleType, true));
				} else {
					fields.add(DataTypes.createStructField(split[0], DataTypes.StringType, true));
				}

		}
		});

		System.out.println(fields.toString());
		
		StructType schema = DataTypes.createStructType(fields);
		System.out.println("Schema Constructed : " + schema.toString());

		// Convert records of the RDD (people) to Rows.
		JavaRDD<Row> rowRDD = people.map(new Function<String, Row>() {
			public Row call(String record) throws Exception {
				String[] fields = record.split(",");
				return RowFactory.create(fields[0], fields[1]);
			}
		});

		// Apply the schema to the RDD.
//		DataFrame peopleDataFrame = sqlContext.createDataFrame(rowRDD, schema);
//		peopleDataFrame.show();
//		peopleDataFrame.write().parquet("hdfs://aiqquat2:8020/test/aditya/parquetout");
	}
}