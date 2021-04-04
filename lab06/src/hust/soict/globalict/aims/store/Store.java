package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.*;

import java.util.ArrayList;

import hust.soict.globalict.aims.cart.*;

public class Store {
	public static final int MAX_NUMBER = 200;
	private ArrayList<MediaWrapper> itemsInStore = new	ArrayList<MediaWrapper>();
	private DVD[] order = new DVD[MAX_NUMBER];
	private int qty;
	public int getQty(){
		return itemsInStore.size();
	}
	public Media getMedia(int i) {
		return itemsInStore.get(i).media;
	}
	
//--------------------------------ADD & REMOVE-----------------------------------
	public void addMedia(Media media) {
		MediaWrapper m = new MediaWrapper(media);
		itemsInStore.add(m);	
		System.out.println("the DVD has been added");
	}
	
	public void removeMedia(Media media) {
		for(MediaWrapper m : itemsInStore) {
			if (m.media.equals(media)) {
				itemsInStore.remove(m);
				break;
			}
		}

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
		System.out.println("1. See a Media’s details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Get a lucky item from cart");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");

	}
	
//---------------------PRINT DVDs-------------------------------
//	public void printStore() {
//		DVD[] list = order;
//		System.out.println("-----------------------------STORE-----------------------------");
//		System.out.format("%2s%20s%20s%15s%10s%7s%15s\n",
//						  "Id","Title","Category","Director",
//						  "Length","Cost","CreatedDate");
//		
//		for (int c= 0; c<qty;c++)
//			System.out.format("%2s%20s%20s%15s%10s%6s$%15s\n", itemsInStore.get(c).getId(),
//							  itemsInStore.get(c).getTitle(), itemsInStore.get(c).getCategory(), itemsInStore.get(c).getDirector(),
//							  itemsInStore.get(c).getLength(), itemsInStore.get(c).getCost(), itemsInStore.get(c).getDateAdded());	
//	
//	}
//	
	
	public void printStore() {
		for( MediaWrapper m : itemsInStore) {
			if (m.media instanceof Book) {
				Book book = (Book)m.media;
				System.out.println(book.getDetail());
			}
			else if(m.media instanceof DVD) {
				DVD dvd = (DVD)m.media;
				System.out.println(dvd.getDetail());
			}
		}
	
	}
}
	
