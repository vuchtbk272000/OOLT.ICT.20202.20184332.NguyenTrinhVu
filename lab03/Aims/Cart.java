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
	public void removeDVD(int index) {
		for (int i=index;i<qty;i++) {
			order[i]=order[i+1];
		}
		qty--;
	}
	public float totalcost() {
		float sum=0;
		for (int i=0; i<qty;i++) {
			sum+=order[i].getCost();
		
		}
		return sum;
	}
	
	
}
