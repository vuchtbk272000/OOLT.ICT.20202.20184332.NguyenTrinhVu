package hust.soict.globalict.test.utils;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.utils.*;

public class DVDTest {

	public static void main(String[] args) {
		DVD print = new DVD();
		MediaUtils sort = new MediaUtils();
		DVD dvd1= new DVD("AAAAA","aaaaa","aaaa",1, 5.6f);
		DVD dvd2= new DVD("BBBBB","bbbbb","bbbb",2, 5.3f);
		DVD dvd3= new DVD("CCCCC","ccccc","cccc",3, 5f);
		DVD dvd4= new DVD("DDDDD","ddddd","dddd",4, 7.2f);
		DVD dvd5= new DVD("EEEEE","eeeee","eeee",5, 3.3f);
		DVD dvd6= new DVD("AAAA","aaaaa","aaaa",1, 5.6f);
		DVD dvd7= new DVD("AAAAA","aaaaa","aaaa",1, 5.0f);
		DVD[] list = new DVD[] {dvd1, dvd2, dvd3, dvd4, dvd5,dvd6,dvd7};
		// Sort By Cost
		System.out.println("list sorted by cost:");
		for (int c=0;c<list.length;c++) {
			list[c] = sort.sortByCost(list)[c];
		}
		for (int i= 0; i<list.length;i++)
			System.out.println(list[i].getDetail());
		//Sort by title
		System.out.println("\nlist sorted by title:");
		for (int c=0;c<list.length;c++) {
			list[c] = sort.sortByTitle(list)[c];
		}
//		for (int i=0; i<list.length;i++) {
//			print.printDetail(list[i]);
//		}
	}

}
