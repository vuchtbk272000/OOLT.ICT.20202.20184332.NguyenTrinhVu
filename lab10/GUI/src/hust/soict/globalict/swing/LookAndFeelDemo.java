package hust.soict.globalict.swing;
import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
public class LookAndFeelDemo extends JFrame{
	public LookAndFeelDemo() {
		
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
	private void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label:"));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button:"));
	}
	private void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
		int i;
		String[] lafNames = new String[lafInfo.length+2];
		for(i=0; i<lafInfo.length; i++) {
			lafNames[i]=lafInfo[i].getName();
		}
		lafNames[i+1]= UIManager.getCrossPlatformLookAndFeelClassName();
		lafNames[i+1]= UIManager.getSystemLookAndFeelClassName();
		for (i=0;i<7;i++)
			System.out.println(lafNames[i]);
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(lafInfo[index].getClassName());			
				}	catch(Exception e) {
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafInfo[index].getName() + " Look And Feel");				
			}
		});
		
		
	}
	
	
}
