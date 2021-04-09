package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CD extends Disc{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	
	public CD(String title, String category, float cost, int length, String director, String artist,
			ArrayList<Track> tracks) {
		super(title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	public boolean addTrack(Track track) {
		for(Track t : tracks)
			if (t.equals(track))
				return false;
			else tracks.add(track);
		return true;
	}
	public boolean reomoveTrack(Track track) {
		for(Track t : tracks)
			if (t.equals(track)) {
				tracks.remove(t);
				return true;
			}
		return false;
	}
	@Override
	public int getLength() {
		int length=0;
		for (Track t : tracks)
			length+= t.getLength();
		return length;
	}
	
	
	
	
}