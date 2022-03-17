package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Asi {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int sira_no;
	private String kupe_no, i_kupe_no, cinsi, cinsiyet, asi_tarih, asi, asi_marka, diger_tarih, veteriner;
	public Asi(int sira_no, String kupe_no, String i_kupe_no, String cinsi, String cinsiyet, String asi_tarih,
			String asi, String asi_marka, String diger_tarih, String veteriner) {
		super();
		this.sira_no = sira_no;
		this.kupe_no = kupe_no;
		this.i_kupe_no = i_kupe_no;
		this.cinsi = cinsi;
		this.cinsiyet = cinsiyet;
		this.asi_tarih = asi_tarih;
		this.asi = asi;
		this.asi_marka = asi_marka;
		this.diger_tarih = diger_tarih;
		this.veteriner = veteriner;
	}
	public Asi() {
		
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
	public String getAsi_tarih() {
		return asi_tarih;
	}
	public void setAsi_tarih(String asi_tarih) {
		this.asi_tarih = asi_tarih;
	}
	public String getAsi() {
		return asi;
	}
	public void setAsi(String asi) {
		this.asi = asi;
	}
	public String getAsi_marka() {
		return asi_marka;
	}
	public void setAsi_marka(String asi_marka) {
		this.asi_marka = asi_marka;
	}
	public String getDiger_tarih() {
		return diger_tarih;
	}
	public void setDiger_tarih(String diger_tarih) {
		this.diger_tarih = diger_tarih;
	}
	public String getVeteriner() {
		return veteriner;
	}
	public void setVeteriner(String veteriner) {
		this.veteriner = veteriner;
	}
	public ArrayList<Asi> getAsiList() throws SQLException{
		ArrayList<Asi> list = new ArrayList<>();
		Asi obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM asi");
			while(rs.next()) {
				obj = new Asi();
				obj.setSira_no(rs.getInt("sira_no"));
				obj.setKupe_no(rs.getString("kupe_no"));
				obj.setI_kupe_no(rs.getString("i_kupe_no"));
				obj.setCinsi(rs.getString("cinsi"));
				obj.setCinsiyet(rs.getString("cinsiyet"));
				obj.setAsi_tarih(rs.getString("asi_tarih"));
				obj.setAsi(rs.getString("asi"));
				obj.setAsi_marka(rs.getString("asi_marka"));
				obj.setDiger_tarih(rs.getString("diger_tarih"));
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
	public boolean addAsi(String kupe_no, String i_kupe_no, String cinsi, String cinsiyet, String asi_tarih,
			String asi, String asi_marka, String diger_tarih, String veteriner) {
		String query = "INSERT INTO asi"+"(kupe_no, i_kupe_no, cinsi, cinsiyet, asi_tarih, asi, asi_marka, diger_tarih, veteriner) VALUES"+"(?,?,?,?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kupe_no);
			preparedStatement.setString(2, i_kupe_no);
			preparedStatement.setString(3, cinsi);
			preparedStatement.setString(4, cinsiyet);
			preparedStatement.setString(5, asi_tarih);
			preparedStatement.setString(6, asi);
			preparedStatement.setString(7, asi_marka);
			preparedStatement.setString(8, diger_tarih);
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
	public boolean deleteAsi(int id) {
		String query = "DELETE FROM asi WHERE sira_no = ?";
	
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
	public boolean updateAsi(int sira_no, String asi_tarih, String asi, String asi_marka, String diger_tarih) {
		String query = "UPDATE asi SET asi_tarih = ?, asi = ?, asi_marka = ?, diger_tarih = ? WHERE sira_no = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, asi_tarih);
			preparedStatement.setString(2, asi);
			preparedStatement.setString(3, asi_marka);
			preparedStatement.setString(4, diger_tarih);
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
