
public class ideskey
{
	public static void main(String arg[])
	{
		int [] k1=new int [65];
		int [] k2=new int [65];
		
		int [] x= new int [129];
		for(int i=0;i<128;i++)
		{
			x[i]=i+1;
			//System.out.println(x[i]);
		}
		for(int i=0;i<64;i++)
		{
			k1[i]=x[i];
			k2[i]=x[64+i];
			//System.out.println(k2[i]);
		}
		//int[] k10=new int [57];
		//int[] k20=new int [57];
		k1=ig(k1);
		k2=ig(k2);
		
		
		
		
		k1=pc1(k1);
		k2=pc1(k2);
		
		k1=subkey(k1,2);
		k2=subkey(k2,3);
		
		for(int i=0;i<48;i++)
		{
			System.out.println(k2[i]);	
		}
		
				
			
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		int [] k= new int[57];
		for(int i=0;i<56;i++)
		{
			if(i==0)
				k[i]=x[49];
			if(i==1)
				k[i]=x[42];
			if(i==2)
				k[i]=x[35];
			if(i==3)
				k[i]=x[28];
			if(i==4)
				k[i]=x[21];
			if(i==5)
				k[i]=x[14];
			if(i==6)
				k[i]=x[7];
			if(i==7)
				k[i]=x[0];
			if(i==8)
				k[i]=x[50];
			if(i==9)
				k[i]=x[43];
			if(i==10)
				k[i]=x[36];
			if(i==11)
				k[i]=x[29];
			if(i==12)
				k[i]=x[22];
			if(i==13)
				k[i]=x[15];
			if(i==14)
				k[i]=x[8];
			if(i==15)
				k[i]=x[1];
			if(i==16)
				k[i]=x[51];
			if(i==17)
				k[i]=x[44];
			if(i==18)
				k[i]=x[37];
			if(i==19)
				k[i]=x[30];
			if(i==20)
				k[i]=x[23];
			if(i==21)
				k[i]=x[16];
			if(i==22)
				k[i]=x[9];
			if(i==23)
				k[i]=x[2];
			if(i==24)
				k[i]=x[52];
			if(i==25)
				k[i]=x[45];
			if(i==26)
				k[i]=x[38];
			if(i==27)
				k[i]=x[31];
			if(i==28)
				k[i]=x[55];
			if(i==29)
				k[i]=x[48];
			if(i==30)
				k[i]=x[41];
			if(i==31)
				k[i]=x[34];
			if(i==32)
				k[i]=x[27];
			if(i==33)
				k[i]=x[20];
			if(i==34)
				k[i]=x[13];
			if(i==35)
				k[i]=x[6];
			if(i==36)
				k[i]=x[54];
			if(i==37)
				k[i]=x[47];
			if(i==38)
				k[i]=x[40];
			if(i==39)
				k[i]=x[33];
			if(i==40)
				k[i]=x[26];
			if(i==41)
				k[i]=x[19];
			if(i==42)
				k[i]=x[12];
			if(i==43)
				k[i]=x[5];
			if(i==44)
				k[i]=x[53];
			if(i==45)
				k[i]=x[46];
			if(i==46)
				k[i]=x[39];
			if(i==47)
				k[i]=x[32];
			if(i==48)
				k[i]=x[25];
			if(i==49)
				k[i]=x[18];
			if(i==50)
				k[i]=x[11];
			if(i==51)
				k[i]=x[4];
			if(i==52)
				k[i]=x[24];
			if(i==53)
				k[i]=x[17];
			if(i==54)
				k[i]=x[10];
			if(i==55)
				k[i]=x[3];
		}
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
	
	
	
	
	
	
	

}
