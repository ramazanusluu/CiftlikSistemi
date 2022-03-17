package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.Fatura;
import Model.Gelir;
import Model.Gider;
import Model.Kullanici;
import Model.Musterigelir;
import Model.Musterigider;
import Model.Personel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import Helper.*;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class KazancGUI extends JFrame {
	static Kullanici kullanici = new Kullanici();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	Gelir gelir = new Gelir();
	Gider gider = new Gider();
	Musterigelir mgelir = new Musterigelir();
	Musterigider mgider = new Musterigider();
	Personel personel = new Personel();
	Fatura fatura = new Fatura();
	
	private JPanel contentPane;
	private JTextField fld_miktar;
	private JTextField fld_personel;
	private JTextField fld_gelirsira;
	private JTable table_gelir;
	private DefaultTableModel gelirModel = null;
	private Object[]  gelirData = null;
	private JTextField fld_gidermiktar;
	private JTextField fld_verenpersonel;
	private JTextField fld_vsira;
	private JTable table_gider;
	private DefaultTableModel giderModel = null;
	private Object[]  giderData = null;
	private JTable table_fatura;
	private JTextField fld_faturasil;
	private JTextField fld_tahsilat;
	private DefaultTableModel faturaModel = null;
	private Object[]  faturaData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KazancGUI frame = new KazancGUI(kullanici);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public KazancGUI(Kullanici kullanici) throws SQLException {
		gelirModel = new DefaultTableModel();
		Object[] colGelirName = new Object[10];
		colGelirName[0] = "Sýra No";
		colGelirName[1] = "Tarih";
		colGelirName[2] = "Gelir Türü";
		colGelirName[3] = "Miktar";
		colGelirName[4] = "Personel";
		colGelirName[5] = "Tahsilat No";
		colGelirName[6] = "Adý Soyadý";
		colGelirName[7] = "TC No/Vergi No";
		colGelirName[8] = "Telefon";
		colGelirName[9] = "Adres";
		gelirModel.setColumnIdentifiers(colGelirName);
		gelirData = new Object[10];
		for(int i = 0; i < gelir.getGelirList().size(); i++) {
			gelirData[0] = gelir.getGelirList().get(i).getSira_no();
			gelirData[1] = gelir.getGelirList().get(i).getTarih();
			gelirData[2] = gelir.getGelirList().get(i).getGelir_type();
			gelirData[3] = gelir.getGelirList().get(i).getMiktar();
			gelirData[4] = gelir.getGelirList().get(i).getPersonel();
			gelirData[5] = gelir.getGelirList().get(i).getTahsilat();
			gelirData[6] = gelir.getGelirList().get(i).getName();
			gelirData[7] = gelir.getGelirList().get(i).getTcno();
			gelirData[8] = gelir.getGelirList().get(i).getTelefon();
			gelirData[9] = gelir.getGelirList().get(i).getAdres();
			gelirModel.addRow(gelirData);
			
		}
		giderModel = new DefaultTableModel();
		Object[] colGiderName = new Object[10];
		colGiderName[0] = "Sýra No";
		colGiderName[1] = "Tarih";
		colGiderName[2] = "Gider Türü";
		colGiderName[3] = "Miktar";
		colGiderName[4] = "Personel";
		colGiderName[5] = "Tahsilat No";
		colGiderName[6] = "Adý Soyadý";
		colGiderName[7] = "TC No/Vergi No";
		colGiderName[8] = "Telefon";
		colGiderName[9] = "Adres";
		giderModel.setColumnIdentifiers(colGiderName);
		giderData = new Object[10];
		for(int j = 0; j < gider.getGiderList().size(); j++) {
			giderData[0] = gider.getGiderList().get(j).getSira_no();
			giderData[1] = gider.getGiderList().get(j).getTarih();
			giderData[2] = gider.getGiderList().get(j).getGider_type();
			giderData[3] = gider.getGiderList().get(j).getMiktar();
			giderData[4] = gider.getGiderList().get(j).getPersonel();
			giderData[5] = gider.getGiderList().get(j).getTahsilat();
			giderData[6] = gider.getGiderList().get(j).getName();
			giderData[7] = gider.getGiderList().get(j).getTcno();
			giderData[8] = gider.getGiderList().get(j).getTelefon();
			giderData[9] = gider.getGiderList().get(j).getAdres();
			giderModel.addRow(giderData);
		}
		
		faturaModel = new DefaultTableModel();
		Object[] colFaturaName = new Object[13];
		colFaturaName[0] = "Fatura NO";
		colFaturaName[1] = "Ýþletme NO";
		colFaturaName[2] = "Ýþletme Adý";
		colFaturaName[3] = "Ýþletme Adres";
		colFaturaName[4] = "Ýþletme Telefon";
		colFaturaName[5] = "Tasilat NO";
		colFaturaName[6] = "Tarih";
		colFaturaName[7] = "Tür";
		colFaturaName[8] = "Fiyat";
		colFaturaName[9] = "Kdv'li Fiyat";
		colFaturaName[10] = "Ýsim";
		colFaturaName[11] = "TC no/Vergi no";
		colFaturaName[12] = "Adres";
		faturaModel.setColumnIdentifiers(colFaturaName);
		faturaData = new Object[13];
		for(int n = 0; n<fatura.getFaturaList().size(); n++) {
			faturaData[0] = fatura.getFaturaList().get(n).getFatura_no();
			faturaData[1] = fatura.getFaturaList().get(n).getIsletme_no();
			faturaData[2] = fatura.getFaturaList().get(n).getIsletme_adi();
			faturaData[3] = fatura.getFaturaList().get(n).getIsletme_adres();
			faturaData[4] = fatura.getFaturaList().get(n).getIsletme_telefon();
			faturaData[5] = fatura.getFaturaList().get(n).getTahsilat_no();
			faturaData[6] = fatura.getFaturaList().get(n).getTarih();
			faturaData[7] = fatura.getFaturaList().get(n).getType();
			faturaData[8] = fatura.getFaturaList().get(n).getFiyat();
			faturaData[9] = fatura.getFaturaList().get(n).getKdv_fiyat();
			faturaData[10] = fatura.getFaturaList().get(n).getName();
			faturaData[11] = fatura.getFaturaList().get(n).getTcno();
			faturaData[12] = fatura.getFaturaList().get(n).getAdres();
			faturaModel.addRow(faturaData);
		}
		
		setTitle("GEL\u0130R-G\u0130DER EKRANI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(KazancGUI.class.getResource("/View/uygulama.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 : " + kullanici.getName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 310, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(617, 10, 75, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAnaMen = new JButton("Ana Men\u00FC");
		btnAnaMen.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/out.png")));
		btnAnaMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AnaGUI agui = new AnaGUI(kullanici);
					agui.setVisible(true);
					dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 55, 1265, 646);
		contentPane.add(tabbedPane);
		
		JPanel panel_gelir = new JPanel();
		panel_gelir.setForeground(Color.BLACK);
		panel_gelir.setBackground(Color.WHITE);
		tabbedPane.addTab("GELÝR", null, panel_gelir, null);
		panel_gelir.setLayout(null);
		
		JScrollPane scrollPane_gelir = new JScrollPane();
		scrollPane_gelir.setBounds(324, 10, 926, 599);
		panel_gelir.add(scrollPane_gelir);
		
		table_gelir = new JTable(gelirModel);
		scrollPane_gelir.setViewportView(table_gelir);
		table_gelir.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_gelirsira.setText(table_gelir.getValueAt(table_gelir.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_gelir.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
				if(e.getType() == TableModelEvent.UPDATE) {
				int selectsira = Integer.parseInt(table_gelir.getValueAt(table_gelir.getSelectedRow(), 0).toString());
				String selectTarih = table_gelir.getValueAt(table_gelir.getSelectedRow(), 1).toString();
				String selectType = table_gelir.getValueAt(table_gelir.getSelectedRow(), 2).toString();
				String selectMiktar = table_gelir.getValueAt(table_gelir.getSelectedRow(), 3).toString();
				String selectPersonel = table_gelir.getValueAt(table_gelir.getSelectedRow(), 4).toString();
				String selectTahsilat = table_gelir.getValueAt(table_gelir.getSelectedRow(), 5).toString();
				String selectName = table_gelir.getValueAt(table_gelir.getSelectedRow(), 6).toString();
				String selectTcno = table_gelir.getValueAt(table_gelir.getSelectedRow(), 7).toString();
				String selectTel = table_gelir.getValueAt(table_gelir.getSelectedRow(), 8).toString();
				String selectAdres = table_gelir.getValueAt(table_gelir.getSelectedRow(), 9).toString();
				
				try {
					boolean control = gelir.updateGelir(selectsira, selectTarih, selectType, selectMiktar, selectPersonel, selectTahsilat, selectName, selectTcno, selectTel, selectAdres);
					if(control) {
						Helper.showMsg("success");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/analist.png")));
		lblNewLabel_2.setBounds(127, 10, 82, 74);
		panel_gelir.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Gelir Bilgilerini Giriniz");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1.setBounds(76, 94, 175, 41);
		panel_gelir.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Tarih : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 146, 104, 33);
		panel_gelir.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gelir T\u00FCr\u00FC : ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 178, 104, 33);
		panel_gelir.add(lblNewLabel_4);
		
		JComboBox comboBox_gelir = new JComboBox();
		comboBox_gelir.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "Hayvan Sat\u0131\u015F\u0131", "S\u00FCt Sat\u0131\u015F\u0131", "Et Sat\u0131\u015F\u0131"}));
		comboBox_gelir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_gelir.setBackground(Color.WHITE);
		comboBox_gelir.setBounds(154, 184, 136, 21);
		panel_gelir.add(comboBox_gelir);
		
		JLabel lblNewLabel_5 = new JLabel("Gelir Mikar\u0131 : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 210, 104, 33);
		panel_gelir.add(lblNewLabel_5);
		
		fld_miktar = new JTextField();
		fld_miktar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_miktar.setColumns(10);
		fld_miktar.setBounds(154, 213, 136, 19);
		panel_gelir.add(fld_miktar);
		fld_miktar.addKeyListener(kl);
		
		JLabel lblNewLabel_6 = new JLabel("Alan Personel : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 274, 104, 33);
		panel_gelir.add(lblNewLabel_6);
		
		fld_personel = new JTextField();
		fld_personel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_personel.setColumns(10);
		fld_personel.setBounds(154, 280, 136, 19);
		panel_gelir.add(fld_personel);
		fld_personel.setText(kullanici.getName());
		fld_personel.addKeyListener(hl);
		fld_personel.addKeyListener(kl);
		
		fld_tahsilat = new JTextField();
		fld_tahsilat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_tahsilat.setColumns(10);
		fld_tahsilat.setBounds(154, 248, 136, 19);
		panel_gelir.add(fld_tahsilat);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(154, 154, 136, 19);
		panel_gelir.add(dateChooser);
		/*, mgelir.getMusteriList().get(j).getTcno(), mgelir.getMusteriList().get(j).getTelefon(), mgelir.getMusteriList().get(j).getAdres()*/
		
		JComboBox comboBox_musteri = new JComboBox();
		comboBox_musteri.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_musteri.setBackground(Color.WHITE);
		comboBox_musteri.setBounds(76, 358, 161, 27);
		for(int j = 0; j<mgelir.getMusteriList().size(); j++) {
			comboBox_musteri.addItem(new Item(mgelir.getMusteriList().get(j).getId(), mgelir.getMusteriList().get(j).getName(), mgelir.getMusteriList().get(j).getTcno(), mgelir.getMusteriList().get(j).getTelefon(), mgelir.getMusteriList().get(j).getAdres()));
		}
		comboBox_musteri.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			System.out.println(item.getId() + " : " + item.getName() + " - " + item.getTcno() + " - " + item.getTelefon() + " - " + item.getAdres());
		});
		panel_gelir.add(comboBox_musteri);
		
		
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = comboBox_gelir.getSelectedItem().toString();
				Item item = (Item) comboBox_musteri.getSelectedItem();
				String name = item.getName();
				String tcno = item.getTcno();
				String telefon = item.getTelefon();
				String adres = item.getAdres();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(dateChooser.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date.length() == 0  ) {
					Helper.showMsg("Lütfen geçerli bir tarih seçiniz !");
				}
				else {
					if(type.equals("Seçiniz") || fld_miktar.getText().length() == 0 || fld_personel.getText().length() == 0 || fld_tahsilat.getText().length() == 0) {
						Helper.showMsg("fill");
					}else {
						
						try {
							boolean control = gelir.addGelir(date, type,  fld_miktar.getText(), fld_personel.getText(), fld_tahsilat.getText(), name, tcno, telefon, adres );
							if(control) {
								Helper.showMsg("success");
								fld_miktar.setText(null);
								updateGelirModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_kaydet.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setBounds(96, 414, 122, 27);
		panel_gelir.add(btn_kaydet);
		
		JLabel lblNewLabel_7_3 = new JLabel("S\u0131ra No : ");
		lblNewLabel_7_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_3.setBounds(10, 558, 72, 33);
		panel_gelir.add(lblNewLabel_7_3);
		
		fld_gelirsira = new JTextField();
		fld_gelirsira.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_gelirsira.setColumns(10);
		fld_gelirsira.setBounds(76, 564, 109, 19);
		panel_gelir.add(fld_gelirsira);
		
		JButton btn_sil = new JButton("Sil");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_gelirsira.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir deðer giriniz !");
				}else {
					int selectsira = Integer.parseInt(fld_gelirsira.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = gelir.deleteGelir(selectsira);
							if(control) {
								Helper.showMsg("success");
								fld_gelirsira.setText(null);
								updateGelirModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/delete.png")));
		btn_sil.setForeground(Color.RED);
		btn_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil.setBackground(Color.WHITE);
		btn_sil.setBounds(205, 562, 85, 21);
		panel_gelir.add(btn_sil);
		
		JButton btn_kaydet_2 = new JButton("M\u00FC\u015Fteri Kay\u0131t");
		btn_kaydet_2.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/login.png")));
		btn_kaydet_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MusterikayitGUI mkayit = new MusterikayitGUI(kullanici);
					mkayit.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btn_kaydet_2.setForeground(Color.BLUE);
		btn_kaydet_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet_2.setBackground(Color.WHITE);
		btn_kaydet_2.setBounds(76, 483, 161, 27);
		panel_gelir.add(btn_kaydet_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("M\u00FC\u015Fteri se\u00E7iniz ; ");
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1_1.setBounds(10, 307, 175, 41);
		panel_gelir.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Tahsilat No :");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_2.setBounds(10, 242, 104, 33);
		panel_gelir.add(lblNewLabel_5_2);
		
		
		JPanel panel_gider = new JPanel();
		panel_gider.setBackground(Color.WHITE);
		tabbedPane.addTab("GÝDER", null, panel_gider, null);
		panel_gider.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/azalan.png")));
		lblNewLabel_2_2.setBounds(127, 10, 82, 74);
		panel_gider.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Gider Bilgilerini Giriniz");
		lblNewLabel_2_1_2.setForeground(Color.BLUE);
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1_2.setBounds(67, 94, 180, 41);
		panel_gider.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tarih : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 146, 104, 33);
		panel_gider.add(lblNewLabel_3_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(154, 154, 136, 19);
		panel_gider.add(dateChooser_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Gider T\u00FCr\u00FC : ");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(10, 178, 104, 33);
		panel_gider.add(lblNewLabel_4_1);
		
		JComboBox comboBox_gider = new JComboBox();
		comboBox_gider.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "Yem Gideri", "Fatura Gideri", "Personel Gideri", "Veteriner Gideri", "Ekipman Gideri", "\u0130la\u00E7 Gideri"}));
		comboBox_gider.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_gider.setBackground(Color.WHITE);
		comboBox_gider.setBounds(154, 184, 136, 21);
		panel_gider.add(comboBox_gider);
		
		JLabel lblNewLabel_5_1 = new JLabel("Gider Miktar\u0131 : ");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(10, 207, 104, 33);
		panel_gider.add(lblNewLabel_5_1);
		
		fld_gidermiktar = new JTextField();
		fld_gidermiktar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_gidermiktar.setColumns(10);
		fld_gidermiktar.setBounds(154, 213, 136, 19);
		panel_gider.add(fld_gidermiktar);
		fld_gidermiktar.addKeyListener(kl);
		
		JLabel lblNewLabel_6_1 = new JLabel("Veren Personel : ");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(10, 238, 110, 33);
		panel_gider.add(lblNewLabel_6_1);
		
		fld_verenpersonel = new JTextField();
		fld_verenpersonel.setText((String) null);
		fld_verenpersonel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_verenpersonel.setColumns(10);
		fld_verenpersonel.setBounds(154, 244, 136, 19);
		panel_gider.add(fld_verenpersonel);
		fld_verenpersonel.setText(kullanici.getName());
		fld_verenpersonel.addKeyListener(hl);
		fld_verenpersonel.addKeyListener(kl);
		
		
		JComboBox comboBox_musteri_gider = new JComboBox();
		comboBox_musteri_gider.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_musteri_gider.setBackground(Color.WHITE);
		comboBox_musteri_gider.setBounds(75, 304, 161, 27);
			for(int n = 0; n<mgider.getMusteriList().size(); n++) {
				comboBox_musteri_gider.addItem(new Item(mgider.getMusteriList().get(n).getId(), mgider.getMusteriList().get(n).getName(), mgider.getMusteriList().get(n).getTcno(), mgider.getMusteriList().get(n).getTelefon(), mgider.getMusteriList().get(n).getAdres()));
			}
			comboBox_musteri_gider.addActionListener(e -> {
				JComboBox c = (JComboBox) e.getSource();
				Item item = (Item) c.getSelectedItem();
			});
		panel_gider.add(comboBox_musteri_gider);
		
		
		JButton btn_kaydet_1 = new JButton("Kaydet");
		btn_kaydet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) comboBox_musteri_gider.getSelectedItem();
				String name = item.getName();
				String tcno = item.getTcno();
				String telefon = item.getTelefon();
				String adres = item.getAdres();
				String typegider = comboBox_gider.getSelectedItem().toString();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				String date2 = "";
				try {
					date2 = sdf2.format(dateChooser_1.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date2.length() == 0  ) {
					Helper.showMsg("Lütfen geçerli bir tarih seçiniz !");
				}
				else {
					if(typegider.equals("Seçiniz") || fld_gidermiktar.getText().length() == 0 || fld_verenpersonel.getText().length() == 0 ) {
						Helper.showMsg("fill");
					}else {
						try {
							boolean control = gider.addGider(date2, typegider, fld_gidermiktar.getText(), fld_verenpersonel.getText(), name, tcno, telefon, adres);
							if(control) {
								Helper.showMsg("success");
								fld_gidermiktar.setText(null);
								
								updateGiderModel();
								
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_kaydet_1.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/save.png")));
		btn_kaydet_1.setForeground(Color.BLUE);
		btn_kaydet_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet_1.setBackground(Color.WHITE);
		btn_kaydet_1.setBounds(95, 341, 122, 27);
		panel_gider.add(btn_kaydet_1);
		
		JLabel lblNewLabel_7_3_1 = new JLabel("S\u0131ra No : ");
		lblNewLabel_7_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_3_1.setBounds(10, 558, 72, 33);
		panel_gider.add(lblNewLabel_7_3_1);
		
		fld_vsira = new JTextField();
		fld_vsira.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_vsira.setColumns(10);
		fld_vsira.setBounds(76, 564, 109, 19);
		panel_gider.add(fld_vsira);
		
		JButton btn_sil_1 = new JButton("Sil");
		btn_sil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_vsira.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir deðer giriniz !");
				}else {
					int selectsira = Integer.parseInt(fld_vsira.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = gider.deleteGider(selectsira);
							if(control) {
								Helper.showMsg("success");
								fld_vsira.setText(null);
								updateGiderModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil_1.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/delete.png")));
		btn_sil_1.setForeground(Color.RED);
		btn_sil_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil_1.setBackground(Color.WHITE);
		btn_sil_1.setBounds(205, 562, 85, 21);
		panel_gider.add(btn_sil_1);
		
		JScrollPane scrollPane_gider = new JScrollPane();
		scrollPane_gider.setBounds(324, 10, 926, 599);
		panel_gider.add(scrollPane_gider);
		
		table_gider = new JTable(giderModel);
		scrollPane_gider.setViewportView(table_gider);
		
		JButton btn_kaydet_2_1 = new JButton("M\u00FC\u015Fteri Kay\u0131t");
		btn_kaydet_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MusterigiderGUI ggui = new MusterigiderGUI(kullanici);
					ggui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
			}
		});
		btn_kaydet_2_1.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/login.png")));
		btn_kaydet_2_1.setForeground(Color.BLUE);
		btn_kaydet_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet_2_1.setBackground(Color.WHITE);
		btn_kaydet_2_1.setBounds(76, 378, 161, 27);
		panel_gider.add(btn_kaydet_2_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("M\u00FC\u015Fteri Se\u00E7iniz ;");
		lblNewLabel_2_1_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1_2_1.setBounds(10, 273, 180, 33);
		panel_gider.add(lblNewLabel_2_1_2_1);
		
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Personel maa\u015F \u00F6demesi i\u00E7in personel se\u00E7iniz");
		lblNewLabel_2_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1_2_1_1.setBounds(10, 426, 309, 33);
		panel_gider.add(lblNewLabel_2_1_2_1_1);
		
		JComboBox comboBox_personel = new JComboBox();
		comboBox_personel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_personel.setBackground(Color.WHITE);
		comboBox_personel.setBounds(75, 457, 161, 27);
		for(int k = 0; k<personel.getPersonelList().size(); k++) {
			comboBox_personel.addItem(new Item(personel.getPersonelList().get(k).getId(), personel.getPersonelList().get(k).getName(), personel.getPersonelList().get(k).getTcno(), personel.getPersonelList().get(k).getTelefon(), personel.getPersonelList().get(k).getAdres()));
		}
		comboBox_personel.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
		});
		panel_gider.add(comboBox_personel);
		
		JButton btn_kaydet_1_1 = new JButton("Maa\u015F \u00F6de\r\n");
		btn_kaydet_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) comboBox_personel.getSelectedItem();
				String name = item.getName();
				String tcno = item.getTcno();
				String telefon = item.getTelefon();
				String adres = item.getAdres();
				String typegider = comboBox_gider.getSelectedItem().toString();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				String date2 = "";
				try {
					date2 = sdf2.format(dateChooser_1.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date2.length() == 0  ) {
					Helper.showMsg("Lütfen geçerli bir tarih seçiniz !");
				}
				else {
					if(typegider.equals("Seçiniz") || fld_gidermiktar.getText().length() == 0 || fld_verenpersonel.getText().length() == 0 ) {
						Helper.showMsg("fill");
					}else {
						try {
							boolean control = gider.addGider(date2, typegider, fld_gidermiktar.getText(), fld_verenpersonel.getText(), name, tcno, telefon, adres);
							if(control) {
								Helper.showMsg("success");
								fld_gidermiktar.setText(null);
								
								updateGiderModel();
								
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_kaydet_1_1.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/save.png")));
		btn_kaydet_1_1.setForeground(Color.BLUE);
		btn_kaydet_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_kaydet_1_1.setBackground(Color.WHITE);
		btn_kaydet_1_1.setBounds(95, 494, 122, 27);
		panel_gider.add(btn_kaydet_1_1);
		
		JPanel panel_fatura = new JPanel();
		panel_fatura.setBackground(Color.WHITE);
		tabbedPane.addTab("FATURA", null, panel_fatura, null);
		panel_fatura.setLayout(null);
		
		JScrollPane scrollPane_fatura = new JScrollPane();
		scrollPane_fatura.setBounds(10, 10, 1240, 530);
		panel_fatura.add(scrollPane_fatura);
		
		table_fatura = new JTable(faturaModel);
		scrollPane_fatura.setViewportView(table_fatura);
		table_fatura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_faturasil.setText(table_fatura.getValueAt(table_fatura.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		JButton btnNewButton = new JButton("Fatura Kay\u0131t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FaturaGUI fgui = new FaturaGUI(kullanici);
					fgui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/login.png")));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 563, 166, 33);
		panel_fatura.add(btnNewButton);
		
		fld_faturasil = new JTextField();
		fld_faturasil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_faturasil.setColumns(10);
		fld_faturasil.setBounds(1036, 569, 109, 19);
		panel_fatura.add(fld_faturasil);
		
		JLabel lblNewLabel_7_3_1_1 = new JLabel("Fatura No : ");
		lblNewLabel_7_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_3_1_1.setBounds(945, 563, 85, 33);
		panel_fatura.add(lblNewLabel_7_3_1_1);
		
		JButton btn_sil_1_1 = new JButton("Sil");
		btn_sil_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_faturasil.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir fatura seçiniz !");
				}else {
					int selectFatura = Integer.parseInt(fld_faturasil.getText());
					try {
						if(Helper.confirm("sure")) {
							boolean control = fatura.deleteFatura(selectFatura);
							if(control) {
								Helper.showMsg("success");
								fld_faturasil.setText(null);
								updateFaturaModel();
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_sil_1_1.setIcon(new ImageIcon(KazancGUI.class.getResource("/View/delete.png")));
		btn_sil_1_1.setForeground(Color.RED);
		btn_sil_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil_1_1.setBackground(Color.WHITE);
		btn_sil_1_1.setBounds(1165, 567, 85, 21);
		panel_fatura.add(btn_sil_1_1);
		
		JComboBox comboBox_yazdir = new JComboBox();
		comboBox_yazdir.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox_yazdir.setBackground(Color.WHITE);
		for(int v = 0; v<fatura.getFaturaList().size(); v++) {
			comboBox_yazdir.addItem(new itemyazdir(fatura.getFaturaList().get(v).getFatura_no(), fatura.getFaturaList().get(v).getIsletme_no(), fatura.getFaturaList().get(v).getIsletme_adi(), fatura.getFaturaList().get(v).getIsletme_adres(), fatura.getFaturaList().get(v).getIsletme_telefon(), fatura.getFaturaList().get(v).getTahsilat_no(), fatura.getFaturaList().get(v).getTarih(), fatura.getFaturaList().get(v).getType(), fatura.getFaturaList().get(v).getFiyat(), fatura.getFaturaList().get(v).getKdv_fiyat(), fatura.getFaturaList().get(v).getName(), fatura.getFaturaList().get(v).getTcno(), fatura.getFaturaList().get(v).getAdres()));
		}
		comboBox_yazdir.addActionListener( e -> {
			JComboBox c = (JComboBox) e.getSource();
			itemyazdir item = (itemyazdir) c.getSelectedItem();
		});
		comboBox_yazdir.setBounds(442, 570, 149, 21);
		
		panel_fatura.add(comboBox_yazdir);
		
		/*
		 * 	Item item = (Item) comboBox_musteri.getSelectedItem();
				String name = item.getName();
				String tcno = item.getTcno();
				String telefon = item.getTelefon();
				String adres = item.getAdres();
				File file = new File("test.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					String yazi = name + "\n" + tcno + "\n" + telefon;
					fos.write(yazi.getBytes());
					fos.flush();
*/
		
		JButton btn_yazdir = new JButton("YAZDIR");
		btn_yazdir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemyazdir item = (itemyazdir) comboBox_yazdir.getSelectedItem();
				int FaturaNo = item.getFatura_no();
				String faturaa = String.valueOf(FaturaNo);
				String isletmeNo = item.getIsletme_no();
				String isletmeAdi = item.getIsletme_adi();
				String isletmeAdres = item.getIsletme_adres();
				String isletmeTelefon = item.getIsletme_telefon();
				String tahsilat = item.getTahsilat_no();
				String date = item.getTarih();
				String type = item.getType();
				String fiyat = item.getFiyat();
				String kdv = item.getKdv_fiyat();
				String name = item.getName();
				String tcno = item.getTcno();
				String adres = item.getAdres();
				
				File file = new File("Fatura.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					String yazi = "Fatura Bilgileri" + "\n" + "Fatura NO : " + faturaa + "\n" + "Ýþletme NO : " + isletmeNo + "\n" + "iþletme Adý : " + isletmeAdi + "\n" + "Ýþletme Adresi : " + isletmeAdres + "\n" + "Ýþletme Telefon NO : " + isletmeTelefon + "\n" + "Tahsilat NO : " + tahsilat + "\n" + "Tarih : " + date + "\n" + "Türü : " + type + "\n" + "Fiyat : " + fiyat + "\n" + "KDV'li Fiyat : " + kdv + "\n" + "Ýsim : " + name + "\n" + "TC NO / Vergi NO : " + tcno + "\n" + "Adres : " + adres;
					fos.write(yazi.getBytes());
					fos.flush();
					fos.close();
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
					// TODO: handle exception
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_yazdir.setForeground(Color.MAGENTA);
		btn_yazdir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_yazdir.setBackground(Color.WHITE);
		btn_yazdir.setBounds(600, 565, 140, 30);
		panel_fatura.add(btn_yazdir);
		
		
		table_gider.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
			try {
				fld_vsira.setText(table_gider.getValueAt(table_gider.getSelectedRow(), 0).toString());
			} catch (Exception e2) {
				// TODO: handle exception
			}	
			}
		});
		table_gider.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectsira = Integer.parseInt(table_gider.getValueAt(table_gider.getSelectedRow(), 0).toString());
					String selectTarih = table_gider.getValueAt(table_gider.getSelectedRow(), 1).toString();
					String selectType = table_gider.getValueAt(table_gider.getSelectedRow(), 2).toString();
					String selectMiktar = table_gider.getValueAt(table_gider.getSelectedRow(), 3).toString();
					String selectPersonel = table_gider.getValueAt(table_gider.getSelectedRow(), 4).toString();
					
					//String selectTahsilat = table_gider.getValueAt(table_gider.getSelectedRow(), 5).toString();
					
					String selectName = table_gider.getValueAt(table_gider.getSelectedRow(), 6).toString();
					String selectTcno = table_gider.getValueAt(table_gider.getSelectedRow(), 7).toString();
					String selectTel = table_gider.getValueAt(table_gider.getSelectedRow(), 8).toString();
					String selectAdres = table_gider.getValueAt(table_gider.getSelectedRow(), 9).toString();
					
					try {
						boolean control = gider.updateGider(selectsira, selectTarih, selectType, selectMiktar, selectPersonel, selectName, selectTcno, selectTel, selectAdres);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
	}
	public void updateGelirModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_gelir.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i < gelir.getGelirList().size(); i++) {
			gelirData[0] = gelir.getGelirList().get(i).getSira_no();
			gelirData[1] = gelir.getGelirList().get(i).getTarih();
			gelirData[2] = gelir.getGelirList().get(i).getGelir_type();
			gelirData[3] = gelir.getGelirList().get(i).getMiktar();
			gelirData[4] = gelir.getGelirList().get(i).getPersonel();
			gelirData[5] = gelir.getGelirList().get(i).getTahsilat();
			gelirData[6] = gelir.getGelirList().get(i).getName();
			gelirData[7] = gelir.getGelirList().get(i).getTcno();
			gelirData[8] = gelir.getGelirList().get(i).getTelefon();
			gelirData[9] = gelir.getGelirList().get(i).getAdres();
			gelirModel.addRow(gelirData);	
		}
	}
	public void updateGiderModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_gider.getModel();
		clearModel.setRowCount(0);
		for(int j = 0; j < gider.getGiderList().size(); j++) {
			giderData[0] = gider.getGiderList().get(j).getSira_no();
			giderData[1] = gider.getGiderList().get(j).getTarih();
			giderData[2] = gider.getGiderList().get(j).getGider_type();
			giderData[3] = gider.getGiderList().get(j).getMiktar();
			giderData[4] = gider.getGiderList().get(j).getPersonel();
			giderData[5] = gider.getGiderList().get(j).getTahsilat();
			giderData[6] = gider.getGiderList().get(j).getName();
			giderData[7] = gider.getGiderList().get(j).getTcno();
			giderData[8] = gider.getGiderList().get(j).getTelefon();
			giderData[9] = gider.getGiderList().get(j).getAdres();
			giderModel.addRow(giderData);
		}
	}
	public void updateFaturaModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_fatura.getModel();
		clearModel.setRowCount(0);
		for(int n = 0; n<fatura.getFaturaList().size(); n++) {
			faturaData[0] = fatura.getFaturaList().get(n).getFatura_no();
			faturaData[1] = fatura.getFaturaList().get(n).getIsletme_no();
			faturaData[2] = fatura.getFaturaList().get(n).getIsletme_adi();
			faturaData[3] = fatura.getFaturaList().get(n).getIsletme_adres();
			faturaData[4] = fatura.getFaturaList().get(n).getIsletme_telefon();
			faturaData[5] = fatura.getFaturaList().get(n).getTahsilat_no();
			faturaData[6] = fatura.getFaturaList().get(n).getTarih();
			faturaData[7] = fatura.getFaturaList().get(n).getType();
			faturaData[8] = fatura.getFaturaList().get(n).getFiyat();
			faturaData[9] = fatura.getFaturaList().get(n).getKdv_fiyat();
			faturaData[10] = fatura.getFaturaList().get(n).getName();
			faturaData[11] = fatura.getFaturaList().get(n).getTcno();
			faturaData[12] = fatura.getFaturaList().get(n).getAdres();
			faturaModel.addRow(faturaData);
		}
	}
}
