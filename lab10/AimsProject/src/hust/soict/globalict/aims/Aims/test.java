package hust.soict.globalict.aims.Aims;

import hust.soict.globalict.aims.media.CD;
import hust.soict.globalict.aims.media.Track;

public class test {

	public static void main(String[] args) throws InterruptedException {
		CD  cd1  = new CD("Hai Ngoai", "Bolero", 12.5f, "Quang Dung", "Quang Ha");
		Track t1 = new Track("Hello", 3);
		Track t2 = new Track("World", 5);
		cd1.addTrack(t2);
		cd1.addTrack(t1);
		cd1.play();
		System.out.println(cd1.getDetail());
    }

}
