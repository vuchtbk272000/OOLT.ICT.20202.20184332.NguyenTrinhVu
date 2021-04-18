package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Track implements Playable, Comparable<Track> {
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
	public	int compareTo(Track track) {
		return 0;
	}
	
	
}	
