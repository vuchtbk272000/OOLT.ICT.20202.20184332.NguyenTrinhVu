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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		menu.add(new JMenuItem("View Cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
		
	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
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
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemInStore();
		for (int i =0; i<store.getQty(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel {
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
			
			container.add(new JButton("Add to cart"));
			if(media instanceof Playable) {
				container.add(new JButton("play"));
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
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
	
	public static void main(String[] args) {
		Store aStore = new Store();
		
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
		ArrayList<Media> st = aStore.getItemInStore();
		for(Media m : st)
			System.out.println("Hello"+m.getDetail());
		new StoreScreen(aStore);
	}
	
	private class ButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("Add Book") || button.equals("Add DVD") || button.equals("Add CD") )
				new AddMediaToStoreScreen();
		}
	}
}
