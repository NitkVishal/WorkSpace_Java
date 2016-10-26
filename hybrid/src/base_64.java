
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class base_64
{
	public void conversion(String s)
	{
		String st="",str="",stm="";
		if (s.length()%3!=0)
		{
			int x=3-s.length()%3;
			for(int i=0;i<x;i++)
			{
				st=st+'$';
			}
			s=s+st;
		}
		byte[] b = s.getBytes();
		for(int i=0;i<s.length();i++)
		{
			String stb=Integer.toBinaryString(b[i]);
			if(stb.length()<8)
			{
				int t=8-stb.length();
				for(int j=0;j<t;j++)
				{
					stb='0'+stb;
				}
			}
			str=str+stb;
			}
		int cont1=0,cont2=6;
		for(int i=0;i<str.length()/6;i++)
		{
			String tem=str.substring(cont1,cont2);
			int y = Integer.parseInt(tem,2);
			//System.out.println(y);
			String c=convert(y);
			stm=stm+c;
			cont1=cont1+6;
			cont2=cont2+6;
			}
		System.out.println("After base_64 FINAL cp is : ");
		System.out.println(stm);
		}
	
	
	
	public String convert(int y)
	{
		String str = "";
		if (y==0)str="A";
		else if(y==1)str="B";
		else if(y==2)str="C";
		else if(y==3)str="D";
		else if(y==4)str="E";
		else if(y==5)str="F";
		else if(y==6)str="G";
		else if(y==7)str="H";
		else if(y==8)str="I";
		else if(y==9)str="J";
		else if(y==10)str="K";
		else if(y==11)str="L";
		else if(y==12)str="M";
		else if(y==13)str="N";
		else if(y==14)str="O";
		else if(y==15)str="P";
		else if(y==16)str="Q";
		else if(y==17)str="R";
		else if(y==18)str="S";
		else if(y==19)str="T";
		else if(y==20)str="U";
		else if(y==21)str="V";
		else if(y==22)str="W";
		else if(y==23)str="X";
		else if(y==24)str="Y";
		else if(y==25)str="Z";
		else if(y==26)str="a";
		else if(y==27)str="b";
		else if(y==28)str="c";
		else if(y==29)str="d";
		else if(y==30)str="e";
		else if(y==31)str="f";
		else if(y==32)str="g";
		else if(y==33)str="h";
		else if(y==34)str="i";
		else if(y==35)str="j";
		else if(y==36)str="k";
		else if(y==37)str="l";
		else if(y==38)str="m";
		else if(y==39)str="n";
		else if(y==40)str="o";
		else if(y==41)str="p";
		else if(y==42)str="q";
		else if(y==43)str="r";
		else if(y==44)str="s";
		else if(y==45)str="t";
		else if(y==46)str="u";
		else if(y==47)str="v";
		else if(y==48)str="w";
		else if(y==49)str="x";
		else if(y==50)str="y";
		else if(y==51)str="z";
		else if(y==52)str="0";
		else if(y==53)str="1";
		else if(y==54)str="2";
		else if(y==55)str="3";
		else if(y==56)str="4";
		else if(y==57)str="5";
		else if(y==58)str="6";
		else if(y==59)str="7";
		else if(y==60)str="8";
		else if(y==61)str="9";
		else if(y==62)str="+";
		else if(y==63)str="/";
		return str;
	}
	public static void main(String arg[]) throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("enter plain text");
	String s =br.readLine();
	base_64 t=new base_64();
	t.conversion(s);
	}
}