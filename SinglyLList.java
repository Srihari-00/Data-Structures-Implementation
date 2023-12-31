import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;








public class SinglyLList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField boxfront;
	private JTextField rearboxin;
	private JTextField elebox;
	private JTextField displaybox;
	private JTextField posbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLList frame = new SinglyLList();
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
	static class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node first;
    private JTextField posdel;

	public SinglyLList() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sll = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
		sll.setFont(new Font("Algerian", Font.BOLD, 14));
		sll.setForeground(new Color(128, 0, 0));
		sll.setBounds(105, 0, 319, 43);
		contentPane.add(sll);
		
		JLabel frontboxin = new JLabel("ENTER AN ELEMENT : ");
		frontboxin.setForeground(new Color(128, 64, 0));
		frontboxin.setFont(new Font("Constantia", Font.BOLD, 13));
		frontboxin.setBounds(10, 36, 190, 33);
		contentPane.add(frontboxin);
		
		boxfront = new JTextField();
		boxfront.setBounds(237, 41, 96, 28);
		contentPane.add(boxfront);
		boxfront.setColumns(10);
		
		JButton insertfront = new JButton("INSERT FRONT");
		insertfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for inserting at front
				
		        int elem = Integer.valueOf(boxfront.getText()) ;
		        Node newnode = new Node(elem);

		        if (first == null) {
		            first = newnode;
		        } else {
		            newnode.link = first;
		            first = newnode;
		        }
		        JOptionPane.showMessageDialog(contentPane, "Element inserterd at front successfully");
		        boxfront.setText("");
			}
		});
		insertfront.setFont(new Font("Constantia", Font.BOLD, 12));
		insertfront.setBounds(353, 41, 149, 23);
		contentPane.add(insertfront);
		
		JButton insertrear = new JButton("INSERT REAR");
		insertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for inserting at rear
				int elem = Integer.valueOf(rearboxin.getText());
		        Node newnode = new Node(elem);

		        if (first == null)
		        {
		            first = newnode;
		        } 
		        else
		        {
		            Node temp = first;
		            while (temp.link != null)
		            {
		                temp = temp.link;
		            }
		            temp.link = newnode;
		        }
		        JOptionPane.showMessageDialog(contentPane, "Element inserted at rear successfully");
		        rearboxin.setText("");
			}
		});
		insertrear.setFont(new Font("Constantia", Font.BOLD, 12));
		insertrear.setBounds(353, 73, 149, 23);
		contentPane.add(insertrear);
		
		rearboxin = new JTextField();
		rearboxin.setColumns(10);
		rearboxin.setBounds(237, 70, 96, 26);
		contentPane.add(rearboxin);
		
		elebox = new JTextField();
		elebox.setColumns(10);
		elebox.setBounds(237, 106, 54, 26);
		contentPane.add(elebox);
		
		JButton insertpos = new JButton("INSERT POSITION");
		insertpos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for inserting at position
		        int data = Integer.valueOf(elebox.getText());
		        int position = Integer.valueOf(posbox.getText());
		        Node newnode = new Node(data);
		        if (position <= 0)
		        {
		            JOptionPane.showMessageDialog(contentPane, "Invalid position");
		        }
		        if (position == 1)
		        {
		            newnode.link = first;
		            first = newnode;
		            JOptionPane.showMessageDialog(contentPane, "Element inserted at "+position+" Successfully");
		            elebox.setText("");
		            posbox.setText("");
		        } 
		        else
		        {
		            Node temp = first;
		            for (int i = 1; i < position - 1 && temp != null; i++)
		            {
		                temp = temp.link;
		            }
		            if (temp == null) {
		                JOptionPane.showMessageDialog(contentPane, "Invalid position");	
		                elebox.setText("");
		                posbox.setText("");
		            }
		            newnode.link = temp.link;
		            temp.link = newnode;
		            JOptionPane.showMessageDialog(contentPane, "Element inserted at "+position+" Successully");
		            posbox.setText("");
		            elebox.setText("");
		        }
			}
		});
		insertpos.setFont(new Font("Constantia", Font.BOLD, 12));
		insertpos.setBounds(353, 106, 149, 33);
		contentPane.add(insertpos);
		
		JLabel frontboxin_1 = new JLabel("ENTER AN ELEMENT : ");
		frontboxin_1.setForeground(new Color(128, 0, 64));
		frontboxin_1.setFont(new Font("Constantia", Font.BOLD, 13));
		frontboxin_1.setBounds(10, 73, 190, 33);
		contentPane.add(frontboxin_1);
		
		JLabel frontboxin_2 = new JLabel("ENTER AN ELEMENT & POSITION  : ");
		frontboxin_2.setForeground(new Color(128, 0, 0));
		frontboxin_2.setFont(new Font("Constantia", Font.BOLD, 13));
		frontboxin_2.setBounds(10, 107, 241, 33);
		contentPane.add(frontboxin_2);
		
		JButton deletefront = new JButton("DELETE FRONT");
		deletefront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deleting at front
				if (first == null) 
				{
		            JOptionPane.showMessageDialog(contentPane, "Deletion is not possible");
		        }
				else
				{
		            JOptionPane.showMessageDialog(contentPane, "Element deleted is " + first.data);
		            first = first.link;
		        }
			}
		});
		deletefront.setFont(new Font("Constantia", Font.BOLD, 12));
		deletefront.setBounds(10, 214, 142, 33);
		contentPane.add(deletefront);
		
		JButton deleterear = new JButton("DELETE REAR");
		deleterear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deleting at rear
				if (first == null) 
				{
		            JOptionPane.showMessageDialog(contentPane, "Deletion not possible");
		        }
				else if (first.link == null) 
				{
		            JOptionPane.showMessageDialog(contentPane, "Deleted element is " + first.data);
		            first = null;
		        } 
				else
				{
		            Node temp = first;
		            while (temp.link.link != null) 
		            {
		                temp = temp.link;
		            }
		           JOptionPane.showMessageDialog(contentPane, "Element deleted is " + temp.link.data);
		            temp.link = null;
		        }
			}
		});
		deleterear.setFont(new Font("Constantia", Font.BOLD, 12));
		deleterear.setBounds(360, 215, 142, 31);
		contentPane.add(deleterear);
		
		JButton deletepos = new JButton("DELETE POSITION");
		deletepos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deleting at position
		        int position = Integer.valueOf(posdel.getText());

		        if (position <= 0 || first == null) {
		            JOptionPane.showMessageDialog(contentPane, "Invalid position");
		            posdel.setText("");
		        }

		        if (position == 1) {
		            first = first.link;
		            JOptionPane.showMessageDialog(contentPane, "Element deleted is "+first.data);
		            posdel.setText("");
		        }
		        else
		        {
		            Node temp = first;
		            for (int i = 1; i < position - 1 && temp != null; i++) {
		                temp = temp.link;
		            }

		            if (temp == null || temp.link == null) {
		                JOptionPane.showMessageDialog(contentPane, "Invalid position");
		                posdel.setText("");
		            }

		            temp.link = temp.link.link;
		            JOptionPane.showMessageDialog(contentPane, "Element deleted is "+temp.link.data);
		            posdel.setText("");
		        }
			}
		});
		deletepos.setFont(new Font("Constantia", Font.BOLD, 12));
		deletepos.setBounds(360, 172, 142, 33);
		contentPane.add(deletepos);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for displaying the singly linked list
				String msg = "";
				if (first == null) 
				{
		            JOptionPane.showMessageDialog(contentPane, "Display not possible");
		        } 
				else
				{
		            Node temp = first;
		            while (temp != null) {
		                msg = msg + temp.data+" ";
		                temp = temp.link;
		            }
		            displaybox.setText(msg);
		        }
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 12));
		display.setBounds(202, 234, 112, 28);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(128, 128, 255));
		displaybox.setBounds(20, 272, 470, 53);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		posbox = new JTextField();
		posbox.setColumns(10);
		posbox.setBounds(301, 106, 35, 26);
		contentPane.add(posbox);
		
		JLabel posdelete = new JLabel("ENTER AN POSITION: ");
		posdelete.setForeground(new Color(128, 0, 64));
		posdelete.setFont(new Font("Constantia", Font.BOLD, 13));
		posdelete.setBounds(10, 170, 190, 33);
		contentPane.add(posdelete);
		
		posdel = new JTextField();
		posdel.setColumns(10);
		posdel.setBounds(210, 172, 59, 26);
		contentPane.add(posdel);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
