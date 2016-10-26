import java.io.*;
import java.util.*;
public class Solution_halloween
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        for (int i=0;i<x;i++)
        {
            int y=scan.nextInt();
            check(y);
        }
    }
    public static void check(double x)
    {
        if (x%2==1)
        {
            x=(x/2)*(x/2+1);
        }
        else
            x=(x/2)*(x/2);
        System.out.println(x);
    }
}