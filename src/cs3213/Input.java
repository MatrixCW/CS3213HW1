package cs3213;

import java.util.ArrayList;
import java.util.Scanner;

public class Input extends Filter{
	
	private Scanner scanner;
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		inputList = new ArrayList<String>();
		scanner = new Scanner(System.in);
	}

	@Override
	protected void perform() {
		if(inputList.size()==0 && outputPipe.isReadyToWrite()){
			inputList = this.getInputData();
			
			outputList = new ArrayList<String>(inputList);
			inputList.remove(0);
			
			outputPipe.write(outputList);
		}
	}
	
	private ArrayList<String> getInputData() {
		System.out.println("Input the String:");
		
		String content = scanner.nextLine();
		ArrayList<String> resultArrayList = new ArrayList<String>();
		resultArrayList.add(content);
		
		return resultArrayList;
	}
}
