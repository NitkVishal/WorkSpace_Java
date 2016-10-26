public class Disticnt_Elements 
{
	public void check(int[]a)
	{
		for (int i=0;i<a.length;i++)
		{
			boolean x=false;
			for(int j=0;j<i;j++)
			{
				if(a[i]==a[j])
				{
					x=true;
					break;
				}
			}
			if(!x)
			{
				System.out.println(a[i]);
			}
		}
	} 
	public static void main(String[] agr)
	{
		int[] a={2,2,2,4,5,1,2,4,2,5,4,25,2,4,5,7,8,7,88,7,7,7,7,7};
		Disticnt_Elements br=new Disticnt_Elements ();
		br.check(a);
		
	}
	}
 
   