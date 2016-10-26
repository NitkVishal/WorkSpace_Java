import java.util.Arrays;
public class Jvt8 {
	
	public static void main(String args[]){	
		int arr[]=new int[10];
		for(int i=0;i<10;i++)
			arr[i]=i;
		String str=Arrays.toString(arr);
		str=str +" Vishal";
		int x=10;
		String st=Integer.toString(x);
		x=Integer.parseInt(st);
		x++;
		//arr=Arrays.parse
		System.out.println(x);
		Arrays.fill(arr, 5);
		System.out.println(Arrays.toString(arr));
	
	}
	
}
