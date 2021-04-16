package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new	ArrayList<Media>();

	private int qty = 0;
	public int getQty(){
		return itemsOrdered.size();
	}
	public Media getMedia(int i) {
		return itemsOrdered.get(i);
	}
//--------------------------ADD 1 Media----------------------------
	public void  addMedia(Media media) {
		if (itemsOrdered.size()<=MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("the Media has been added");
			qty++;
		}
		else {
			System.out.println("the cart is full");
		}
	}
	
	
//--------------------------REMOVE Media---------------------------
//	public void removeMedia(int index) {
//		for (int i=index;i<qty;i++) {
//			order[i]=order[i+1];
//		}
//		qty--;
//	}
//	public DVD[] removeDVD(DVD[] list, int index) {
//		for (int i=index;i<list.length;i++) {
//			order[i]=order[i+1];
//		}
//		DVD[] list1 =new DVD[] {};
//		for (int j=0;j<list.length-1;j++) {
//			list1[j]=list[j];
//		}
//		return list1;		
//	}
	public void removeMedia(Media media) {
		for (Media m : itemsOrdered) {
			if (m.equals(media)){
				itemsOrdered.remove(m);
				break;
			}
		}
		
	}
	public void clear() {
		itemsOrdered.clear();
	}
//----------------------------TOTAL COST-----------------------------
	public float totalCost() {
		
		float sum=0;
		for (Media m : itemsOrdered) {
			sum+=m.getCost();		
		}
		return sum;
	}
//	public float totalcost(DVD[] list) {
//		float sum=0;
//		for (int i=0; i<list.length;i++) {
//			sum+=list[i].getCost();
//		
//		}
//		return sum;
//	}
//------------------------------------sort--------------------------------
	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.byCost);
	}
	public void sortByTitle() {
		Collections.sort(itemsOrdered,Media.byTitle);
	}
	public void sortAllFields() {
		Collections.sort(itemsOrdered,Media.byFields);
	}
////-----------------------------SORT ALL FIELDS--------------------
//	public DVD[] sortAllField(DVD[] list) {
//		MediaUtils Utils = new MediaUtils();
//		
//		sortByTitle(list);
//		for(int i=0;i<list.length;i++) {
//			for(int j=i+1;j<list.length;j++) {
//				if (list[i].getTitle().compareTo(list[j].getTitle())==0) {
//					if(Utils.compareByCost(list[i],list[j])<0) {
//						Utils.swap(list[i], list[j]);
//					}
//				}
//			}
//		}
//		for(int i=0;i<list.length;i++) {
//			for(int j=i+1;j<list.length;j++) {
//				if (list[i].getTitle().compareTo(list[j].getTitle())==0) {
//					if (Utils.compareByCost(list[i],list[j])==0) {
//					if(Utils.compareByLength(list[i],list[j])<0) {
//						Utils.swap(list[i], list[j]);
//					}
//				}
//				}
//			}
//		}
//		
//			
//		return list;
//	}
//	public ArrayList<MediaWrapper> sortAllField() {
//		MediaUtils Utils = new MediaUtils();
//		ArrayList<MediaWrapper> list = new ArrayList<MediaWrapper>();
//		this.sortByTitle();
//		for (int i =0;i<itemsOrdered.size();i++) {
//			list.add(itemsOrdered.get(i));
//		}
//		DVD tmp = new DVD();
//		
//		for(int i=0;i<list.size();i++) {
//			for(int j=i+1;j<list.size();j++) {
//				if (list.get(i).media.getTitle().compareTo(list.get(j).media.getTitle())==0) {
//					if (Utils.compareByCost(list.get(i).media,list.get(j).media)==0) {
//					if(Utils.compareByLength(list.get(i).media,list.get(j).media)<0) {
//						Utils.swap(list.get(i), list.get(j));
//					}
//				}
//				}
//			}
//		}
//		
//		
//		return list;
//	}

//	
//------------------------------DETAIL CART----------------------------
//	public void printDVDCart() {
//		DVD[] list = order;
//		System.out.println("-----------------------------CART-----------------------------");
//		System.out.format("%2s%15s%10s%10s%10s%7s%15s\n",
//						  "Id","Title","Category","Director",
//						  "Length","Cost","CreatedDate");
//		if (qty>0) {
//			for (int c= 0; c<qty;c++)
//				System.out.format("%2s%15s%10s%10s%10s%6s$%15s\n", list[c].getId(),
//							  list[c].getTitle(), list[c].getCategory(), list[c].getDirector(),
//							  list[c].getLength(), list[c].getCost(), list[c].getDateAdded());	
//		}
//		else System.out.println("the cart is empty");
//	}
	public void printCart(DVD[] list) {
		
		System.out.println("-----------------------------CART-----------------------------");
		System.out.format("%2s%15s%10s%10s%10s%7s%15s\n",
						  "Id","Title","Category","Director",
						  "Length","Cost","CreatedDate");
		
		for (int c= 0; c<qty;c++)
			System.out.format("%2s%15s%10s%10s%10s%6s$%15s\n", list[c].getId(),
							  list[c].getTitle(), list[c].getCategory(), list[c].getDirector(),
							  list[c].getLength(), list[c].getCost(), list[c].getDateAdded());	
	
	}
	
	public void printCart() {
		for (Media m : itemsOrdered) {
			System.out.println(m.getDetail());
		}
		System.out.println(totalCost());
	}
	
		
//------------------------------SEARCH BY ID---------------------
	public ArrayList<Media> searchById(int id) {
		ArrayList<Media> match = new ArrayList<Media>();
		int c=0;
		for(int i =0; i<qty;i++) {
			if (Integer.toString(itemsOrdered.get(i).getId()).contains(Integer.toString(i))) {
				match.add(itemsOrdered.get(i));
				c++;
			}
		}
//		if (c==0) {
//			DVD noResult = new DVD("no DVD matched");
//			match.add(noResult);
//		}
		return match;
	}	
	
//-------------------------------SEARCH BY TITLE------------------
	public ArrayList<Media> searchByTitle(String title) {
		ArrayList<Media> match = new ArrayList<Media>(); 
		int i=0;
		for (int c=0;c<qty;c++) {
			if (itemsOrdered.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
				match.add(itemsOrdered.get(i));
				i++; 
			}		
//			if (i==0) {
//				DVD noResult = new DVD("no DVD matched");
//				match.add(noResult);
//			}
		}
		return match;	
	}
	
//---------------------------LUCKY ITEM------------------------
	public Media luckyItem(int a) {
		if (a>-1)
			return itemsOrdered.get(a);
		else return null;
	}
	public  int getLuckyItem() {
		int rand=-1;
		if (itemsOrdered.size()==0) System.out.println("your card is empty");
		else{
		int range=itemsOrdered.size()-1;
			rand=(int)(Math.random()*range);
			Media luckyItem=itemsOrdered.get(rand);
			System.out.print("your lucky item :"); 
			System.out.println(luckyItem.getDetail());
		}
		return rand;
		}
	
	
}


