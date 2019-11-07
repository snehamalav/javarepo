package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employee;




public class EmpDao {
	public boolean registerUser(Employee emp){
		boolean result = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("insert into employee values (?,?,?,?,?,?,?,?)");
			
			smt.setInt(1, emp.getEid());
			smt.setString(2, emp.getFname());
			smt.setString(3, emp.getLname());
			smt.setString(4, emp.getPassword());
			smt.setInt(5, emp.getContactno());
			smt.setString(6, emp.getGender());
			smt.setString(7, emp.getEmail());
			smt.setString(8, emp.getDname());
			int rs = smt.executeUpdate();
			connection.close();
			
			if (rs>0){
				result = true;
			}
		}
		
		catch (Exception e){
			System.out.println(e);
		}
		return result;
	}
	public List<Employee> getAllEmployee(){
		List<Employee> plist =new ArrayList<Employee>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr");
			String sql= "select * from employee";
			PreparedStatement smt= connection.prepareStatement(sql);
			ResultSet rs=smt.executeQuery();
			while(rs.next())
			{
				Employee p=new Employee(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)),
						 rs.getString(6), rs.getString(7), rs.getString(8));
			   plist.add(p);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		
		return plist;
		
	}
	public Employee getempDetails(int eid)
	{
		
		Employee emp=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("select * from employee where eid=?");
			
			smt.setInt(1, eid);
			
			ResultSet rs = smt.executeQuery();
			
			
			if (rs.next()){
				emp=new Employee(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)),
						 rs.getString(6), rs.getString(7), rs.getString(8));
			}
			connection.close();
		}
		
		catch (Exception e){
			System.out.println(e);
		}
	return emp;	
	}
	
	public boolean deleteUser(int eid)
	{
		boolean result=false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("delete from employee where eid=? ");
			
			smt.setInt(1, eid);
			
			
			
			ResultSet rs = smt.executeQuery();
			if(rs.next())
			{
				result=true;
			}
			connection.close();
			
			
		}
		
		catch (Exception e){
			System.out.println(e);
		}
		return result;
	}
		
}
