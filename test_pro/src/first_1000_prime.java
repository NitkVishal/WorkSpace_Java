
public class first_1000_prime {

	public static void main(String[] args)
	{
		int count =0,x=2;
		while(count<5)
		{
			boolean b=false;
			for(int i=2;i<x;i++)
			{
				if(x%i==0)
				{
					b=true;
					break;}
				}
			if(!b)
			{
				count=count+1;
				System.out.println(x);
			}
			x=x+1;
		}
		}

}
