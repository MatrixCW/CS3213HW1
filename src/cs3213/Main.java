package cs3213;

public class Main {
	
	public static void main(String[] agrs){
		Pipe inputShiftPipe = new Pipe();
		Pipe shiftAlphatizer = new Pipe();
		
		Filter input = new Input(null,inputShiftPipe);
		Filter shift = new CircularShift(inputShiftPipe, shiftAlphatizer);
		
		(new Thread(input)).start();
		(new Thread(shift)).start();
	}

}
