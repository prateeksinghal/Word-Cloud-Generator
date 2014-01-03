package Sorting;

import java.io.*;
public class Sort
{
	public static void Sort_main(String path)throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader(path+"/../Frequency.wst"));
		File file = new File(path+"/../Top100");
		if (!file.exists())
		{
			file.createNewFile();
		}
		Writer fw = new FileWriter(file,false);
		BufferedWriter Br = new BufferedWriter(fw);
			String Str;
			int count=4033;
			String arr[]=new String[count];
			count=0;
			while( (Str = br.readLine())!= null)
			{
				arr[count++]=Str;
			}
			br.close();
			arr=mergeSort(arr,count);
			for(int i=0;i<100;i++)
				Br.write(arr[i]+"\n");
			Br.close();
	}
	public static int cmp(String a,String b)
	{
		int la,lb,i,n1,n2;
		String str1,str2;
		la=a.length();
		lb=b.length();
		str1=a.substring(a.indexOf(' ')+1,la);
		str2=b.substring(b.indexOf(' ')+1,lb);
		n1=Integer.parseInt(str1);
		n2=Integer.parseInt(str2);
		return (n1-n2);		
	}	

public static String[] mergeSort(String a[],int n)
{
	int i;
	if(n==1)
		return a;
	else
	{
		int n1,n2;
		if(n%2==0)
		{
			n1=n/2;
			n2=n/2;
		}
		else
		{
			n1=(n-1)/2;
			n2=n-n1;
		}
		String L[]=new String[n1];
		String R[]=new String[n2];
		for(i=0;i<n1;i++)
			L[i]=a[i];
		for(i=0;i<n2;i++)
			R[i]=a[n1+i];
		L=mergeSort(L,n1);
		R=mergeSort(R,n2);
		a=merge(a,L,n1,R,n2);
		return a;
	}
}

public static String[] merge(String a[],String L[],int n1,String R[],int n2)
{
	int i,j,k;
	i=j=k=0;
	while(i<n1 && j<n2)
	{
		if(cmp(L[i],R[j])>0)
		{
			a[k]=L[i];
			i=i+1;
			k=k+1;
		}
		else
		{
			a[k]=R[j];
			j=j+1;
			k=k+1;
		}
	}
	if(i>=n1)
	{
		while(j<n2)
		{
			a[k]=R[j];
			k=k+1;
			j=j+1;
		}
	}
	else
	{
		while(i<n1)
		{
			a[k]=L[i];
			k=k+1;
			i=i+1;
		}
	}
	return a;
}
}