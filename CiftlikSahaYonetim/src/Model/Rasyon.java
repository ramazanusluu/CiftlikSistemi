package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Rasyon {

	DBConnection conn = new DBConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	private int id;
	private String b_saman, b_kuruot, b_silaj, b_yem, d_saman, d_kuruot, d_silaj, d_yem, i_saman, i_kuruot, i_silaj, i_yem, saman, kuruot, silaj, yem;
	public Rasyon(int id, String b_saman, String b_kuruot, String b_silaj, String b_yem, String d_saman,
			String d_kuruot, String d_silaj, String d_yem, String i_saman, String i_kuruot, String i_silaj,
			String i_yem, String saman, String kuruot, String silaj, String yem) {
		super();
		this.id = id;
		this.b_saman = b_saman;
		this.b_kuruot = b_kuruot;
		this.b_silaj = b_silaj;
		this.b_yem = b_yem;
		this.d_saman = d_saman;
		this.d_kuruot = d_kuruot;
		this.d_silaj = d_silaj;
		this.d_yem = d_yem;
		this.i_saman = i_saman;
		this.i_kuruot = i_kuruot;
		this.i_silaj = i_silaj;
		this.i_yem = i_yem;
		this.saman = saman;
		this.kuruot = kuruot;
		this.silaj = silaj;
		this.yem = yem;
	}
	public Rasyon() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_saman() {
		return b_saman;
	}
	public void setB_saman(String b_saman) {
		this.b_saman = b_saman;
	}
	public String getB_kuruot() {
		return b_kuruot;
	}
	public void setB_kuruot(String b_kuruot) {
		this.b_kuruot = b_kuruot;
	}
	public String getB_silaj() {
		return b_silaj;
	}
	public void setB_silaj(String b_silaj) {
		this.b_silaj = b_silaj;
	}
	public String getB_yem() {
		return b_yem;
	}
	public void setB_yem(String b_yem) {
		this.b_yem = b_yem;
	}
	public String getD_saman() {
		return d_saman;
	}
	public void setD_saman(String d_saman) {
		this.d_saman = d_saman;
	}
	public String getD_kuruot() {
		return d_kuruot;
	}
	public void setD_kuruot(String d_kuruot) {
		this.d_kuruot = d_kuruot;
	}
	public String getD_silaj() {
		return d_silaj;
	}
	public void setD_silaj(String d_silaj) {
		this.d_silaj = d_silaj;
	}
	public String getD_yem() {
		return d_yem;
	}
	public void setD_yem(String d_yem) {
		this.d_yem = d_yem;
	}
	public String getI_saman() {
		return i_saman;
	}
	public void setI_saman(String i_saman) {
		this.i_saman = i_saman;
	}
	public String getI_kuruot() {
		return i_kuruot;
	}
	public void setI_kuruot(String i_kuruot) {
		this.i_kuruot = i_kuruot;
	}
	public String getI_silaj() {
		return i_silaj;
	}
	public void setI_silaj(String i_silaj) {
		this.i_silaj = i_silaj;
	}
	public String getI_yem() {
		return i_yem;
	}
	public void setI_yem(String i_yem) {
		this.i_yem = i_yem;
	}
	public String getSaman() {
		return saman;
	}
	public void setSaman(String saman) {
		this.saman = saman;
	}
	public String getKuruot() {
		return kuruot;
	}
	public void setKuruot(String kuruot) {
		this.kuruot = kuruot;
	}
	public String getSilaj() {
		return silaj;
	}
	public void setSilaj(String silaj) {
		this.silaj = silaj;
	}
	public String getYem() {
		return yem;
	}
	public void setYem(String yem) {
		this.yem = yem;
	}
	public ArrayList<Rasyon> getRasyonList() throws SQLException{
		ArrayList<Rasyon> list = new ArrayList<>();
		Rasyon obj;
		Connection con = conn.connDb();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT*FROM rasyon");
			while(rs.next()) {
				obj = new Rasyon();
				obj.setId(rs.getInt("id"));
				obj.setB_saman(rs.getString("b_saman"));
				obj.setB_kuruot(rs.getString("b_kuruot"));
				obj.setB_silaj(rs.getString("b_silaj"));
				obj.setB_yem(rs.getString("b_yem"));
				obj.setD_saman(rs.getString("d_saman"));
				obj.setD_kuruot(rs.getString("d_kuruot"));
				obj.setD_silaj(rs.getString("d_silaj"));
				obj.setD_yem(rs.getString("d_yem"));
				obj.setI_saman(rs.getString("i_saman"));
				obj.setI_kuruot(rs.getString("i_kuruot"));
				obj.setI_silaj(rs.getString("i_silaj"));
				obj.setI_yem(rs.getString("i_yem"));
				obj.setSaman(rs.getString("saman"));
				obj.setKuruot(rs.getString("kuruot"));
				obj.setSilaj(rs.getString("silaj"));
				obj.setYem(rs.getString("yem"));
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
	public boolean addRasyon(String b_saman, String b_kuruot, String b_silaj, String b_yem, String d_saman,
			String d_kuruot, String d_silaj, String d_yem, String i_saman, String i_kuruot, String i_silaj,
			String i_yem, String saman, String kuruot, String silaj, String yem) throws SQLException {

		String query = "INSERT INTO rasyon" + "(id, b_saman, b_kuruot, b_silaj, b_yem, d_saman, d_kuruot, d_silaj, d_yem, i_saman, i_kuruot, i_silaj, i_yem, saman, kuruot, silaj, yem ) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean key = false;
		Connection con = conn.connDb();
		int count = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM rasyon WHERE id = 1");
			while(rs.next()) {
				count++;
			}
			if(count == 0) {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, b_saman);
			preparedStatement.setString(3, b_kuruot);
			preparedStatement.setString(4, b_silaj);
			preparedStatement.setString(5, b_yem);
			preparedStatement.setString(6, d_saman);
			preparedStatement.setString(7, d_kuruot);
			preparedStatement.setString(8, d_silaj);
			preparedStatement.setString(9, d_yem);
			preparedStatement.setString(10, i_saman);
			preparedStatement.setString(11, i_kuruot);
			preparedStatement.setString(12, i_silaj);
			preparedStatement.setString(13, i_yem);
			preparedStatement.setString(14, saman);
			preparedStatement.setString(15, kuruot);
			preparedStatement.setString(16, silaj);
			preparedStatement.setString(17, yem);
			preparedStatement.executeUpdate();
			}
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else {
			return false;
		}
	}
	public boolean updateRasyon(String b_saman, String b_kuruot, String b_silaj, String b_yem, String d_saman,
			String d_kuruot, String d_silaj, String d_yem, String i_saman, String i_kuruot, String i_silaj,
			String i_yem, String saman, String kuruot, String silaj, String yem) {
		String query = "UPDATE rasyon SET b_saman = ?, b_kuruot = ?, b_silaj = ?, b_yem = ?, d_saman = ?, d_kuruot = ?, d_silaj = ?, d_yem = ?, i_saman = ?, i_kuruot = ?, i_silaj = ?, i_yem = ?, saman = ?, kuruot = ?, silaj = ?, yem = ? WHERE id = 1";
		Connection con = conn.connDb();
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, b_saman);
			preparedStatement.setString(2, b_kuruot);
			preparedStatement.setString(3, b_silaj);
			preparedStatement.setString(4, b_yem);
			preparedStatement.setString(5, d_saman);
			preparedStatement.setString(6, d_kuruot);
			preparedStatement.setString(7, d_silaj);
			preparedStatement.setString(8, d_yem);
			preparedStatement.setString(9, i_saman);
			preparedStatement.setString(10, i_kuruot);
			preparedStatement.setString(11, i_silaj);
			preparedStatement.setString(12, i_yem);
			preparedStatement.setString(13, saman);
			preparedStatement.setString(14, kuruot);
			preparedStatement.setString(15, silaj);
			preparedStatement.setString(16, yem);
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
