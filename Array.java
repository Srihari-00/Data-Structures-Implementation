import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Array extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField element;
    private JTextField deleteposition;
    private JTextField position;
    private JTextField displaybox;
    private int arr[];

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Array frame = new Array();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Array() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 510, 407);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setForeground(new Color(128, 128, 0));
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel array = new JLabel("ARRAY DATA STRUCTURE");
        array.setBounds(116, 10, 181, 19);
        array.setForeground(new Color(0, 0, 128));
        array.setFont(new Font("Algerian", Font.BOLD, 14));
        contentPane.add(array);

        JLabel length = new JLabel("ENTER ARRAY LENGTH :");
        length.setBounds(27, 53, 170, 18);
        length.setFont(new Font("Constantia", Font.BOLD, 14));
        length.setForeground(new Color(255, 0, 0));
        contentPane.add(length);

        textField = new JTextField();
        textField.setBounds(228, 51, 123, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton create = new JButton("CREATE ARRAY");
        create.setForeground(new Color(128, 64, 0));
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String lenText = textField.getText().trim();

                    if (lenText.isEmpty()) {
                        JOptionPane.showMessageDialog(Array.this, "Please enter a value for array length.");
                        return;
                    }

                    int len = Integer.parseInt(lenText);

                    if (len <= 0) {
                        JOptionPane.showMessageDialog(Array.this, "Please enter a positive integer for array length.");
                        return;
                    }

                    arr = new int[len];
                    String message = "Array of length " + len + " created";
                    JOptionPane.showMessageDialog(Array.this, message);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Array.this, "Invalid input. Please enter a valid integer for array length.");
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        create.setBounds(162, 93, 156, 23);
        create.setFont(new Font("Constantia", Font.BOLD, 12));
        contentPane.add(create);

        JLabel insert = new JLabel("INSERT AN INTEGER ELEMENT");
        insert.setForeground(new Color(0, 128, 0));
        insert.setFont(new Font("Constantia", Font.BOLD, 14));
        insert.setBounds(10, 147, 222, 18);
        contentPane.add(insert);

        element = new JTextField();
        element.setBounds(228, 145, 48, 19);
        contentPane.add(element);
        element.setColumns(10);

        JButton insertbtn = new JButton("INSERT");
        insertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CODE FOR INSERTION ARRAY 
                try {
                    if (arr == null) {
                        JOptionPane.showMessageDialog(Array.this, "Array is not created. Please create an array first.");
                        return;
                    }

                    String elementText = element.getText().trim();
                    if (elementText.isEmpty()) {
                        JOptionPane.showMessageDialog(Array.this, "Please enter a value for the element to insert.");
                        return;
                    }

                    int value = Integer.parseInt(elementText);
                    // Add your logic to insert the value into the array at the specified position
                    // ...
                    int pos = Integer.valueOf(position.getText());
                    arr[pos] = value;
                    String message = "Element " + value + " inserted at position " + pos + ".";
                    JOptionPane.showMessageDialog(Array.this, message);
                    element.setText("");
                    position.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Array.this, "Invalid input. Please enter a valid integer for the element.");
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        insertbtn.setBackground(new Color(128, 128, 128));
        insertbtn.setFont(new Font("Constantia", Font.BOLD, 12));
        insertbtn.setForeground(new Color(255, 0, 128));
        insertbtn.setBounds(401, 145, 85, 23);
        contentPane.add(insertbtn);

        JLabel lblNewLabel = new JLabel("DELETE POSITION : ");
        lblNewLabel.setForeground(new Color(128, 0, 0));
        lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 14));
        lblNewLabel.setBounds(32, 193, 141, 18);
        contentPane.add(lblNewLabel);

        deleteposition = new JTextField();
        deleteposition.setBounds(201, 191, 96, 19);
        contentPane.add(deleteposition);
        deleteposition.setColumns(10);

        JButton deletebtn = new JButton("DELETE");
        deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CODE FOR DELETING ARRAY 
                try {
                    if (arr == null) {
                        JOptionPane.showMessageDialog(Array.this, "Array is not created. Please create an array first.");
                        return;
                    }

                    String deletePositionText = deleteposition.getText().trim();
                    if (deletePositionText.isEmpty()) {
                        JOptionPane.showMessageDialog(Array.this, "Please enter a position to delete an element.");
                        return;
                    }

                    int position = Integer.parseInt(deletePositionText);

                    // Add your logic to delete the element at the specified position from the array
                    // ...
                    arr[position] = 0;

                    String message = "Element at position " + position + " deleted.";
                    JOptionPane.showMessageDialog(Array.this, message);
                    deleteposition.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Array.this, "Invalid input. Please enter a valid integer for the position.");
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        deletebtn.setForeground(new Color(0, 64, 128));
        deletebtn.setFont(new Font("Constantia", Font.BOLD, 12));
        deletebtn.setBounds(350, 190, 106, 23);
        contentPane.add(deletebtn);

        JButton displaybtn = new JButton("DISPLAY");
        displaybtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CODE FOR DISPLAYING ARRAY 
                try {
                    if (arr == null) {
                        JOptionPane.showMessageDialog(Array.this, "Array is not created. Please create an array first.");
                        return;
                    }
                    StringBuilder msg = new StringBuilder("Array Elements: ");
                    for (int i = 0; i < arr.length; i++) {
                        msg.append(arr[i]);
                        if (i < arr.length - 1) {
                            msg.append(", ");
                        }
                    }
                    displaybox.setText(msg.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        displaybtn.setFont(new Font("Constantia", Font.BOLD, 12));
        displaybtn.setBounds(201, 240, 85, 21);
        contentPane.add(displaybtn);

        position = new JTextField();
        position.setBounds(350, 145, 39, 19);
        contentPane.add(position);
        position.setColumns(10);

        JLabel pos = new JLabel("POSITION");
        pos.setForeground(new Color(0, 128, 255));
        pos.setFont(new Font("Constantia", Font.BOLD, 12));
        pos.setBounds(286, 149, 59, 15);
        contentPane.add(pos);

        displaybox = new JTextField();
        displaybox.setBackground(new Color(128, 255, 255));
        displaybox.setBounds(54, 290, 421, 38);
        contentPane.add(displaybox);
        displaybox.setColumns(10);
    }
}
