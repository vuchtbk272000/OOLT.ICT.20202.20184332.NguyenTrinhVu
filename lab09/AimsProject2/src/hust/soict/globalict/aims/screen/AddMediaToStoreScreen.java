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

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
public class AddMediaToStoreScreen extends JFrame {
	protected TextField titleField;
	protected TextField categoryField;
	protected TextField costField;
	protected TextField lengthField;
	public AddMediaToStoreScreen() {
		
		ButtonListener btnListener =new ButtonListener();
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(6,2));
		cp.add(new Label("Title: "));
		titleField =new TextField(50);
		cp.add(titleField);
		
		cp.add(new Label("Category: "));
		categoryField =new TextField(50);
		cp.add(categoryField);
		
		cp.add(new Label("Length: "));
		lengthField =new TextField(50);
		cp.add(lengthField);
		
		cp.add(new Label("Cost: "));
		costField =new TextField(50);
		cp.add(costField);
		
		JPanel container=new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton createItem=new JButton("ADD");
		createItem.addActionListener(btnListener);
		createItem.setAlignmentY(CENTER_ALIGNMENT);
		container.add(createItem);
		cp.add(container);
		setTitle("ADD Digital Video Disc");
		setSize(1000,600);
		setVisible(true);
		}
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button=e.getActionCommand();
			if (button.equals("ADD")) {
				int lengthIn=Integer.parseInt(lengthField.getText());
				String titleIn=titleField.getText();
				String categoryIn=categoryField.getText();
				float costIn=Float.parseFloat(costField.getText());
				
				Media media=new Media(titleIn, categoryIn, costIn, lengthIn);
				
				Store st = new Store();
				for(Media m : StoreScreen.store.getItemInStore()) {
					st.addMedia(m);
				}				
				st.addMedia(media);
				String message;
				message="Add Media: '"+media.getTitle()+"' successfuly ";
				JOptionPane.showMessageDialog(null,
				message,"Add DVD completed",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new StoreScreen(st);
			}
		}
	}
	
}
