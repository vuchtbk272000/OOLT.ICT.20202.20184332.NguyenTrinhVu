package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.cart.*;

public class Store {
	public static final int MAX_NUMBER = 200;
	private DVD[] itemsInStore = new DVD[MAX_NUMBER];
	private int qty;
	public int getQty(){
		return qty;
	}
	public DVD getDVD(int i) {
		return itemsInStore[i];
	}
	
//--------------------------------ADD & REMOVE-----------------------------------
	public void addDVD(DVD disc) {
		itemsInStore[qty]= disc;
		qty++;
		System.out.println("the DVD has been added");
	}
	
	public void remove(DVD disc) {
		for(int i=0;i< itemsInStore.length;i++) {
			if (itemsInStore[i].equals(disc)) {
				for (int j=i;j<qty;j++) {
					itemsInStore[j]=itemsInStore[j+1];
				}
				break;
			}
		}
		qty--;
	}
//----------------------------------MENU-------------------------------------------
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
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");

	}
	
//---------------------PRINT DVDs-------------------------------
	public void printStore() {
		DVD[] list = itemsInStore;
		System.out.println("-----------------------------STORE-----------------------------");
		System.out.format("%2s%20s%20s%15s%10s%7s%15s\n",
						  "Id","Title","Category","Director",
						  "Length","Cost","CreatedDate");
		
		for (int c= 0; c<qty;c++)
			System.out.format("%2s%20s%20s%15s%10s%6s$%15s\n", list[c].getId(),
							  list[c].getTitle(), list[c].getCategory(), list[c].getDirector(),
							  list[c].getLength(), list[c].getCost(), list[c].getDateAdded());	
	
	}
	
}
