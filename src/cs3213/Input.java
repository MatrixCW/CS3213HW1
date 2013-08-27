package cs3213;

import java.util.ArrayList;
import java.util.LinkedList;

public class Input extends Filter{
	
	LinkedList<ArrayList<String>> waitingList;
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		inputList = new ArrayList<String>();
	}

	@Override
	protected void perform() {
		if (inputList.size()>0 && outputPipe.isReadyToWrite()) {
			outputList = new ArrayList<String>(inputList);
			outputPipe.write(outputList);
			
			inputList.remove(0);
		}
	}
	
	public void inputStream(String str) {
		inputList.add(str);
	}
	
	public boolean isReadyToWriteIn(){
		return inputList.size()==0?true:false;
	}
}
