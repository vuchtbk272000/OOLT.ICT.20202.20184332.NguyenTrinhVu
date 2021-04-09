package hust.soict.globalict.aims.media;

public class Disc extends Media{
	protected int length;
	protected String director;
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc(String title, String category, float cost, int length, String director) {
		super(title, category, cost);
		this.length = length;
		director = director;
	}
	
	
}
