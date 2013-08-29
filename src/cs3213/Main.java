package cs3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
		
		(new Thread(input)).start();
		(new Thread(shift)).start();
		(new Thread(alphabetizer)).start();
		(new Thread(output)).start();
		
		startInput((Input)input);
	}
	
	public static void startInput(Input input){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Input ignore words and spilt by '|', example: today|yesterday|history");
			String keywords = scanner.nextLine();
			System.out.println("Input titles and spilt by '|', example: The game of Throne | Harray Porter | Rice, Pray, Love");
			String titles = scanner.nextLine();
			
			input.passPackage(new Package(new ArrayList<String>(Arrays.asList(keywords.split("\\|"))), 
					new ArrayList<String>(Arrays.asList(titles.split("\\|")))));
		}
	}

}
