import java.util.*;
public class TestClass3 {

	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]){
		int n=scan.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scan.nextInt();
		}
		int temp=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if((arr[i]^arr[j])>temp)
					temp=arr[i]^arr[j];
			}
		}
		System.out.println(temp);
	}
}
