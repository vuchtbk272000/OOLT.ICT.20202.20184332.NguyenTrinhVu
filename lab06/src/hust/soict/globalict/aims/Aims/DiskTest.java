package hust.soict.globalict.aims.Aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DVD;

public class DiskTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		Cart anOrder = new Cart();
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Ficiton","George Lucas",87, 24.95f);
		DVD dvd3 = new DVD("Aladdin","Animation",18.99f);
		DVD dvd4 = new DVD("Aladdin 2","Animation",18.99f);
		
		DVD [] arDVD= {new DVD("Naruto"), new DVD("Attack on titan")};
		anOrder.addDVD(dvd1);
		anOrder.addDVD(dvd2);
		anOrder.addDVD(dvd3);
		anOrder.addDVD(dvd1, dvd2);
		anOrder.addDVD(arDVD);
		anOrder.addDVD(dvd4);
		for (int i =0; i<anOrder.getQty();i++)
			System.out.println(anOrder.getDVD(i).getTitle());
		System.out.println("the total cost is:"+ anOrder.totalcost());
		DVD[] search = new DVD[10];
		String token= keyboard.nextLine();
		search = anOrder.searchByTitle(token);
		for (int i= 0;i<search.length;i++) {
			if (search[i]!= null)
				System.out.println(search[i].getTitle());
		}
		System.out.println(dvd2.search("ala"));

	}

}
