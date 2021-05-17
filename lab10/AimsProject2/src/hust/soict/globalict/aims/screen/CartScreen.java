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
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.collections.ObservableList;
public class CartScreen extends JFrame {
	public static Cart cart;
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
//		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	//create menu bar
//	JMenuBar createMenuBar() {
//	
//	}
	//create header
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View Store");
		cart.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Store tmp = StoreScreen.store;
						setVisible(false);
	                   new StoreScreen(tmp);
	                }
				}
				);
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
		
		ObservableList<Media> itemsInCart = cart.getItemsInCart();
		for (int i =0; i<cart.getQty(); i++) {
			MediaCart cell = new MediaCart(itemsInCart.get(i));
			center.add(cell);
		}
		
		return center;
	}
	//items
	public class MediaCart extends JPanel {
		ButtonListener btnListener = new ButtonListener();
		private Media media;
		public MediaCart(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel(""+media.getCost()+" $");
			cost.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
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
	public CartScreen(Cart c) {
		this.cart = c;
		ObservableList<Media> mediaInCart = cart.getItemsInCart();
	
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public CartScreen(Cart c,boolean b) {
		this.cart = c;
		ObservableList<Media> mediaInCart = cart.getItemsInCart();
	
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(false);
		setTitle("Store");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public CartScreen() {
		this.cart = new Cart();
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(false);
		setTitle("Store");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public CartScreen(Media media) {
		Cart tmp = cart;
		try {
			tmp.addMedia(media);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart = tmp;
		ObservableList<Media> mediaInCart = cart.getItemsInCart();
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);	
		setTitle("Store");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
