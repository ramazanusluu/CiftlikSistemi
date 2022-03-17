package Helper;

public class itemyazdir {
	private int fatura_no;
	private String isletme_no, isletme_adi, isletme_adres, isletme_telefon, tahsilat_no, tarih, type, fiyat, kdv_fiyat, name, tcno, adres;
	public itemyazdir(int fatura_no, String isletme_no, String isletme_adi, String isletme_adres,
			String isletme_telefon, String tahsilat_no, String tarih, String type, String fiyat, String kdv_fiyat,
			String name, String tcno, String adres) {
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
	
	@Override
	public String toString() {
		return this.tahsilat_no;
	}
}
