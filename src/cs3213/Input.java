package cs3213;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * This class handles user input.
 * Its instance will prompt for words to ignore, and strings to process
 */

public class Input extends Filter{
	
	LinkedList<Package> waitingPackages;
	
	private static Scanner scanner;
	
	
	public Input(Pipe inputP, Pipe outputP) {
		
		super(inputP, outputP);
		waitingPackages = new LinkedList<Package>();
	}

	@Override
	protected void performIndependentTask(){
		if(outputPipe.isReadyToWrite() && waitingPackages.size()>0){
			synchronized (this) {
				inputPackage = waitingPackages.poll();
				outputPackage = new Package(inputPackage);
				outputPipe.write(outputPackage);
				
				inputPackage = null;
			}
		} 
	}
	
	public synchronized void passPackage(Package inputPackge){
		waitingPackages.add(inputPackge);
	}

}
