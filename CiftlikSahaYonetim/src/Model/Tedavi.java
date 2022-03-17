package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Tedavi {
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int sira_no;
	private String kupe_no, i_kupe_no, cinsi, cinsiyet, tedavi_tarih, hastalik, tedavi, ilac, veteriner;
	public Tedavi(int sira_no, String kupe_no, String i_kupe_no, String cinsi, String cinsiyet, String tedavi_tarih,
			String hastalik, String tedavi, String ilac, String veteriner) {
		super();
		this.sira_no = sira_no;
		this.kupe_no = kupe_no;
		this.i_kupe_no = i_kupe_no;
		this.cinsi = cinsi;
		this.cinsiyet = cinsiyet;
		this.tedavi_tarih = tedavi_tarih;
		this.hastalik = hastalik;
		this.tedavi = tedavi;
		this.ilac = ilac;
		this.veteriner = veteriner;
	}
	public Tedavi() {
		
	}
	public int getSira_no() {
		return sira_no;
	}
	public void setSira_no(int sira_no) {
		this.sira_no = sira_no;
	}
	public String getKupe_no() {
		return kupe_no;
	}
	public void setKupe_no(String kupe_no) {
		this.kupe_no = kupe_no;
	}
	public String getI_kupe_no() {
		return i_kupe_no;
	}
	public void setI_kupe_no(String i_kupe_no) {
		this.i_kupe_no = i_kupe_no;
	}
	public String getCinsi() {
		return cinsi;
	}
	public void setCinsi(String cinsi) {
		this.cinsi = cinsi;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getTedavi_tarih() {
		return tedavi_tarih;
	}
	public void setTedavi_tarih(String tedavi_tarih) {
		this.tedavi_tarih = tedavi_tarih;
	}
	public String getHastalik() {
		return hastalik;
	}
	public void setHastalik(String hastalik) {
		this.hastalik = hastalik;
	}
	public String getTedavi() {
		return tedavi;
	}
	public void setTedavi(String tedavi) {
		this.tedavi = tedavi;
	}
	public String getIlac() {
		return ilac;
	}
	public void setIlac(String ilac) {
		this.ilac = ilac;
	}
	public String getVeteriner() {
		return veteriner;
	}
	public void setVeteriner(String veteriner) {
		this.veteriner = veteriner;
	}
	
	public ArrayList<Tedavi> getTedaviList() throws SQLException{
		ArrayList<Tedavi> list = new ArrayList<>();
		Tedavi obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM tedavi");
			while(rs.next()) {
				obj = new Tedavi();
				obj.setSira_no(rs.getInt("sira_no"));
				obj.setKupe_no(rs.getString("kupe_no"));
				obj.setI_kupe_no(rs.getString("i_kupe_no"));
				obj.setCinsi(rs.getString("cinsi"));
				obj.setCinsiyet(rs.getString("cinsiyet"));
				obj.setTedavi_tarih(rs.getString("tedavi_tarih"));
				obj.setHastalik(rs.getString("hastalik"));
				obj.setTedavi(rs.getString("tedavi"));
				obj.setIlac(rs.getString("ilac"));
				obj.setVeteriner(rs.getString("veteriner"));
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
	public boolean addTedavi(String kupe_no, String i_kupe_no, String cinsi, String cinsiyet, String tedavi_tarih,
			String hastalik, String tedavi, String ilac, String veteriner) {
		String query = "INSERT INTO tedavi"+"(kupe_no, i_kupe_no, cinsi, cinsiyet, tedavi_tarih, hastalik, tedavi, ilac, veteriner) VALUES"+"(?,?,?,?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kupe_no);
			preparedStatement.setString(2, i_kupe_no);
			preparedStatement.setString(3, cinsi);
			preparedStatement.setString(4, cinsiyet);
			preparedStatement.setString(5, tedavi_tarih);
			preparedStatement.setString(6, hastalik);
			preparedStatement.setString(7, tedavi);
			preparedStatement.setString(8, ilac);
			preparedStatement.setString(9, veteriner);
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
	public boolean deleteTedavi(int id) {
		String query = "DELETE FROM tedavi WHERE sira_no = ?";
	
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
	
	public boolean updateTedavi(int sira_no, String tedavi_tarih,String hastalik, String tedavi, String ilac) {
		String query = "UPDATE tedavi SET tedavi_tarih = ?, hastalik = ?, tedavi = ?, ilac = ?WHERE sira_no = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tedavi_tarih);
			preparedStatement.setString(2, hastalik);
			preparedStatement.setString(3, tedavi);
			preparedStatement.setString(4, ilac);
			preparedStatement.setInt(5, sira_no);
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
