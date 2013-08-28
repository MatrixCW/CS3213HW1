package cs3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CircularShifter extends Filter{
	
	private final Set<String> ignoreWords = 
			new HashSet<String>((Arrays.asList("is", "the", "of", "and", "as", "a", "after")));
	
	public CircularShifter(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
	}

	@Override
	protected void performIndependentTask() {
		//if current input list is empty try to load from the inpipe
		
		if (inputPipe.isReadyToRead() && inputList == null){
			System.out.println("CircularShifter is reading inputs");
			inputList = inputPipe.read();
			readyForProcessing = true;
		}
		
		if(readyForProcessing){
			
			outputList = shiftWordsArray(inputList);

			
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && inputList != null) {
			
			System.out.println("CircularShifter is writing outputs");
			outputPipe.write(outputList);
			inputList = null;
			readyForProcessing = false;
			
		}
	}
	
	private ArrayList<String> shiftWordsArray(ArrayList<String> inputArray){
		String originString  = inputArray.get(0).trim();
		String[] spiltStrings = originString.split("\\s+");
		LinkedList<String> arrayOfKeywords = capitalizeKeyWords(spiltStrings);
		
		ArrayList<String> shiftArrays = new ArrayList<String>();
		for (int i = 0; i < spiltStrings.length - 1; i++) {
			String appendString = arrayOfKeywords.poll();
			arrayOfKeywords.add(appendString);
			
			String head = arrayOfKeywords.get(0);
			if(ignoreWords.contains(head.toLowerCase())){
				continue;
			}else{
				shiftArrays.add(keywordsStringBuild(arrayOfKeywords));
			}
		}
		
		return shiftArrays;
	}
	
	private LinkedList<String> capitalizeKeyWords(String[] spiltStrings){
		LinkedList<String> keywordsArray = new LinkedList<String>(Arrays.asList(spiltStrings));
		LinkedList<String> resultArray = new LinkedList<String>();
		
		for (String string : keywordsArray) {
			if (ignoreWords.contains(string.toLowerCase())) {
				resultArray.add(string.toLowerCase());
			} else {
				String keyword = capitalizeOneWord(string.toLowerCase());
				resultArray.add(keyword);
			}
		}
		
		return resultArray;
	}
	
	private String keywordsStringBuild(LinkedList<String> keywordsArray){
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
