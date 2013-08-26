package cs3213;

public abstract class Filter extends Runnable {
	private Pipe input_Pipe;
	private Pipe output_Pipe;
	
	public Filter(Pipe in_Pipe, Pipe out_Pipe){
		input_Pipe = in_Pipe;
		output_Pipe = out_Pipe;
	}
	
}
