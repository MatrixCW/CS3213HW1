package cs3213;

public class Output extends Filter{

	public Output(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performIndependentTask() {
		// TODO Auto-generated method stub
		if (this.inputPipe.isReadyToRead() && this.inputList == null){
			//System.out.println("Alphabetizer is now reading inputs");
			inputList = inputPipe.read();
		}
		
		if ( inputList != null) {
			for (String line : inputList) {
				System.out.println(line);
			}
			
			inputList = null;
		}
	}

}
