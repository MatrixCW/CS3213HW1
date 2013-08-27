package cs3213;

import java.util.ArrayList;

public abstract class Filter implements Runnable{
	protected Pipe inputPipe;
	protected Pipe outputPipe;
	protected volatile ArrayList<String> inputList;
	protected volatile ArrayList<String> outputList;
	
	public Filter(Pipe inputP, Pipe outputP){
		inputPipe = inputP;
		outputPipe = outputP;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			perform();
		}
	}
	
	protected  abstract void perform();
}
