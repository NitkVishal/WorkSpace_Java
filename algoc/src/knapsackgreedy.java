import java.io.*;
class ksap
{
float p[];
float w[];
int n,m;

void getdata()throws IOException
{
BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));

System.out.println("how many objects");
n=Integer.parseInt(obj.readLine());
System.out.println("enter the capacity of bag");
m=Integer.parseInt(obj.readLine());

p=new float[n+1];
w=new float[m+1];

for(int i=1;i<=n;i++)
{
System.out.println("enter profit and weight");
p[i]=Float.parseFloat(obj.readLine());
w[i]=Float.parseFloat(obj.readLine());
}

}


void sort()
{
for(int i=1;i<=n-1;i++)
for(int j=1;j<=n-i;j++)
if ((p[j]/w[j])<(p[j+1]/w[j+1]))
{
float temp =p[j];
p[j]=p[j+1];
p[j+1]=temp;

float temp1=w[j];
w[j]=w[j+1];
w[j+1]=temp1;
}
}

float greedk()
{ int i;
float x[]=new float[n+1];

float u;
float pr=0;

for( i=1;i<=n;i++)

{ x[i]=0;
u=m;
for( i=1;i<=n;i++)
{
if(w[i]<=u)
x[i]=1;
else
break;
u=u-(w[i]);
}



if( i<=n)
x[i]=u/w[i];
} 
for(i=1;i<=n;i++)
pr=pr+(p[i])*(x[i]);
return pr;
}

} 
class knapsackgreedy
{
public static void main(String args[])throws IOException

{
ksap ob=new ksap();
ob.getdata();
ob.sort();

float maxprofit;
maxprofit=ob.greedk();
System.out.println("Maximum profit="+maxprofit);
}
}
