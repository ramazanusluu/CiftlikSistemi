package Helper;

public class Itemfatura {
	
	private int sira_no;
	private String tahsilat, tarih, type, fiyat, name, tcno, adres;
	public Itemfatura(int sira_no, String tahsilat, String tarih, String type, String fiyat, String name, String tcno,
			String adres) {
		super();
		this.sira_no = sira_no;
		this.tahsilat = tahsilat;
		this.tarih = tarih;
		this.type = type;
		this.fiyat = fiyat;
		this.name = name;
		this.tcno = tcno;
		this.adres = adres;
	}
	public int getSira_no() {
		return sira_no;
	}
	public void setSira_no(int sira_no) {
		this.sira_no = sira_no;
	}
	public String getTahsilat() {
		return tahsilat;
	}
	public void setTahsilat(String tahsilat) {
		this.tahsilat = tahsilat;
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
	
	
	@Override
	public String toString() {
		return this.tahsilat;
	}
	
	
	

}
