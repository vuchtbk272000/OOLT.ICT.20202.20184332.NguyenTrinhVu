package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.utils.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DVD order[]= new DVD[MAX_NUMBER_ORDERED];
	private int qty = 0;
	public int getQty(){
		return qty;
	}
	public DVD getDVD(int i) {
		return order[i];
	}
//--------------------------ADD 1 DVD----------------------------
	public void  addDVD(DVD disc) {
		if (qty<=MAX_NUMBER_ORDERED) {
			order[qty]= disc;
			qty++;
			System.out.println("the DVD has been added");
		}
		else {
			System.out.println("the cart is full");
		}
	}
//--------------------------REMOVE DVD---------------------------
	public void removeDVD(int index) {
		for (int i=index;i<qty;i++) {
			order[i]=order[i+1];
		}
		qty--;
	}
	public DVD[] removeDVD(DVD[] list, int index) {
		for (int i=index;i<list.length;i++) {
			order[i]=order[i+1];
		}
		DVD[] list1 =new DVD[] {};
		for (int j=0;j<list.length-1;j++) {
			list1[j]=list[j];
		}
		return list1;		
	}
	public void removeDVD(DVD disc) {
		int index=0;
		for (DVD dvd : order) {
			if (dvd.equals(disc)){
				break;
			}
			index++;
		}
		for (int i=index;i<qty;i++) {
			order[i]=order[i+1];
		}
		qty--;
	}
//----------------------------TOTAL COST-----------------------------
	public float totalcost() {
		float sum=0;
		for (int i=0; i<qty;i++) {
			sum+=order[i].getCost();
		
		}
		return sum;
	}
	public float totalcost(DVD[] list) {
		float sum=0;
		for (int i=0; i<list.length;i++) {
			sum+=list[i].getCost();
		
		}
		return sum;
	}
//----------------------------ADD DVD Arr---------------
	public void addDVD(DVD [] dvdList) {
		for (int i =0; i< dvdList.length; i++) {
			if (qty<=MAX_NUMBER_ORDERED) {
				order[qty]= dvdList[i];
				qty++;
				System.out.println("the DVD has been added");
			}
			else {
				System.out.println("the cart is full");
			}
		}
	}
//----------------------------ADD 2 DVDs-----------------
	public void addDVD(DVD dvd1,DVD dvd2){
		if (qty<=MAX_NUMBER_ORDERED) {
			order[qty]= dvd1;
			qty++;
			System.out.println("the DVD has been added");
		}
		else {
			System.out.println("the cart is full");
		}
		if (qty<=MAX_NUMBER_ORDERED) {
			order[qty]= dvd2;
			qty++;
			System.out.println("the DVD has been added");
		}
		else {
			System.out.println("the cart is full");
		}
	}
//-----------------------------SORT BY COST--------------------
	public void sortByCost(DVD[] list) {
		DVDUtils Utils = new DVDUtils();
		System.out.println("list sorted by cost:");
		for (int c=0;c<list.length;c++) {
			list[c] = Utils.sortByCost(list)[c];
		}
		for(int i=0;i<list.length;i++) {
			for(int j=i+1;j<list.length;j++) {
				if (list[i].getCost()==list[j].getCost()) 
					if (list[i].getTitle().compareTo(list[j].getTitle())>0) 			
						Utils.swap(list[i], list[j]);				
		
				}
			}
		}
		
		
	public  DVD[] sortByCost() {
		
		DVD[] list = new DVD[qty];
		for (int i =0;i<qty;i++) {
			list[i]=order[i];
		}
		DVDUtils Utils = new DVDUtils();
		System.out.println("list sorted by cost:");
		for (int c=0;c<qty;c++) {
			list[c] = Utils.sortByCost(list)[c];
		}
		
		return list;
	}
//-----------------------------SORT BY TITLE-------------------
	public void sortByTitle(DVD[] list) {
		DVDUtils Utils = new DVDUtils();
		System.out.println("\nlist sorted by title:");
		for (int c=0;c<list.length;c++) {
			list[c] = Utils.sortByTitle(list)[c];
		}
				
	}
	public DVD[] sortByTitle() {
		DVD[] list = new DVD[qty];
		for (int i =0;i<qty;i++) {
			list[i]=order[i];
		}
		DVDUtils Utils = new DVDUtils();

		for (int c=0;c<list.length;c++) {
			list[c] = Utils.sortByTitle(list)[c];
		}
				
		return list;
	}
	
//-----------------------------SORT ALL FIELDS--------------------
	public DVD[] sortAllField(DVD[] list) {
		DVDUtils Utils = new DVDUtils();
		
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
	public DVD[] sortAllField() {
		DVD[] list = new DVD[qty];
		for (int i =0;i<qty;i++) {
			list[i]=order[i];
		}
		DVD tmp = new DVD();
		DVDUtils Utils = new DVDUtils();
		
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

//------------------------------DETAIL CART----------------------------
	public void printCart() {
		DVD[] list = order;
		System.out.println("-----------------------------CART-----------------------------");
		System.out.format("%2s%15s%10s%10s%10s%7s%15s\n",
						  "Id","Title","Category","Director",
						  "Length","Cost","CreatedDate");
		if (qty>0) {
			for (int c= 0; c<qty;c++)
				System.out.format("%2s%15s%10s%10s%10s%6s$%15s\n", list[c].getId(),
							  list[c].getTitle(), list[c].getCategory(), list[c].getDirector(),
							  list[c].getLength(), list[c].getCost(), list[c].getDateAdded());	
		}
		else System.out.println("the cart is empty");
	}
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
	
		
//------------------------------SEARCH BY ID---------------------
	public DVD[] searchById(int id) {
		DVD[] match = new DVD[qty];
		int c=0;
		for(int i =0; i<qty;i++) {
			if (Integer.toString(order[i].getId()).contains(Integer.toString(i))) {
				match[c]=order[i];
				c++;
				
			}
		}
		if (c==0) {
			DVD noResult = new DVD("no DVD matched");
			match[c]= noResult;
		}
		return match;
	}	
//-------------------------------SEARCH BY TITLE------------------
	public DVD[] searchByTitle(String title) {
		DVD[] match = new DVD[qty]; 
		int i=0;
		for (int c=0;c<qty;c++) {
			if (order[c].getTitle().toLowerCase().contains(title.toLowerCase())) {
				match[i]=order[c];
				i++;
			}		
			if (i==0) {
				DVD noResult = new DVD("no DVD matched");
				match[i]= noResult;
			}
		}
		return match;	
	}
	
	
}


