

import java.io.*;


public class ides
{
	public static void main(String arg[]) throws IOException 
	{
		 int [] k1=new int [65];
		 int [] k2=new int [65];
		 int []k=new int[129];
		// JOptionPane.showMessageDialog(null, "here comes the text.");
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 System.out.println("enter key ");
         String ks =br.readLine();
         k =	keybit(ks);
         System.out.println("your 128 bits key: ");
         for(int i=0;i<128;i++)
         {
        	System.out.print(" "+k[i]);
         }
         for(int i=0;i<64;i++)
 		 {
 			k1[i]=k[i];
 			k2[i]=k[64+i];
 		 }
         k1=ig(k1);
 		 k2=ig(k2);
 		 k1=pc1(k1);
 		 k2=pc1(k2);
         System.out.println();
         
         
         int []a = new int[33];
 		 int []b = new int[33];
 		 int []c = new int[33];
         int con=0;
         int []plt=new int[97];
         System.out.println("Enter plain text ");
         String s = br.readLine();
         System.out.println("you plain text's bits: ");
         
         int []pl=plainbit(s);
         for(int i=0;i<pl.length;i++)
         {
        	 System.out.print(" "+pl[i]);
         }
         System.out.println();
         int cp[]=new int[pl.length];
         int t=(pl.length)/96;
         //System.out.println(t);
        // System.out.println(x.length);
         
         
         
         for(int j=0;j<t;j++)
         {
         
             for(int i=0;i<96;i++)
              {
        	   plt[i]=pl[con+i];
        	   //System.out.print(" "+xx[i]);
        	  }
             plt=ip(plt);
   		    for(int i=0; i<32;i++)
   		    {
   	         a[i]=plt[i];
   		     b[i]=plt[32+i];
   		     c[i]=plt[64+i];
   		//System.out.println(a[i]);
   		    }
   		  plt= idese(a,b,c,k1,k2);
   		  for(int i=0;i<96;i++)
   		  {
   			  cp[con+i]=plt[i];
   		  }
          System.out.println();
          con=con+96;
         } 
         
         
         
         
         
         System.out.println();
         System.out.println("cypher bits for given plain text ");
         for(int i=0;i<cp.length;i++)
         {
        	 System.out.print(" "+cp[i] );
         }
         System.out.println();
         //String s2;
		//	s2=JOptionPane.showInputDialog(null,"Enter the number '0' for Default assumtion or '1' for if u want to enter the values for KEY");
         
         
         
         
         
         
         int con1=0;
         System.out.println("press enter for decryption"); 
         for(int i=0; i<32;i++)
		    {
	         a[i]=cp[i];
		     b[i]=cp[32+i];
		     c[i]=cp[64+i];
		     //System.out.println(a[i]);
		    }
         
         for(int j=0;j<t;j++)
         {
         
             for(int i=0;i<96;i++)
              {
        	   plt[i]=cp[con1+i];
        	   //System.out.print(" "+xx[i]);
        	  }
             plt=ip(plt);
   		    for(int i=0; i<32;i++)
   		    {
   	         a[i]=plt[i];
   		     b[i]=plt[32+i];
   		     c[i]=plt[64+i];
   		//System.out.println(a[i]);
   		    }
         
         plt=idesd(a,b,c,k1,k2);
         
          
         for(int i=0;i<96;i++)
  		  {
  			  pl[con1+i]=plt[i];
  		  }
         System.out.println();
         con1=con1+96;   
 
         }
         
         
         System.out.println();
         System.out.println("plain text bits for given cypher  text bits ");
         for(int i=0;i<cp.length;i++)
         {
        	 System.out.print(" "+pl[i] );
         }
         System.out.println();
         
         
}
	
	
	
	
	
	
	
	
	
