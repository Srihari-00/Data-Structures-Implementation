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

public class CircularQueue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sizebox;
	private JTextField elementbox;
	private JTextField displaybox;

	private int cq[];
	private int size;
	private int rear = -1;
	private int front = 0;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cqueue = new JLabel("CIRCULAR QUEUE DATA STRUCTURE");
		cqueue.setFont(new Font("Algerian", Font.BOLD, 14));
		cqueue.setBounds(108, 10, 350, 19);
		contentPane.add(cqueue);

		JLabel size = new JLabel("ENTER THE SIZE OF THE  QUEUE :");
		size.setForeground(new Color(128, 0, 64));
		size.setFont(new Font("Constantia", Font.BOLD, 13));
		size.setBounds(21, 58, 237, 30);
		contentPane.add(size);

		sizebox = new JTextField();
		sizebox.setBounds(289, 62, 96, 19);
		contentPane.add(sizebox);
		sizebox.setColumns(10);

		JButton create = new JButton("CREATE QUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//creating code here
				int size = Integer.valueOf(sizebox.getText());
				cq = new int[size];
				JOptionPane.showMessageDialog(contentPane, "Queue of size "+size+" Created");
			}
		});
		create.setFont(new Font("Constantia", Font.BOLD, 12));
		create.setBounds(185, 98, 167, 21);
		contentPane.add(create);

		JLabel elements = new JLabel("ENTER THE ELEMENT :");
		elements.setForeground(new Color(0, 0, 160));
		elements.setFont(new Font("Constantia", Font.BOLD, 13));
		elements.setBounds(22, 127, 200, 30);
		contentPane.add(elements);

		elementbox = new JTextField();
		elementbox.setBounds(204, 129, 133, 26);
		contentPane.add(elementbox);
		elementbox.setColumns(10);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int size = Integer.valueOf(sizebox.getText());
				int elem;

				if (count == size) {
					JOptionPane.showMessageDialog(contentPane, "Queue is full, Insertion is not possible");
				} else {
					elem = Integer.valueOf(elementbox.getText());
					rear = (rear + 1) % size;
					cq[rear] = elem;
					count++;
					JOptionPane.showMessageDialog(contentPane, "Element got inserted");
					elementbox.setText("");
				}

			}


		});
		insert.setFont(new Font("Constantia", Font.BOLD, 12));
		insert.setBounds(374, 130, 96, 27);
		contentPane.add(insert);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deleting code here
				int size = Integer.valueOf(sizebox.getText());
				if(count==0)
				{
					JOptionPane.showMessageDialog(contentPane, "Queue is empty, Deletion is not possible");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Deleted element : "+cq[front]);
					front = (front+1)%size;
					count--;
				}
			}
		});
		delete.setFont(new Font("Constantia", Font.BOLD, 12));
		delete.setBounds(205, 167, 85, 30);
		contentPane.add(delete);

		JButton display_1 = new JButton("DISPLAY");
		display_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display code here
				int size = Integer.valueOf(sizebox.getText());
				int f1 = front;
				if(count == 0)
				{
					JOptionPane.showMessageDialog(contentPane, "Queue is empty, Display not possible");
				}
				else 
				{
					String msg ="";
					for(int i=1;i<=count;i++)
					{
						msg = msg+" "+cq[f1];
						f1 = (f1+1)%size;				
					}
					displaybox.setText(msg);
				}
			}
		});
		display_1.setFont(new Font("Constantia", Font.BOLD, 12));
		display_1.setBounds(215, 213, 85, 30);
		contentPane.add(display_1);

		displaybox = new JTextField();
		displaybox.setBounds(66, 253, 444, 43);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}
	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
