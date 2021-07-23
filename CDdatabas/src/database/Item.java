package database;

public class Item {

	private String title;
	private int playingTime;
	private boolean gotIt = false;
	private String comment;
	
	public Item(String title, int playingTime, String comment) {
		super();
		this.title = title;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

}
