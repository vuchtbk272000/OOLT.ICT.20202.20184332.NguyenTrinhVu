package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CD extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	
//------------------------------CONSTRUCTOR--------------------------------
	public CD(String title, String category, float cost, String director, String artist) {
		super(title, category, cost, director);
		this.artist = artist;
	}
//-----------------------------------------------------------------------------
	public void addTrack(Track track) {
		if (tracks.contains(track)== false)
			tracks.add(track);
		else System.out.println("The item already exists.");
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
			length=length+ t.getLength();
		return length;
	}
	@Override
	public String getDetail() {
		String s;
		s = ("CD: "+ id + "- "+ title+ "- "+category+"- "+artist+"- "+director+"- ");
		
		String trackTitles="";
		for (Track t: tracks)
			trackTitles= trackTitles +t.getTitle()+"/ ";
		s=s+trackTitles+"- "+cost+"- "+this.getLength();
		return s; 	
	}
	@Override
	public void play() {
		System.out.println(title);

		System.out.println("CD length: "+this.getLength());
		for (Track t : tracks)
			t.play();
		
	}
	
	
	
}