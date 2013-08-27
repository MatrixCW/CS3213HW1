package cs3213;

import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void main(String[] agrs){
		Pipe inputShiftPipe = new Pipe();
		Pipe shiftAlphatizer = new Pipe();
		
		Filter input = new Input(null,inputShiftPipe);
		Filter shift = new CircularShift(inputShiftPipe, shiftAlphatizer);
		
		(new Thread(input)).start();
		(new Thread(shift)).start();
		
		startInput((Input)input);
	}
	
	public static void startInput(Input input){
		scanner = new Scanner(System.in);
		while(true){
				System.out.println("Input String");
				input.inputStream(scanner.nextLine());
		}
	}

}
