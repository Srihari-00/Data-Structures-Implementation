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

public class DoublyLList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField infront;
	private JTextField inrear;
	private JTextField inpos;
	private JTextField pos;
	private JTextField delpos;
	private JTextField displaybox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLList frame = new DoublyLList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private int elem ;
	private int position;
	class Node
	{
		Node prevLink;
		int data;
		Node nextLink;
	}
	private Node first;
	private Node temp;

	/**
	 * Create the frame.
	 */
	public DoublyLList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 377);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dll = new JLabel("DOUBLY LINKEDLIST DATA STRUCTURE");
		dll.setFont(new Font("Algerian", Font.BOLD, 14));
		dll.setBounds(96, 5, 366, 25);
		contentPane.add(dll);
		
		JLabel inputfront = new JLabel("ENTER AN ELEMENT : ");
		inputfront.setFont(new Font("Constantia", Font.BOLD, 13));
		inputfront.setBounds(10, 40, 144, 17);
		contentPane.add(inputfront);
		
		infront = new JTextField();
		infront.setBounds(164, 40, 55, 19);
		contentPane.add(infront);
		infront.setColumns(10);
		
		JButton frntbtn = new JButton("INSERT FRONT");
		frntbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert front code here
				elem = Integer.valueOf(infront.getText());
				Node newNode = new Node();
				newNode.data = elem;
				newNode.prevLink = null;
				newNode.nextLink = null;
				if(first == null)
				{
					first = newNode;
					JOptionPane.showMessageDialog(contentPane, "NewNode is created");
					infront.setText("");
				}
				else {
					newNode.nextLink = first;
					first.prevLink = newNode;
					first = newNode;
					JOptionPane.showMessageDialog(contentPane, "Element is inserted");
					infront.setText("");
				}
			}
		});
		frntbtn.setFont(new Font("Constantia", Font.BOLD, 13));
		frntbtn.setBounds(343, 36, 158, 25);
		contentPane.add(frntbtn);
		
		JButton insertend = new JButton("INSERT REAR");
		insertend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert rear code here
				elem = Integer.valueOf(inrear.getText());
				Node newNode = new Node();
				newNode.data = elem;
				newNode.prevLink = null;
				newNode.nextLink = null;
				if(first == null)
				{
					first = newNode;
					JOptionPane.showMessageDialog(contentPane, "Element is inserted at end");
					inrear.setText("");
				}
				else {
					temp = first;
					while(temp.nextLink != null)
					{
						temp = temp.nextLink;
					}
					temp.nextLink = newNode;
					newNode.prevLink = temp;
					JOptionPane.showMessageDialog(contentPane, "Element is inserted at end");
					inrear.setText("");
				}
			}
		});
		insertend.setFont(new Font("Constantia", Font.BOLD, 13));
		insertend.setBounds(341, 63, 158, 25);
		contentPane.add(insertend);
		
		JButton insertpost = new JButton(" INSERT");
		insertpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert at position code here
				elem = Integer.valueOf(inpos.getText());
			    position = Integer.valueOf(pos.getText());
			    Node newNode = new Node();
			    newNode.data = elem;
			    newNode.prevLink = null;
			    newNode.nextLink = null;

			    if (first == null)
			    {
			        // List is empty, insert at front
			        first = newNode;
			        JOptionPane.showMessageDialog(contentPane, "Element is inserted");
			        inpos.setText("");
			        pos.setText("");
			        
			    }
			    else
			    {
			        temp = first;
			        int currentPosition = 1;

			        // Traverse to the specified position
			        while (currentPosition < position - 1 && temp.nextLink != null)
			        {
			            temp = temp.nextLink;
			            currentPosition++;
			        }

			        // Insert at the specified position
			        newNode.nextLink = temp.nextLink;
			        newNode.prevLink = temp;
			        if (temp.nextLink != null)
			        {
			            temp.nextLink.prevLink = newNode;
			        }
			        temp.nextLink = newNode;
			        JOptionPane.showMessageDialog(contentPane, "Element is inserted");
			        inpos.setText("");
			        pos.setText("");
			    }
			}
		});
		insertpost.setFont(new Font("Constantia", Font.BOLD, 13));
		insertpost.setBounds(388, 98, 113, 25);
		contentPane.add(insertpost);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete at position code here
				System.out.println("Enter the position : ");
			    position = Integer.valueOf(delpos.getText());
			    if (first == null)
			    {
			        JOptionPane.showMessageDialog(contentPane, "Deletion not possible");
			        delpos.setText("");
			    }
			    else
			    {
			        temp = first;
			        int currentPosition = 1;

			        // Traverse to the specified position
			        while (currentPosition < position && temp.nextLink != null)
			        {
			            temp = temp.nextLink;
			            currentPosition++;
			        }

			        // Delete at the specified position
			        if (temp.nextLink != null)
			        {
			            temp.prevLink.nextLink = temp.nextLink;
			            temp.nextLink.prevLink = temp.prevLink;
			        }
			        else
			        {
			            // Deleting at the end of the list
			            temp.prevLink.nextLink = null;
			        }
			        JOptionPane.showMessageDialog(contentPane, "Element deleted is "+temp.data);
			        delpos.setText("");
			    }

			}
		});
		delete.setFont(new Font("Constantia", Font.BOLD, 13));
		delete.setBounds(264, 139, 158, 25);
		contentPane.add(delete);
		
		JLabel inputfront_1 = new JLabel("ENTER AN ELEMENT : ");
		inputfront_1.setFont(new Font("Constantia", Font.BOLD, 13));
		inputfront_1.setBounds(10, 67, 144, 17);
		contentPane.add(inputfront_1);
		
		JLabel inputfront_2 = new JLabel("ENTER AN ELEMENT : ");
		inputfront_2.setFont(new Font("Constantia", Font.BOLD, 13));
		inputfront_2.setBounds(10, 102, 144, 17);
		contentPane.add(inputfront_2);
		
		JLabel inputfront_3 = new JLabel("POSITION");
		inputfront_3.setFont(new Font("Constantia", Font.BOLD, 13));
		inputfront_3.setBounds(223, 98, 77, 25);
		contentPane.add(inputfront_3);
		
		JLabel inputfront_4 = new JLabel("ENTER AN POSITION: ");
		inputfront_4.setFont(new Font("Constantia", Font.BOLD, 13));
		inputfront_4.setBounds(10, 143, 144, 17);
		contentPane.add(inputfront_4);
		
		inrear = new JTextField();
		inrear.setColumns(10);
		inrear.setBounds(164, 64, 55, 19);
		contentPane.add(inrear);
		
		inpos = new JTextField();
		inpos.setColumns(10);
		inpos.setBounds(164, 99, 55, 19);
		contentPane.add(inpos);
		
		pos = new JTextField();
		pos.setColumns(10);
		pos.setBounds(323, 99, 55, 19);
		contentPane.add(pos);
		
		delpos = new JTextField();
		delpos.setColumns(10);
		delpos.setBounds(164, 140, 55, 19);
		contentPane.add(delpos);
		
		JButton deletefrnt = new JButton("DELETE FRONT");
		deletefrnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete front code here
				if(first == null)
				{
					JOptionPane.showMessageDialog(contentPane, "Deletion not possible ");
				}
				if(first.nextLink == null)
				{
					JOptionPane.showMessageDialog(contentPane, "Deleted Element is : "+first.data);
					first = null;
					
				}
				else {
					first = first.nextLink;
					JOptionPane.showMessageDialog(contentPane, "Deleted Element is : "+first.data);
					first.prevLink = null;
				}
			}
		});
		deletefrnt.setFont(new Font("Constantia", Font.BOLD, 13));
		deletefrnt.setBounds(10, 184, 158, 25);
		contentPane.add(deletefrnt);
		
		JButton deleteend = new JButton("DELETE REAR");
		deleteend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete rear code here
				if(first == null)
				{
					JOptionPane.showMessageDialog(contentPane, "Deletion not possible");
				}
				else if(first.nextLink == null)
				{
					JOptionPane.showMessageDialog(contentPane, "Element deleted is : "+first.data);
					first = null;
				}
				else {
					temp = first;
					while(temp.nextLink.nextLink != null)
					{
						temp = temp.nextLink;
					}
					JOptionPane.showMessageDialog(contentPane, "Element deleted is "+temp.nextLink.data);
					temp.nextLink = null;
				}
			}
		});
		deleteend.setFont(new Font("Constantia", Font.BOLD, 13));
		deleteend.setBounds(264, 184, 158, 25);
		contentPane.add(deleteend);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display code here
				String msg = "";
				if (first == null)
			    {
			        JOptionPane.showMessageDialog(contentPane, "Displaying not possible");
			    }
			    else if(first.nextLink == null)
			    {
			    	msg = msg+first.data+" ";
			    	displaybox.setText(msg);
			    	
			    }
			    else
			    {
			        temp = first;
			        while (temp.nextLink != null)
			        {
			            msg = msg + temp.data + " ";
			            temp = temp.nextLink;
			        }
			    }
				displaybox.setText(msg);
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 13));
		display.setBounds(45, 231, 158, 25);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(128, 128, 128));
		displaybox.setBounds(10, 274, 489, 44);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton displayrev = new JButton(" DISPLAY REVERSE");
		displayrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display reverse code here
				String msg = "";
				if(first == null)
				{
					JOptionPane.showMessageDialog(contentPane, "Display not possible");
				}
				else if(first.nextLink == null)
				{
					msg = msg + first.data;
					displaybox.setText(msg);
				}
				else {
					temp = first;
					while(temp.nextLink != null)
					{
						temp = temp.nextLink;
					}
					while(temp != null)
					{
						msg = msg + temp.data+" ";
						temp = temp.prevLink;
					}
					displaybox.setText(msg);
				}
			}
		});
		displayrev.setFont(new Font("Constantia", Font.BOLD, 13));
		displayrev.setBounds(246, 231, 158, 25);
		contentPane.add(displayrev);
	}
}
