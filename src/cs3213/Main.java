package cs3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static final String INPUT_IGNORE_WORDS_PROMPT = "Input ignore words and spilt by '|', example: today|yesterday|history";
	private static final String INPUT_SRINGS_TO_PROCESS_PROMPT = "Input titles and spilt by '|', example: The game of Throne | Harray Porter | Eat, Pray, Love";
    private static final String EXIT_MARK = "exit";
    private static final String EXIT_PROMPT = "Enter exit to terminate program";
    private static final int PAUSE_DURATION = 500;

    private static ArrayList<Filter> childThreadObjects = new ArrayList<Filter>();
	
	public static void main(String[] agrs){
		
		//pipe connecting input reader and shifter 
		Pipe inputShiftPipe = new Pipe();
		//pipe connecting shifter and alphabetizer
		Pipe shiftAlphabetizer = new Pipe();
		//pipe connecting alphabetizer and output writer
		Pipe alphabetizerOutput = new Pipe();
		
		
		Filter input = new Input(null,inputShiftPipe);
		Filter shift = new CircularShifter(inputShiftPipe, shiftAlphabetizer);
		Filter alphabetizer = new Alphabetizer(shiftAlphabetizer,alphabetizerOutput);
		Filter output = new Output(alphabetizerOutput, null);
		
		Thread inputThread = new Thread(input);
		Thread shiftThread = new Thread(shift);
		Thread alphabetizerThread = new Thread(alphabetizer);
		Thread outputThread = new Thread(output);
		
		childThreadObjects.add(input);
		childThreadObjects.add(shift);
		childThreadObjects.add(alphabetizer);
		childThreadObjects.add(output);
		
		inputThread.start();
		shiftThread.start();
		alphabetizerThread.start();
		outputThread.start();

		startInput((Input)input);
	}
	
	public static void startInput(Input input){
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			
			System.out.println(INPUT_IGNORE_WORDS_PROMPT);
			System.out.println(EXIT_PROMPT);
			String ignorewords = scanner.nextLine();
			
			System.out.println(INPUT_SRINGS_TO_PROCESS_PROMPT);
			System.out.println(EXIT_PROMPT);
			String titles = scanner.nextLine();
			
			if(titles.equals(EXIT_MARK)){
				
				scanner.close();
				terminatePrograme(); //mark child threads to exit
				break;
				
			}
			
			input.passPackage(new Package(new ArrayList<String>(Arrays.asList(ignorewords.split("\\|"))), 
					new ArrayList<String>(Arrays.asList(titles.split("\\|")))));
			
			//this try catch method is to make the interface friendlier. it can be moved
			try{
				Thread.sleep(PAUSE_DURATION);
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
	
	
	public static void terminatePrograme(){
		
		for(Filter flt : childThreadObjects){
			
			flt.terminate();
			
		}
		
	}
	
	

}
