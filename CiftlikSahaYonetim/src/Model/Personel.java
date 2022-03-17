package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Personel {
	
	private int id;
	private String name, tcno, cinsiyet, telefon, adres, resim, baslama_tarih, gorev, maas, iban;
	

	DBConnection conn = new DBConnection();
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Personel(int id, String name, String tcno, String cinsiyet, String telefon, String adres, String resim,
			String baslama_tarih, String gorev, String maas, String iban) {
		
		this.id = id;
		this.name = name;
		this.tcno = tcno;
		this.cinsiyet = cinsiyet;
		this.telefon = telefon;
		this.adres = adres;
		this.resim = resim;
		this.baslama_tarih = baslama_tarih;
		this.gorev = gorev;
		this.maas = maas;
		this.iban = iban;
	}
	
	public Personel() {
		
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

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getResim() {
		return resim;
	}

	public void setResim(String resim) {
		this.resim = resim;
	}

	public String getBaslama_tarih() {
		return baslama_tarih;
	}

	public void setBaslama_tarih(String baslama_tarih) {
		this.baslama_tarih = baslama_tarih;
	}

	public String getGorev() {
		return gorev;
	}

	public void setGorev(String gorev) {
		this.gorev = gorev;
	}

	public String getMaas() {
		return maas;
	}

	public void setMaas(String maas) {
		this.maas = maas;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	
	public ArrayList<Personel> getPersonelList() throws SQLException{
		ArrayList<Personel> list = new ArrayList<>();
		Personel obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM personel");
			while(rs.next()) {
				obj = new Personel();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setTcno(rs.getString("tcno"));
				obj.setCinsiyet(rs.getString("cinsiyet"));
				obj.setTelefon(rs.getString("telefon"));
				obj.setAdres(rs.getString("adres"));
				obj.setResim(rs.getString("resim"));
				obj.setBaslama_tarih(rs.getString("baslama_tarih"));
				obj.setGorev(rs.getString("gorev"));
				obj.setMaas(rs.getString("maas"));
				obj.setIban(rs.getString("iban"));
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
	public boolean addPersonel(String name, String tcno, String cinsiyet, String telefon, String adres, String resim,
			String baslama_tarih, String gorev, String maas, String iban) {
		String query = "INSERT INTO personel"+"(name, tcno, cinsiyet, telefon, adres, resim, baslama_tarih, gorev, maas, iban) VALUES"+"(?,?,?,?,?,?,?,?,?,?)";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, cinsiyet);
			preparedStatement.setString(4, telefon);
			preparedStatement.setString(5, adres);
			preparedStatement.setString(6, resim);
			preparedStatement.setString(7, baslama_tarih);
			preparedStatement.setString(8, gorev);
			preparedStatement.setString(9, maas);
			preparedStatement.setString(10, iban);
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
	public boolean deletePersonel(int id) {
		String query = "DELETE FROM personel WHERE id = ?";
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
	public boolean updatePersonel(int id, String name, String tcno, String cinsiyet, String telefon, String adres, String resim,
			String baslama_tarih, String gorev, String maas, String iban) {
		String query = "UPDATE personel SET name = ?, tcno = ?, cinsiyet = ?, telefon = ?, adres = ?, resim = ?, baslama_tarih = ?, gorev = ?, maas = ?, iban = ?  WHERE id = ?";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			Statement st = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, tcno);
			preparedStatement.setString(3, cinsiyet);
			preparedStatement.setString(4, telefon);
			preparedStatement.setString(5, adres);
			preparedStatement.setString(6, resim);
			preparedStatement.setString(7, baslama_tarih);
			preparedStatement.setString(8, gorev);
			preparedStatement.setString(9, maas);
			preparedStatement.setString(10, iban);
			preparedStatement.setInt(11, id);
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
