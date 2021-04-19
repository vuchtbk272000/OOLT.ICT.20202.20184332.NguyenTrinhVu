package hust.soict.globalict.test;
import hust.soict.globalict.aims.media.*;
public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("Truyen Kieu","poem",12f);
		book1.addAuthor("Nguyen Du");
		book1.setContent("t1 t1 t3 t1 t2 t4");
		System.out.println(book1.getDetail());
		System.out.print(book1.getContentTokens());

	}

}
