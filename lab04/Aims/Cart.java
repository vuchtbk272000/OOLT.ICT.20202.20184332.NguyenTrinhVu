package Aims;

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
		DVD print = new DVD();
		DVDUtils Utils = new DVDUtils();
		System.out.println("list sorted by cost:");
		for (int c=0;c<list.length;c++) {
			list[c] = Utils.sortByCost(list)[c];
		}
		System.out.println("-----------------------------CART-----------------------------");
		System.out.format("%2s%15s%10s%10s%10s%7s%15s\n",
						  "Id","Title","Category","Director",
						  "Length","Cost","CreatedDate");
		
		for (int i= 0; i<list.length;i++)
			System.out.format("%2s%15s%10s%10s%10s%6s$%15s\n", list[i].getId(),
							  list[i].getTitle(), list[i].getCategory(), list[i].getDirector(),
							  list[i].getLength(), list[i].getCost(), list[i].getDateAdded());
	}
//-----------------------------SORT BY TITLE-------------------
	public void sortByTitle(DVD[] list) {
		DVD print = new DVD();
		DVDUtils Utils = new DVDUtils();
		System.out.println("\nlist sorted by title:");
		for (int c=0;c<list.length;c++) {
			list[c] = Utils.sortByTitle(list)[c];
		}
						//***********************
		System.out.println("-----------------------------CART-----------------------------");
		System.out.format("%2s%15s%10s%10s%10s%7s%15s\n",
						  "Id","Title","Category","Director",
						  "Length","Cost","CreatedDate");
		
		for (int i= 0; i<list.length;i++)
			System.out.format("%2s%15s%10s%10s%10s%6s$%15s\n", list[i].getId(),
							  list[i].getTitle(), list[i].getCategory(), list[i].getDirector(),
	list[i].getLength(), list[i].getCost(), list[i].getDateAdded());
	}
//-----------------------------SORT ALL FIELDS--------------------
	public DVD[] sortAllField(DVD[] list) {
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
		
		
		
			//**************
			System.out.println("list sorted by title, cost and length:\n");
			System.out.println("-----------------------------CART-----------------------------");
			System.out.format("%2s%15s%10s%10s%10s%7s%15s\n",
							  "Id","Title","Category","Director",
							  "Length","Cost","CreatedDate");
			
			for (int c= 0; c<list.length;c++)
				System.out.format("%2s%15s%10s%10s%10s%6s$%15s\n", list[c].getId(),
								  list[c].getTitle(), list[c].getCategory(), list[c].getDirector(),
								  list[c].getLength(), list[c].getCost(), list[c].getDateAdded());	
		
		return list;
	}
		
//------------------------------SEARCH BY ID---------------------
	public DVD search(DVD [] list,int id) {
		DVD print = new DVD();
		for(DVD i : list) {
			if (i.getId()==id) {
				print.printDetail(i);
				return i;
			}
		}
		System.out.println("no DVD matched the given id: "+id);
		return null;
	}	
	
	
	
}