	static int [] idesd(int []a,int []b,int[]c,int []k1,int[] k2)
	{
		int a1[]=new int[33];
		int k11[]=new int[48];
		int k21[]=new int[48];
		int pl[]=new int[97];
		for(int i=15;i>=0;i--)
		{
			a1=b;
			a=expansion(a);
			b=expansion(b);
			c=expansion(c);
			k11=subkey(k1,i);
			k21=subkey(k2,i);
			
			System.out.println("k1 for round   "  +i+" ");
			
			for(int j=0;j<32;j++)
			{
			System.out.print(" "+k11[j]+" ");
			
			}
			System.out.println();
			
			System.out.println("k2 for round   "  +i+" ");
			for(int j=0;j<32;j++)
			{
			
			System.out.print(" "+k21[j]+" ");
			}
			System.out.println();
			System.out.println();
			k11=function(b,k11);
			k21=function(b,k21);
			k11=function(a,k11);
			k21=function(c,k21);
			c=sbox(k11);
			b=sbox(k21);
			a=a1;
			
			//System.out.println(i);
		}
		
		 a1=a;
		  a=b;
		  b=a1;
		  
		for(int i=0;i<32;i++)
		{
			pl[i]=a[i];
			pl[i+32]=b[i];
			pl[i+64]=c[i];
		}
		
		
		pl=ipi(pl);
		
		return pl;
	}
	
	
	
	
	
	
	
	
	
	
	
	static int [] plainbit(String s)throws IOException
	  
	    {
	    	   String bs="",sn = "";
	    	
	           
	           byte[] b = s.getBytes();
	        
	           for(int i=0;i<s.length();i++)
	           {
	        	bs=Integer.toBinaryString(b[i]);
	        	if(bs.length()==8)
	        	    {
	        		  // System.out.println("8 bit"+bs);
	        		sn+=bs;
	        		}
	        	else
	        	   {
	        		//System.out.println("<8 bit"+bs);
	        		String st="";
	        		int count=8-bs.length();
	        		for(int k=0;k<count;k++)
	        		{
	        		 st+=0;
	        		}
	        		String sn1=st+bs;
	        		sn=sn+sn1;
	        		//System.out.println("made 8 bit"+sn1);
	        		
	        	    }
	        
	         }
	        // System.out.println(sn.length());  
	        String appe="";
	        
	        int cont= (sn.length()%96);
	        
	      
	       
	        
	       // System.out.println(cont);
	       
	        if(cont!=0)
	        {
	        cont=96-cont;
	        for(int i=0;i<cont;i++)
	        {
	         appe +=0;
	        }
	        sn=sn+appe;
	        }
	     // System.out.println(sn.length());
	        int t=sn.length()/96;
	        //System.out.println(t);	
	        int x[]=new int [sn.length()];
	        char [] arr = sn.toCharArray();
	       
	        for(int i=0;i<sn.length();i++)
	        {
	        	if(arr[i]=='1')
	        	{
	        		x[i]=1;
	        	}
	        	else 
	        		{
	        		x[i]=0;
	        		}
	        	//System.out.print(x[i]);
	        }
	     // System.out.println(x.length);
	        for(int i=0;i<t;i++)
	        {
	        
	        }
	       return x; 
	        
	    }
	
	
	
	
	
	
	static int [] keybit(String ks)throws IOException
	{
		String bs="",sn = "";
		int [] x=new int [129];
		 byte[] b =ks.getBytes();
	        
         for(int i=0;i<ks.length();i++)
         {
      	bs=Integer.toBinaryString(b[i]);
      	if(bs.length()==8)
      	    {
      		  // System.out.println("8 bit"+bs);
      		sn+=bs;
      		}
      	else
      	   {
      		//System.out.println("<8 bit"+bs);
      		String st="";
      		int count=8-bs.length();
      		for(int k=0;k<count;k++)
      		{
      		 st+=0;
      		}
      		String sn1=st+bs;
      		sn=sn+sn1;
      		//System.out.println("made 8 bit   "+sn1);
      		
      	}
      
      }
         //System.out.println(sn);
         String app="";
         if (sn.length()<128)
         {
        	 int count=128-sn.length();
        	 //System.out.println(count);
        	 for(int i=0;i<count;i++)
 	        {
 	         app +=0;
 	        }
 	        sn=sn+app;
        	 
         }
         //System.out.println(sn);
         
         char [] arr = sn.toCharArray();
         for(int i=0;i<128;i++)
         {
        	 if(arr[i]=='1')
        	 {
        		 x[i]=1;
        	 }
        	 else
        		 x[i]=0;
         }
		
		return x;
		
	}
	













