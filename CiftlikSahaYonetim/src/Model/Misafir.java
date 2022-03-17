package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Misafir {
	private int id;
	private String ad_soyad, tcno, ziyaret_tarih, neden;
	
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Misafir(int id, String ad_soyad, String tcno, String ziyaret_tarih, String neden) {
		super();
		this.id = id;
		this.ad_soyad = ad_soyad;
		this.tcno = tcno;
		this.ziyaret_tarih = ziyaret_tarih;
		this.neden = neden;
	}
	public Misafir() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd_soyad() {
		return ad_soyad;
	}
	public void setAd_soyad(String ad_soyad) {
		this.ad_soyad = ad_soyad;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getZiyaret_tarih() {
		return ziyaret_tarih;
	}
	public void setZiyaret_tarih(String ziyaret_tarih) {
		this.ziyaret_tarih = ziyaret_tarih;
	}
	public String getNeden() {
		return neden;
	}
	public void setNeden(String neden) {
		this.neden = neden;
	}
	
	public ArrayList<Misafir> getMisafirList() throws SQLException{
		ArrayList<Misafir> list = new ArrayList<>();
		Misafir obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM misafir");
			while(rs.next()) {
				obj = new Misafir();
				obj.setId(rs.getInt("id"));
				obj.setAd_soyad(rs.getString("ad_soyad"));
				obj.setTcno(rs.getString("tcno"));
				obj.setZiyaret_tarih(rs.getString("ziyaret_tarih"));
				obj.setNeden(rs.getString("neden"));
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
	public boolean addMisafir(String ad_soyad, String tcno, String ziyaret_tarih, String neden) {
		String query = "INSERT INTO misafir"+"(ad_soyad, tcno, ziyaret_tarih, neden) VALUES"+"(?,?,?,?)";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, ad_soyad);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, ziyaret_tarih);
			preparedStatement.setString(4, neden);
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
	public boolean deleteMisafir(int id) {
		String query = "DELETE FROM misafir WHERE id = ?";
	
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
	
	public boolean updateMisafir(int id, String ad_soyad, String tcno, String ziyaret_tarih, String neden) {
		String query = "UPDATE misafir SET ad_soyad = ?, tcno = ?, ziyaret_tarih = ?, neden = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, ad_soyad);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, ziyaret_tarih);
			preparedStatement.setString(4, neden);
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
