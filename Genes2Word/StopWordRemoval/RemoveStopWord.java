package StopWordRemoval;

import java.io.*;
import java.util.*;

public class RemoveStopWord
{
	public static HashMap<String,Integer> list_stop_words = new HashMap<String,Integer>();
	public static HashMap<String,Integer> list_of_words = new HashMap<String,Integer>();
	
	public static HashMap<String,String> dict_words = new HashMap<String,String>();
	
	public static void copy_stop_words_mem(String File_Name)throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader(File_Name));
		try
		{
			String Str = br.readLine();
			while( Str != null)
			{
				StringTokenizer St = new StringTokenizer(Str," ");
				while(St.hasMoreTokens())
				{
					String S = St.nextToken();
					if(list_stop_words.containsKey(S) == false)
						list_stop_words.put(S,1);
					else list_stop_words.put(S,list_stop_words.get(S)+1);
					
				}
				Str = br.readLine();
			}
		}
		finally
		{
			br.close();
		}
	}
	
	public static void copy_dictionary_mem(String File_Name)throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader(File_Name));
		try
		{
			String Str; 
			while( (Str = br.readLine())!= null)
			{
				
					String S = Str.substring(0,Str.indexOf('\t'));
					String key=Str.substring(Str.indexOf('\t')+1,Str.length());
					if(dict_words.containsKey(key) == false)
						dict_words.put(key,S);
					
			}
		}
		finally
		{
			br.close();
		}
	}
	
	public static void remove_stop_words(String S)throws IOException
	{
			
					if(list_stop_words.containsKey(S) == false)
					{
						if(list_of_words.containsKey(S) == false)
							list_of_words.put(S,1);
						else list_of_words.put(S,list_of_words.get(S)+1);
						
					}
			
	}
	public static void RemoveStopWord_main(String dict_path)throws IOException
	{
		File file = new File(dict_path+"/../Frequency.wst");
		int arr[]=new int[26];
		if (!file.exists())
		{
			file.createNewFile();
		}
		Writer fw = new FileWriter(file,false);
		BufferedWriter Br = new BufferedWriter(fw);
		Set<String> keys = list_of_words.keySet();
			for(String S : keys)
			{
				
				if((S.length()!=0)&&((S.charAt(0)>='A'&&S.charAt(0)<='Z')||(S.charAt(0)>='a'&&S.charAt(0)<='z'))&&(arr[Character.toUpperCase(S.charAt(0))-'A']==0))
				{
					copy_dictionary_mem(dict_path+"/"+Character.toUpperCase(S.charAt(0)));
					arr[Character.toUpperCase(S.charAt(0))-'A']++;
				}
				if(dict_words.get(S)!=null)
				{
					
					Br.write(dict_words.get(S)+" "+list_of_words.get(S)+"\n");
				}
				
			}
			Br.close();
		
				
	}		
	
}