	static int[] idese(int[]a,int[]b,int[]c,int[]k1,int[]k2)
	{
		int a1[]=new int[33];
		int k11[]=new int[48];
		int k21[]=new int[48];
		int cp[]=new int[97];
		int cp1[]=new int[97];
		
		for(int i=0;i<16;i++)
		{
			a1=b;
			a=expansion(a);
			b=expansion(b);
			c=expansion(c);
			k11=subkey(k1,i);
			k21=subkey(k2,i);
			
			System.out.println("k1 for round   "  +i+" ");
			
			for(int j=0;j<32;j++)
			{
			System.out.print(" "+k11[j]+" ");
			
			}
			System.out.println();
			
			System.out.println("k2 for round   "  +i+" ");
			for(int j=0;j<32;j++)
			{
			
			System.out.print(" "+k21[j]+" ");
			}
			
			System.out.println();
			
			k11=function(b,k11);
			k21=function(b,k21);
			k11=function(a,k11);
			k21=function(c,k21);
			c=sbox(k11);
			b=sbox(k21);
			a=a1;
			
		
			for(int j=0;j<32;j++)
			{
			cp1[j]=a[j];
			cp1[j+32]=b[j];
			cp1[j+64]=c[j];	
			//System.out.print(" "+a[j]);
			}
			System.out.println();
			
			System.out.println("data of round   "+i);
			for(int j=0;j<96;j++)
			{
			System.out.print(" "+cp1[j]);
			}
			System.out.println();
			System.out.println();
			
		}
		
		  a1=a;
		  a=b;
		  b=a1;
		  
		for(int i=0;i<32;i++)
		{
			cp[i]=a[i];
			cp[i+32]=b[i];
			cp[i+64]=c[i];
		}
		
		
		cp=ipi(cp);
		
       /* System.out.println(" the cypher text is ");
		for(int i=0; i<96;i++)
		{
			System.out.print(" "+cp[i]+" ");
		}*/
		return cp;
	} 
	
	
	
	
static int[] ip(int[] y)
	
