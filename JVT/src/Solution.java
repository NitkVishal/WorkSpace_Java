import java.io.*;
import java.util.*;

public class Solution {

    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        int t=scan.nextInt(),x;
        int arr[]=new int[100];
        for(int i=0;i<t;i++)
            {
        	int k=0;
            x=scan.nextInt();
            while(x>0)
            {
            	arr[k++]=x%10;
            	x=x/10;
            }
           for(int j=k-1;j>0;j--){
            	if(arr[j]>arr[j-1])
            	System.out.println('X');
            	else
            		System.out.println(arr[j]);
            	}
            System.out.println(arr[0]);
            }
       }
    }
