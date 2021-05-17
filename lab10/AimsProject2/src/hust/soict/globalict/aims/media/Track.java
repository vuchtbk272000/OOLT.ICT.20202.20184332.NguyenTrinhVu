package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable, Comparable{
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

	public void play() throws PlayerException{
		if (this.length > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		else System.out.println("ERROR: the track's length is non-positive");
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track)o;
			if (this.title.equals(track.title))
				if (this.length==track.length)
					return true;
			}
		
		return false;
	}
	@Override
	public int compareTo(Object object) {
		int c=0;
		if (object instanceof Track) {
			Track track = (Track)object;
			c = track.title.compareToIgnoreCase(this.title);
			if (c==0) {
				c = this.title.compareTo(track.title);
				if (c==0){
					c = track.length-this.length;
				}
			}		
		}
		
		return c;
	}
	
}	
