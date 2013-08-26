package cs3213;

import java.util.ArrayList;

public class Input extends Filter{
	private boolean hasInput;
	private ArrayList<String> outputList;
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		hasInput = false;
		outputList = new ArrayList<String>();
	}

	@Override
	protected synchronized void perform() {
		while(true){
			if(outputPipe.isReadyToWrite() && hasInput){
				outputPipe.write(outputList);
				outputList.remove(0);
				hasInput = false;
				
				break;
			}
		}
	}
	
	public synchronized void inputStream(String str){
		hasInput = true;
		outputList.add(str);
	}
	
	public synchronized boolean isReadyToWriteInto(){
		return !hasInput;
	}

}
