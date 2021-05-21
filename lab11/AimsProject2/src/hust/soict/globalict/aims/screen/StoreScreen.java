package hust.soict.globalict.aims.screen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CD;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
public class StoreScreen extends JFrame {
	public static Store store;
//	public void addMedia(Media media) {
//		Store st = store;
//		st.addMedia(media);
//		this.store = st;
//	}
//	
	
	//NORTH
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	//create menu bar
	JMenuBar createMenuBar() {
		ButtonListener btnListener = new ButtonListener();
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JButton addBook = new JButton("Add Book");
		JButton addDVD = new JButton("Add DVD");
		JButton addCD = new JButton("Add CD");
		
		smUpdateStore.add(addBook);
		smUpdateStore.add(addDVD);
		smUpdateStore.add(addCD);
		
		addBook.addActionListener(btnListener);
		addDVD.addActionListener(btnListener);
		addCD.addActionListener(btnListener);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		JMenuItem cart = new JMenuItem("View cart");
		cart.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						Cart tmp = CartScreenFx.cart;
						setVisible(false);
		                new CartScreenFx(CartScreenFx.cart);
	                }
				});
		menu.add(cart);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
		
	}
	//create header
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						setVisible(false);
		                new CartScreenFx(CartScreenFx.cart);
	                }
				});
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	//create Center
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemInStore();
		for (int i =0; i<store.getQty(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	//items
	public class MediaStore extends JPanel {
		ButtonListener btnListener = new ButtonListener();
		private Media media;
		public MediaStore(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel(""+media.getCost()+" $");
			cost.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton addToCart = new JButton("Add to cart");
			addToCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cart tmp = CartScreenFx.cart;
					try {
						tmp.addMedia(media);
					} catch (LimitExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
	                new CartScreenFx(tmp);
                }
			});
			container.add(addToCart);
			
			if(media instanceof Playable) {
				JButton play = new JButton("Play");
				play.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JDialog d = new JDialog();
						// create a label
				        JLabel l = new JLabel("Playing "+ media.getTitle());
				 
				        d.add(l);
				 
				        // setsize of dialog
				        d.setSize(100, 100);
				 
				        // set visibility of dialog
				        d.setVisible(true);
	                }
				});
				container.add(play);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	//constructor
	public StoreScreen(Store st) {
		this.store = st;
		ArrayList<Media> mediaInStore = store.getItemInStore();
		for(Media m : store.getItemInStore())
			System.out.println("Hello"+m.getDetail());
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public StoreScreen(Store st,boolean b) {
		this.store = st;
		ArrayList<Media> mediaInStore = store.getItemInStore();
		for(Media m : store.getItemInStore())
			System.out.println("Hello"+m.getDetail());
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(false);
		setTitle("Store");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//main
	public static void main(String[] args) {
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
		try {
			aCart.addMedia(cd1);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new CartScreenFx(aCart,false);
		
		ArrayList<Media> st = aStore.getItemInStore();
		for(Media m : st)
			System.out.println("Hello"+m.getDetail());
		new StoreScreen(aStore);
	}
	
	private class ButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("Add Book")  ) {
				setVisible(false);
				new AddBookToStoreScreen();
			}	
			else if( button.equals("Add DVD")) {
				setVisible(false);
				new AddDVDToStoreScreen();
			}	
			else if(button.equals("Add CD") ) {
				setVisible(false);
				new AddCDToStoreScreen();
			}
			
		}
	}
}
