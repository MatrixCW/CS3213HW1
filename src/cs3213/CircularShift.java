package cs3213;

import java.util.ArrayList;

public class CircularShift extends Filter{

	public CircularShift(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
	}

	@Override
	protected void perform() {
		//if current input list is empty try to load from the inpipe
		if (inputPipe.isReadyToRead() && inputList == null){
			inputList = inputPipe.read();
			inputPipe.commit();
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && inputList != null) {
			outputList = shiftLinesArray(inputList);
			outputPipe.write(outputList);
			
			inputList = null;
		}
	}
	
	private ArrayList<String> shiftLinesArray(ArrayList<String> inputArray){
		return new ArrayList<String>(inputList);
	}

}
