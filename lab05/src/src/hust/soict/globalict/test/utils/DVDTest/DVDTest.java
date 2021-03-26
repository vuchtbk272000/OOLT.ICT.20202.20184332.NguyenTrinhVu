package hust.soict.globalict.test.utils.DVDTest;
import hust.soict.globalict.aims.utils.DVDUtils.*;
import hust.soict.globalict.aims.disc.DVD.DVD;

public class DVDTest {

	public static void main(String[] args) {
		DVD print = new DVD();
		DVDUtils sort = new DVDUtils();
		DVD dvd1= new DVD("AAAAA","aaaaa","aaaa",1, 5.6f);
		DVD dvd2= new DVD("BBBBB","bbbbb","bbbb",2, 5.3f);
		DVD dvd3= new DVD("CCCCC","ccccc","cccc",3, 5f);
		DVD dvd4= new DVD("DDDDD","ddddd","dddd",4, 7.2f);
		DVD dvd5= new DVD("EEEEE","eeeee","eeee",5, 3.3f);
		
		DVD[] list = new DVD[] {dvd1, dvd2, dvd3, dvd4, dvd5};
		// Sort By Cost
		System.out.println("list sorted by cost:");
		for (int c=0;c<list.length;c++) {
			list[c] = sort.sortByCost(list)[c];
		}
		for (int i= 0; i<list.length;i++)
			print.printDetail(list[i]);
		//Sort by title
		System.out.println("\nlist sorted by title:");
		for (int c=0;c<list.length;c++) {
			list[c] = sort.sortByTitle(list)[c];
		}
		for (int i=0; i<list.length;i++) {
			print.printDetail(list[i]);
		}
	}

}
