package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Home extends JFrame implements ActionListener{
	
	JButton view,add,update,delete;
	Home(){
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1120,630);
		add(image);
		
		JLabel heading= new JLabel("Employee Management System");
		heading.setBounds(650,20,400,40);
		heading.setFont(new Font("Raleway",Font.BOLD,25));
		
		image.add(heading);
		
		add= new JButton("ADD");
		add.setBounds(650,80,150,40);
		add.addActionListener(this);
		image.add(add);
		
		view= new JButton("VIEW");
		view.setBounds(820,80,150,40);
		view.addActionListener(this);
		image.add(view);
		
		update= new JButton("UPDATE");
		update.setBounds(650,140,150,40);
		update.addActionListener(this);
		image.add(update);
		
		delete= new JButton("DELETE");
		delete.setBounds(820,140,150,40);
		delete.addActionListener(this);
		image.add(delete);
		
		setSize(1120,630);
		setLocation(140,50);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			setVisible(false);
			new Add();
		}
		else if(ae.getSource() == view) {
			setVisible(false);
			new View();
		}
		else if(ae.getSource() == update) {
			setVisible(false);
			new View();
			
		}
		else {
			setVisible(false);
			new Delete();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();
	}

}
