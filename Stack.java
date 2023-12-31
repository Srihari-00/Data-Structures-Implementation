import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField stacksize;
	private JTextField inputbox;
	private JTextField displaybox;
	
	private int  s[];
	public int size;
	private int top=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel stack = new JLabel("STACK DATA STRUCTURE");
		stack.setFont(new Font("Algerian", Font.BOLD, 16));
		stack.setForeground(new Color(128, 0, 0));
		stack.setBounds(194, 10, 294, 26);
		contentPane.add(stack);
		
		JLabel size = new JLabel("ENTER THE STACK SIZE :");
		size.setFont(new Font("Constantia", Font.BOLD, 12));
		size.setForeground(new Color(0, 0, 160));
		size.setBounds(77, 59, 207, 34);
		contentPane.add(size);
		
		stacksize = new JTextField();
		stacksize.setBounds(294, 65, 145, 19);
		contentPane.add(stacksize);
		stacksize.setColumns(10);
		
		JButton create = new JButton("CREATE STACK");
		create.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Stack creation code
		        int size = Integer.valueOf(stacksize.getText());
		        s = new int[size];
		        String message = "Stack of size " + size + " Created";
		        JOptionPane.showMessageDialog(contentPane, message);
		    }
		});
		create.setFont(new Font("Constantia", Font.BOLD, 12));
		create.setForeground(new Color(0, 0, 255));
		create.setBounds(161, 105, 171, 21);
		contentPane.add(create);
		
		JLabel elementinput = new JLabel("ENTER AN ELEMENT : ");
		elementinput.setFont(new Font("Constantia", Font.BOLD, 12));
		elementinput.setBounds(77, 153, 207, 26);
		contentPane.add(elementinput);
		
		inputbox = new JTextField();
		inputbox.setBounds(259, 155, 123, 19);
		contentPane.add(inputbox);
		inputbox.setColumns(10);
		
		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//push code here
				int elem;
				int size = Integer.valueOf(stacksize.getText());
				if(top == size-1)
				{
					JOptionPane.showMessageDialog(contentPane,"Push not Possible");
					inputbox.setText("");
				}
				else
				{
					elem = Integer.valueOf(inputbox.getText());
					++top;
					s[top] = elem;
					JOptionPane.showMessageDialog(contentPane, "Push successfull");
					inputbox.setText("");
				}
			}
		});
		push.setFont(new Font("Constantia", Font.BOLD, 12));
		push.setBounds(403, 154, 85, 21);
		contentPane.add(push);
		
		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pop code
				if(top==-1)
				{
					JOptionPane.showMessageDialog(contentPane, "Pop not Possible");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Element popped "+s[top]);
					--top;
				}
			}
		});
		pop.setFont(new Font("Constantia", Font.BOLD, 12));
		pop.setBounds(199, 201, 85, 21);
		contentPane.add(pop);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display code here
				String msg = "";
				if(top==-1)
				{
					JOptionPane.showMessageDialog(contentPane, "Stack is empty");
				}
				else
				{
					for(int i=top;i>=0;i--)
					{
						msg = msg+" "+s[i];
					}
					displaybox.setText(msg);
				}
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 12));
		display.setBounds(199, 232, 85, 21);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(0, 255, 128));
		displaybox.setBounds(77, 278, 397, 50);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}
}
