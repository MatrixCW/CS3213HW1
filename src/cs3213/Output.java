package cs3213;


/*
 * This class handles output.
 * Its instance will display processed strings to the user
 */
public class Output extends Filter{

	public Output(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performIndependentTask() {
		// TODO Auto-generated method stub
		
		if(inputPackage == null && inputPipe.isReadyToRead()){
			
			inputPackage = inputPipe.read();
			
			for(String string : inputPackage.getStringsToProcess()){
				
				System.out.println(string);
				
			}
			
			inputPackage = null;
			
		
			
		}
	}

}
