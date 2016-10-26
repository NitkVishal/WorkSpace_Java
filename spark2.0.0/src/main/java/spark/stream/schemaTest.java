package spark.stream;

import java.util.ArrayList;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class schemaTest {
	public static void main(String args[]){
		String schemaString = "name age";
	    java.util.List<StructField> fields = new ArrayList();
	    
	    for (String fieldName : schemaString.split(" ")) {
	    	  StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
	    	  fields.add(field);
	    }
	    StructType schema = DataTypes.createStructType(fields);
	    System.out.println(schema);
	    
	}
}
