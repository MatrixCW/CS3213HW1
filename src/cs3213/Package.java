package cs3213;

import java.util.ArrayList;

public class Package {
	
	private ArrayList<String> wordsToIgnore;
	private ArrayList<String> stringsToProcess;
	
	
	public Package(Package inputPackage){
		wordsToIgnore = new ArrayList<String>(inputPackage.getWordsToIgnore());
		stringsToProcess = new ArrayList<String>(inputPackage.getStringsToProcess());
	}
	
	
	public Package(ArrayList<String> wordsToIgnore, ArrayList<String> stringsToProcess){
		this.wordsToIgnore = new ArrayList<String>(wordsToIgnore);
		this.stringsToProcess = new ArrayList<String>(stringsToProcess);
	}
	
	public ArrayList<String> getWordsToIgnore(){
		return new ArrayList<String>(wordsToIgnore);
	}
	
	public ArrayList<String> getStringsToProcess(){
		return new ArrayList<String>(stringsToProcess);
	}
}
