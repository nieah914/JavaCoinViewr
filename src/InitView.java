import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JSlider;

public class InitView extends JFrame {
	
	private JPanel contentPane = new JPanel();
	private JTextField textField;
	private JButton btnNewButton = new JButton("New button");
	private int opacity;
	private final JSlider slider = new JSlider();
	int pX,pY;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnNewMenu = new JMenu("New menu");
	private JTable table = new JTable();
	private Vector<String> columns = new Vector<String>();
	private final JMenu mnNewMenu_1 = new JMenu("X");
	
	DefaultTableModel model ;
	private String[] title = {"coin","price"};
	private String[][] datas = new String[0][0];
	
	/**
	 * Launch the application.
	 */
	
	public void modiOpacity(int opacity) {
		int passNum = 0;
		passNum = opacity;
		System.out.println(""+passNum);
		contentPane.setBackground(new Color(0, 0, 0, passNum));
		textField.setBackground(new Color(0, 0, 0, passNum));
		btnNewButton.setBackground(new Color(0, 0, 0, passNum));
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitView frame = new InitView();
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
	public InitView() {
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		opacity = 100;
		
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("test");
		
		
		
		contentPane.setBackground(new Color(0,0,0,60));
		getContentPane().add(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		textField = new JTextField();
		
		textField.addKeyListener
	      (new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {
	           int key = e.getKeyCode();
	           if (key == KeyEvent.VK_ENTER) {
	              Toolkit.getDefaultToolkit().beep();   
	              System.out.println("ENTER pressed");
	              opacity = Integer.parseInt(textField.getText());
	              setBackground(new Color(0, 0, 0, opacity));
	              }
	           }
	         }
	      );
				
				contentPane.add(slider, "2, 4");
				slider.setMaximum(250);
				slider.addChangeListener(new ChangeListener() {
				      public void stateChanged(ChangeEvent event) {
				        int value = 0;
				        value = slider.getValue();
				        modiOpacity(value);		        
				      }
				    });
		
		
				
				
				
				contentPane.add(textField, "2, 6, left, default");
				textField.setColumns(10);
				
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						opacity = Integer.parseInt(textField.getText());
						setBackground(new Color(0, 0, 0, opacity));
						
					}
					
				});
				
				contentPane.add(btnNewButton, "4, 6");
				
				contentPane.add(table, "2, 8, fill, fill");
		setJMenuBar(menuBar);
		
		menuBar.add(mnNewMenu);
		
		menuBar.add(mnNewMenu_1);
		
		menuBar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                // Get x,y and store them
                pX=me.getX();
                pY=me.getY();
                
            }
        });
		 // Add MouseMotionListener for detecting drag
		menuBar.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent me)
            {
                // Set the location
                // get the current location x-co-ordinate and then get
                // the current drag x co-ordinate, add them and subtract most recent
                // mouse pressed x co-ordinate
                // do same for y co-ordinate
                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
            }
        });
		
		
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 122));
		
		
		
		
		
	}

}
