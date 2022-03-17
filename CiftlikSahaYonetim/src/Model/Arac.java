package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Arac {

	private int id;
	private String plaka, cinsi, sofor_ad, sofor_tc, gelis_tarih, gelis_sebep;
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Arac(int id, String plaka, String cinsi, String sofor_ad, String sofor_tc, String gelis_tarih, String gelis_sebep) {
		super();
		this.id = id;
		this.plaka = plaka;
		this.cinsi = cinsi;
		this.sofor_ad = sofor_ad;
		this.sofor_tc = sofor_tc;
		this.gelis_tarih = gelis_tarih;
		this.gelis_sebep = gelis_sebep;
	}
	public Arac() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaka() {
		return plaka;
	}
	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	public String getCinsi() {
		return cinsi;
	}
	public void setCinsi(String cinsi) {
		this.cinsi = cinsi;
	}
	public String getSofor_ad() {
		return sofor_ad;
	}
	public void setSofor_ad(String sofor_ad) {
		this.sofor_ad = sofor_ad;
	}
	public String getSofor_tc() {
		return sofor_tc;
	}
	public void setSofor_tc(String sofor_tc) {
		this.sofor_tc = sofor_tc;
	}
	public String getGelis_tarih() {
		return gelis_tarih;
	}
	public void setGelis_tarih(String gelis_tarih) {
		this.gelis_tarih = gelis_tarih;
	}
	public String getGelis_sebep() {
		return gelis_sebep;
	}
	public void setGelis_sebep(String gelis_sebep) {
		this.gelis_sebep = gelis_sebep;
	}
	public ArrayList<Arac> getAracList() throws SQLException{
		ArrayList<Arac> list = new ArrayList<>();
		Arac obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM misafir_arac");
			while(rs.next()) {
				obj = new Arac();
				obj.setId(rs.getInt("id"));
				obj.setPlaka(rs.getString("plaka"));
				obj.setCinsi(rs.getString("cinsi"));
				obj.setSofor_ad(rs.getString("sofor_ad"));
				obj.setSofor_tc(rs.getString("sofor_tc"));
				obj.setGelis_tarih(rs.getString("gelis_tarih"));
				obj.setGelis_sebep(rs.getString("gelis_sebep"));
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
	public boolean addArac(String plaka, String cinsi, String sofor_ad, String sofor_tc, String gelis_tarih, String gelis_sebep) {
		String query = "INSERT INTO misafir_arac"+"(plaka, cinsi, sofor_ad, sofor_tc, gelis_tarih, gelis_sebep) VALUES"+"(?,?,?,?,?,?)";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, plaka);
			preparedStatement.setString(2, cinsi);
			preparedStatement.setString(3, sofor_ad);
			preparedStatement.setString(4, sofor_tc);
			preparedStatement.setString(5, gelis_tarih);
			preparedStatement.setString(6, gelis_sebep);
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
	public boolean deleteArac(int id) {
		String query = "DELETE FROM misafir_arac WHERE id = ?";
	
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
	public boolean updateArac(int id, String plaka, String cinsi, String sofor_ad, String sofor_tc, String gelis_tarih, String gelis_sebep) {
		String query = "UPDATE misafir_arac SET plaka = ?, cinsi = ?, sofor_ad = ?, sofor_tc = ?, gelis_tarih = ?, gelis_sebep = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, plaka);
			preparedStatement.setString(2, cinsi);
			preparedStatement.setString(3, sofor_ad);
			preparedStatement.setString(4, sofor_tc);
			preparedStatement.setString(5, gelis_tarih);
			preparedStatement.setString(6, gelis_sebep);
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
