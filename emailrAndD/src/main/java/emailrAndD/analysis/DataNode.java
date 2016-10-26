package emailrAndD.analysis;

public class DataNode {
	private String channel;
	private String from;
	private String text;
	
	public void setChannel(String channel){
		this.channel = channel;
	}
	
	public String getChannel(){
		return this.channel;
	}
	
	public void setFrom(String from){
		this.from = from;
	}
	public String getfrom(){
		return this.from;
	}
	
	public void setText(String text){
		this.text= text;
	}
	public String getText(){
		return this.text;
	}
}
