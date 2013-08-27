package cs3213;

import java.util.ArrayList;

/*THis is the abstract class filter. Other classes, namely, 
Input, OUtput, CircularShifter and Alphabetizer
are sub-types of this class.*/
public abstract class Filter implements Runnable{
	
	protected  Pipe inputPipe;
	protected  Pipe outputPipe;
	protected  ArrayList<String> inputList;
	protected  ArrayList<String> outputList;
	
	public Filter(Pipe inputPipe, Pipe outputPipe){
		this.inputPipe = inputPipe;
		this.outputPipe = outputPipe;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			performSpecificTask();
		}
	}

	//SUbclasses will implement this method according to their own tasks
	protected  abstract void performSpecificTask();
}
