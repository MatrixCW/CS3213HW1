package cs3213;

import java.util.ArrayList;

/*
 * This is the class that handles "words to ignore"
 *
 * */

public final class WordsIgnorer {
	
	private ArrayList<String> wordsToIgnore;
	private static WordsIgnorer myInstance;
	
	
	private WordsIgnorer(){
		
		wordsToIgnore = new ArrayList<String>();
		
	}
	
	
	//this class utilize singleton pattern
	public WordsIgnorer getINstance(){
		
		if(myInstance == null){
			
			myInstance = new WordsIgnorer();
			
		}
		
		return myInstance;
	}
	
	
	public void addIgnoringWord(String word){
		
		wordsToIgnore.add(word);
		
	}
	
	
	public void clear(){
		
		wordsToIgnore.clear();
		
	}
	
	public void displayAllWords(){
		
		for(String string : wordsToIgnore){
			
			System.out.println(string);
			
		}
		
	}
	

}
