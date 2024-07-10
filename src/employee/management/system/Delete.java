package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Delete extends JFrame implements ActionListener{
	
	Choice cEmpId;
	JButton delete,back;
	Delete(){
		
		getContentPane().setBackground(Color.gray);
		setLayout(null);
		
		JLabel labelempId = new JLabel("Employee ID");
		labelempId.setBounds(50,50,100,30);
		add(labelempId);
		
		cEmpId = new Choice();
		cEmpId.setBounds(200,50,150,30);
		add(cEmpId);
		
		try {
			conn c = new conn();
			String query ="select * from employeedata";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				cEmpId.add(rs.getString("empId"));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50,100,100,30);
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200,100,100,30);
		add(lblname);
		
		try {
			conn c = new conn();
			String query ="select * from employeedata where empId = '"+cEmpId.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		cEmpId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				try {
					conn c = new conn();
					String query ="select * from employeedata where empId = '"+cEmpId.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()) {
						lblname.setText(rs.getString("name"));
					}
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		});
		
		delete = new JButton("Delete");
		delete.setBounds(80,300,100,30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("Back");
		back.setBounds(220,300,100,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("delete.png"));
		Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,400);
		add(image);
		
		
		setSize(600,400);
		setLocation(250,200);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==delete) {
			
			try {
				conn c = new conn();
				String query = "delete from employeedata where empId = '"+cEmpId.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee info. deleted");
				setVisible(false);
				new Home();
			}
			catch(Exception e) {
				
			}
		}
		else {
			setVisible(false);
			new Home();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new Delete();
	}

}
