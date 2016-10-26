import java.util.*;
public class TestClass2 {
	static Scanner scan= new Scanner(System.in);
    public static void main(String args[] ) {
     int t= scan.nextInt(),a,c,x,z,l,r;
     for(int i=0;i<=t;i++)
     {
     	a=scan.nextInt();
     	c=scan.nextInt();
     	x=scan.nextInt();
     	z=scan.nextInt();
     	
     	
     	double l1=(-1+Math.sqrt(1+2*(c-a)))/2;
        double l2=(-1-Math.sqrt(1+2*(c-a)))/2;
        //System.out.println(l1+" "+l2);
        if(l1>0)
        	l=(int)l1;
        else
        	l=(int)l2;
        l1=((-2)+Math.sqrt(4+4*4*(z-x)))/8;
        l2=((-2)-Math.sqrt(4+4*4*(z-x)))/8;
        if(l1>0)
        	r=(int)l1;
        else
        	r=(int)l2;
        System.out.println(l+" "+r);
        int s=0;
        for(int j =l;j<=r;j++)
        {
        	s+=(j+2)*(j+1);
        	}
        System.out.println(s);
     }
     
     
    }
}
