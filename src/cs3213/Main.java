package cs3213;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] agrs){
		Pipe inputShitPipe = new Pipe();
		Filter input = new Input(null,inputShitPipe);
		
		(new Thread(input)).start();
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
			if (((Input)input).isReadyToWriteInto()) {
				System.out.println("Input your string");
				((Input)input).inputStream(scan.nextLine());
			}
		}
		
	}

}
