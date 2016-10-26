
public class duplicate_remove {
public void check(int[] ar)
{
	for(int i=0;i<ar.length;i++)
	{
		int x=ar[i];
		//int j=i;
		boolean b=false;
		for(int j=i+1;j<ar.length;j++)
		{
			if(x==ar[j])
			{
	          b=true;
	          break;
			}
		}
		if(!b)
			{
			System.out.println(x);
			}
		
		}
	}
	public static void main(String[] args) {
		int []ar={1,1,1,1,2,3,4,5,5,6,8,9,9,9,10,15,15,15,16,16,16,17,17};
		duplicate_remove dr=new duplicate_remove();
		dr.check(ar);
		}

}
