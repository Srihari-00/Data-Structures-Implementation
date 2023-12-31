import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE A DATA STRUCTURE");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setBounds(140, 10, 212, 21);
		contentPane.add(lblNewLabel);
		
		JButton array = new JButton("ARRAY");
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Place array window opening code here
//				Array a = new Array();
	//			a.setVisible(true);
				new Array().setVisible(true);
			}
		});
		array.setForeground(new Color(255, 0, 0));
		array.setFont(new Font("Constantia", Font.BOLD, 12));
		array.setBounds(173, 50, 115, 23);
		contentPane.add(array);
		
		JButton stack = new JButton("STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Place Stack window opening code here
				new Stack().setVisible(true);
			}
		});
		stack.setForeground(new Color(0, 0, 255));
		stack.setFont(new Font("Constantia", Font.BOLD, 12));
		stack.setBounds(38, 99, 85, 21);
		contentPane.add(stack);
		
		JButton queue = new JButton("QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////Place Queue window opening code here
				new Queue().setVisible(true);
			}
		});
		queue.setForeground(new Color(128, 64, 0));
		queue.setFont(new Font("Constantia", Font.BOLD, 12));
		queue.setBounds(327, 99, 85, 21);
		contentPane.add(queue);
		
		JButton circularqueue = new JButton("CIRCULAR QUEUE");
		circularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Place circular queue window opening code here
				new CircularQueue().setVisible(true);
			}
		});
		circularqueue.setForeground(new Color(0, 128, 192));
		circularqueue.setFont(new Font("Constantia", Font.BOLD, 12));
		circularqueue.setBounds(38, 157, 143, 23);
		contentPane.add(circularqueue);
		
		JButton sll = new JButton("SINGLE LINKED LIST");
		sll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Place single linked list window opening code here
				new SinglyLList().setVisible(true);
			}
		});
		sll.setForeground(new Color(64, 128, 128));
		sll.setFont(new Font("Constantia", Font.BOLD, 12));
		sll.setBounds(260, 156, 155, 23);
		contentPane.add(sll);
		
		JButton dll = new JButton("DOUBLY LINKED LIST");
		dll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Place doubly linked list window opening code here
				new DoublyLList().setVisible(true);
			}
		});
		dll.setForeground(new Color(128, 128, 0));
		dll.setFont(new Font("Constantia", Font.BOLD, 12));
		dll.setBounds(140, 210, 163, 23);
		contentPane.add(dll);
	}
}
