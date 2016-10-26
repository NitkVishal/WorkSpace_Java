import java.util.*;

class qsort{
	public int arr[],size;
	
	qsort(int n){
		size=n;
		arr=new int[n];
	}
	
	public int partition(int l,int r)
	{
	    int i=l,j=r,q=arr[l],t;
	    while(i<j)
	    {
	    	//System.out.println("Hello");
	        while(arr[i]<=q&& i<size-1)
	            i++;
	        while(arr[j]>q)
	            j--;
	        if(i<j)
	        {
	            t=arr[i];
	            arr[i]=arr[j];
	            arr[j]=t;
	        }
	    }
	    arr[l]=arr[j];
	    arr[j]=q;
	    return j;
	}
	
	
	public void sort(int l,int r) {
		if(l<r){
			int p=partition(l,r);
			sort(l,p-1);
			sort(p+1,r);
		}
	}
	
	
	public void print(){
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void merge1(int l,int m,int r){
	    int n1,n2,i,j,k;
	    n1=m-l+1;
	    n2=r-m;
	    int lr[]=new int[n1],rr[]=new int[n2];
	    for(i=0;i<n1;i++)
	        lr[i]=arr[l+i];
	    for(j=0;j<n2;j++)
	        rr[j]=arr[m+j+1];

	     i=0;j=0;k=l;
	     while(i<n1&&j<n2)
	     {
	         if(lr[i]<=rr[j])
	         {
	            arr[k]=lr[i];
	            i++;
	         }
	         else
	         {
	             arr[k]=rr[j];
	             j++;
	         }
	         k++;
	      }
	      while(i<n1)
	      {
	          arr[k]=lr[i];
	          i++;
	          k++;
	      }
	      while(j<n2)
	      {
	          arr[k]=rr[j];
	          j++;
	          k++;
	      }

	}
	
	public void merge(int l,int m,int r){
		int n1,n2,k,i,j;
		n1=m-l+1;
		n2=r-m;
		int ll[]=new int[n1];
		int rr[]=new int[n2];
		//System.out.println(n1+" "+n2+" "+l+" "+m+" "+r);
		for(i=0;i<n1;i++)
			ll[i]=arr[l+i];
		for(j=0;j<n2;j++)
			rr[j]=arr[m+j+1];
		
		i=0;j=0;k=l;
		while(i<n1&& j<n2){
			if(ll[i]<=rr[j])
				{
				arr[k]=ll[i];
				i++;
				}
			else
				{
				arr[k]=rr[j];
				j++;
				}
			k++;
		}
		
		while(i<n1)
		{
			arr[k]=ll[i];
			i++;
			k++;
		}
			
		while(j<n2){
			arr[k]=rr[j];
			j++;
			k++;
		}
			
		
		
		
	}
	
	
	
	
	public void msort(int l,int r){
		if(l<r)
		{
			int m=(l+r)/2;
			msort(l,m);
			msort(m+1,r);
			merge(l,m,r);
			
		}
	}
	
}


public class quick {
	
	static Scanner scan=new Scanner(System.in);
	public static void main(String...args) {
		int n=scan.nextInt();
		qsort qs=new qsort(n);
		
		for(int i=0;i<n;i++)
			qs.arr[i]=scan.nextInt();
		//qs.print();
		//qs.sort(0,n-1);
		qs.msort(0, n-1);
		qs.print();
		}
	 }
  
  
  