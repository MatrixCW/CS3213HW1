package cs3213;

import java.util.ArrayList;

/*THis is the abstract class filter.
Input, Output, CircularShifter and Alphabetizer
are sub-types of this class.*/
public abstract class Filter implements Runnable{
	
	protected  Pipe inputPipe;
	protected  Pipe outputPipe;
	
	protected boolean readyForProcessing;
	
	protected  Package inputPackage;
	protected  Package outputPackage;
	
	public Filter(Pipe inputPipe, Pipe outputPipe){
		this.inputPipe = inputPipe;
		this.outputPipe = outputPipe;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			performIndependentTask();
		}
	}

	//SUbclasses will implement this method according to their own tasks
	protected  abstract void performIndependentTask();
}
