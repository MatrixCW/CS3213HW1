package cs3213;

/*
 * Instance of this class sorts a collection of strings
 * and pass them to the next filter for execution
 */
public class Alphabetizer extends Filter{

	public Alphabetizer(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performIndependentTask() {
		
		if (this.inputPipe.isReadyToRead() && this.inputPackage == null){
			
			System.out.println("Alphabetizer is now reading inputs");
			inputPackage = inputPipe.read();
			addToOutputString();
		    sortOutputList();
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && this.inputPackage != null) {
			
			System.out.println("Alphabetizer is now producing outputs");
			outputPipe.write(outputPackage);
			inputPackage = null;//clean inputList for next read
			readyForProcessing = false;
			
		}
	}
	
	private void addToOutputString(){
		
//		if(outputList == null){
//			
//			outputList = new ArrayList<String>();
//			
//		}
//		
//		
//		for(String string : inputList){
//			
//			outputList.add(string);
//			
//		}
		
	}
	
    private void sortOutputList(){
    	
//    	Collections.sort(outputList);
		
	}
	

}
