class Link
{
	public int data;
	public Link nextlink;

	public Link(int d)
	{
		data=d;
	}

	public void printlink()
	{
		System.out.print("==>[ "+data+" ]");
	}
}

class Link_list 
{

	Link first;
	
	public Link_list()
	{
		first=null;
	}	

	public boolean isEmpty()
	{
		if(first == null)
			return true;
		else
			return false;
	}

	public void insert(int d)
	{
		Link l=new Link(d);
		l.nextlink=first;
		first=l;	
	}

	public Link delete()
	{
		Link temp=first;
		first=first.nextlink;
		return temp;	
	}

	public void printlist()
	{
		Link currentlink=first;
		System.out.println("List : ");
			
		while(currentlink != null)
		{
			currentlink.printlink();
			currentlink=currentlink.nextlink;	
		}
	}

}

public class Link_list_test
{
	public static void main(String rn[])
	{
		Link_list list=new Link_list();

		list.insert(1);		
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);

		list.printlist();
		
		while(!list.isEmpty())
		{
			Link deletedlink=list.delete();	
			System.out.println("deleted:");
			deletedlink.printlink();
			System.out.println(" ");
			
		}

		list.printlist();
		
	}
}