package customTools;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Sentiment {
	public static int getSentiment(String s){
		int count=0;
		String currentDirectory = new File("").getAbsolutePath();
		try{
			String filename = currentDirectory+"/workspace/Bullhorn/WebContent/texts/happy.txt";
			File happyfile = new File(filename);
			Scanner happy = new Scanner(happyfile);
			
			String filename2 = currentDirectory+"/workspace/Bullhorn/WebContent/texts/sad.txt";
			File sadfile = new File(filename2);
			Scanner sad = new Scanner(sadfile);
			
			HashSet<String> happywords = new HashSet<String>();
			HashSet<String> sadwords = new HashSet<String>();
			
			while(happy.hasNext()){
				happywords.add(happy.nextLine());
			}
			
			while(sad.hasNext()){
				String next = sad.nextLine();
				sadwords.add(next);
			}
			
			s=s.toLowerCase();
			String[] words = s.split(" ");
			
			
			for(String word:words){
				if(happywords.contains(word)){
					count++;
				}
				else if(sadwords.contains(word)){
					count--;
				}
			}
			sad.close();
			happy.close();
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
		}
		return count;
	}
}
