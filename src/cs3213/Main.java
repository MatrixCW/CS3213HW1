package cs3213;

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
		
		
	}
	

}
