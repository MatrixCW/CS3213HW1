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
			outputPipe.write(waitingList.poll());
		}
	}
	
	public void inputStream(String str) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(str);
		
		waitingList.add(list);
	}
}
