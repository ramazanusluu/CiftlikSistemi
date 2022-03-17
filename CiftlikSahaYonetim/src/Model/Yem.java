package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Yem {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int sira_no;
	private String tarih, kapasite, rasyon, deger, gunluk_gider, yillik_gider, fiyat, paket;
	public Yem(int sira_no, String tarih, String kapasite, String rasyon, String deger, String gunluk_gider,
			String yillik_gider, String fiyat, String paket) {
		super();
		this.sira_no = sira_no;
		this.tarih = tarih;
		this.kapasite = kapasite;
		this.rasyon = rasyon;
		this.deger = deger;
		this.gunluk_gider = gunluk_gider;
		this.yillik_gider = yillik_gider;
		this.fiyat = fiyat;
		this.paket = paket;
	}
	public Yem() {
		
	}
	public int getSira_no() {
		return sira_no;
	}
	public void setSira_no(int sira_no) {
		this.sira_no = sira_no;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getKapasite() {
		return kapasite;
	}
	public void setKapasite(String kapasite) {
		this.kapasite = kapasite;
	}
	public String getRasyon() {
		return rasyon;
	}
	public void setRasyon(String rasyon) {
		this.rasyon = rasyon;
	}
	public String getDeger() {
		return deger;
	}
	public void setDeger(String deger) {
		this.deger = deger;
	}
	public String getGunluk_gider() {
		return gunluk_gider;
	}
	public void setGunluk_gider(String gunluk_gider) {
		this.gunluk_gider = gunluk_gider;
	}
	public String getYillik_gider() {
		return yillik_gider;
	}
	public void setYillik_gider(String yillik_gider) {
		this.yillik_gider = yillik_gider;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getPaket() {
		return paket;
	}
	public void setPaket(String paket) {
		this.paket = paket;
	}
	public ArrayList<Yem> getYemList() throws SQLException{
		ArrayList<Yem> list = new ArrayList<>();
		
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM yem ORDER BY sira_no ASC");
			while(rs.next()) {
				Yem obj = new Yem();
				obj.setSira_no(rs.getInt("sira_no"));
				obj.setTarih(rs.getString("tarih"));
				obj.setKapasite(rs.getString("kapasite"));
				obj.setRasyon(rs.getString("rasyon"));
				obj.setDeger(rs.getString("deger"));
				obj.setGunluk_gider(rs.getString("gunluk_gider"));
				obj.setYillik_gider(rs.getString("yillik_gider"));
				obj.setFiyat(rs.getString("fiyat"));
				obj.setPaket(rs.getString("paket"));
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
	public boolean addYem(String tarih, String kapasite, String rasyon, String deger, String gunluk_gider,
			String yillik_gider, String fiyat, String paket) {
		String query = "INSERT INTO yem"+"(tarih, kapasite, rasyon, deger, gunluk_gider, yillik_gider, fiyat, paket) VALUES"+"(?,?,?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tarih);
			preparedStatement.setString(2, kapasite);
			preparedStatement.setString(3, rasyon);
			preparedStatement.setString(4, deger);
			preparedStatement.setString(5, gunluk_gider);
			preparedStatement.setString(6, yillik_gider);
			preparedStatement.setString(7, fiyat);
			preparedStatement.setString(8, paket);
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
	public boolean deleteYem(int sira_no) {
		String query = "DELETE FROM yem WHERE sira_no = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, sira_no);
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
	public boolean updateYem(int sira_no, String tarih, String kapasite, String rasyon, String deger, String gunluk_gider,
			String yillik_gider, String fiyat, String paket) {
		String query = "UPDATE yem SET tarih = ?, kapasite = ?, rasyon = ?, deger = ?, gunluk_gider = ?, yillik_gider= ?, fiyat = ?, paket = ? WHERE sira_no = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tarih);
			preparedStatement.setString(2, kapasite);
			preparedStatement.setString(3, rasyon);
			preparedStatement.setString(4, deger);
			preparedStatement.setString(5, gunluk_gider);
			preparedStatement.setString(6, yillik_gider);
			preparedStatement.setString(7, fiyat);
			preparedStatement.setString(8, paket);
			preparedStatement.setInt(9, sira_no);
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
