
public class overload {
	public static void over (int x,int y)
	{
		System.out.println("1_fuction ");
	}
	public static void over(int x ,float y)
	{
		System.out.println("2_fuction");
	}

	public static void main(String args[])
	{
		int x=10;
		float z=10;
		//over(x,x);
		over(x,z);
	}
}
