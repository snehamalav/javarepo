package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Track;



public class MyService {
	public List<Track> getAllTracks(){
		List<Track> tlist =new ArrayList<Track>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr");
			String sql= "select * from track";
			PreparedStatement smt= connection.prepareStatement(sql);
			ResultSet rs=smt.executeQuery();
			while(rs.next())
			{
				Track t=new Track(rs.getString(1), rs.getString(2));
			   tlist.add(t);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		
		return tlist;
		
	}
// to get a particular track using parameter title
	public Track gettrackDetails(String title)
	{
		
		Track track=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("select * from track where title=?");
			
			smt.setString(1, title);
			
			ResultSet rs = smt.executeQuery();
			
			
			if (rs.next()){
				track=new Track(rs.getString(1), rs.getString(2));
			}
			connection.close();
		}
		
		catch (Exception e){
			System.out.println(e);
		}
	return track;	
	}
	
	//to insert the details into track table
	public boolean registerTrack(Track track){
		boolean result = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("insert into track values (?,?)");
			
			smt.setString(1, track.getTitle());
			smt.setString(2,track.getSinger());
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
	//deleting the track
	public boolean deleteTrack(String title){
		boolean result = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("delete from track where title=?");
			
			smt.setString(1, title);
			
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
	public boolean updateTrack(Track track){
		boolean result = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step-1
			Connection connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"hr",
						"hr"); // step-2
			PreparedStatement smt =  connection.prepareStatement("update track set singer=? where title=?");
			
			smt.setString(1, track.getSinger());
			smt.setString(2, track.getTitle());
			
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
}
