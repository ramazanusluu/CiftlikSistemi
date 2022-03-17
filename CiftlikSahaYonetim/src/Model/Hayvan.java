package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Hayvan {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	
	private int id;
	private String k_kupe_no, i_kupe_no, name, cinsi, cinsiyet, d_tarih, kayit_tarih, anne_küpe, anne_verim, baba_küpe, baba_verim, verim_puan, durum;
	public Hayvan(int id, String k_kupe_no, String i_kupe_no, String name, String cinsi, String cinsiyet,
			String d_tarih, String kayit_tarih, String anne_küpe, String anne_verim, String baba_küpe,
			String baba_verim, String verim_puan, String durum) {
		super();
		this.id = id;
		this.k_kupe_no = k_kupe_no;
		this.i_kupe_no = i_kupe_no;
		this.name = name;
		this.cinsi = cinsi;
		this.cinsiyet = cinsiyet;
		this.d_tarih = d_tarih;
		this.kayit_tarih = kayit_tarih;
		this.anne_küpe = anne_küpe;
		this.anne_verim = anne_verim;
		this.baba_küpe = baba_küpe;
		this.baba_verim = baba_verim;
		this.verim_puan = verim_puan;
		this.durum = durum;
	}
	public Hayvan() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getK_kupe_no() {
		return k_kupe_no;
	}
	public void setK_kupe_no(String k_kupe_no) {
		this.k_kupe_no = k_kupe_no;
	}
	public String getI_kupe_no() {
		return i_kupe_no;
	}
	public void setI_kupe_no(String i_kupe_no) {
		this.i_kupe_no = i_kupe_no;
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
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getD_tarih() {
		return d_tarih;
	}
	public void setD_tarih(String d_tarih) {
		this.d_tarih = d_tarih;
	}
	public String getKayit_tarih() {
		return kayit_tarih;
	}
	public void setKayit_tarih(String kayit_tarih) {
		this.kayit_tarih = kayit_tarih;
	}
	public String getAnne_küpe() {
		return anne_küpe;
	}
	public void setAnne_küpe(String anne_küpe) {
		this.anne_küpe = anne_küpe;
	}
	public String getAnne_verim() {
		return anne_verim;
	}
	public void setAnne_verim(String anne_verim) {
		this.anne_verim = anne_verim;
	}
	public String getBaba_küpe() {
		return baba_küpe;
	}
	public void setBaba_küpe(String baba_küpe) {
		this.baba_küpe = baba_küpe;
	}
	public String getBaba_verim() {
		return baba_verim;
	}
	public void setBaba_verim(String baba_verim) {
		this.baba_verim = baba_verim;
	}
	public String getVerim_puan() {
		return verim_puan;
	}
	public void setVerim_puan(String verim_puan) {
		this.verim_puan = verim_puan;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	public ArrayList<Hayvan> getHayvanList() throws SQLException{
		ArrayList<Hayvan> list = new ArrayList<>();
		Hayvan obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM hayvan ORDER BY id ASC");
			while(rs.next()) {
				obj = new Hayvan();
				obj.setId(rs.getInt("id"));
				obj.setK_kupe_no(rs.getString("k_kupe_no"));
				obj.setI_kupe_no(rs.getString("i_kupe_no"));
				obj.setName(rs.getString("name"));
				obj.setCinsi(rs.getString("cinsi"));
				obj.setCinsiyet(rs.getString("cinsiyet"));
				obj.setD_tarih(rs.getString("d_tarih"));
				obj.setKayit_tarih(rs.getString("kayit_tarih"));
				obj.setAnne_küpe(rs.getString("anne_kupe"));
				obj.setAnne_verim(rs.getString("anne_verim"));
				obj.setBaba_küpe(rs.getString("baba_kupe"));
				obj.setBaba_verim(rs.getString("baba_verim"));
				obj.setVerim_puan(rs.getString("verim_puan"));
				obj.setDurum(rs.getString("durum"));
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
	public ArrayList<Hayvan> getCanlihayvanList() throws SQLException{
		ArrayList<Hayvan> list = new ArrayList<>();
		Hayvan obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM hayvan WHERE durum = 'Canlý'");
			while(rs.next()) {
				obj = new Hayvan();
				obj.setId(rs.getInt("id"));
				obj.setK_kupe_no(rs.getString("k_kupe_no"));
				obj.setI_kupe_no(rs.getString("i_kupe_no"));
				obj.setName(rs.getString("name"));
				obj.setCinsi(rs.getString("cinsi"));
				obj.setCinsiyet(rs.getString("cinsiyet"));
				obj.setD_tarih(rs.getString("d_tarih"));
				obj.setKayit_tarih(rs.getString("kayit_tarih"));
				obj.setAnne_küpe(rs.getString("anne_kupe"));
				obj.setAnne_verim(rs.getString("anne_verim"));
				obj.setBaba_küpe(rs.getString("baba_kupe"));
				obj.setBaba_verim(rs.getString("baba_verim"));
				obj.setVerim_puan(rs.getString("verim_puan"));
				obj.setDurum(rs.getString("durum"));
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
	public boolean addHayvan(String k_kupe_no, String i_kupe_no, String name, String cinsi, String cinsiyet,
			String d_tarih, String kayit_tarih, String anne_küpe, String anne_verim, String baba_küpe,
			String baba_verim, String verim_puan, String durum) {
		String query = "INSERT INTO hayvan"+"(k_kupe_no, i_kupe_no, name, cinsi, cinsiyet, d_tarih, kayit_tarih, anne_kupe, anne_verim, baba_kupe, baba_verim, verim_puan, durum) VALUES"+"(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, k_kupe_no);
			preparedStatement.setString(2, i_kupe_no);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, cinsi);
			preparedStatement.setString(5, cinsiyet);
			preparedStatement.setString(6, d_tarih);
			preparedStatement.setString(7, kayit_tarih);
			preparedStatement.setString(8, anne_küpe);
			preparedStatement.setString(9, anne_verim);
			preparedStatement.setString(10, baba_küpe);
			preparedStatement.setString(11, baba_verim);
			preparedStatement.setString(12, verim_puan);
			preparedStatement.setString(13, durum);
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
	public boolean deleteHayvan(int id) {
		String query = "DELETE FROM hayvan WHERE id = ?";
	
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
	public boolean updateHayvan(int id, String k_kupe_no, String i_kupe_no, String name, String cinsi, String cinsiyet,
			String d_tarih, String kayit_tarih, String anne_küpe, String anne_verim, String baba_küpe,
			String baba_verim, String verim_puan) {
		String query = "UPDATE hayvan SET k_kupe_no = ?, i_kupe_no = ?, name = ?, cinsi = ?, cinsiyet = ?, d_tarih= ?, kayit_tarih = ?, anne_kupe = ?, anne_verim = ?, baba_kupe = ?, baba_verim = ?, verim_puan = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, k_kupe_no);
			preparedStatement.setString(2, i_kupe_no);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, cinsi);
			preparedStatement.setString(5, cinsiyet);
			preparedStatement.setString(6, d_tarih);
			preparedStatement.setString(7, kayit_tarih);
			preparedStatement.setString(8, anne_küpe);
			preparedStatement.setString(9, anne_verim);
			preparedStatement.setString(10, baba_küpe);
			preparedStatement.setString(11, baba_verim);
			preparedStatement.setString(12, verim_puan);
			preparedStatement.setInt(13, id);
		
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
	public boolean updatedurum(int id, String durum) {
		String query = "UPDATE hayvan SET durum = ? WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, durum);
			preparedStatement.setInt(2, id);
		
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
	
	public Hayvan getFetch(int id) {
		Connection con = conn.connDb();
		Hayvan h = new Hayvan();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM hayvan WHERE id = " + id);
			while(rs.next()) {
				h.setId(rs.getInt("id"));
				h.setK_kupe_no(rs.getString("k_kupe_no"));
				h.setI_kupe_no(rs.getString("i_kupe_no"));
				h.setName(rs.getString("name"));
				h.setCinsi(rs.getString("cinsi"));
				h.setCinsiyet(rs.getString("cinsiyet"));
				h.setD_tarih(rs.getString("d_tarih"));
				h.setKayit_tarih(rs.getString("kayit_tarih"));
				h.setAnne_küpe(rs.getString("anne_kupe"));
				h.setAnne_verim(rs.getString("anne_verim"));
				h.setBaba_küpe(rs.getString("baba_kupe"));
				h.setBaba_verim(rs.getString("baba_verim"));
				h.setVerim_puan(rs.getString("verim_puan"));
				h.setDurum(rs.getString("durum"));
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}
	

}
