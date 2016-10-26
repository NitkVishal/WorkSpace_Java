

public class duplicate_no {
	public static void main(String arg[])
	{
		int [] arr={1,1,1,1,};
		
		for (int i=0;i<arr.length;i++)
		{
			int x=arr[i];
			for(int j=i+1;j<arr.length;)
			{
				if(x==arr[j])
					System.out.println(x);
				break;
			}
		}
		
	}

}
