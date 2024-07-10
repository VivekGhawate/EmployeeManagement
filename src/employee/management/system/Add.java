package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;


public class Add extends JFrame implements ActionListener{

	Random ran= new Random();
	int number=ran.nextInt(999999);
	
	JTextField tfname,tffname,tfsalary,tflname,tfadress,tfphone,tfaadhar,tfemail,tfdesignation;
	JComboBox cbeducation;
	JLabel lblempId;
	JButton add,back;
	Add(){
		getContentPane().setBackground(Color.gray);
		setLayout(null);
		
		JLabel heading= new JLabel("Add Employee details");
		heading.setBounds(300,30,500,50);
		heading.setFont(new Font("SAN serrif",Font.BOLD,25));
		add(heading);
		
		JLabel labelname= new JLabel("Name:");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelname);
		
		tfname= new JTextField();
		tfname.setBounds(200,150,150,30);
		add(tfname);
		
		//
		JLabel labelfname= new JLabel("Father Name:");
		labelfname.setBounds(400,150,150,30);
		labelfname.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelfname);
		
		tffname= new JTextField();
		tffname.setBounds(600,150,150,30);
		add(tffname);
		//
		JLabel labellname= new JLabel("Last Name:");
		labellname.setBounds(50,200,150,30);
		labellname.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labellname);
		
		tflname= new JTextField();
		tflname.setBounds(200,200,150,30);
		add(tflname);
		//
		
		JLabel labelsalary= new JLabel("Salary:");
		labelsalary.setBounds(400,200,150,30);
		labelsalary.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelsalary);
		
		tfsalary= new JTextField();
		tfsalary.setBounds(600,200,150,30);
		add(tfsalary);
		//
		
		JLabel labeladdress= new JLabel("Address:");
		labeladdress.setBounds(50,250,150,30);
		labeladdress.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labeladdress);
		
		tfadress= new JTextField();
		tfadress.setBounds(200,250,150,30);
		add(tfadress);
		//
		
		JLabel labelphone= new JLabel("Phone:");
		labelphone.setBounds(400,250,150,30);
		labelphone.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelphone);
		
		tfphone= new JTextField();
		tfphone.setBounds(600,250,150,30);
		add(tfphone);
		//
		
		JLabel labelemail= new JLabel("Email:");
		labelemail.setBounds(50,300,150,30);
		labelemail.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelemail);
		
		tfemail= new JTextField();
		tfemail.setBounds(200,300,150,30);
		add(tfemail);
		//
		
		JLabel labeleducation= new JLabel("Phone:");
		labeleducation.setBounds(400,300,150,30);
		labeleducation.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labeleducation);
		
		String courses[] = {"BBA","BCA","BA","B.COM","B.TECH","MBA","MCA","MA","M.TECH","MSC"};
		
		cbeducation= new JComboBox(courses);
		cbeducation.setBounds(600,300,150,30);
		add(cbeducation);
		//
		
		JLabel labeldesignation= new JLabel("Designation:");
		labeldesignation.setBounds(50,350,150,30);
		labeldesignation.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labeldesignation);
		
		tfdesignation= new JTextField();
		tfdesignation.setBounds(200,350,150,30);
		add(tfdesignation);
		//
		
		JLabel labelaadhar= new JLabel("Aadhar No:");
		labelaadhar.setBounds(400,350,150,30);
		labelaadhar.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelaadhar);
		
		tfaadhar= new JTextField();
		tfaadhar.setBounds(600,350,150,30);
		add(tfaadhar);
		//
		
		JLabel labelempId= new JLabel("Employee Id:");
		labelempId.setBounds(50,400,150,30);
		labelempId.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(labelempId);
		
		lblempId= new JLabel(""+number);
		lblempId.setBounds(200,400,150,30);
		lblempId.setFont(new Font("SAN serrif",Font.PLAIN,20));
		add(lblempId);
		//
		
		
		add= new JButton("ADD");
		add.setBounds(250,500,150,40);
		add.setBackground(Color.black);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);
		
		//
		back= new JButton("BACK");
		back.setBounds(450,500,150,40);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(900,600);
		setLocation(200,50);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() ==add) {
			String name = tfname.getText();
			String fname = tffname.getText();
			String lname = tflname.getText();
			String salary = tfsalary.getText();
			String address = tfadress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String education = (String)cbeducation.getSelectedItem();
			String designation = tfdesignation.getText();
			String aadhar = tfaadhar.getText();
			String empId = lblempId.getText();
			
			try {
				conn conn = new conn();
				String query="insert into employeedata values('"+name+"','"+fname+"','"+lname+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully");
				setVisible(false);
				new Home();
			}
			catch(Exception e) {
				System.out.println("inserting problem"+e);
			}
		}
		
		else {
			setVisible(false);
			new Home();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Add();
	}

}
