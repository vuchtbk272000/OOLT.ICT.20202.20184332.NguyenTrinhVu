package hust.soict.globalict.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.globalict.aims.media.CD;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
public class MediaTest {

	public static void main(String[] args) {
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Fiction","George Lucas",87, 24.95f);
		DVD dvd4 = new DVD("The Lion King","Animations","Tran Thanh",87, 24.95f);
		DVD dvd5 = new DVD("kong", "Animation","Roger Allers",87,19.95f);
		DVD dvd6 = new DVD("Avenger", "Action","Roger Allers",99,19.95f);
		CD  cd1  = new CD("Hai Ngoai", "Bolero", 12.5f, "Quang Dung", "Quang Ha");
		Track t1 = new Track("Hello", 3);
		Track t2 = new Track("World", 5);
		cd1.addTrack(t2);
		cd1.addTrack(t1);
		ArrayList<Media> medias = new ArrayList<Media>();
		medias.add(cd1);
		medias.add(dvd1);
		medias.add(dvd6);
		medias.add(dvd4);
		Collections.sort(medias);
		for (Media m : medias)
			System.out.println(m.getDetail());
		Iterator<Media> list = medias.iterator();
		while(list.hasNext())
			list.next().play();	
		
	}

}
