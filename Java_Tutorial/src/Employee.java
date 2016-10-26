import java.io.Serializable;
public class Employee implements Serializable{
	
	private static final long serialVersionID = 1L;
	
	int No;
	String name;
	
	public int getEno(){
		return No;
	}
	
	public void setEmployeeNo(int no){
		this.No=no;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getEmployeeName(){
		return name;
	}
	
	}

