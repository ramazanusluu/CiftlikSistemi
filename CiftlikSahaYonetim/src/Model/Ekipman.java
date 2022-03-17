package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Ekipman {
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private int id;
	private String name, cinsi, marka, model, fiyat, alim_tarihi, alan_personel, kullanim_amaci;
	public Ekipman(int id, String name, String cinsi, String marka, String model, String fiyat, String alim_tarihi,
			String alan_personel, String kullanim_amaci) {
		super();
		this.id = id;
		this.name = name;
		this.cinsi = cinsi;
		this.marka = marka;
		this.model = model;
		this.fiyat = fiyat;
		this.alim_tarihi = alim_tarihi;
		this.alan_personel = alan_personel;
		this.kullanim_amaci = kullanim_amaci;
	}
	public Ekipman() {
		
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
	public String getCinsi() {
		return cinsi;
	}
	public void setCinsi(String cinsi) {
		this.cinsi = cinsi;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getAlim_tarihi() {
		return alim_tarihi;
	}
	public void setAlim_tarihi(String alim_tarihi) {
		this.alim_tarihi = alim_tarihi;
	}
	public String getAlan_personel() {
		return alan_personel;
	}
	public void setAlan_personel(String alan_personel) {
		this.alan_personel = alan_personel;
	}
	public String getKullanim_amaci() {
		return kullanim_amaci;
	}
	public void setKullanim_amaci(String kullanim_amaci) {
		this.kullanim_amaci = kullanim_amaci;
	}
	public ArrayList<Ekipman> getEkipmanList() throws SQLException{
		ArrayList<Ekipman> list = new ArrayList<>();
		Ekipman obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM ekipman ORDER BY id ASC");
			while(rs.next()) {
				obj = new Ekipman();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setCinsi(rs.getString("cinsi"));
				obj.setMarka(rs.getString("marka"));
				obj.setModel(rs.getString("model"));
				obj.setFiyat(rs.getString("fiyat"));
				obj.setAlim_tarihi(rs.getString("alim_tarihi"));
				obj.setAlan_personel(rs.getString("alan_personel"));
				obj.setKullanim_amaci(rs.getString("kullanim_amaci"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addEkipman(String name, String cinsi, String marka, String model, String fiyat, String alim_tarihi,
			String alan_personel, String kullanim_amaci) {
		String query = "INSERT INTO ekipman"+"(name, cinsi, marka, model, fiyat, alim_tarihi, alan_personel, kullanim_amaci) VALUES"+"(?,?,?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, cinsi);
			preparedStatement.setString(3, marka);
			preparedStatement.setString(4, model);
			preparedStatement.setString(5, fiyat);
			preparedStatement.setString(6, alim_tarihi);
			preparedStatement.setString(7, alan_personel);
			preparedStatement.setString(8, kullanim_amaci);
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
	
	public boolean deleteEkipman(int id) {
		String query = "DELETE FROM ekipman WHERE id = ?";
	
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
	
	public boolean updateEkipman(int id, String name, String cinsi, String marka, String model, String fiyat, String alim_tarihi,
			String alan_personel, String kullanim_amaci) {
		String query = "UPDATE ekipman SET name = ?, cinsi = ?, marka = ?, model = ?, fiyat = ?, alim_tarihi= ?, alan_personel = ?, kullanim_amaci = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, cinsi);
			preparedStatement.setString(3, marka);
			preparedStatement.setString(4, model);
			preparedStatement.setString(5, fiyat);
			preparedStatement.setString(6, alim_tarihi);
			preparedStatement.setString(7, alan_personel);
			preparedStatement.setString(8, kullanim_amaci);
			preparedStatement.setInt(9, id);
		
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
