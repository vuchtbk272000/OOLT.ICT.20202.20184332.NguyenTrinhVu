package hust.soict.globalict.aims.screen;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CD;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreenFx extends JFrame{
	public static Cart cart;
	private JFXPanel fxPanel = new JFXPanel();
	public CartScreenFx(Cart c) {

		super();
		this.cart = c;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		setTitle("Cart");
		setVisible(true);
		setSize(1024,768);
			
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/Cart.fxml"));
					CartScreenController controller = new CartScreenController(c);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}	catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		});	
		
	}
	public CartScreenFx(Cart c,boolean a) {

		super();
		this.cart = c;
		
		this.add(fxPanel);
		
		setTitle("Cart");
		setVisible(a);
		setSize(1024,768);
			
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/Cart.fxml"));
					CartScreenController controller = new CartScreenController(c);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}	catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		});	
		
	}
	

	public static void main(String[]args) {
		Store aStore = new Store();
		Cart aCart = new Cart();
		
		Book book1 = new Book("Truyen Kieu","poem",12f);
		book1.addAuthor("Nguyen Du");
		book1.setContent("t1 t1 t2 t1 t3 t4");
		Book book2 = new Book("Khong gia dinh","Novel",28f);
		book2.addAuthor("Remi");
		book2.addAuthor("Bomen");
		book2.addAuthor("Putin");
		book2.setContent("t2 t3 t3 t1 t4 t5 t6 t7 t8 t1 t1 t1 t1 t2");
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Fiction","George Lucas",87, 24.95f);
		DVD dvd4 = new DVD("bo gia","Science Ficiton","Tran Thanh",87, 24.95f);
		DVD dvd5 = new DVD("kong", "Animation","Roger Allers",87,19.95f);
		DVD dvd6 = new DVD("Avenger", "Action","Roger Allers",99,19.95f);
		CD  cd1  = new CD("Hai Ngoai", "Bolero", 12.5f, "Quang Dung", "Quang Ha");
		Track t1 = new Track("Hello", 3);
		Track t2 = new Track("World", 5);
		aStore.addMedia(book1);
		aStore.addMedia(book2);
		aStore.addMedia(dvd1);
		aStore.addMedia(dvd2);
		aStore.addMedia(dvd4);
		aStore.addMedia(dvd5);
		aStore.addMedia(dvd6);
		aStore.addMedia(cd1);
		new CartScreen(aCart,false);
		ArrayList<Media> st = aStore.getItemInStore();
		for(Media m : st)
			System.out.println("Hello"+m.getDetail());
		try {
			aCart.addMedia(cd1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			aCart.addMedia(dvd1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			aCart.addMedia(book1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		aCart.addMedia(dvd2);
		new CartScreenFx(aCart);
		
	}

}
