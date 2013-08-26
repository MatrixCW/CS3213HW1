package cs3213;

import java.util.ArrayList;

public class Pipe {
	private ArrayList<String> parse_Data;
	
	public Pipe(){
		parse_Data = null;
	}
	
	public ArrayList<String> read(){
		return parse_Data;
	}
	
	public void write(ArrayList<String> data){
		parse_Data = data;
	}
	
	public void commit(){
		parse_Data = null;
	}
	
	public boolean isReadyToWrite(){
		return (parse_Data == null)?true:false;
	}
	
	public boolean isReadyToRead(){
		return (parse_Data == null)?false:true;
	}

}
