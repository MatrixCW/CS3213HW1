package cs3213;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] agrs){
		Pipe inputShitPipe = new Pipe();
		Filter input = new Input(null,inputShitPipe);
		
		(new Thread(input)).start();
	}

}
