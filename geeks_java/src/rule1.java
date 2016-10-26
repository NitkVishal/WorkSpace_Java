class grandparent
{
	public void print()
	{
		System.out.println("grandparent_print");
	}
	}
class parent extends grandparent
{
	public void print()
	{
		super.print();
		System.out.println("parent_print");
	}
	}
class child extends parent
{
	public void print()
	{
	    super.print();
		System.out.println("child_print");
	
	}
	}
public class rule1 {

	public static void main(String args[])
	{
		child p=new child();
		p.print();
	}
}
