package hust.soict.globalict.test.store;
import hust.soict.globalict.aims.disc.DVD;
import hust.soict.globalict.aims.store.*;
public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Fiction","George Lucas",87, 24.95f);
		DVD dvd3 = new DVD("Aladdin","Animation",18.99f);
		Store anStore= new Store();
		anStore.addDVD(dvd1);
		anStore.addDVD(dvd2);
		anStore.addDVD(dvd3);
		for(int i = 0; i<anStore.getQty();i++) {
			System.out.println(anStore.getDVD(i).getTitle());
		}

		System.out.println(anStore.getQty());
		anStore.remove(dvd3);
		System.out.println(anStore.getQty());
		for(int i = 0; i<anStore.getQty();i++) {
			if (anStore.getDVD(i).getTitle()!= null)
			System.out.println(anStore.getDVD(i).getTitle());
		}
		anStore.addDVD(dvd3);
		for(int i = 0; i<anStore.getQty();i++) {
			if (anStore.getDVD(i).getTitle()!= null)
			System.out.println(anStore.getDVD(i).getTitle());
		}
		
	}

}
