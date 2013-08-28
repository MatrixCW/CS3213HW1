package cs3213;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * This class handles user input.
 * Its instance will prompt for words to ignore, and strings to process
 */

public class Input extends Filter{
	
	private static final String WordsIgnorerPrompt = "Please enter words to ignore";
	private static final String StringToProcessPrompt = "Please enter strings to process";
	private static final String ExitPrompt = "If you are done, enter %exit% to continue" ;
	private static final String ExitMark = "%exit%";
	
	private static Scanner scanner;
	
	LinkedList<ArrayList<String>> waitingList;
	
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		waitingList = new LinkedList<ArrayList<String>>();
	}

	@Override
	protected void performIndependentTask() {
		
		promptForIgnoringWords();
		promptForProcessingStrings();
		
		if (waitingList.size()>0 && outputPipe.isReadyToWrite()) {
			synchronized (this) {
				//System.out.println("ready to write in input filter");
				outputList = waitingList.poll();
				outputPipe.write(outputList);
			}
		}
	}
	
	public synchronized void inputStream(String str) {
		inputList = new ArrayList<String>();
		inputList.add(str);
		waitingList.add(inputList);
	}
	
    public static void promptForIgnoringWords(){
		
		scanner = new Scanner(System.in);
		
		int counter = 0;
		System.out.println(WordsIgnorerPrompt);
		
		while(true){
			counter++;
			System.out.println("No. " + counter + " word to ignore: ");
			System.out.println(ExitPrompt);
			String currentInput = scanner.nextLine();
			
			if(currentInput.equals(ExitMark)){
				break;
			}
				
		}
	}
    
     public static void promptForProcessingStrings(){
		
		scanner = new Scanner(System.in);
		
		int counter = 0;
		System.out.println(StringToProcessPrompt);
		
		while(true){
			counter++;
			System.out.println("No. " + counter + " string to process: ");
			System.out.println(ExitPrompt);
			String currentInput = scanner.nextLine();
			
			if(currentInput.equals(ExitMark)){
				break;
			}
				
		}
	}
	
}
