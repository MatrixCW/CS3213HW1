package cs3213;

import java.util.ArrayList;

public class Pipe {
	private ArrayList<String> parse_Data;
	
	public Pipe(){
		parse_Data = null;
	}
	
	public ArrayList<String> read(){
		ArrayList<String> result = parse_Data;
		parse_Data = null;
		
		return result;
	}
	
	public void write(ArrayList<String> data){
		parse_Data = data;
	}
	
	public boolean isNotReady(){
		return (parse_Data == null)?true:false;
	}

}
