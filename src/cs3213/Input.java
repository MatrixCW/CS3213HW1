package cs3213;

import java.util.ArrayList;
import java.util.LinkedList;

public class Input extends Filter{
	
	LinkedList<ArrayList<String>> waitingList;
	
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		waitingList = new LinkedList<ArrayList<String>>();
		
	}

	@Override
	protected void perform() {
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
	
//	public boolean isReadyToWriteIn(){
//		return inputList==null?true:false;
//	}
}
