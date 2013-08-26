package cs3213;

public abstract class Filter implements Runnable{
	protected Pipe inputPipe;
	protected Pipe outputPipe;
	
	public Filter(Pipe inputP, Pipe outputP){
		inputPipe = inputP;
		outputPipe = outputP;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			perform();
		}
	}
	
	public abstract void perform();
}
