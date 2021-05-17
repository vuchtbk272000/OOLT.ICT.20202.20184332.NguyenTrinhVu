package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
public class SwingAccumulator extends JFrame{
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum=0;
	
	public SwingAccumulator() {
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(2,2));
		cp.add(new Label("Enter an interger: "));
		tfInput =new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		cp.add(new Label("The Accumlated Sum is:"));
		tfOutput=new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		setTitle("Swing Accumulator");
		setSize(700,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingAccumulator();
	}
	
	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn=Integer.parseInt(tfInput.getText());
			sum+=numberIn;
			tfInput.setText("");
			tfOutput.setText(sum+"");
		}
	}
	
}
