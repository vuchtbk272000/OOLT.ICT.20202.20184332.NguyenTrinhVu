package hust.soict.globalict.aims.cart;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<MediaWrapper> itemsOrdered = new	ArrayList<MediaWrapper>();

	private int qty = 0;
	public int getQty(){
		return itemsOrdered.size();
	}
	public Media getMedia(int i) {
		return itemsOrdered.get(i).media;
	}
//--------------------------ADD 1 Media----------------------------
	public void  addMedia(Media media) {
		if (qty<=MAX_NUMBER_ORDERED) {
			MediaWrapper wrapper = new MediaWrapper(media);
			itemsOrdered.add(wrapper);
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
		MediaWrapper wrapper = new MediaWrapper(media);
		for (MediaWrapper w : itemsOrdered) {
			if (w.equals(wrapper)){
				itemsOrdered.remove(w);
				break;
			}
		}
		
	}
	public void clear() {
		itemsOrdered.clear();
	}
//----------------------------TOTAL COST-----------------------------
	public float totalcost() {
		
		float sum=0;
		for (MediaWrapper w : itemsOrdered) {
			sum+=w.media.getCost();		
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
////----------------------------ADD DVD Arr---------------
//	public void addDVD(DVD [] dvdList) {
//		for (int i =0; i< dvdList.length; i++) {
//			if (qty<=MAX_NUMBER_ORDERED) {
//				order[qty]= dvdList[i];
//				qty++;
//				System.out.println("the DVD has been added");
//			}
//			else {
//				System.out.println("the cart is full");
//			}
//		}
//	}
////----------------------------ADD 2 DVDs-----------------
//	public void addDVD(DVD dvd1,DVD dvd2){
//		if (qty<=MAX_NUMBER_ORDERED) {
//			order[qty]= dvd1;
//			qty++;
//			System.out.println("the DVD has been added");
//		}
//		else {
//			System.out.println("the cart is full");
//		}
//		if (qty<=MAX_NUMBER_ORDERED) {
//			order[qty]= dvd2;
//			qty++;
//			System.out.println("the DVD has been added");
//		}
//		else {
//			System.out.println("the cart is full");
//		}
//	}
//-----------------------------SORT BY COST--------------------
//	public void sortByCost(DVD[] list) {
//		MediaUtils Utils = new MediaUtils();
//		System.out.println("list sorted by cost:");
//		for (int c=0;c<list.length;c++) {
//			list[c] = Utils.sortByCost(list)[c];
//		}
//		for(int i=0;i<list.length;i++) {
//			for(int j=i+1;j<list.length;j++) {
//				if (list[i].getCost()==list[j].getCost()) 
//					if (list[i].getTitle().compareTo(list[j].getTitle())>0) 			
//						Utils.swap(list[i], list[j]);				
//		
//				}
//			}
//		}
	
		
		
//	public  DVD[] sortByCost() {
//		
//		DVD[] list = new DVD[qty];
//		for (int i =0;i<qty;i++) {
//			list[i]=itemsOrdered.get(i);
//		}
//		MediaUtils Utils = new MediaUtils();
//		System.out.println("list sorted by cost:");
//		for (int c=0;c<qty;c++) {
//			list[c] = Utils.sortByCost(list)[c];
//		}
//		
//		return list;
//	}
	public  ArrayList<MediaWrapper> sortByCost() {
		MediaUtils Utils = new MediaUtils();
		ArrayList<MediaWrapper> list = new ArrayList<MediaWrapper>();
		list = Utils.sortByCost(itemsOrdered);		
		System.out.println("list sorted by cost:");
		
		
		return list;
	}
//-----------------------------SORT BY TITLE-------------------
	public void sortByTitle(DVD[] list) {
		MediaUtils Utils = new MediaUtils();
		System.out.println("\nlist sorted by title:");
		for (int c=0;c<list.length;c++) {
			list[c] = Utils.sortByTitle(list)[c];
		}
				
	}
	public ArrayList<MediaWrapper> sortByTitle() {
		MediaUtils Utils = new MediaUtils();
		ArrayList<MediaWrapper> list = new ArrayList<MediaWrapper>();
		list = Utils.sortByTitle(itemsOrdered);		
		System.out.println("list sorted by title:");
		
		
		return list;
	}
	
//-----------------------------SORT ALL FIELDS--------------------
	public DVD[] sortAllField(DVD[] list) {
		MediaUtils Utils = new MediaUtils();
		
		sortByTitle(list);
		for(int i=0;i<list.length;i++) {
			for(int j=i+1;j<list.length;j++) {
				if (list[i].getTitle().compareTo(list[j].getTitle())==0) {
					if(Utils.compareByCost(list[i],list[j])<0) {
						Utils.swap(list[i], list[j]);
					}
				}
			}
		}
		for(int i=0;i<list.length;i++) {
			for(int j=i+1;j<list.length;j++) {
				if (list[i].getTitle().compareTo(list[j].getTitle())==0) {
					if (Utils.compareByCost(list[i],list[j])==0) {
					if(Utils.compareByLength(list[i],list[j])<0) {
						Utils.swap(list[i], list[j]);
					}
				}
				}
			}
		}
		
			
		return list;
	}
	public ArrayList<MediaWrapper> sortAllField() {
		MediaUtils Utils = new MediaUtils();
		ArrayList<MediaWrapper> list = new ArrayList<MediaWrapper>();
		this.sortByTitle();
		for (int i =0;i<itemsOrdered.size();i++) {
			list.add(itemsOrdered.get(i));
		}
		DVD tmp = new DVD();
		
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if (list.get(i).media.getTitle().compareTo(list.get(j).media.getTitle())==0) {
					if (Utils.compareByCost(list.get(i).media,list.get(j).media)==0) {
					if(Utils.compareByLength(list.get(i).media,list.get(j).media)<0) {
						Utils.swap(list.get(i), list.get(j));
					}
				}
				}
			}
		}
		
		
		return list;
	}

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
		for (MediaWrapper m : itemsOrdered) {
			System.out.println(m.media.getDetail());
		}
	}
	
		
//------------------------------SEARCH BY ID---------------------
	public ArrayList<Media> searchById(int id) {
		ArrayList<Media> match = new ArrayList<Media>();
		int c=0;
		for(int i =0; i<qty;i++) {
			if (Integer.toString(itemsOrdered.get(i).media.getId()).contains(Integer.toString(i))) {
				match.add(itemsOrdered.get(i).media);
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
			if (itemsOrdered.get(i).media.getTitle().toLowerCase().contains(title.toLowerCase())) {
				match.add(itemsOrdered.get(i).media);
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
		return itemsOrdered.get(a).media;
	}
	public  int getLuckyItem() {
		int rand=-1;
		if (itemsOrdered.size()==0) System.out.println("your card is empty");
		else{
		int range=itemsOrdered.size()-1;
			rand=(int)(Math.random()*range);
			Media luckyItem=itemsOrdered.get(rand).media;
			System.out.print("your lucky item :"); 
			System.out.println(luckyItem.getDetail());
			//itemOrdered.get(rand).setCost(0);
		}
		return rand;
		}
	
	
}


