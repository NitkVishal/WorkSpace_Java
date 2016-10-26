import java.io.*;
import java.util.*;
public class super_this {
	public static void main(String args[])
	{
		//driv d=new driv();
		//d.xx();
		
		
	}

}
class base1
{
	public void xx()
	{
		System.out.println("base_xx");
		
	}
	base1()
	{
		
	}
	}


class driv extends base1
{
	
	public void driv()
	{
		System.out.println("driv constructur");
	}
	
	public void xx()
	{
		
	}
	}
