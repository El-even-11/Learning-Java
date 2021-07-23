package database;

public class DVD extends Item {

	private String director;

	public DVD(String title, int playingTime, String comment, String director) {
		super(title, playingTime, comment);
		this.director = director;
	}

}
