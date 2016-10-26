import javax.swing.*;
import java.io.*;
import java.lang.*;
class DesKey 
{
	int a[],pc[][],b[],c[],d[],k[][],p[],ipa[],eb[],left[],right[],sb[],per[],xor[],ipar[],ipi[],fin[];
	void getkey()
	{
			int y[]={0,0,0,0,1,0,0,1,1, 0,0,1,1,0,1,0,0, 0,1,0,1,0,1,1,1, 0,1,1,1,1,0,0,1, 1,0,0,1,1,0,1,1, 1,0,1,1,1,1,0,0, 1,1,0,1,1,1,1,1, 1,1,1,1,0,0,0,1}; 
			a=new int[65];
			a=y;
			int i;
	}
	void enterkey()
	{
			int i;
			a=new int[65];
			String s;
			for(i=1;i<=64;i++)
			{	
				s=JOptionPane.showInputDialog(null, "Enter '0' or '1'");
				a[i]=Integer.parseInt(s);
			}
	}
	void pc1()
	{
		
			int k=0,s,i,j,r=1,c;
			b=new int[65];
			for(i=1;i<=64;i++)
			{
					if(i==1)
							b[8]=a[i];
					if(i==2)
							b[16]=a[i];
					if(i==3)
							b[24]=a[i];
					if(i==4)
							b[56]=a[i];
					if(i==5)
							b[52]=a[i];
					if(i==6)
							b[44]=a[i];
					if(i==7)
							b[36]=a[i];
					if(i==9)
							b[7]=a[i];
					if(i==10)
							b[15]=a[i];
					if(i==11)
							b[23]=a[i];
					if(i==12)
							b[55]=a[i];
					if(i==13)
							b[51]=a[i];
					if(i==14)
							b[43]=a[i];
					if(i==15)
							b[35]=a[i];
					if(i==17)
							b[6]=a[i];
					if(i==18)
							b[14]=a[i];
					if(i==19)
							b[22]=a[i];
					if(i==20)
							b[54]=a[i];
					if(i==21)
							b[50]=a[i];
					if(i==22)
							b[42]=a[i];
					if(i==23)
							b[34]=a[i];
					if(i==25)
							b[5]=a[i];
					if(i==26)
							b[13]=a[i];
					if(i==27)
							b[21]=a[i];
					if(i==28)
							b[53]=a[i];
					if(i==29)
							b[49]=a[i];
					if(i==30)
							b[41]=a[i];
					if(i==31)
							b[33]=a[i];
					if(i==33)
							b[4]=a[i];
					if(i==34)
							b[12]=a[i];
					if(i==35)
							b[20]=a[i];
					if(i==36)
							b[28]=a[i];
					if(i==37)
							b[48]=a[i];
					if(i==38)
							b[40]=a[i];
					if(i==39)
							b[32]=a[i];
					if(i==41)
							b[3]=a[i];	
					if(i==42)
							b[11]=a[i];
					if(i==43)
							b[19]=a[i];
					if(i==44)
							b[27]=a[i];
					if(i==45)
							b[47]=a[i];
					if(i==46)
							b[39]=a[i];
					if(i==47)
							b[31]=a[i];
					if(i==49)
							b[2]=a[i];
					if(i==50)
							b[10]=a[i];
					if(i==51)
							b[18]=a[i];
					if(i==52)
							b[26]=a[i];
					if(i==53)
							b[46]=a[i];
					if(i==54)
							b[38]=a[i];
					if(i==55)
							b[30]=a[i];
					if(i==57)
							b[1]=a[i];
					if(i==58)
							b[9]=a[i];
					if(i==59)
							b[17]=a[i];
					if(i==60)
							b[25]=a[i];
					if(i==61)
							b[45]=a[i];
					if(i==62)
							b[37]=a[i];
					if(i==63)
							b[29]=a[i];
			}	
	}
	//This function will calculate all the 16 Keys that are required for Encryption and Decryption
	void subkeys()
	{
			int l[],r[],i,j,s,t,t1,t2;
			l=new int[29];
			k=new int [17][49];
			r=new int[57];
			c=new int[57];
			//splitting 56 bit from pc1 int L (1-28) and R (29-56)
			for(i=1;i<=28;i++)
			{
					l[i]=b[i];
			}
			for(i=29;i<=56;i++)
			{
					r[i]=b[i];
			}
			for(int d=1;d<=16;d++)
			{
					// Here it is single shift
					if(d==1 || d==2 || d==9 ||d==16)
					{	
						t=l[1];
						for(i=1;i<=27;i++)
								l[i]=l[i+1];
						l[28]=t;
						t=r[29];
						for(i=29;i<56;i++)
								r[i]=r[i+1];
						r[56]=t;
					}
					//Here it is Double shift
					else
					{
						t1=l[1];
						t2=l[2];
						for(int z=1;z<3;z++)
							for(i=1;i<=27;i=i+1)
							{
									l[i]=l[i+1];
							}
						l[27]=t1;
						l[28]=t2;
						t1=r[29];
						t2=r[30];
						for(int z=1;z<3;z++)
							for(i=29;i<56;i=i+1)
							{
									r[i]=r[i+1];
							}
						r[55]=t1;
						r[56]=t2;
					}
				for(i=1;i<=56;i++)
					{
					if(i<=28)
							c[i]=l[i];
					else
							c[i]=r[i];
					}
					for(i=1;i<=57;i++)
					{	
						if(i!=9 && i!=18 &&i!=22 && i!=25 &&i!=35 &&i!=38 &&i!=43 &&i!=54)
						{
							switch (i) 
							{
						        case 1:  k[d][5]=c[i]  ; break;
							    case 2:  k[d][24]=c[i] ; break;
								case 3:  k[d][7]=c[i]  ; break;
							    case 4:  k[d][16]=c[i] ; break;
								case 5:  k[d][6]=c[i]  ; break;
								case 6:	 k[d][10]=c[i] ; break;
								case 7:  k[d][20]=c[i] ; break;
								case 8:  k[d][18]=c[i]  ; break;
            //case 9:  return 24 ; break;
								case 10:  k[d][12]=c[i]  ; break;
								case 11:  k[d][3]=c[i] ; break;
								case 12:  k[d][15]=c[i]  ; break;
								case 13:  k[d][23]=c[i] ; break;
								case 14:  k[d][1]=c[i]  ; break;
								case 15:  k[d][9]=c[i] ; break;
								case 16:  k[d][19]=c[i]  ; break;
						        case 17:  k[d][2]=c[i] ; break;
			//case 18:  return 5  ; break;
						        case 19:  k[d][14]=c[i] ; break;
								case 20:  k[d][22]=c[i]  ; break;
						        case 21:  k[d][11]=c[i] ; break;
			//case 22:  return 5  ; break;
						        case 23:  k[d][13]=c[i] ; break;
								case 24:  k[d][4]=c[i]  ; break;
            //case 25:  return 24 ; break
								case 26:  k[d][17]=c[i] ; break;
								case 27:  k[d][21]=c[i]  ; break;
					            case 28:  k[d][8]=c[i] ; break;
								case 29:  k[d][47]=c[i]  ; break;
						        case 30:  k[d][31]=c[i] ; break;
								case 31:  k[d][27]=c[i]  ; break;
								case 32:  k[d][48]=c[i] ; break;
								case 33:  k[d][35]=c[i] ; break;
								case 34:  k[d][41]=c[i] ; break;
			//case 35:  return 31 ; break;
								case 36:  k[d][46]=c[i] ; break;
								case 37:  k[d][28]=c[i] ; break;
			//case 38:  return 31 ; break
								case 39:  k[d][39]=c[i] ; break;
								case 40:  k[d][32]=c[i] ; break;
								case 41 :  k[d][25]=c[i]   ; break;			
								case 42 :  k[d][44]=c[i]   ; break;			
			//case 43 :  return    ; break;			
								case 44 :  k[d][37]=c[i]   ; break;			
								case 45 :  k[d][34]=c[i]   ; break;			
								case 46 :  k[d][43]=c[i]   ; break;			
								case 47 :  k[d][29]=c[i]   ; break;			
								case 48 :  k[d][36]=c[i]   ; break;			
								case 49 :  k[d][38]=c[i]   ; break;			
								case 50 :  k[d][45]=c[i]   ; break;			
								case 51 :  k[d][33]=c[i]   ; break;			
								case 52 :  k[d][26]=c[i]   ; break;			
								case 53 :  k[d][42]=c[i]   ; break;			
			//case 54:
								case 55 :  k[d][30]=c[i]   ; break;
								case 56 :  k[d][40]=c[i]   ; break;
							}
					}
				}
		}
	}
	// for plain text
	//this will automatically assain plaintext values in the order of o's and 1's
	void gettext()
	{
			int y[]={0,0,0,0,0 ,0,0,0,1 ,0,0,1,0 ,0,0,1,1 ,0,1,0,0 ,0,1,0,1 ,0,1,1,0 ,0,1,1,1 ,1,0,0,0 ,1,0,0,1 ,1,0,1,0 ,1,0,1,1 ,1,1,0,0 ,1,1,0,1, 1,1,1,0 ,1,1,1,1};
			p=new int[65];
			int i;
			p=y;
			System.out.println("\n The plain text that is Encrypted and Decrypted is :\n");
			for(i=1;i<65;i++)
			{
					System.out.print(p[i]+"\t");
			}
	}
	//this will allow user to enter the plain text
	void entertext()
	{
			int i;
			p=new int[65];
			String s;
			for(i=1;i<=64;i++)
			{
				
				s=JOptionPane.showInputDialog(null, "Enter the number '0' or '1'");
				p[i]=Integer.parseInt(s);

			}
	}
	//this will store ip value positions in ipa array
	void ip()
	{
			int i,j,l=1,k=1,h,c1,c2;
							int f[]=new int[65];
							int g[]=new int[65];
						
							int x=1,t=0,l1,s=-1,k1;
							for(i=1;i<65;i++)
							{
								g[i]=i;
							}
							for(i=1;i<=8;i++)
							{
								if(i<5)
								{
									t=t+2;k1=t;
									for(j=7;j>=0;j--)
									{
										f[x+j]=g[k1];
										k1=k1+8;
									}
								}
								else
								{
									s=s+2;
									l1=s;
									for(j=7;j>=0;j--)
									{
										f[x+j]=g[l1];
										l1=l1+8;
									}
								}
								x=x+8;
							}
							System.out.print("\n");
			ipa=new int [65];
			for(i=1;i<=8;i++)
			{
					for(j=0;j<=7;j++)
					{
							h=f[l];
							ipa[j+k]=p[h];
							l++;
					}
					k=k+8;
			}
			ipar=new int[65];
			//System.out.println("After Calucating the Initial Permutation of Plain Text we get :\n");
			for(i=1;i<65;i++)
			{
					System.out.print(ipa[i]+"\t");
			}
	}
	//Here the rounds start and so enters in to the loop
	void Ebit()
	{
			//but you need to take right half of ur ipa.....so consider Left[] for left and Right[] for right
			left=new int[65];
			right=new int[65];
			int i,j,k=-5,s=34;
			for(i=1;i<65;i++)
			{
					if(i<33)
						left[i]=ipa[i];
					else
						right[i]=ipa[i];
			}
			eb=new int[49];
			for(i=1;i<9;i++)
			{
					k=k+6;
					s=s-2;
					for(j=0;j<=5;j++)
					{
							eb[k+j]=right[s+32];
							//System.out.print(eb[k+j]+"-"+ipa[s+32]+"-"+s+"\t");
							s++;
							if(s==33)
								s=1;
					}
			}
	}
	void xorwk(int round, DesKey ky)
	{
			xor=new int[65];
			int i;
			for(i=1;i<49;i++)
			{
					if(ky.k[round][i]==eb[i])
						xor[i]=0;
					else
						xor[i]=1;
			}
	}
	void sbox()
	{
			int i,j,n,c1,c2,r=0,s[];
			s=new int[7];
			sb=new int[65];
					n=1;
					//for S-Box 1
							int t=1;
							for(j=1;j<7;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=14;
							if(c1==0 && c2==1)
								r=4;
							if(c1==0 && c2==2)
								r=13;
							if(c1==0 && c2==3)
								r=1;
							if(c1==0 && c2==4)
								r=2;
							if(c1==0 && c2==5)
								r=15;
							if(c1==0 && c2==6)
								r=11;
							if(c1==0 && c2==7)
								r=8;
							if(c1==0 && c2==8)
								r=3;
							if(c1==0 && c2==9)
								r=10;
							if(c1==0 && c2==10)
								r=6;
							if(c1==0 && c2==11)
								r=12;
							if(c1==0 && c2==12)
								r=5;
							if(c1==0 && c2==13)
								r=9;
							if(c1==0 && c2==14)
								r=0;
							if(c1==0 && c2==15)
								r=7;
							if(c1==1 && c2==0)
								r=0;
							if(c1==1 && c2==1)
								r=15;
							if(c1==1 && c2==2)
								r=7;
							if(c1==1 && c2==3)
								r=4;
							if(c1==1 && c2==4)
								r=14;
							if(c1==1 && c2==5)
								r=2;
							if(c1==1 && c2==6)
								r=13;
							if(c1==1 && c2==7)
								r=1;
							if(c1==1 && c2==8)
								r=10;
							if(c1==1 && c2==9)
								r=6;
							if(c1==1 && c2==10)
								r=12;
							if(c1==1 && c2==11)
								r=11;
							if(c1==1 && c2==12)
								r=9;
							if(c1==1 && c2==13)
								r=5;
							if(c1==1 && c2==14)
								r=3;
							if(c1==1 && c2==15)
								r=8;
							if(c1==2 && c2==0)
								r=4;
							if(c1==2 && c2==1)
								r=1;
							if(c1==2 && c2==2)
								r=14;
							if(c1==2 && c2==3)
								r=8;
							if(c1==2 && c2==4)
								r=13;
							if(c1==2 && c2==5)
								r=6;
							if(c1==2 && c2==6)
								r=2;
							if(c1==2 && c2==7)
								r=11;
							if(c1==2 && c2==8)
								r=15;
							if(c1==2 && c2==9)
								r=12;
							if(c1==2 && c2==10)
								r=9;
							if(c1==2 && c2==11)
								r=7;
							if(c1==2 && c2==12)
								r=3;
							if(c1==2 && c2==13)
								r=10;
							if(c1==2 && c2==14)
								r=5;
							if(c1==2 && c2==15)
								r=0;
							if(c1==3 && c2==0)
								r=15;
							if(c1==3 && c2==1)
								r=12;
							if(c1==3 && c2==2)
								r=8;
							if(c1==3 && c2==3)
								r=2;
							if(c1==3 && c2==4)
								r=4;
							if(c1==3 && c2==5)
								r=9;
							if(c1==3 && c2==6)
								r=1;
							if(c1==3 && c2==7)
								r=7;
							if(c1==3 && c2==8)
								r=5;
							if(c1==3 && c2==9)
								r=11;
							if(c1==3 && c2==10)
								r=3;
							if(c1==3 && c2==11)
								r=14;
							if(c1==3 && c2==12)
								r=10;
							if(c1==3 && c2==13)
								r=0;
							if(c1==3 && c2==14)
								r=6;
							if(c1==3 && c2==15)
								r=13;
							int c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;
										
					// for S-Box 2
						
							t=1;
							for(j=7;j<13;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=14+1;
							if(c1==0 && c2==1)
								r=1;
							if(c1==0 && c2==2)
								r=8;
							if(c1==0 && c2==3)
								r=14;
							if(c1==0 && c2==4)
								r=6;
							if(c1==0 && c2==5)
								r=11;
							if(c1==0 && c2==6)
								r=3;
							if(c1==0 && c2==7)
								r=4;
							if(c1==0 && c2==8)
								r=9;
							if(c1==0 && c2==9)
								r=7;
							if(c1==0 && c2==10)
								r=2;
							if(c1==0 && c2==11)
								r=13;
							if(c1==0 && c2==12)
								r=12;
							if(c1==0 && c2==13)
								r=0;
							if(c1==0 && c2==14)
								r=5;
							if(c1==0 && c2==15)
								r=10;
							if(c1==1 && c2==0)
								r=3;
							if(c1==1 && c2==1)
								r=13;
							if(c1==1 && c2==2)
								r=4;
							if(c1==1 && c2==3)
								r=7;
							if(c1==1 && c2==4)
								r=15;
							if(c1==1 && c2==5)
								r=2;
							if(c1==1 && c2==6)
								r=8;
							if(c1==1 && c2==7)
								r=14;
							if(c1==1 && c2==8)
								r=12;
							if(c1==1 && c2==9)
								r=0;
							if(c1==1 && c2==10)
								r=1;
							if(c1==1 && c2==11)
								r=10;
							if(c1==1 && c2==12)
								r=6;
							if(c1==1 && c2==13)
								r=9;
							if(c1==1 && c2==14)
								r=11;
							if(c1==1 && c2==15)
								r=5;
							if(c1==2 && c2==0)
								r=0;
							if(c1==2 && c2==1)
								r=14;
							if(c1==2 && c2==2)
								r=7;
							if(c1==2 && c2==3)
								r=11;
							if(c1==2 && c2==4)
								r=10;
							if(c1==2 && c2==5)
								r=4;
							if(c1==2 && c2==6)
								r=13;
							if(c1==2 && c2==7)
								r=1;
							if(c1==2 && c2==8)
								r=5;
							if(c1==2 && c2==9)
								r=8;
							if(c1==2 && c2==10)
								r=12;
							if(c1==2 && c2==11)
								r=6;
							if(c1==2 && c2==12)
								r=9;
							if(c1==2 && c2==13)
								r=3;
							if(c1==2 && c2==14)
								r=2;
							if(c1==2 && c2==15)
								r=15;
							if(c1==3 && c2==0)
								r=13;
							if(c1==3 && c2==1)
								r=8;
							if(c1==3 && c2==2)
								r=10;
							if(c1==3 && c2==3)
								r=1;
							if(c1==3 && c2==4)
								r=3;
							if(c1==3 && c2==5)
								r=15;
							if(c1==3 && c2==6)
								r=4;
							if(c1==3 && c2==7)
								r=2;
							if(c1==3 && c2==8)
								r=11;
							if(c1==3 && c2==9)
								r=6;
							if(c1==3 && c2==10)
								r=7;
							if(c1==3 && c2==11)
								r=12;
							if(c1==3 && c2==12)
								r=0;
							if(c1==3 && c2==13)
								r=5;
							if(c1==3 && c2==14)
								r=14;
							if(c1==3 && c2==15)
								r=9;
							c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;

							// S-Box 3
						
							t=1;
							for(j=13;j<19;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=10;
							if(c1==0 && c2==1)
								r=0;
							if(c1==0 && c2==2)
								r=9;
							if(c1==0 && c2==3)
								r=14;
							if(c1==0 && c2==4)
								r=6;
							if(c1==0 && c2==5)
								r=3;
							if(c1==0 && c2==6)
								r=15;
							if(c1==0 && c2==7)
								r=5;
							if(c1==0 && c2==8)
								r=1;
							if(c1==0 && c2==9)
								r=13;
							if(c1==0 && c2==10)
								r=12;
							if(c1==0 && c2==11)
								r=7;
							if(c1==0 && c2==12)
								r=11;
							if(c1==0 && c2==13)
								r=4;
							if(c1==0 && c2==14)
								r=2;
							if(c1==0 && c2==15)
								r=8;
							if(c1==1 && c2==0)
								r=13;
							if(c1==1 && c2==1)
								r=7;
							if(c1==1 && c2==2)
								r=0;
							if(c1==1 && c2==3)
								r=9;
							if(c1==1 && c2==4)
								r=3;
							if(c1==1 && c2==5)
								r=4;
							if(c1==1 && c2==6)
								r=6;
							if(c1==1 && c2==7)
								r=10;
							if(c1==1 && c2==8)
								r=2;
							if(c1==1 && c2==9)
								r=8;
							if(c1==1 && c2==10)
								r=5;
							if(c1==1 && c2==11)
								r=14;
							if(c1==1 && c2==12)
								r=12;
							if(c1==1 && c2==13)
								r=11;
							if(c1==1 && c2==14)
								r=15;
							if(c1==1 && c2==15)
								r=1;
							if(c1==2 && c2==0)
								r=13;
							if(c1==2 && c2==1)
								r=6;
							if(c1==2 && c2==2)
								r=4;
							if(c1==2 && c2==3)
								r=9;
							if(c1==2 && c2==4)
								r=8;
							if(c1==2 && c2==5)
								r=15;
							if(c1==2 && c2==6)
								r=3;
							if(c1==2 && c2==7)
								r=0;
							if(c1==2 && c2==8)
								r=11;
							if(c1==2 && c2==9)
								r=1;
							if(c1==2 && c2==10)
								r=2;
							if(c1==2 && c2==11)
								r=12;
							if(c1==2 && c2==12)
								r=5;
							if(c1==2 && c2==13)
								r=10;
							if(c1==2 && c2==14)
								r=14;
							if(c1==2 && c2==15)
								r=7;
							if(c1==3 && c2==0)
								r=1;
							if(c1==3 && c2==1)
								r=10;
							if(c1==3 && c2==2)
								r=13;
							if(c1==3 && c2==3)
								r=0;
							if(c1==3 && c2==4)
								r=6;
							if(c1==3 && c2==5)
								r=9;
							if(c1==3 && c2==6)
								r=8;
							if(c1==3 && c2==7)
								r=7;
							if(c1==3 && c2==8)
								r=4;
							if(c1==3 && c2==9)
								r=15;
							if(c1==3 && c2==10)
								r=14;
							if(c1==3 && c2==11)
								r=3;
							if(c1==3 && c2==12)
								r=11;
							if(c1==3 && c2==13)
								r=5;
							if(c1==3 && c2==14)
								r=2;
							if(c1==3 && c2==15)
								r=12;
							c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;

						// for S-Box 4
						t=1;
							for(j=19;j<25;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=7;
							if(c1==0 && c2==1)
								r=13;
							if(c1==0 && c2==2)
								r=14;
							if(c1==0 && c2==3)
								r=3;
							if(c1==0 && c2==4)
								r=0;
							if(c1==0 && c2==5)
								r=6;
							if(c1==0 && c2==6)
								r=9;
							if(c1==0 && c2==7)
								r=10;
							if(c1==0 && c2==8)
								r=1;
							if(c1==0 && c2==9)
								r=2;
							if(c1==0 && c2==10)
								r=8;
							if(c1==0 && c2==11)
								r=5;
							if(c1==0 && c2==12)
								r=11;
							if(c1==0 && c2==13)
								r=12;
							if(c1==0 && c2==14)
								r=4;
							if(c1==0 && c2==15)
								r=15;
							if(c1==1 && c2==0)
								r=13;
							if(c1==1 && c2==1)
								r=8;
							if(c1==1 && c2==2)
								r=11;
							if(c1==1 && c2==3)
								r=5;
							if(c1==1 && c2==4)
								r=6;
							if(c1==1 && c2==5)
								r=15;
							if(c1==1 && c2==6)
								r=0;
							if(c1==1 && c2==7)
								r=3;
							if(c1==1 && c2==8)
								r=4;
							if(c1==1 && c2==9)
								r=7;
							if(c1==1 && c2==10)
								r=2;
							if(c1==1 && c2==11)
								r=12;
							if(c1==1 && c2==12)
								r=1;
							if(c1==1 && c2==13)
								r=10;
							if(c1==1 && c2==14)
								r=14;
							if(c1==1 && c2==15)
								r=9;
							if(c1==2 && c2==0)
								r=10;
							if(c1==2 && c2==1)
								r=6;
							if(c1==2 && c2==2)
								r=9;
							if(c1==2 && c2==3)
								r=0;
							if(c1==2 && c2==4)
								r=12;
							if(c1==2 && c2==5)
								r=11;
							if(c1==2 && c2==6)
								r=7;
							if(c1==2 && c2==7)
								r=13;
							if(c1==2 && c2==8)
								r=15;
							if(c1==2 && c2==9)
								r=1;
							if(c1==2 && c2==10)
								r=3;
							if(c1==2 && c2==11)
								r=14;
							if(c1==2 && c2==12)
								r=5;
							if(c1==2 && c2==13)
								r=2;
							if(c1==2 && c2==14)
								r=8;
							if(c1==2 && c2==15)
								r=4;
							if(c1==3 && c2==0)
								r=3;
							if(c1==3 && c2==1)
								r=15;
							if(c1==3 && c2==2)
								r=0;
							if(c1==3 && c2==3)
								r=6;
							if(c1==3 && c2==4)
								r=10;
							if(c1==3 && c2==5)
								r=1;
							if(c1==3 && c2==6)
								r=13;
							if(c1==3 && c2==7)
								r=8;
							if(c1==3 && c2==8)
								r=9;
							if(c1==3 && c2==9)
								r=4;
							if(c1==3 && c2==10)
								r=5;
							if(c1==3 && c2==11)
								r=11;
							if(c1==3 && c2==12)
								r=12;
							if(c1==3 && c2==13)
								r=7;
							if(c1==3 && c2==14)
								r=2;
							if(c1==3 && c2==15)
								r=14;
							c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;

					//for S Box 5
						t=1;
							for(j=25;j<31;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=2;
							if(c1==0 && c2==1)
								r=12;
							if(c1==0 && c2==2)
								r=4;
							if(c1==0 && c2==3)
								r=1;
							if(c1==0 && c2==4)
								r=7;
							if(c1==0 && c2==5)
								r=10;
							if(c1==0 && c2==6)
								r=11;
							if(c1==0 && c2==7)
								r=6;
							if(c1==0 && c2==8)
								r=8;
							if(c1==0 && c2==9)
								r=5;
							if(c1==0 && c2==10)
								r=3;
							if(c1==0 && c2==11)
								r=15;
							if(c1==0 && c2==12)
								r=13;
							if(c1==0 && c2==13)
								r=0;
							if(c1==0 && c2==14)
								r=14;
							if(c1==0 && c2==15)
								r=9;
							if(c1==1 && c2==0)
								r=14;
							if(c1==1 && c2==1)
								r=11;
							if(c1==1 && c2==2)
								r=2;
							if(c1==1 && c2==3)
								r=12;
							if(c1==1 && c2==4)
								r=4;
							if(c1==1 && c2==5)
								r=7;
							if(c1==1 && c2==6)
								r=13;
							if(c1==1 && c2==7)
								r=1;
							if(c1==1 && c2==8)
								r=5;
							if(c1==1 && c2==9)
								r=0;
							if(c1==1 && c2==10)
								r=15;
							if(c1==1 && c2==11)
								r=10;
							if(c1==1 && c2==12)
								r=3;
							if(c1==1 && c2==13)
								r=9;
							if(c1==1 && c2==14)
								r=8;
							if(c1==1 && c2==15)
								r=6;
							if(c1==2 && c2==0)
								r=4;
							if(c1==2 && c2==1)
								r=2;
							if(c1==2 && c2==2)
								r=1;
							if(c1==2 && c2==3)
								r=11;
							if(c1==2 && c2==4)
								r=10;
							if(c1==2 && c2==5)
								r=13;
							if(c1==2 && c2==6)
								r=7;
							if(c1==2 && c2==7)
								r=8;
							if(c1==2 && c2==8)
								r=15;
							if(c1==2 && c2==9)
								r=9;
							if(c1==2 && c2==10)
								r=12;
							if(c1==2 && c2==11)
								r=5;
							if(c1==2 && c2==12)
								r=6;
							if(c1==2 && c2==13)
								r=3;
							if(c1==2 && c2==14)
								r=0;
							if(c1==2 && c2==15)
								r=14;
							if(c1==3 && c2==0)
								r=11;
							if(c1==3 && c2==1)
								r=8;
							if(c1==3 && c2==2)
								r=12;
							if(c1==3 && c2==3)
								r=7;
							if(c1==3 && c2==4)
								r=1;
							if(c1==3 && c2==5)
								r=14;
							if(c1==3 && c2==6)
								r=2;
							if(c1==3 && c2==7)
								r=13;
							if(c1==3 && c2==8)
								r=6;
							if(c1==3 && c2==9)
								r=15;
							if(c1==3 && c2==10)
								r=0;
							if(c1==3 && c2==11)
								r=9;
							if(c1==3 && c2==12)
								r=10;
							if(c1==3 && c2==13)
								r=4;
							if(c1==3 && c2==14)
								r=5;
							if(c1==3 && c2==15)
								r=3;
							c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;

						// for S_Box 6
						t=1;
							for(j=31;j<37;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=12;
							if(c1==0 && c2==1)
								r=1;
							if(c1==0 && c2==2)
								r=10;
							if(c1==0 && c2==3)
								r=15;
							if(c1==0 && c2==4)
								r=9;
							if(c1==0 && c2==5)
								r=2;
							if(c1==0 && c2==6)
								r=6;
							if(c1==0 && c2==7)
								r=8;
							if(c1==0 && c2==8)
								r=0;
							if(c1==0 && c2==9)
								r=13;
							if(c1==0 && c2==10)
								r=3;
							if(c1==0 && c2==11)
								r=4;
							if(c1==0 && c2==12)
								r=14;
							if(c1==0 && c2==13)
								r=7;
							if(c1==0 && c2==14)
								r=5;
							if(c1==0 && c2==15)
								r=11;
							if(c1==1 && c2==0)
								r=10;
							if(c1==1 && c2==1)
								r=15;
							if(c1==1 && c2==2)
								r=4;
							if(c1==1 && c2==3)
								r=2;
							if(c1==1 && c2==4)
								r=7;
							if(c1==1 && c2==5)
								r=12;
							if(c1==1 && c2==6)
								r=9;
							if(c1==1 && c2==7)
								r=5;
							if(c1==1 && c2==8)
								r=6;
							if(c1==1 && c2==9)
								r=1;
							if(c1==1 && c2==10)
								r=13;
							if(c1==1 && c2==11)
								r=14;
							if(c1==1 && c2==12)
								r=0;
							if(c1==1 && c2==13)
								r=11;
							if(c1==1 && c2==14)
								r=3;
							if(c1==1 && c2==15)
								r=8;
							if(c1==2 && c2==0)
								r=9;
							if(c1==2 && c2==1)
								r=14;
							if(c1==2 && c2==2)
								r=15;
							if(c1==2 && c2==3)
								r=5;
							if(c1==2 && c2==4)
								r=2;
							if(c1==2 && c2==5)
								r=8;
							if(c1==2 && c2==6)
								r=12;
							if(c1==2 && c2==7)
								r=3;
							if(c1==2 && c2==8)
								r=7;
							if(c1==2 && c2==9)
								r=0;
							if(c1==2 && c2==10)
								r=4;
							if(c1==2 && c2==11)
								r=10;
							if(c1==2 && c2==12)
								r=1;
							if(c1==2 && c2==13)
								r=13;
							if(c1==2 && c2==14)
								r=11;
							if(c1==2 && c2==15)
								r=6;
							if(c1==3 && c2==0)
								r=4;
							if(c1==3 && c2==1)
								r=3;
							if(c1==3 && c2==2)
								r=2;
							if(c1==3 && c2==3)
								r=12;
							if(c1==3 && c2==4)
								r=9;
							if(c1==3 && c2==5)
								r=5;
							if(c1==3 && c2==6)
								r=15;
							if(c1==3 && c2==7)
								r=10;
							if(c1==3 && c2==8)
								r=11;
							if(c1==3 && c2==9)
								r=14;
							if(c1==3 && c2==10)
								r=1;
							if(c1==3 && c2==11)
								r=7;
							if(c1==3 && c2==12)
								r=6;
							if(c1==3 && c2==13)
								r=0;
							if(c1==3 && c2==14)
								r=8;
							if(c1==3 && c2==15)
								r=13;
							c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;

						
						// now for S-Box 7
						t=1;
							for(j=37;j<43;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=4;
							if(c1==0 && c2==1)
								r=11;
							if(c1==0 && c2==2)
								r=2;
							if(c1==0 && c2==3)
								r=14;
							if(c1==0 && c2==4)
								r=15;
							if(c1==0 && c2==5)
								r=0;
							if(c1==0 && c2==6)
								r=8;
							if(c1==0 && c2==7)
								r=13;
							if(c1==0 && c2==8)
								r=3;
							if(c1==0 && c2==9)
								r=12;
							if(c1==0 && c2==10)
								r=9;
							if(c1==0 && c2==11)
								r=7;
							if(c1==0 && c2==12)
								r=5;
							if(c1==0 && c2==13)
								r=10;
							if(c1==0 && c2==14)
								r=6;
							if(c1==0 && c2==15)
								r=1;
							if(c1==1 && c2==0)
								r=13;
							if(c1==1 && c2==1)
								r=0;
							if(c1==1 && c2==2)
								r=11;
							if(c1==1 && c2==3)
								r=7;
							if(c1==1 && c2==4)
								r=4;
							if(c1==1 && c2==5)
								r=9;
							if(c1==1 && c2==6)
								r=1;
							if(c1==1 && c2==7)
								r=10;
							if(c1==1 && c2==8)
								r=14;
							if(c1==1 && c2==9)
								r=3;
							if(c1==1 && c2==10)
								r=5;
							if(c1==1 && c2==11)
								r=12;
							if(c1==1 && c2==12)
								r=2;
							if(c1==1 && c2==13)
								r=15;
							if(c1==1 && c2==14)
								r=8;
							if(c1==1 && c2==15)
								r=6;
							if(c1==2 && c2==0)
								r=1;
							if(c1==2 && c2==1)
								r=4;
							if(c1==2 && c2==2)
								r=11;
							if(c1==2 && c2==3)
								r=13;
							if(c1==2 && c2==4)
								r=12;
							if(c1==2 && c2==5)
								r=3;
							if(c1==2 && c2==6)
								r=7;
							if(c1==2 && c2==7)
								r=14;
							if(c1==2 && c2==8)
								r=10;
							if(c1==2 && c2==9)
								r=15;
							if(c1==2 && c2==10)
								r=6;
							if(c1==2 && c2==11)
								r=8;
							if(c1==2 && c2==12)
								r=0;
							if(c1==2 && c2==13)
								r=5;
							if(c1==2 && c2==14)
								r=9;
							if(c1==2 && c2==15)
								r=2;
							if(c1==3 && c2==0)
								r=6;
							if(c1==3 && c2==1)
								r=11;
							if(c1==3 && c2==2)
								r=13;
							if(c1==3 && c2==3)
								r=8;
							if(c1==3 && c2==4)
								r=1;
							if(c1==3 && c2==5)
								r=4;
							if(c1==3 && c2==6)
								r=10;
							if(c1==3 && c2==7)
								r=7;
							if(c1==3 && c2==8)
								r=9;
							if(c1==3 && c2==9)
								r=5;
							if(c1==3 && c2==10)
								r=0;
							if(c1==3 && c2==11)
								r=15;
							if(c1==3 && c2==12)
								r=14;
							if(c1==3 && c2==13)
								r=2;
							if(c1==3 && c2==14)
								r=3;
							if(c1==3 && c2==15)
								r=12;
							c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;

							// for S Box --8
							t=1;
							for(j=43;j<49;j++)
							{
								s[t]=xor[j];
								t++;
							}
							c1=s[6]*1+s[1]*2;
							c2=s[5]+s[4]*2+s[3]*2*2+s[2]*2*2*2;
							if(c1==0 && c2==0)
								r=13;
							if(c1==0 && c2==1)
								r=2;
							if(c1==0 && c2==2)
								r=8;
							if(c1==0 && c2==3)
								r=4;
							if(c1==0 && c2==4)
								r=6;
							if(c1==0 && c2==5)
								r=15;
							if(c1==0 && c2==6)
								r=11;
							if(c1==0 && c2==7)
								r=1;
							if(c1==0 && c2==8)
								r=10;
							if(c1==0 && c2==9)
								r=9;
							if(c1==0 && c2==10)
								r=3;
							if(c1==0 && c2==11)
								r=14;
							if(c1==0 && c2==12)
								r=5;
							if(c1==0 && c2==13)
								r=0;
							if(c1==0 && c2==14)
								r=12;
							if(c1==0 && c2==15)
								r=7;
							if(c1==1 && c2==0)
								r=1;
							if(c1==1 && c2==1)
								r=15;
							if(c1==1 && c2==2)
								r=13;
							if(c1==1 && c2==3)
								r=8;
							if(c1==1 && c2==4)
								r=10;
							if(c1==1 && c2==5)
								r=3;
							if(c1==1 && c2==6)
								r=7;
							if(c1==1 && c2==7)
								r=4;
							if(c1==1 && c2==8)
								r=12;
							if(c1==1 && c2==9)
								r=5;
							if(c1==1 && c2==10)
								r=6;
							if(c1==1 && c2==11)
								r=11;
							if(c1==1 && c2==12)
								r=0;
							if(c1==1 && c2==13)
								r=14;
							if(c1==1 && c2==14)
								r=9;
							if(c1==1 && c2==15)
								r=2;
							if(c1==2 && c2==0)
								r=7;
							if(c1==2 && c2==1)
								r=11;
							if(c1==2 && c2==2)
								r=4;
							if(c1==2 && c2==3)
								r=1;
							if(c1==2 && c2==4)
								r=9;
							if(c1==2 && c2==5)
								r=12;
							if(c1==2 && c2==6)
								r=14;
							if(c1==2 && c2==7)
								r=2;
							if(c1==2 && c2==8)
								r=0;
							if(c1==2 && c2==9)
								r=6;
							if(c1==2 && c2==10)
								r=10;
							if(c1==2 && c2==11)
								r=13;
							if(c1==2 && c2==12)
								r=15;
							if(c1==2 && c2==13)
								r=3;
							if(c1==2 && c2==14)
								r=5;
							if(c1==2 && c2==15)
								r=8;
							if(c1==3 && c2==0)
								r=2;
							if(c1==3 && c2==1)
								r=1;
							if(c1==3 && c2==2)
								r=14;
							if(c1==3 && c2==3)
								r=7;
							if(c1==3 && c2==4)
								r=4;
							if(c1==3 && c2==5)
								r=10;
							if(c1==3 && c2==6)
								r=8;
							if(c1==3 && c2==7)
								r=13;
							if(c1==3 && c2==8)
								r=15;
							if(c1==3 && c2==9)
								r=12;
							if(c1==3 && c2==10)
								r=9;
							if(c1==3 && c2==11)
								r=0;
							if(c1==3 && c2==12)
								r=3;
							if(c1==3 && c2==13)
								r=5;
							if(c1==3 && c2==14)
								r=6;
							if(c1==3 && c2==15)
								r=11;
							 c=3;
							for(i=1;i<5;i++)
							{
									if(r%2==0)
										sb[n+c]=0;
									else
										sb[n+c]=1;
									r=r/2;
									c--;
							}
							n=n+4;
							//Here it will Apply permutation to the sbox that is calculated
				per=new int[65];
					for(i=1;i<33;i++)
					{
							switch (i)
							{
								case 16: per[1]=sb[i]; break;
								case 7: per[2]=sb[i]; break;
								case 20: per[3]=sb[i]; break;
								case 21: per[4]=sb[i]; break;
								case 29: per[5]=sb[i]; break;
								case 12: per[6]=sb[i]; break;
								case 28: per[7]=sb[i]; break;
								case 17: per[8]=sb[i]; break;
								case 1: per[9]=sb[i]; break;
								case 15: per[10]=sb[i]; break;
								case 23: per[11]=sb[i]; break;
								case 26: per[12]=sb[i]; break;
								case 5: per[13]=sb[i]; break;
								case 18: per[14]=sb[i]; break;
								case 31: per[15]=sb[i]; break;
								case 10: per[16]=sb[i]; break;
								case 2: per[17]=sb[i]; break;
								case 8: per[18]=sb[i]; break;
								case 24: per[19]=sb[i]; break;
								case 14: per[20]=sb[i]; break;
								case 32: per[21]=sb[i]; break;
								case 27: per[22]=sb[i]; break;
								case 3: per[23]=sb[i]; break;
								case 9: per[24]=sb[i]; break;
								case 19 :per[25]=sb[i];break;
								case 13: per[26]=sb[i]; break;
								case 30: per[27]=sb[i]; break;
								case 6: per[28]=sb[i]; break;
								case 22 :per[29]=sb[i];break;
								case 11: per[30]=sb[i]; break;
								case 4: per[31]=sb[i]; break;
								case 25: per[32]=sb[i]; break;
								//case 19 :per[25]=sb[i];break;

							}
					}
	}
	void xorswap()
	{
			int temp[]=new int[65];
			int i;
			for(i=33;i<65;i++)
			{
					temp[i-32]=right[i];
			}
			for(i=1;i<33;i++)
			{
					if(per[i]==left[i])
						right[i+32]=0;
					else
						right[i+32]=1;
			}
			for(i=1;i<33;i++)
			{
					left[i]=temp[i];
			}
			for(i=1;i<65;i++)
			{
					if(i<33)
						ipa[i]=left[i];
					else
						ipa[i]=right[i];
			}
	}

	void printpresent()
	{
		
			
			for(int i=1;i<65;i++)
			{
						if(i==33)
							System.out.println("");

						System.out.print(ipa[i]+"\t");
			}
	}
	void finl()
	{
		fin=new int[65];
		
			for(int i=1;i<65;i++)
			{
				if(i<33)
					fin[i]=left[i];
				else
					fin[i]=right[i];
			}
	}
	void swap()
	{
			int temp[]=new int [65];
			for(int i=1;i<33;i++)
			{
					temp[i]=fin[i+32];
					fin[i+32]=fin[i];
					fin[i]=temp[i];
			}
	}


	void ipin()
	{
		int f[]=new int[65];
		int g[]=new int[65];
		int i,j,x=1,t=0,l,s=-1,k;
		for(i=1;i<65;i++)
		{
			g[i]=i;
		}
		for(i=1;i<=8;i++)
		{
			if(i<5)
			{
				t=t+2;k=t;
				for(j=7;j>=0;j--)
				{
					f[x+j]=g[k];
					k=k+8;
				}
			}
			else
			{
				s=s+2;
				l=s;
				for(j=7;j>=0;j--)
				{
					f[x+j]=g[l];
					l=l+8;
				}
			}
			x=x+8;
		}
		ipi=new int[65];
		int m=1;
		for(i=1;i<65;i++)
		{
				ipi[f[m]]=fin[i];
				m++;
		}
	
		//System.out.print("this is for ipinverse\n");
		for(i=1;i<65;i++)
		{			
				
			System.out.print(ipi[i]+"\t");
   
		}
		for(i=1;i<65;i++)
		{
				p[i]=ipi[i];
		}

	}
	void putkey()
	{	
			int i,j;
			System.out.println("The Key we are Using for Encryption and Decryption is \n");
			for(i=1;i<65;i++)
			{
				System.out.print(a[i]+"\t");
			}	
			System.out.println("The Permutation Choice 1 of key is :\n");
			for(i=1;i<57;i++)
			{
				System.out.print(b[i]+"\t");
			}	
			System.out.println("this is for keys");
			for(i=1;i<17;i++)
			{
					System.out.println("\nfor key " +i);
					for(j=1;j<49;j++)
					{
							System.out.print(k[i][j]+"\t");
					}
			}
			

	}
}







public class DES
{
		
		public static void main(String args[])
		{
			int i;
			DesKey key;
			key= new DesKey();
			String s;
			s=JOptionPane.showInputDialog(null,"Enter the number '0' for Default assumtion or '1' for if u want to enter the values for KEY");
			//Do u want to enter the key or u want program to allot its own key ...If yes press YES or NO");
			if(Integer.parseInt(s)==1)
			{
					key.enterkey();
			}
			else
			{
					key.getkey();
			}
			key.pc1();
			key.subkeys();
			key.putkey();
			DesKey ptext;
			ptext=new DesKey();
			s=JOptionPane.showInputDialog(null,"Enter the number '0' for Default assumtion or '1' for if u want to enter the values for PLAIN TEXT");
			//Do u want to enter the key or u want program to allot its own key ...If yes press YES or NO");
			if(Integer.parseInt(s)==1)
			{
					ptext.entertext();
			}
			else
			{
					ptext.gettext();
			}
			System.out.println("\n\tAfter calcutating the Initial permutation of Encrypted message we get :\n");

			ptext.ip();
			for(i=1;i<17;i++)
			{
				ptext.Ebit();
				ptext.xorwk(i,key);
				ptext.sbox();
				ptext.xorswap();
				ptext.finl();
			System.out.println("Here goes the round no : "+i+" using key no " +i);		
			}
			ptext.swap();
			System.out.println("\nThis is the enctrypted message : \n");
			ptext.ipin();
			System.out.println("\n\n\n\t\tNow Starts the decryption part\n");
			System.out.println("\n\tAfter calculating the Initial permutation of Decrypted message we get :\n");

			ptext.ip();
			int r=1;
			for(i=16;i>0;i--)
			{
				ptext.Ebit();
				ptext.xorwk(i,key);
				ptext.sbox();
				ptext.xorswap();
				ptext.finl();
				System.out.println("\nHere goes the round no : "+r+" using key no " +i);	
				r++;
			}
			ptext.swap();	
			System.out.println("\nThis is the decrypted message\n");
			ptext.ipin();      			
		}		
}

/*If u want to see the Output of all the rounds simply remove "//" in the above statements*/
