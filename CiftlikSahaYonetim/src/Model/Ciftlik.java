package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Ciftlik {
	
	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private int id;
	private String isletme_no, name, adres, telefon, kurulus_yil, kapasite;
	public Ciftlik(int id, String isletme_no, String name, String adres, String telefon, String kurulus_yil,
			String kapasite) {
		super();
		this.id = id;
		this.isletme_no = isletme_no;
		this.name = name;
		this.adres = adres;
		this.telefon = telefon;
		this.kurulus_yil = kurulus_yil;
		this.kapasite = kapasite;
	}
	
	public Ciftlik() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsletme_no() {
		return isletme_no;
	}
	public void setIsletme_no(String isletme_no) {
		this.isletme_no = isletme_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getKurulus_yil() {
		return kurulus_yil;
	}
	public void setKurulus_yil(String kurulus_yil) {
		this.kurulus_yil = kurulus_yil;
	}
	public String getKapasite() {
		return kapasite;
	}
	public void setKapasite(String kapasite) {
		this.kapasite = kapasite;
	}
	
	
	public ArrayList<Ciftlik> getCiftlikList() throws SQLException{
		ArrayList<Ciftlik> list = new ArrayList<>();
		Ciftlik obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM ciftlik");
			while(rs.next()) {
				obj = new Ciftlik();
				obj.setId(rs.getInt("id"));
				obj.setIsletme_no(rs.getString("isletme_no"));
				obj.setName(rs.getString("name"));
				obj.setAdres(rs.getString("adres"));
				obj.setTelefon(rs.getString("telefon"));
				obj.setKurulus_yil(rs.getString("kurulus_yil"));
				obj.setKapasite(rs.getString("kapasite"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
			rs.close();
			con.close();
		}
		return list;
		
	}
	
	public boolean addCiftlik( String isletme_no, String name, String adres, String telefon, String kurulus_yil,
			String kapasite) throws SQLException {

		String query = "INSERT INTO ciftlik" + "(id, isletme_no, name, adres, telefon, kurulus_yil, kapasite) VALUES" + "(?,?,?,?,?,?,?)";
		boolean key = false;
		Connection con = conn.connDb();
		int count = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM ciftlik WHERE id = 1");
			while(rs.next()) {
				count++;
			}
			if(count == 0) {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, isletme_no);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, adres);
			preparedStatement.setString(5, telefon);
			preparedStatement.setString(6, kurulus_yil);
			preparedStatement.setString(7, kapasite);
			preparedStatement.executeUpdate();
			}
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else {
			return false;
		}
	}
	
	public boolean updateCiftlik(String isletme_no, String name, String adres, String telefon, String kurulus_yil,String kapasite) {
		String query = "UPDATE ciftlik SET isletme_no = ?, name = ?, adres = ?, telefon = ?, kurulus_yil = ?, kapasite= ? WHERE id = 1";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, isletme_no);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, adres);
			preparedStatement.setString(4, telefon);
			preparedStatement.setString(5, kurulus_yil);
			preparedStatement.setString(6, kapasite);
			
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
