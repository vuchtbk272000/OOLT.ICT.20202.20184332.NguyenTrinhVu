package hust.soict.globalict.aims.screen;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
	private TextField contentField;
//	private ArrayList<Track> tracks = new ArrayList<Track>();
	private TextField titleField;
	private TextField categoryField;
	private TextField costField;
	private TextField authorField;
	private TextField lengthField;

	public AddBookToStoreScreen() {
		ButtonListener btnListener =new ButtonListener();
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(6,2));
		
		cp.add(new Label("Title: "));
		titleField =new TextField(50);
		cp.add(titleField);
		
		cp.add(new Label("Category: "));
		categoryField =new TextField(50);
		cp.add(categoryField);
		
//		cp.add(new Label("Length: "));
//		lengthField =new TextField(50);
//		cp.add(lengthField);
		
		cp.add(new Label("Cost: "));
		costField =new TextField(50);
		cp.add(costField);
		
		cp.add(new Label("Author: "));
		authorField =new TextField(50);
		cp.add(authorField);
		
		cp.add(new Label("Content: "));
		contentField =new TextField(50);
		cp.add(contentField);
		
		JPanel container=new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton createItem=new JButton("ADD");
		createItem.addActionListener(btnListener);
		createItem.setAlignmentY(CENTER_ALIGNMENT);
		container.add(createItem);
	
		
		JButton back=new JButton("Back");
		back.addActionListener(btnListener);
		back.setAlignmentY(CENTER_ALIGNMENT);
		container.add(back);
		cp.add(container);
		
		setTitle("ADD Digital Video Disc");
		setSize(1000,600);
		setVisible(true);
		}
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button=e.getActionCommand();
			Store st = new Store();
			for(Media m : StoreScreen.store.getItemInStore()) {
				st.addMedia(m);
			}
			if (button.equals("ADD")) {
//				int lengthIn=Integer.parseInt(lengthField.getText());
				String titleIn=titleField.getText();
				String categoryIn=categoryField.getText();
				String authorIn = authorField.getText();
				String contentIn = contentField.getText();
				float costIn=Float.parseFloat(costField.getText());
				
				Book book = new Book(titleIn, categoryIn, costIn);
				
								
				st.addMedia(book);
				String message;
				message="Add Media: '"+book.getTitle()+"' successfuly ";
				JOptionPane.showMessageDialog(null,
				message,"Add DVD completed",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new StoreScreen(st);
			}
			else {
				setVisible(false);
				new StoreScreen(st);
			}
		}
	}
	

}
