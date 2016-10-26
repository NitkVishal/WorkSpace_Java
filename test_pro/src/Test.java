import java.util.StringTokenizer;

class Test
{
	
	public static void main(String args[]) {
		String s = "Get Entertained";
		StringTokenizer st = new StringTokenizer(s, "t");
		while(st.hasMoreElements())
		System.out.print(st.nextToken());
	}
}