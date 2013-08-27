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
				System.out.println("hehehe");
				inputList = inputPipe.read();
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && inputList != null) {
			System.out.println("heheout");
			outputList = shiftLinesArray(inputList);
			outputPipe.write(outputList);
			//outputPipe.commit();
			
			inputList = null;
		}
	}
	
	private ArrayList<String> shiftLinesArray(ArrayList<String> inputArray){
		return new ArrayList<String>(inputList);
	}

}
