package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Ilac {
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int id;
	private String kayit_tarih, name, miktar, type, saklama, son_kullanim, veteriner;
	public Ilac(int id, String kayit_tarih, String name, String miktar, String type, String saklama,
			String son_kullanim, String veteriner) {
		super();
		this.id = id;
		this.kayit_tarih = kayit_tarih;
		this.name = name;
		this.miktar = miktar;
		this.type = type;
		this.saklama = saklama;
		this.son_kullanim = son_kullanim;
		this.veteriner = veteriner;
	}
	public Ilac() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKayit_tarih() {
		return kayit_tarih;
	}
	public void setKayit_tarih(String kayit_tarih) {
		this.kayit_tarih = kayit_tarih;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiktar() {
		return miktar;
	}
	public void setMiktar(String miktar) {
		this.miktar = miktar;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSaklama() {
		return saklama;
	}
	public void setSaklama(String saklama) {
		this.saklama = saklama;
	}
	public String getSon_kullanim() {
		return son_kullanim;
	}
	public void setSon_kullanim(String son_kullanim) {
		this.son_kullanim = son_kullanim;
	}
	public String getVeteriner() {
		return veteriner;
	}
	public void setVeteriner(String veteriner) {
		this.veteriner = veteriner;
	}
	public ArrayList<Ilac> getIlacList() throws SQLException{
		ArrayList<Ilac> list = new ArrayList<>();
		Ilac obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM ilac_depo");
			while(rs.next()) {
				obj = new Ilac();
				obj.setId(rs.getInt("id"));
				obj.setKayit_tarih(rs.getString("kayit_tarih"));
				obj.setName(rs.getString("name"));
				obj.setMiktar(rs.getString("miktar"));
				obj.setType(rs.getString("type"));
				obj.setSaklama(rs.getString("saklama"));
				obj.setSon_kullanim(rs.getString("son_kullanim"));
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
	public boolean addIlac(String kayit_tarih, String name, String miktar, String type, String saklama,
			String son_kullanim, String veteriner) {
		String query = "INSERT INTO ilac_depo"+"(kayit_tarih, name, miktar, type, saklama, son_kullanim, veteriner) VALUES"+"(?,?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kayit_tarih);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, miktar);
			preparedStatement.setString(4, type);
			preparedStatement.setString(5, saklama);
			preparedStatement.setString(6, son_kullanim);
			preparedStatement.setString(7, veteriner);
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
	public boolean deleteIlac(int id) {
		String query = "DELETE FROM ilac_depo WHERE id = ?";
	
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
	public boolean updateIlac(int id, String kayit_tarih, String name, String miktar, String type, String saklama,
			String son_kullanim) {
		String query = "UPDATE ilac_depo SET kayit_tarih = ?, name = ?, miktar = ?, type = ?, saklama = ?, son_kullanim = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kayit_tarih);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, miktar);
			preparedStatement.setString(4, type);
			preparedStatement.setString(5, saklama);
			preparedStatement.setString(6, son_kullanim);
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
