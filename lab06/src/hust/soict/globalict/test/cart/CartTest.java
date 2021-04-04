package hust.soict.globalict.test.cart;
import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.globalict.aims.media.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.utils.MediaUtils;
public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		MediaUtils Utils = new MediaUtils();
		DVD print = new DVD();
		Cart anOrder = new Cart();
		DVD dvd1= new DVD("AAAAA","aaaaa","aaaa",1, 5.6f);
		DVD dvd2= new DVD("BBBBB","bbbbb","bbbb",2, 5.3f);
		DVD dvd3= new DVD("CCCCC","ccccc","cccc",3, 5f);
		DVD dvd4= new DVD("DDDDD","ddddd","dddd",4, 7.2f);
		DVD dvd5= new DVD("EEEEE","eeeee","eeee",5, 3.3f);
		DVD dvd6= new DVD("AAAAA","aaaa2","aaa2",2,5.6f);
		DVD dvd7= new DVD("AAAA","aaaaa","aaaa",1, 5.6f);
		DVD dvd8= new DVD("Aaaaa","aaaaa","aaaa",1, 5.6f);
		
		DVD[] list = new DVD[] {dvd1, dvd2, dvd3, dvd4, dvd5,dvd6};

		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.addMedia(dvd4);
		
		
		anOrder.printCart();
		anOrder.sortByCost();
		anOrder.printCart();
		ArrayList<MediaWrapper> tmp = new ArrayList<MediaWrapper>();
	
		tmp = anOrder.sortByCost();
		
//		anOrder.sortAllField();
//		System.out.println("Total Cost: "+ anOrder.totalcost(list)+"$");
//		anOrder.printCart();
	}	

}
