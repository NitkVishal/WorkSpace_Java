import java.util.*;

public class Solution4 {
    
    
    int fabi(int a,int b,int x){
        int i=1,sum=0;
        if(x==0)
            return a;
        else if(x==1)
            return b;
          else {
            while(i<x)
                {
                sum=a+b;
                a=b;
                b=sum;
                i++;
            }
            return sum;
        }
    }

    static Scanner scan= new Scanner (System.in);
    public static void main(String[] args) {
        Solution4 o=new Solution4();
        int t=scan.nextInt(),a,b,x;
        for(int i=0;i<t;i++)
            {
            a=scan.nextInt();
            b=scan.nextInt();
            x=scan.nextInt();
            System.out.println(o.fabi(a,b,x));
           
        }
    }
}