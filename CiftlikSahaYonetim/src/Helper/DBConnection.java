package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

Connection c = null;
	
	public DBConnection(){
		
	}
	public Connection connDb() {
		try {
			this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ciftliksahayonetim","postgres","12345");
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
}
