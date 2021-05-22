package hust.soict.globalict.aims.Aims;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CD;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.media.Track;

public class test {

	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException {
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",-87,19.95f);
		CD  cd1  = new CD("Hai Ngoai", "Bolero", 12.5f, "Quang Dung", "Quang Ha");
		Track t1 = new Track("Hello", 3);
		Track t2 = new Track("World", 5);
		cd1.addTrack(t2);
		cd1.addTrack(t1);
		CD cd3= null;
		DVD dvd2 = null;
		try {
			dvd1.play();
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(cd1.getDetail());
		try	{
			System.out.println(cd3.equals(dvd1));
		}
		catch(NullPointerException e) {
			System.out.println("NULL");
		}
		catch (ClassCastException e) {
			e.printStackTrace();
			}
		
    }

}
