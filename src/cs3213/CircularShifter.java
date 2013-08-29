package cs3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


/*
 * This class shift string according to words to ignore list.
 * and capitalize the first word after shifting
 */

public class CircularShifter extends Filter{
	
	private Set<String> ignoreWords;
	
	public CircularShifter(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
	}

	@Override
	protected void performIndependentTask() {
		//if current input list is empty try to load from the inpipe
		
		if (inputPipe.isReadyToRead() && inputPackage == null){
			System.out.println("CircularShifter is reading inputs");
			inputPackage = inputPipe.read();
			outputPackage = shiftWordsPackage(inputPackage);
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && inputPackage != null) {
			System.out.println("CircularShifter is writing outputs");
			outputPipe.write(outputPackage);
			outputPipe.commit();
			inputPackage = null;
		}
	}
	
	private Package shiftWordsPackage(Package inpackage){
		ignoreWords = new HashSet<String>();
		for (String keyword : inpackage.getWordsToIgnore()) {
			ignoreWords.add(keyword.toLowerCase());
		}
		
		ArrayList<String> resultList = new ArrayList<String>();
		for (String title : inpackage.getStringsToProcess()) {
			String[] titleParts = title.split("\\s+");
			LinkedList<String> listOfWords = new LinkedList<String>(Arrays.asList(titleParts));
			
			for (int i = 0; i < listOfWords.size(); i++) {
				String head = listOfWords.getFirst();
				if(!ignoreWords.contains(head.toLowerCase())){
					LinkedList<String>titleList = capitalizeKeyWordsInTitle(listOfWords);
					resultList.add(titleStringBuild(titleList));
				}
				
				listOfWords.poll();
				listOfWords.addLast(head);
			}
		}
		
		return new Package(inpackage.getWordsToIgnore(), resultList);
	}
	
	//return list of words with uppercase and lowercase
	private LinkedList<String> capitalizeKeyWordsInTitle(LinkedList<String> spiltStrings){
		LinkedList<String> resultArray = new LinkedList<String>();
		
		for (String string : spiltStrings) {
			if (ignoreWords.contains(string.toLowerCase())) {
				resultArray.add(string.toLowerCase());
			} else {
				String keyword = capitalizeOneWord(string.toLowerCase());
				resultArray.add(keyword);
			}
		}
		
		return resultArray;
	}
	
	//bulid the seperate linklist words into a string
	private String titleStringBuild(LinkedList<String> keywordsArray){
		String keywordString = "";
		for (int i=0;i<keywordsArray.size()-1;i++) {
			keywordString += keywordsArray.get(i)+" ";
		}
		
		keywordString += keywordsArray.getLast();
		
		return keywordString;
	}
	
	private String capitalizeOneWord(String str){
		String result;
		if (str.length()>1) {
			result = Character.toUpperCase(str.toLowerCase().charAt(0)) + str.toLowerCase().substring(1);
		} else {
			result = Character.toUpperCase(str.toLowerCase().charAt(0)) + "";
		}
		
		return result;
	}

}
