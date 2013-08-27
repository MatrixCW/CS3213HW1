package cs3213;

import java.util.ArrayList;

public class Alphabetizer extends Filter{

	public Alphabetizer(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performIndependentTask() {
		
		if (this.inputPipe.isReadyToRead() && this.inputList == null){
				
			System.out.println("Alphabetizer is now reading inputs");
			inputList = inputPipe.read();
		}
	
		ArrayList<String> temp = new ArrayList<String>();
		
		for(String string : this.inputList){
			temp.add(string);
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && this.inputList != null) {
			System.out.println("Alphabetizer is now writing outputs");
			outputList = temp;
			outputPipe.write(outputList);
			inputList = null;
		}
	}
	

}
