package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Fatura {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int fatura_no;
	private String isletme_no, isletme_adi, isletme_adres, isletme_telefon, tahsilat_no, tarih, type, fiyat, kdv_fiyat, name, tcno, adres;
	public Fatura(int fatura_no, String isletme_no, String isletme_adi, String isletme_adres, String isletme_telefon,
			String tahsilat_no, String tarih, String type, String fiyat, String kdv_fiyat, String name, String tcno,
			String adres) {
		super();
		this.fatura_no = fatura_no;
		this.isletme_no = isletme_no;
		this.isletme_adi = isletme_adi;
		this.isletme_adres = isletme_adres;
		this.isletme_telefon = isletme_telefon;
		this.tahsilat_no = tahsilat_no;
		this.tarih = tarih;
		this.type = type;
		this.fiyat = fiyat;
		this.kdv_fiyat = kdv_fiyat;
		this.name = name;
		this.tcno = tcno;
		this.adres = adres;
	}
	public Fatura() {
		
	}
	public int getFatura_no() {
		return fatura_no;
	}
	public void setFatura_no(int fatura_no) {
		this.fatura_no = fatura_no;
	}
	public String getIsletme_no() {
		return isletme_no;
	}
	public void setIsletme_no(String isletme_no) {
		this.isletme_no = isletme_no;
	}
	public String getIsletme_adi() {
		return isletme_adi;
	}
	public void setIsletme_adi(String isletme_adi) {
		this.isletme_adi = isletme_adi;
	}
	public String getIsletme_adres() {
		return isletme_adres;
	}
	public void setIsletme_adres(String isletme_adres) {
		this.isletme_adres = isletme_adres;
	}
	public String getIsletme_telefon() {
		return isletme_telefon;
	}
	public void setIsletme_telefon(String isletme_telefon) {
		this.isletme_telefon = isletme_telefon;
	}
	public String getTahsilat_no() {
		return tahsilat_no;
	}
	public void setTahsilat_no(String tahsilat_no) {
		this.tahsilat_no = tahsilat_no;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getKdv_fiyat() {
		return kdv_fiyat;
	}
	public void setKdv_fiyat(String kdv_fiyat) {
		this.kdv_fiyat = kdv_fiyat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public ArrayList<Fatura> getFaturaList() throws SQLException{
		ArrayList<Fatura> list = new ArrayList<>();
		
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM fatura ORDER BY fatura_no ASC");
			while(rs.next()) {
				Fatura obj = new Fatura();
				obj.setFatura_no(rs.getInt("fatura_no"));
				obj.setIsletme_no(rs.getString("isletme_no"));
				obj.setIsletme_adi(rs.getString("isletme_adi"));
				obj.setIsletme_adres(rs.getString("isletme_adres"));
				obj.setIsletme_telefon(rs.getString("isletme_telefon"));
				obj.setTahsilat_no(rs.getString("tahsilat_no"));
				obj.setTarih(rs.getString("tarih"));
				obj.setType(rs.getString("type"));
				obj.setFiyat(rs.getString("fiyat"));
				obj.setKdv_fiyat(rs.getString("kdv_fiyat"));
				obj.setName(rs.getString("name"));
				obj.setTcno(rs.getString("tcno"));
				obj.setAdres(rs.getString("adres"));
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
	public boolean addFatura(String isletme_no, String isletme_adi, String isletme_adres, String isletme_telefon,
			String tahsilat_no, String tarih, String type, String fiyat, String kdv_fiyat, String name, String tcno,
			String adres) {
		String query = "INSERT INTO fatura"+"(isletme_no, isletme_adi, isletme_adres, isletme_telefon, tahsilat_no, tarih, type, fiyat, kdv_fiyat, name, tcno, adres) VALUES"+"(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, isletme_no);
			preparedStatement.setString(2, isletme_adi);
			preparedStatement.setString(3, isletme_adres);
			preparedStatement.setString(4, isletme_telefon);
			preparedStatement.setString(5, tahsilat_no);
			preparedStatement.setString(6, tarih);
			preparedStatement.setString(7, type);
			preparedStatement.setString(8, fiyat);
			preparedStatement.setString(9, kdv_fiyat);
			preparedStatement.setString(10, name);
			preparedStatement.setString(11, tcno);
			preparedStatement.setString(12, adres);
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
	public boolean deleteFatura(int fatura_no) {
		String query = "DELETE FROM fatura WHERE fatura_no = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, fatura_no);
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
	public boolean updateFatura(int fatura_no, String isletme_no, String isletme_adi, String isletme_adres, String isletme_telefon,
			String tahsilat_no, String tarih, String type, String fiyat, String kdv_fiyat, String name, String tcno,
			String adres) {
		String query = "UPDATE fatura SET isletme_no = ?, isletme_adi = ?, isletme_adres = ?, isletme_telefon = ?, tahsilat_no = ?, tarih = ?, type= ?, fiyat = ?, kdv_fiyat = ?, name = ?, tcno = ?, adres = ? WHERE fatura_no = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, isletme_no);
			preparedStatement.setString(2, isletme_adi);
			preparedStatement.setString(3, isletme_adres);
			preparedStatement.setString(4, isletme_telefon);
			preparedStatement.setString(5, tahsilat_no);
			preparedStatement.setString(6, tarih);
			preparedStatement.setString(7, type);
			preparedStatement.setString(8, fiyat);
			preparedStatement.setString(9, kdv_fiyat);
			preparedStatement.setString(10, name);
			preparedStatement.setString(11, tcno);
			preparedStatement.setString(12, adres);
			preparedStatement.setInt(13, fatura_no);
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
