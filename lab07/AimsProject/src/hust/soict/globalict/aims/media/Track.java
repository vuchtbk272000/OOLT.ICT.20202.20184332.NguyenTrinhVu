package hust.soict.globalict.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public int getLength() {
		return length;
	}
	
	public String getTitle() {
		return title;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		}
}	
