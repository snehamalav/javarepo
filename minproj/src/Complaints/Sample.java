package Complaints;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Sample {
public static void loader(){
    String csvFile = "C:\\Users\\lntinfotech\\Desktop\\Data.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    try {

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] data = line.split(cvsSplitBy);

            System.out.println( data[0]+" "+data[1]+" "+ data[2]+ " "+data[3]+" "+ data[4]+" "+ data[5]+ " "+data[6]+" "+ data[7]+" "+ data[8]+ " "+data[9]+" "+ data[10]+ " "+data[11]+ " "+data[12]+ " "+data[13]);

            
            
            Class.forName("oracle.jdbc.driver.OracleDriver");//step1
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");//step2
			PreparedStatement pst = connection.prepareStatement("insert into complaints values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//step3
			pst.setString(1, data[0]); pst.setString(2, data[1]); pst.setString(3, data[2]); pst.setString(4, data[3]); pst.setString(5, data[4]); pst.setString(6, data[5]); pst.setString(7, data[6]); pst.setString(8, data[7]); pst.setString(9, data[8]); pst.setString(10, data[9]); pst.setString(11, data[10]); pst.setString(12, data[11]); pst.setString(13, data[12]); pst.setString(14, data[13]); 
			pst.executeUpdate();
			System.out.println("Record Added");
			connection.close();//step5
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
	
}

}



