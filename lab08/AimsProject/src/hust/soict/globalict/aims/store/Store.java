package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.*;

import java.util.ArrayList;

import hust.soict.globalict.aims.cart.*;

public class Store {
	public static final int MAX_NUMBER = 200;
	private ArrayList<Media> itemsInStore = new	ArrayList<Media>();

	public int getQty(){
		return itemsInStore.size();
	}
	public Media getMedia(int i) {
		return itemsInStore.get(i);
	}
	
//--------------------------------ADD & REMOVE-----------------------------------
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)){
			itemsInStore.add(media);	
			System.out.println("the DVD has been added.");
		}
	}
		
	
	public void removeMedia(Media media) {
		for(Media m : itemsInStore) {
			if (m.equals(media)) {
				itemsInStore.remove(m);				
				System.out.println("the Media has been removed.");
				break;
			}
		
		}
		System.out.println("the Media is not found");

	}
//----------------------------------------------------------MENU-----------------------------------------------------
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");

		System.out.println("1. Play a media");
		System.out.println("2. See a Media’s details");
		System.out.println("3. Add a Media to cart");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Play a media");
		System.out.println("2. Filter Medias in cart");
		System.out.println("3. Sort Medias in cart");
		System.out.println("4. Remove Media from cart");
		System.out.println("5. Get a lucky item from cart");
		System.out.println("6. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");

	}
	
	public void printStore() {
		for( Media m : itemsInStore) {
			System.out.println(m.getDetail());
		}
	
	}
}
	
