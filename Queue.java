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

public class Queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizebox;
	private JTextField elementbox;
	private JTextField displaybox;
	
	private int[] q;
	public int size;
	private int rear = -1;
	private int front = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel queue = new JLabel("QUEUE DATA STRUCTURE");
		queue.setFont(new Font("Algerian", Font.BOLD, 14));
		queue.setBounds(144, 10, 302, 25);
		contentPane.add(queue);
		
		JLabel size = new JLabel("ENTER THE QUEUE SIZE :");
		size.setForeground(new Color(64, 0, 64));
		size.setFont(new Font("Constantia", Font.BOLD, 14));
		size.setBounds(48, 59, 196, 25);
		contentPane.add(size);
		
		sizebox = new JTextField();
		sizebox.setBounds(280, 60, 96, 19);
		contentPane.add(sizebox);
		sizebox.setColumns(10);
		
		JButton create = new JButton("CREATE QUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create code here
				int size = Integer.valueOf(sizebox.getText());
				q = new int[size];
				JOptionPane.showMessageDialog(contentPane, "Queue of size "+size+" Created");
			}
		});
		create.setFont(new Font("Constantia", Font.BOLD, 12));
		create.setBounds(144, 94, 179, 21);
		contentPane.add(create);
		
		JLabel element = new JLabel("ENTER AN ELEMENT : ");
		element.setForeground(new Color(255, 128, 64));
		element.setFont(new Font("Constantia", Font.BOLD, 14));
		element.setBounds(48, 127, 196, 25);
		contentPane.add(element);
		
		elementbox = new JTextField();
		elementbox.setBounds(280, 128, 96, 19);
		contentPane.add(elementbox);
		elementbox.setColumns(10);
		
		JButton push = new JButton("INSERT");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert code here
				int elem ;
				int size = Integer.valueOf(sizebox.getText());
				if(rear == size-1)
				{
					JOptionPane.showMessageDialog(contentPane, "Queue is full, insertion not possible");
					sizebox.setText("");
				}
				else
				{
					elem = Integer.valueOf(elementbox.getText());
					++rear;//incrementing the rear
					q[rear] = elem;//inserting the element at the rear position of the queue
					JOptionPane.showMessageDialog(contentPane, "Element is inserted Successfully");
					elementbox.setText("");
				}
			}
		});
		push.setFont(new Font("Constantia", Font.BOLD, 12));
		push.setBounds(399, 127, 96, 25);
		contentPane.add(push);
		
		JButton pop = new JButton("DELETE");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pop code here
				if(rear == -1 || front > rear)
				{
					JOptionPane.showMessageDialog(contentPane, "Queue is empty, Deletion is not possible");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane,"Element deleted : "+q[front]);
					++front;//incrementing the front
				}
			}
		});
		pop.setFont(new Font("Constantia", Font.BOLD, 12));
		pop.setBounds(198, 162, 85, 21);
		contentPane.add(pop);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display code here
				if(rear == -1 || front > rear)
				{
					JOptionPane.showMessageDialog(contentPane, "Queue is empty, Display is not possible");
				}
				else
				{
					String msg = "";
					//Traversing through the Queue
					for(int i=front;i<=rear;i++)
					{
						msg = msg +" "+q[i];
						
					}
					displaybox.setText(msg);
				}
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 12));
		display.setBounds(198, 193, 85, 21);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setForeground(new Color(0, 0, 255));
		displaybox.setFont(new Font("Constantia", Font.BOLD, 12));
		displaybox.setBackground(new Color(128, 128, 128));
		displaybox.setBounds(48, 245, 440, 49);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}
}
