package Helper;

public class Itemhayvan {
	
	private int id;
	private String k_küpe_no, i_kupe_no, cinsi, cinsiyet;
	public Itemhayvan(int id, String k_küpe_no, String i_kupe_no, String cinsi, String cinsiyet) {
		super();
		this.id = id;
		this.k_küpe_no = k_küpe_no;
		this.i_kupe_no = i_kupe_no;
		this.cinsi = cinsi;
		this.cinsiyet = cinsiyet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getK_küpe_no() {
		return k_küpe_no;
	}
	public void setK_küpe_no(String k_küpe_no) {
		this.k_küpe_no = k_küpe_no;
	}
	public String getI_kupe_no() {
		return i_kupe_no;
	}
	public void setI_kupe_no(String i_kupe_no) {
		this.i_kupe_no = i_kupe_no;
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
	
	@Override
	public String toString() {
		return this.k_küpe_no;
	}
	
	

}
