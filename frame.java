package ATMGUI;
import ATMGUI.*;
import ATMProgram.*;
import ATMProgram.Manager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	static String ct1,ct2;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939\\untitled.png"));
		setTitle("\u57CE\u5E0224\u5C0F\u65F6ATM\u81EA\u52A8\u53D6\u6B3E\u673A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(99, 212, 81, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(99, 262, 81, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAtm = new JLabel("");
		lblAtm.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\\u65B0\u5EFA\u6587\u4EF6\u5939\\u=1986919323,801047730&fm=15&gp=0.jpg"));
		lblAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtm.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		lblAtm.setBounds(57, 10, 425, 192);
		contentPane.add(lblAtm);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		@SuppressWarnings("deprecation") 
		String content1=textField.getText();
		@SuppressWarnings("deprecation")
		String content2=passwordField_1.getText();
		System.out.println(content1+"\n"+content2);
		if(content1!=null&&!(content1.trim().equals(""))
				&&content2!=null&&!(content2.trim().equals(""))) {
			BankServer server=null;
					User user=null;
			try {
				server=new BankServer();
				user=server.chick(content1, content2);
				System.out.println(content1+"\n"+content2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"账户或密码未输入");
		}
			}
			});
		
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton.setBounds(64, 329, 127, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1.setBounds(355, 329, 127, 40);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
				
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(189, 272, 182, 27);
		contentPane.add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(190, 225, 182, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
	