	{
		int con=89;
		int []pl = new int[97];
		for(int i=0;i<12 ;i++)
		{
		pl[i]=y[con];
		pl[i+12]=y[con+2];
		pl[i+24]=y[con+4];
		pl[i+36]=y[con+6];
		pl[i+48]=y[con-1];
		pl[i+60]=y[con+1];
		pl[i+72]=y[con+3];
		pl[i+84]=y[con+5];
		
		
		con=con-8;
		
		}
		
		return pl;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	static int [] expansion(int[]x)
	{ 
		int [] k=new int[48];
		for(int i=0;i<5;i++)
		{
			k[i+1]=x[i];
			k[7+i]=x[4+i];
			k[13+i]=x[8+i];
			k[19+i]=x[12+i];
			k[25+i]=x[16+i];
			k[31+i]=x[20+i];
			k[37+i]=x[24+i];
			k[43+i]=x[28+i];
			
			
		}
		k[0]=x[31];
		k[6]=x[3];
		k[12]=x[7];
		k[18]=x[11];
		k[24]=x[15];
		k[30]=x[19];
		k[36]=x[23];
		k[42]=x[27];
		k[47]=x[0];
		
		
		
		return k;
	
	}
	
	
	
	
	
	
	
	static int[] ipi(int[] x)
	{
		int j=0;
		int []y=new int [97];
		for(int i=0;i<12;i++)
		{
			y[j+i]=x[59-i];
			y[j+i+1]=x[11-i];
			y[j+i+2]=x[71-i];
			y[j+i+3]=x[23-i];
			y[j+i+4]=x[83-i];
			y[j+i+5]=x[35-i];
			y[j+i+6]=x[95-i];
			y[j+i+7]=x[47-i];
			
			j=j+7;
				
		}
	return y;	
	}
	

	
	
	
	
	
	
	
	
	
	
	static int[] ig(int [] x)
	{
		int [] k= new int[57];
		
		for(int i=0;i<7;i++)
		{
			k[i]=x[i];
			k[7+i]=x[8+i];
			k[14+i]=x[16+i];
			k[21+i]=x[24+i];
			k[28+i]=x[32+i];
			k[35+i]=x[40+i];
			k[42+i]=x[48+i];
			k[49+i]=x[56+i];
			
		}
		return k;
	}
	
	
	
	
	
	
	static int[] pc1(int[]x)
	{
		int con=49;
		int [] k= new int[57];
		for(int i=0;i<8;i++)
		{
			k[i]=x[con];
			k[i+8]=x[con+1];
			k[i+16]=x[con+2];
			k[i+28]=x[con+6];
			k[i+36]=x[con+5];
			k[i+44]=x[con+4];
			
			con=con-7;
		}
		k[24]=x[52];
		k[25]=x[45];
		k[26]=x[38];
		k[27]=x[31];
		k[52]=x[24];
		k[53]=x[17];
		k[54]=x[10];
		k[55]=x[3];
		return k;
		
	}
	
	
	
	
	
	
	
	static int[] shift1b(int [] x)
	{
		int []k=new int[56];
		for(int i= 0;i<6;i++)
		{
			k[i]=x[i+1];
			k[7+i]=x[8+i];
			k[14+i]=x[15+i];
			k[21+i]=x[22+i];
			k[28+i]=x[29+i];
			k[35+i]=x[36+i];
			k[42+i]=x[43+i];
			k[49+i]=x[50+i];
		}
		k[6]=x[0];
		k[13]=x[7];
		k[20]=x[14];
		k[27]=x[21];
		k[34]=x[28];
		k[41]=x[35];
		k[48]=x[42];
		k[55]=x[49];
		return k;
		
	}
	
	
	
	
	
	
	
	
	static int[] shift2b(int []x)
	{
		int [] k= new int[56];
		for(int i=0;i<5;i++)
		{
			k[i]=x[2+i];
			k[7+i]=x[9+i];
			k[14+i]=x[16+i];
			k[21+i]=x[23+i];
			k[28+i]=x[30+i];
			k[35+i]=x[37+i];
			k[42+i]=x[44+i];
			k[49+i]=x[51+i];
		}
		
			k[5]=x[0];
			k[6]=x[1];
			k[12]=x[7];
			k[13]=x[8];
			k[19]=x[14];
			k[20]=x[15];
			k[26]=x[21];
			k[27]=x[22];
			k[33]=x[28];
			k[34]=x[29];
			k[40]=x[35];
			k[41]=x[36];
			k[47]=x[42];
			k[48]=x[43];
			k[54]=x[49];
			k[55]=x[50];
		
		
		
		return k;
		
		
		}
	
	
	
	
	
	
	
	
	
	static int[] pc2(int []x)
	{
		
		int [] k =new int [49];
		
		k[0]=x[13];
		k[1]=x[16];
		k[2]=x[10];
		k[3]=x[23];
		k[4]=x[0];
		k[5]=x[4];
		k[6]=x[2];
		k[7]=x[27];
		k[8]=x[14];
		k[9]=x[5];
		k[10]=x[20];
		k[11]=x[9];
		k[12]=x[22];
		k[13]=x[18];
		k[14]=x[11];
		k[15]=x[3];
		k[16]=x[25];
		k[17]=x[7];
		k[18]=x[15];
		k[19]=x[6];
		k[20]=x[26];
		k[21]=x[19];
		k[22]=x[12];
		k[23]=x[1];
		k[24]=x[40];
		k[25]=x[51];
		k[26]=x[30];
		k[27]=x[36];
		k[28]=x[46];
		k[29]=x[54];
		k[30]=x[29];
		k[31]=x[39];
		k[32]=x[50];
		k[33]=x[44];
		k[34]=x[32];
		k[35]=x[47];
		k[36]=x[43];
		k[37]=x[48];
		k[38]=x[38];
		k[39]=x[55];
		k[40]=x[33];
		k[41]=x[52];
		k[42]=x[45];
		k[43]=x[41];
		k[44]=x[49];
		k[45]=x[35];
		k[46]=x[28];
		k[47]=x[31];
		
		return k;
	}
	
	
	
	
	
	static int[] subkey(int[] x,int z)
	{   
		z=z+1;
		int[] y=new int[57];
		for(int i=0;i<z;i++)
		{
		if (i==0)
		{
			y=shift1b(x);
		}
		if (i==1||i==8||i==15)
		{
			y=shift1b(y);
		}
		if (i==2||i==3||i==4||i==5||i==6||i==7||i==9||i==10||i==11||i==12||i==13||i==14)
		{
			y=shift2b(y);
		}
		
		
		}
		y=pc2(y);
		
		
		return y;
	} 
	
	
	
	static int [] function(int [] x, int [] y)
	{
		for(int i=0;i<48;i++)
		{
			if(x[i]==y[i])
			{
				x[i]=0;
			}
			else
			{
				x[i]=1;
			}
		}
		
		
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	static int [] sbox(int[] x)
	{   
		
		
	int [][]s1= { {14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
			      {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
			      {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
			      {15,12,8,2,7,9,1,7,5,11,3,14,10,0,6,13}};
		
    int[][]s2= {  {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
			      {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
			      {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
			      {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
  
	int [][]s3= { {10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
			      {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
			      {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
			      {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};
	
	int[][]s4={   {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
			      {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
			      {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
			      {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
	
	int [][]s5={  {2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
			      {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
			      {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
			      {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};
	  
	int [][]s6 ={ {12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
			      {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
			      {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
			      {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};
	
	int [][]s7= { {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
			      {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
			      {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
			      {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};
	
	int[][]s8={   {13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
			      {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
			      {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
			      {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}}; 
	
	
	String str,str1;
	int sum=0,sum1=1,m,n;
	int[][]s=new int[4][16];
	int y[]=new int [33];
	int count1=0;
	
	int l;
	
	
	
		
		for(int i=0;i<8;i++)
		{
			str=Integer.toString(x[sum+i]);
			str+=Integer.toString(x[sum+i+5]);
			m=Integer.parseInt(str, 2);
			sum=sum+5;
			str1=Integer.toString(x[sum1+i]);
			sum1++;
			str1+=Integer.toString(x[sum1+i]);
			sum1++;
			str1+=Integer.toString(x[sum1+i]);
			sum1++;
			str1+=Integer.toString(x[sum1+i]);
			n=Integer.parseInt(str1, 2);
			sum1=sum1+2;
			switch (i)
			{
			case 0:s=s1;break;
			case 1:s=s2;break;
			case 2:s=s3;break;
			case 3:s=s4;break;
			case 4:s=s5;break;
			case 5:s=s6;break;
			case 6:s=s7;break;
			case 7:s=s8;break;
			}
			l=s[m][n];
			//System.out.print(" "+l);
			String str2 = Integer.toBinaryString(l);
			
			char[] arr = str2.toCharArray();
			int [] z= new int [5];
			int count=3;
			for (int j=str2.length()-1; j>=0; j--)
		    {
		        if (arr[j] == '1')
		        {             
		            z[count] = 1;
		            count--;
		        }
		        else if (arr[j] == '0')
		        {
		           z[count] = 0;
		           count--;
		        }
		        else
		        {
		        	z[count]=0;
		        	count--;
		        }
		    }
		
			for(int j=0;j<4;j++)
			{
				y[count1+j]=z[j];
				
				//System.out.print(" "+z[j]);
			}
			count1=count1+4;
			
		}
		
	
		
		
		return y;
	}
	

	}





