package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class View extends JFrame implements ActionListener{
	
	JTable table;
	Choice cemployeeId;
	JButton back,search,update;
	View(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel searchlb1= new JLabel("Search by Employee ID");
		searchlb1.setBounds(20,20,150,20);
		add(searchlb1);
		
		cemployeeId = new Choice();
		cemployeeId.setBounds(180,20,150,20);
		add(cemployeeId);
		
		table=new JTable();
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from employeedata");
			
			while(rs.next()) {
				cemployeeId.add(rs.getString("empId"));
			}
		}
		catch(Exception e) {
			
		}
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from employeedata");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			while(rs.next()) {
				cemployeeId.add(rs.getString("empId"));
			}
		}
		catch(Exception e) {
			
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,100,900,600);
		add(jsp);
		
		search= new JButton("Search");
		search.setBounds(20,70,80,20);
		search.setBackground(Color.black);
		search.setForeground(Color.WHITE);
		search.addActionListener(this);
		add(search);
		
		update= new JButton("Update");
		update.setBounds(220,70,80,20);
		update.setBackground(Color.black);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		back= new JButton("BACK");
		back.setBounds(120,70,80,20);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLocation(50,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			String query = "select * from employeedata where empId='"+cemployeeId.getSelectedItem()+"'";
			try {
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e){
				
			}
		}
		
		else if(ae.getSource()==update){
			setVisible(false);
			new Update(cemployeeId.getSelectedItem());
		}
		else {
			setVisible(false);
			new Home();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new View();
	}

}
