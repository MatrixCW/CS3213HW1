package cs3213;

import java.util.ArrayList;

public class Pipe {
	
	private volatile ArrayList<String> parse_Data;
	
	public Pipe(){
		
	}
	
	public ArrayList<String> read(){
		
		ArrayList<String> current_Data = new ArrayList<String>(parse_Data);
		this.commit();
		
		return current_Data;
	}
	
	public synchronized void write(ArrayList<String> data_To_Write){
		
		ArrayList<String> temp = new ArrayList<String>(data_To_Write);
		
		this.parse_Data = temp;
		
		
//		for (String elements : this.parse_Data) {
//			System.out.println("Message from input filter:" + elements);
//		}
	}
	
	private void commit(){
		parse_Data = null;
	}
	
	
	public synchronized boolean isReadyToWrite(){
		
		if(parse_Data == null)
			return true;
		else
			return false;
		
	}
	
	public synchronized boolean isReadyToRead(){
		
		if(parse_Data == null)
			return false;
		else
			return true;
		
	}

}
