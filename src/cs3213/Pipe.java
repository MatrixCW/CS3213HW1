package cs3213;


public class Pipe {
	
	private Package parse_Data;
	
	public Pipe(){
		
	}
	
	public Package read(){
		
		Package current_Data = new Package(parse_Data);
		this.commit();
		
		return current_Data;
	}
	
	public synchronized void write(Package data_To_Write){
		
		Package temp = new Package(data_To_Write);
		
		this.parse_Data = temp;
		
		for (String elements : this.parse_Data.getKeywords()) {
			System.out.println("Message from input filter:" + elements);
		}
		
		for (String elements : this.parse_Data.getImplementString()) {
			System.out.println("Message from input filter:" + elements);
		}
	}
	
	public void commit(){
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
