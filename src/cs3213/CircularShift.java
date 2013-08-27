package cs3213;

import java.util.ArrayList;

public class CircularShift extends Filter{
	private ArrayList<String> inputList;
	private ArrayList<String> outputList;

	public CircularShift(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
	}

	@Override
	protected void perform() {
		if (inputPipe.isReadyToRead() && outputPipe.isReadyToWrite()) {
			inputList = inputPipe.read();
			inputPipe.commit();
			
			outputList = this.shiftLinesArray(inputList);
			outputPipe.write(outputList);
		}
	}
	
	private ArrayList<String> shiftLinesArray(ArrayList<String> inputArray){
		return inputArray;
	}

}
