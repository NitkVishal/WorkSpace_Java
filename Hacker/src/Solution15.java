import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution15 {

    static Scanner scan= new Scanner (System.in);
    public static void main(String[] args) {
        int t=scan.nextInt();
        
        for(int i=0;i<t;i++){
            long x=scan.nextLong();
            boolean a=false,b=false,c=false,d=false;
            if(x<=Math.pow(2, 7)-1&&x>=-Math.pow(2, 7))
               a=true;
            if(x<=Math.pow(2, 15)-1&&x>=-Math.pow(2, 15))
               b=true;
            if(x<=Math.pow(2, 31)-1&& x>=-Math.pow(2, 31))
               c=true;
            if(x<=Math.pow(2,63)-1&& x>=-Math.pow(2, 63))
               d=true;
            if(!a&&!b&&!c&&!d)
               System.out.println(x+" can't be fitted anywhere."+a+" "+b+" "+c+" "+d+" ");
            else{
                System.out.println(x+" can be fitted in:"+a+" "+b+" "+c+" "+d+" ");
                if(a)
                    System.out.println("* byte");
                if(b)
                    System.out.println("* short");
                if(c)
                    System.out.println("* int");
                if(d)
                    System.out.println("* long");
            }
        }
    }
}