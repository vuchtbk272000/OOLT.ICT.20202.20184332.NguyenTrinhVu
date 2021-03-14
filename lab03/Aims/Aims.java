package Aims;

import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		Cart anOrder = new Cart();
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Ficiton","George Lucas",87, 24.95f);
		DVD dvd3 = new DVD("Aladdin","Animation",18.99f);
		anOrder.addDVD(dvd1);
		anOrder.addDVD(dvd2);
		anOrder.addDVD(dvd3);
		for (int i =0; i<anOrder.getQty();i++)
			System.out.println(anOrder.getDVD(i).getTitle());
		System.out.println("the total cost is:"+ anOrder.totalcost());
		System.out.println("enter DVD index to remove:(from 0 to "+(anOrder.getQty()-1)+ "):");
		for (int i =0; i<anOrder.getQty();i++)
			System.out.println((i) +". "+anOrder.getDVD(i).getTitle());
		int index = keyboard.nextInt();
		anOrder.removeDVD(index);
		for (int i =0; i<anOrder.getQty();i++)
			System.out.println(anOrder.getDVD(i).getTitle());
		System.out.println("the total cost is:"+ anOrder.totalcost());
	}	

}
