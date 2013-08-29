package cs3213;

import java.util.ArrayList;
import java.util.Arrays;

public class Package {
	private ArrayList<String> keywords;
	private ArrayList<String> implementStrings;
	
	public Package(Package inputPackage){
		keywords = inputPackage.getKeywords();
		implementStrings = inputPackage.getImplementString();
	}
	
	public Package(ArrayList<String> keywordsStrArray, ArrayList<String> implementStrArray){
		keywords = new ArrayList<String>(keywordsStrArray);
		implementStrings = new ArrayList<String>(implementStrArray);
	}
	
	public ArrayList<String> getKeywords(){
		return new ArrayList<String>(keywords);
	}
	
	public ArrayList<String> getImplementString(){
		return new ArrayList<String>(implementStrings);
	}
	
	public void appendToImplementString(String str){
		implementStrings.add(str);
	}
}