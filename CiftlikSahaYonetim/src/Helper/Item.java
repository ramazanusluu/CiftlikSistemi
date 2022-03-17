package Helper;

public class Item {
	
	private int id;
	private String name, tcno, telefon, adres;
	public Item(int id, String name, String tcno, String telefon, String adres) {
		super();
		this.id = id;
		this.name = name;
		this.tcno = tcno;
		this.telefon = telefon;
		this.adres = adres;
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
	
	@Override
	public String toString() {
		return this.name;
		
	}
	
	
}
