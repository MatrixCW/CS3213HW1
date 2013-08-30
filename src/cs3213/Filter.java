package cs3213;

/*THis is the abstract class filter.
Input, Output, CircularShifter and Alphabetizer
are sub-types of this class.*/
public abstract class Filter implements Runnable{
	
	protected  Pipe inputPipe;
	protected  Pipe outputPipe;
	
	protected  Package inputPackage;
	protected  Package outputPackage;
	
	private volatile boolean running = true;
	 
	public Filter(Pipe inputPipe, Pipe outputPipe){
		this.inputPipe = inputPipe;
		this.outputPipe = outputPipe;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running){
			performIndependentTask();
		}
	}
	
	public synchronized void terminate(){
		
		running = false;
		
	}

	//SUbclasses will implement this method according to their own tasks
	protected  abstract void performIndependentTask();
}
