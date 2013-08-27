package cs3213;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphabetizer extends Filter{

	public Alphabetizer(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performIndependentTask() {
		
		if (this.inputPipe.isReadyToRead() && this.inputList == null){
			//System.out.println("Alphabetizer is now reading inputs");
			inputList = inputPipe.read();
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && this.inputList != null) {
			//System.out.println("Alphabetizer is now writing outputs");
			String[] sortStrings = inputList.toArray(new String[inputList.size()]);
			Arrays.sort(sortStrings);
			outputList = new ArrayList<String>(Arrays.asList(sortStrings));
			
			outputPipe.write(outputList);
			inputList = null;
		}
	}
	

}
