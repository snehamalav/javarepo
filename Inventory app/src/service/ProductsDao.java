package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductsDao {
	public boolean productRegister(Product product)
	{
		boolean result=false;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("insert into product values (?,?,?,?,?)");
			
			smt.setString(1, product.getPid());
			smt.setString(2,product.getPname());
			smt.setInt(3, product.getUnitprice());
			smt.setInt(4,product.getStock());
			smt.setString(5, product.getCategory());
	
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
public List<Product> getAllProduct(){
	List<Product> plist =new ArrayList<>();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
		Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"hr",
					"hr");
		String sql= "select * from product";
		PreparedStatement smt= connection.prepareStatement(sql);
		ResultSet rs=smt.executeQuery();
		while(rs.next())
		{
			Product p=new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
		   plist.add(p);
		}
	}
	catch (Exception e){
		System.out.println(e);
	}
	
	
	return plist;
	
}
	
	

}
