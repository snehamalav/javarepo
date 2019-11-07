package Complaints;

import java.sql.*;
import java.util.Scanner;
//import java.util.Scanner;

public class demo2 {
  
	public static void main(String[] args)  {
	
	Connection connection = null;
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
			PreparedStatement pst=connection.prepareStatement("select Complaint_ID,COMPANY_RESPONSE_TO_CONSUMER from complaints where COMPANY_RESPONSE_TO_CONSUMER='Closed with explanation'");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
			
		System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t");
			}
	}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e);
			

		} catch (SQLException s)
		{
			System.out.println(s);
		}
		finally
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}

