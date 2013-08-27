package cs3213;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class Pipe {
	private volatile ArrayList<String> parse_Data;
	
	public Pipe(){
		parse_Data = null;
	}
	
	public ArrayList<String> read(){
		ArrayList<String> result = new ArrayList<String>(parse_Data);
		this.commit();
		
		return result;
	}
	
	public synchronized void write(ArrayList<String> data){
		parse_Data = data;
		
		for (String string : data) {
			System.out.println("Message from input filter:" + string);
		}
	}
	
	public synchronized void commit(){
		parse_Data = null;
	}
	
	public synchronized boolean isReadyToWrite(){
		return (parse_Data == null)?true:false;
	}
	
	public synchronized boolean isReadyToRead(){
		return (parse_Data == null)?false:true;
	}

}
