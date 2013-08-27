package cs3213;

import java.util.ArrayList;

public class Input extends Filter{
	
	private volatile ArrayList<String> outputList;
	
	public Input(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		outputList = new ArrayList<String>();
	}

	@Override
	protected void perform() {
		while(true){
			
			if(outputPipe.isReadyToWrite() && outputList.size() == 1){
				outputPipe.write(outputList);
				outputList.remove(0);
				
				break;
			}
		}
	}
	
	public void inputStream(String str){
		System.out.println(str);
	
		outputList.add(str);
	}
	
	public boolean isReadyToWriteInto(){
		return (outputList.size() == 0)?true:false;
	}

}
