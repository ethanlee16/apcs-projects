
public class Tool {
	public int size;
	private String attachment;
	private String description;
	
	public Tool() {
		
	}
	
	public Tool(int size, String description) {
		this.size = size;
		this.description = description;
	}
	
	public Tool(int size, String description, String attachment) {
		this.size = size;
		this.description = description;
		this.attachment = attachment;
	}
	
	public void useTool(int numberOfTimes) {
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
}
