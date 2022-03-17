package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Kuruot {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int sira_no;
	private String tarih, kapasite, rasyon, deger, gunluk_gider, yillik_gider, fiyat, kucuk_balya, buyuk_balya;
	public Kuruot(int sira_no, String tarih, String kapasite, String rasyon, String deger, String gunluk_gider,
			String yillik_gider, String fiyat, String kucuk_balya, String buyuk_balya) {
		super();
		this.sira_no = sira_no;
		this.tarih = tarih;
		this.kapasite = kapasite;
		this.rasyon = rasyon;
		this.deger = deger;
		this.gunluk_gider = gunluk_gider;
		this.yillik_gider = yillik_gider;
		this.fiyat = fiyat;
		this.kucuk_balya = kucuk_balya;
		this.buyuk_balya = buyuk_balya;
	}
	public Kuruot() {
		
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
	public String getKucuk_balya() {
		return kucuk_balya;
	}
	public void setKucuk_balya(String kucuk_balya) {
		this.kucuk_balya = kucuk_balya;
	}
	public String getBuyuk_balya() {
		return buyuk_balya;
	}
	public void setBuyuk_balya(String buyuk_balya) {
		this.buyuk_balya = buyuk_balya;
	}
	
	public ArrayList<Kuruot> getKuruotList() throws SQLException{
		ArrayList<Kuruot> list = new ArrayList<>();
		
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM kuru_ot ORDER BY sira_no ASC");
			while(rs.next()) {
				Kuruot obj = new Kuruot();
				obj.setSira_no(rs.getInt("sira_no"));
				obj.setTarih(rs.getString("tarih"));
				obj.setKapasite(rs.getString("kapasite"));
				obj.setRasyon(rs.getString("rasyon"));
				obj.setDeger(rs.getString("deger"));
				obj.setGunluk_gider(rs.getString("gunluk_gider"));
				obj.setYillik_gider(rs.getString("yillik_gider"));
				obj.setFiyat(rs.getString("fiyat"));
				obj.setKucuk_balya(rs.getString("kucuk_balya"));
				obj.setBuyuk_balya(rs.getString("buyuk_balya"));
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
	public boolean addKuruot(String tarih, String kapasite, String rasyon, String deger, String gunluk_gider,
			String yillik_gider, String fiyat, String kucuk_balya, String buyuk_balya) {
		String query = "INSERT INTO kuru_ot"+"(tarih, kapasite, rasyon, deger, gunluk_gider, yillik_gider, fiyat, kucuk_balya, buyuk_balya) VALUES"+"(?,?,?,?,?,?,?,?,?)";
	
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
			preparedStatement.setString(8, kucuk_balya);
			preparedStatement.setString(9, buyuk_balya);
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
	public boolean deleteKuruot(int sira_no) {
		String query = "DELETE FROM kuru_ot WHERE sira_no = ?";
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
	public boolean updateKuruot(int sira_no, String tarih, String kapasite, String rasyon, String deger, String gunluk_gider,
			String yillik_gider, String fiyat, String kucuk_balya, String buyuk_balya) {
		String query = "UPDATE kuru_ot SET tarih = ?, kapasite = ?, rasyon = ?, deger = ?, gunluk_gider = ?, yillik_gider= ?, fiyat = ?, kucuk_balya = ?, buyuk_balya = ? WHERE sira_no = ?";
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
			preparedStatement.setString(8, kucuk_balya);
			preparedStatement.setString(9, buyuk_balya);
			preparedStatement.setInt(10, sira_no);
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
