package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Yonetici extends User{
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	

	public Yonetici(int id, String name, String tcno, String username, String password, String phone, String type) {
		super(id, name, tcno, username, password, phone, type);
		// TODO Auto-generated constructor stub
	}
	public Yonetici() {
		
	}
	
	public ArrayList<User> getKullaniciList() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		User obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM kullanici ORDER BY id ASC");
			while(rs.next()) {
				obj = new User();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setTcno(rs.getString("tcno"));
				obj.setUsername(rs.getString("username"));
				obj.setPassword(rs.getString("password"));
				obj.setPhone(rs.getString("phone"));
				obj.setType(rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean addKullanici(String name, String tcno, String username, String password, String phone, String type) {
		String query = "INSERT INTO kullanici"+"(name, tcno, username, password, phone, type) VALUES"+"(?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, phone);
			preparedStatement.setString(6, type);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(key)
		return true;
		else
		return false;
		
		
	}
	public boolean deleteKullanici(int id) {
		String query = "DELETE FROM kullanici WHERE id = ?";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(key)
		return true;
		else
		return false;
		
		
	}
	public boolean updateKullanici(int id, String name, String tcno, String username, String password, String phone, String type) {
		String query = "UPDATE kullanici SET name = ?, tcno = ?, username = ?, password = ?, phone = ?, type= ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, phone);
			preparedStatement.setString(6, type);
			preparedStatement.setInt(7, id);
		
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(key)
		return true;
		else
		return false;
		
	
		
	}
	 

}
