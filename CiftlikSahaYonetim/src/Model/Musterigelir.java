package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Musterigelir {
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int id;
	private String name, tcno, telefon, adres;
	public Musterigelir(int id, String name, String tcno, String telefon, String adres) {
		super();
		this.id = id;
		this.name = name;
		this.tcno = tcno;
		this.telefon = telefon;
		this.adres = adres;
	}
	public Musterigelir() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public ArrayList<Musterigelir> getMusteriList() throws SQLException{
		ArrayList<Musterigelir> list = new ArrayList<>();
		Musterigelir obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM gelir_musteri ORDER BY id ASC");
			while(rs.next()) {
				obj = new Musterigelir();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setTcno(rs.getString("tcno"));
				obj.setTelefon(rs.getString("telefon"));
				obj.setAdres(rs.getString("adres"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.close();
			st.close();
			rs.close();
		}
		
		return list;
	}
	public boolean addMusteri(String name, String tcno, String telefon, String adres) {
		String query = "INSERT INTO gelir_musteri"+"(name, tcno, telefon, adres) VALUES"+"(?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, telefon);
			preparedStatement.setString(4, adres);
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
	public boolean deleteMusteri(int id) {
		String query = "DELETE FROM gelir_musteri WHERE id = ?";
	
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
	public boolean updateMusteri(int id, String name, String tcno, String telefon, String adres) {
		String query = "UPDATE gelir_musteri SET name = ?, tcno = ?, telefon = ?, adres = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, telefon);
			preparedStatement.setString(4, adres);
			preparedStatement.setInt(5, id);
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
