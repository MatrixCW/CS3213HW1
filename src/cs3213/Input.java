package cs3213;

import java.util.ArrayList;
import java.util.Scanner;

public class Input extends Filter{
	
	private volatile ArrayList<String> outputList;
	private Scanner scanner;
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		outputList = new ArrayList<String>();
		scanner = new Scanner(System.in);
	}

	@Override
	protected void perform() {
		if(outputList.size()==0 && outputPipe.isReadyToWrite()){
			outputList = this.getInputData();
			
			outputPipe.write(outputList);
			outputList.remove(0);
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
