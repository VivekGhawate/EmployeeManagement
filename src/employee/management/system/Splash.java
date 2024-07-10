package employee.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Splash extends JFrame implements ActionListener{
	
	Splash(){
		
		getContentPane().setBackground(Color.gray);
		setSize(1170,660);
		setLocation(60,60);
		setVisible(true);
		JLabel heading= new JLabel("Employee Management System");
		
		setLayout(null);
		heading.setBounds(80,30,1200,70);
		heading.setFont(new Font("serrif",Font.PLAIN,60));
		heading.setForeground(Color.RED);
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,100,1150,500);
		add(image);
		
		JButton clickhere= new JButton("CLick here to Continue");
		clickhere.setBounds(400,400,300,70);
		add(clickhere);
		clickhere.addActionListener(this);
		image.add(clickhere);
		
	
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new Splash();
		
	}

}
