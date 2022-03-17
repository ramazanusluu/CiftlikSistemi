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

import Model.Kullanici;
import Model.Kuruot;
import Model.Rasyon;
import Model.Saman;
import Model.Silaj;
import Model.Yem;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import Helper.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;

public class DepoGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();
	
	Rasyon rasyon = new Rasyon();
	Saman saman = new Saman();
	Kuruot kuruot = new Kuruot();
	Silaj silaj = new Silaj();
	Yem yem = new Yem();
	
	private JPanel contentPane;
	private JTextField fld_kapasite;
	private JTextField fld_rasyon;
	private JTextField fld_sirano;
	private JTextField fld_deger;
	private DefaultTableModel samanModel = null;
	private Object[]  samanData = null;
	private JTable table_saman;
	private JTextField fld_kkapasite;
	private JTextField fld_krasyon;
	private JTextField fld_kfiyat;
	private JTextField fld_ksirano;
	private JTable table_kuruot;
	private DefaultTableModel kuruotModel = null;
	private Object[]  kuruotData = null;
	private JTextField fld_skapaiste;
	private JTextField fld_srasyon;
	private JTextField fld_sfiyat;
	private JTextField fld_silajsirano;
	private JTable table_silaj;
	private DefaultTableModel silajModel = null;
	private Object[]  silajData = null;
	private JTextField fld_fkapasite;
	private JTextField fld_frasyon;
	private JTextField fld_ffiyat;
	private JTextField fld_yemsira;
	private JTable table_yem;
	private DefaultTableModel yemModel = null;
	private Object[]  yemData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepoGUI frame = new DepoGUI(kullanici);
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
	public DepoGUI(Kullanici kullanici) throws SQLException {
		samanModel = new DefaultTableModel();
		Object[] colSamanName = new Object[10];
		colSamanName[0] = "Sýra NO";
		colSamanName[1] = "Tarih";
		colSamanName[2] = "Kapasite (baþ)";
		colSamanName[3] = "Rasyon";
		colSamanName[4] = "Kg Fiyat";
		colSamanName[5] = "Günlük Gider (kg)";
		colSamanName[6] = "Yýllýk Gider (kg)";
		colSamanName[7] = "Fiyat";
		colSamanName[8] = "Küçük Balya(25kg)";
		colSamanName[9] = "Büyük Balya(250kg)";
		samanModel.setColumnIdentifiers(colSamanName);
		samanData = new Object[10];
		for(int j = 0; j < saman.getSamanList().size(); j++) {
			samanData[0] = saman.getSamanList().get(j).getSira_no();
			samanData[1] = saman.getSamanList().get(j).getTarih();
			samanData[2] = saman.getSamanList().get(j).getKapasite();
			samanData[3] = saman.getSamanList().get(j).getRasyon();
			samanData[4] = saman.getSamanList().get(j).getDeger();
			samanData[5] = saman.getSamanList().get(j).getGunluk_gider();
			samanData[6] = saman.getSamanList().get(j).getYillik_gider();
			samanData[7] = saman.getSamanList().get(j).getFiyat();
			samanData[8] = saman.getSamanList().get(j).getKucuk_balya();
			samanData[9] = saman.getSamanList().get(j).getBuyuk_balya();
			samanModel.addRow(samanData);
		}
		kuruotModel = new DefaultTableModel();
		Object[] colKuruotName = new Object[10];
		colKuruotName[0] = "Sýra NO";
		colKuruotName[1] = "Tarih";
		colKuruotName[2] = "Kapasite (baþ)";
		colKuruotName[3] = "Rasyon";
		colKuruotName[4] = "Kg Fiyat";
		colKuruotName[5] = "Günlük Gider (kg)";
		colKuruotName[6] = "Yýllýk Gider (kg)";
		colKuruotName[7] = "Fiyat";
		colKuruotName[8] = "Küçük Balya(25kg)";
		colKuruotName[9] = "Büyük Balya(250kg)";
		kuruotModel.setColumnIdentifiers(colKuruotName);
		kuruotData = new Object[10];
		for(int k = 0 ; k < kuruot.getKuruotList().size(); k++) {
			kuruotData[0] = kuruot.getKuruotList().get(k).getSira_no();
			kuruotData[1] = kuruot.getKuruotList().get(k).getTarih();
			kuruotData[2] = kuruot.getKuruotList().get(k).getKapasite();
			kuruotData[3] = kuruot.getKuruotList().get(k).getRasyon();
			kuruotData[4] = kuruot.getKuruotList().get(k).getDeger();
			kuruotData[5] = kuruot.getKuruotList().get(k).getGunluk_gider();
			kuruotData[6] = kuruot.getKuruotList().get(k).getYillik_gider();
			kuruotData[7] = kuruot.getKuruotList().get(k).getFiyat();
			kuruotData[8] = kuruot.getKuruotList().get(k).getKucuk_balya();
			kuruotData[9] = kuruot.getKuruotList().get(k).getBuyuk_balya();
			kuruotModel.addRow(kuruotData);
		}
		silajModel = new DefaultTableModel();
		Object[] colSilajName = new Object[9];
		colSilajName[0] = "Sýra NO";
		colSilajName[1] = "Tarih";
		colSilajName[2] = "Kapasite (baþ)";
		colSilajName[3] = "Rasyon";
		colSilajName[4] = "Kg Fiyat";
		colSilajName[5] = "Günlük Gider (kg)";
		colSilajName[6] = "Yýllýk Gider (kg)";
		colSilajName[7] = "Fiyat";
		colSilajName[8] = "Paket (1000kg)";
		silajModel.setColumnIdentifiers(colSilajName);
		silajData = new Object[9];
		for(int l = 0; l < silaj.getSilajList().size(); l++) {
			silajData[0] = silaj.getSilajList().get(l).getSira_no();
			silajData[1] = silaj.getSilajList().get(l).getTarih();
			silajData[2] = silaj.getSilajList().get(l).getKapasite();
			silajData[3] = silaj.getSilajList().get(l).getRasyon();
			silajData[4] = silaj.getSilajList().get(l).getDeger();
			silajData[5] = silaj.getSilajList().get(l).getGunluk_gider();
			silajData[6] = silaj.getSilajList().get(l).getYillik_gider();
			silajData[7] = silaj.getSilajList().get(l).getFiyat();
			silajData[8] = silaj.getSilajList().get(l).getPaket();
			silajModel.addRow(silajData);
		}
		yemModel = new DefaultTableModel();
		Object[] colYemName = new Object[9];
		colYemName[0] = "Sýra NO";
		colYemName[1] = "Tarih";
		colYemName[2] = "Kapasite (baþ)";
		colYemName[3] = "Rasyon";
		colYemName[4] = "Kg Fiyat";
		colYemName[5] = "Günlük Gider (kg)";
		colYemName[6] = "Yýllýk Gider (kg)";
		colYemName[7] = "Fiyat";
		colYemName[8] = "Paket (50kg)";
		yemModel.setColumnIdentifiers(colYemName);
		yemData = new Object[9];
		for(int a = 0; a < yem.getYemList().size(); a++) {
			yemData[0] = yem.getYemList().get(a).getSira_no();
			yemData[1] = yem.getYemList().get(a).getTarih();
			yemData[2] = yem.getYemList().get(a).getKapasite();
			yemData[3] = yem.getYemList().get(a).getRasyon();
			yemData[4] = yem.getYemList().get(a).getDeger();
			yemData[5] = yem.getYemList().get(a).getGunluk_gider();
			yemData[6] = yem.getYemList().get(a).getYillik_gider();
			yemData[7] = yem.getYemList().get(a).getFiyat();
			yemData[8] = yem.getYemList().get(a).getPaket();
			yemModel.addRow(yemData);
		}

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(DepoGUI.class.getResource("/View/uygulama.png")));
		setTitle("DEPOLAR");
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
		btnAnaMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AnaGUI ag = new AnaGUI(kullanici);
					ag.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnAnaMen.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/out.png")));
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 56, 1264, 645);
		contentPane.add(tabbedPane);
		
		JPanel panel_saman = new JPanel();
		panel_saman.setBackground(Color.WHITE);
		tabbedPane.addTab("SAMAN", null, panel_saman, null);
		panel_saman.setLayout(null);
		
		JScrollPane scrollPane_saman = new JScrollPane();
		scrollPane_saman.setBounds(10, 10, 1239, 439);
		panel_saman.add(scrollPane_saman);
		
		table_saman = new JTable(samanModel);
		scrollPane_saman.setViewportView(table_saman);
		table_saman.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_sirano.setText(table_saman.getValueAt(table_saman.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_saman.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
				int selectSirano = Integer.parseInt(table_saman.getValueAt(table_saman.getSelectedRow(), 0).toString());
				String selectTarih = table_saman.getValueAt(table_saman.getSelectedRow(), 1).toString();
				String selectKapasite = table_saman.getValueAt(table_saman.getSelectedRow(), 2).toString();
				String selectRasyon = table_saman.getValueAt(table_saman.getSelectedRow(), 3).toString();
				String selectDeger = table_saman.getValueAt(table_saman.getSelectedRow(), 4).toString();
			
				int kapasite = Integer.parseInt(selectKapasite);
				int rasyon = Integer.parseInt(selectRasyon);
				int deger = Integer.parseInt(selectDeger);
				
				int igunluk = (kapasite * rasyon) ;
				String sgunluk = String.valueOf(igunluk);
				
				int iyillik = (igunluk * 365);
				String syillik = String.valueOf(iyillik);
				
				int ifiyat = (iyillik * deger);
				String sfiyat = String.valueOf(ifiyat);
				
				int ikucuk = (iyillik / 25);
				String skucuk = String.valueOf(ikucuk);
				
				int ibuyuk = (iyillik / 250);
				String sbuyuk = String.valueOf(ibuyuk);
				
				try {
					boolean control = saman.updateSaman(selectSirano, selectTarih, selectKapasite, selectRasyon, selectDeger, sgunluk, syillik, sfiyat, skucuk, sbuyuk);
					if(control) {
						Helper.showMsg("success");
						updateSamanModel();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				}		
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/bgdy.png")));
		lblNewLabel_2.setBounds(604, 504, 62, 64);
		panel_saman.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hesaplama Tarihi : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 455, 144, 35);
		panel_saman.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hayvan Kapasitesi : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 495, 155, 35);
		panel_saman.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Rasyon De\u011Feri : ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(10, 535, 127, 35);
		panel_saman.add(lblNewLabel_3_2);
		
		fld_kapasite = new JTextField();
		fld_kapasite.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kapasite.setColumns(10);
		fld_kapasite.setBounds(191, 502, 137, 21);
		panel_saman.add(fld_kapasite);
		fld_kapasite.addKeyListener(kl);
		
		
		fld_rasyon = new JTextField();
		fld_rasyon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_rasyon.setColumns(10);
		fld_rasyon.setBounds(191, 542, 137, 21);
		panel_saman.add(fld_rasyon);
		fld_rasyon.addKeyListener(kl);
		for(int i = 0; i<rasyon.getRasyonList().size(); i++) {
			fld_rasyon.setText(rasyon.getRasyonList().get(i).getSaman());
		}
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(191, 464, 137, 19);
		panel_saman.add(dateChooser);
		
		JButton btn_hesapla = new JButton("Hesapla");
		btn_hesapla.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/save.png")));
		btn_hesapla.setForeground(Color.BLUE);
		btn_hesapla.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_hesapla.setBackground(Color.WHITE);
		btn_hesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
					if(fld_kapasite.getText().length() == 0 || fld_deger.getText().length() == 0 || fld_rasyon.getText().length() ==0 ) {
						Helper.showMsg("fill");
					}else {
						String kapasite = fld_kapasite.getText();
						int selectkapasite = Integer.parseInt(kapasite);
						
						String rasyon = fld_rasyon.getText();
						int selectrasyon = Integer.parseInt(rasyon);
						
						String deger = fld_deger.getText();
						int selectdeger = Integer.parseInt(deger);
						
						int selectgunluk = selectkapasite * selectrasyon;
						String gunluk = String.valueOf(selectgunluk);
						
						int selectyillik = (selectgunluk * 365) ;
						String yillik = String.valueOf(selectyillik);
						
						int selectfiyat = selectyillik * selectdeger;
						String fiyat = String.valueOf(selectfiyat);
						
						int selectkucuk = (selectyillik / 25);
						String kucuk = String.valueOf(selectkucuk);
						
						int selectbuyuk = (selectyillik / 250);
						String buyuk = String.valueOf(selectbuyuk);
						
							try {
								boolean control = saman.addSaman(date, kapasite,  rasyon, deger, gunluk, yillik, fiyat, kucuk, buyuk);
								if(control) {
								Helper.showMsg("success");
								fld_kapasite.setText(null);
								fld_rasyon.setText(null);
								fld_deger.setText(null);
								updateSamanModel();
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				}
				
			}
		});
		btn_hesapla.setBounds(417, 520, 121, 28);
		panel_saman.add(btn_hesapla);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("S\u0131ra NO : ");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(912, 513, 73, 35);
		panel_saman.add(lblNewLabel_3_1_1);
		
		fld_sirano = new JTextField();
		fld_sirano.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sirano.setColumns(10);
		fld_sirano.setBounds(995, 520, 137, 21);
		panel_saman.add(fld_sirano);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/delete.png")));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_sirano.getText().length() == 0 ) {
					Helper.showMsg("Lütfen geçerli bir deger giriniz !");
				}
				else {
					int selectsiraNo = Integer.parseInt(fld_sirano.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = saman.deleteSaman(selectsiraNo);
							if(control) {
								Helper.showMsg("success");
								fld_sirano.setText(null);
								updateSamanModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btnSil.setForeground(Color.RED);
		btnSil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSil.setBackground(Color.WHITE);
		btnSil.setBounds(1142, 517, 107, 25);
		panel_saman.add(btnSil);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Fiyat(kg) : ");
		lblNewLabel_3_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_1.setBounds(10, 573, 127, 35);
		panel_saman.add(lblNewLabel_3_2_1);
		
		fld_deger = new JTextField();
		fld_deger.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_deger.setColumns(10);
		fld_deger.setBounds(191, 580, 137, 21);
		panel_saman.add(fld_deger);
		
		JPanel panel_kuruot = new JPanel();
		panel_kuruot.setBackground(Color.WHITE);
		tabbedPane.addTab("KURU OT", null, panel_kuruot, null);
		panel_kuruot.setLayout(null);
		
		JScrollPane scrollPane_kuruot = new JScrollPane();
		scrollPane_kuruot.setBounds(10, 10, 1239, 439);
		panel_kuruot.add(scrollPane_kuruot);
		
		table_kuruot = new JTable(kuruotModel);
		scrollPane_kuruot.setViewportView(table_kuruot);
		table_kuruot.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_ksirano.setText(table_kuruot.getValueAt(table_kuruot.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
			}
		});
		table_kuruot.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectSirano = Integer.parseInt(table_kuruot.getValueAt(table_kuruot.getSelectedRow(), 0).toString());
					String selectTarih = table_kuruot.getValueAt(table_kuruot.getSelectedRow(), 1).toString();
					String selectKapasite = table_kuruot.getValueAt(table_kuruot.getSelectedRow(), 2).toString();
					String selectRasyon = table_kuruot.getValueAt(table_kuruot.getSelectedRow(), 3).toString();
					String selectDeger = table_kuruot.getValueAt(table_kuruot.getSelectedRow(), 4).toString();
				
					int kapasite = Integer.parseInt(selectKapasite);
					int rasyon = Integer.parseInt(selectRasyon);
					int deger = Integer.parseInt(selectDeger);
					
					int igunluk = (kapasite * rasyon) ;
					String sgunluk = String.valueOf(igunluk);
					
					int iyillik = (igunluk * 365);
					String syillik = String.valueOf(iyillik);
					
					int ifiyat = (iyillik * deger);
					String sfiyat = String.valueOf(ifiyat);
					
					int ikucuk = (iyillik / 25);
					String skucuk = String.valueOf(ikucuk);
					
					int ibuyuk = (iyillik / 250);
					String sbuyuk = String.valueOf(ibuyuk);
					
					try {
						boolean control = kuruot.updateKuruot(selectSirano, selectTarih, selectKapasite, selectRasyon, selectDeger, sgunluk, syillik, sfiyat, skucuk, sbuyuk);
						if(control) {
							Helper.showMsg("success");
							updateKuruotModel();
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		JLabel lblNewLabel_3_3 = new JLabel("Hesaplama Tarihi : ");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(10, 455, 144, 35);
		panel_kuruot.add(lblNewLabel_3_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(191, 464, 137, 19);
		panel_kuruot.add(dateChooser_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Hayvan Kapasitesi : ");
		lblNewLabel_3_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_2.setBounds(10, 495, 155, 35);
		panel_kuruot.add(lblNewLabel_3_1_2);
		
		fld_kkapasite = new JTextField();
		fld_kkapasite.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kkapasite.setColumns(10);
		fld_kkapasite.setBounds(191, 502, 137, 21);
		panel_kuruot.add(fld_kkapasite);
		fld_kkapasite.addKeyListener(kl);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Rasyon De\u011Feri : ");
		lblNewLabel_3_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_2.setBounds(10, 535, 127, 35);
		panel_kuruot.add(lblNewLabel_3_2_2);
		
		fld_krasyon = new JTextField();
		fld_krasyon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_krasyon.setColumns(10);
		fld_krasyon.setBounds(191, 542, 137, 21);
		panel_kuruot.add(fld_krasyon);
		fld_krasyon.addKeyListener(kl);
		for(int n = 0; n<rasyon.getRasyonList().size(); n++) {
			fld_krasyon.setText(rasyon.getRasyonList().get(n).getKuruot());
		}
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Fiyat(kg) : ");
		lblNewLabel_3_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_1_1.setBounds(10, 573, 127, 35);
		panel_kuruot.add(lblNewLabel_3_2_1_1);
		
		fld_kfiyat = new JTextField();
		fld_kfiyat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kfiyat.setColumns(10);
		fld_kfiyat.setBounds(191, 580, 137, 21);
		panel_kuruot.add(fld_kfiyat);
		fld_kfiyat.addKeyListener(kl);
		
		JButton btn_kuruothesapla = new JButton("Hesapla");
		btn_kuruothesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					if(fld_kkapasite.getText().length() == 0 || fld_kfiyat.getText().length() == 0 || fld_krasyon.getText().length() ==0 ) {
						Helper.showMsg("fill");
					}else {
						String kapasite = fld_kkapasite.getText();
						int selectkapasite = Integer.parseInt(kapasite);
						
						String rasyon = fld_krasyon.getText();
						int selectrasyon = Integer.parseInt(rasyon);
						
						String deger = fld_kfiyat.getText();
						int selectdeger = Integer.parseInt(deger);
						
						int selectgunluk = selectkapasite * selectrasyon;
						String gunluk = String.valueOf(selectgunluk);
						
						int selectyillik = (selectgunluk * 365) ;
						String yillik = String.valueOf(selectyillik);
						
						int selectfiyat = selectyillik * selectdeger;
						String fiyat = String.valueOf(selectfiyat);
						
						int selectkucuk = (selectyillik / 25);
						String kucuk = String.valueOf(selectkucuk);
						
						int selectbuyuk = (selectyillik / 250);
						String buyuk = String.valueOf(selectbuyuk);
						try {
							boolean control = kuruot.addKuruot(date2, kapasite, rasyon, deger, gunluk, yillik, fiyat, kucuk, buyuk);
							if(control) {
								Helper.showMsg("success");
								fld_kkapasite.setText(null);
								fld_kfiyat.setText(null);
								fld_krasyon.setText(null);
								updateKuruotModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
				}
				}
				
			}
		});
		btn_kuruothesapla.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/save.png")));
		btn_kuruothesapla.setForeground(Color.BLUE);
		btn_kuruothesapla.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kuruothesapla.setBackground(Color.WHITE);
		btn_kuruothesapla.setBounds(417, 520, 121, 28);
		panel_kuruot.add(btn_kuruothesapla);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/yonca.png")));
		lblNewLabel_2_1.setBounds(604, 504, 62, 64);
		panel_kuruot.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("S\u0131ra NO : ");
		lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1.setBounds(912, 513, 73, 35);
		panel_kuruot.add(lblNewLabel_3_1_1_1);
		
		fld_ksirano = new JTextField();
		fld_ksirano.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ksirano.setColumns(10);
		fld_ksirano.setBounds(995, 520, 137, 21);
		panel_kuruot.add(fld_ksirano);
		
		JButton btn_ksil = new JButton("Sil");
		btn_ksil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_ksirano.getText().length() == 0 ) {
					Helper.showMsg("Lütfen geçerli bir deðer giriniz !");
				}else {
					if(Helper.confirm("sure")) {
						int selectSirano = Integer.parseInt(fld_ksirano.getText());
						try {
							boolean control = kuruot.deleteKuruot(selectSirano);
							if(control) {
								Helper.showMsg("success");
								fld_ksirano.setText(null);
								updateKuruotModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_ksil.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/delete.png")));
		btn_ksil.setForeground(Color.RED);
		btn_ksil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_ksil.setBackground(Color.WHITE);
		btn_ksil.setBounds(1142, 517, 107, 25);
		panel_kuruot.add(btn_ksil);
		
		JPanel panel_silaj = new JPanel();
		panel_silaj.setBackground(Color.WHITE);
		tabbedPane.addTab("SÝLAJ", null, panel_silaj, null);
		panel_silaj.setLayout(null);
		
		JScrollPane scrollPane_kuruot_1 = new JScrollPane();
		scrollPane_kuruot_1.setBounds(10, 10, 1239, 439);
		panel_silaj.add(scrollPane_kuruot_1);
		
		table_silaj = new JTable(silajModel);
		scrollPane_kuruot_1.setViewportView(table_silaj);
		table_silaj.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_silajsirano.setText(table_silaj.getValueAt(table_silaj.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_silaj.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectSirano = Integer.parseInt(table_silaj.getValueAt(table_silaj.getSelectedRow(), 0).toString());
					String selectTarih = table_silaj.getValueAt(table_silaj.getSelectedRow(), 1).toString();
					String selectKapasite = table_silaj.getValueAt(table_silaj.getSelectedRow(), 2).toString();
					String selectRasyon = table_silaj.getValueAt(table_silaj.getSelectedRow(), 3).toString();
					String selectDeger = table_silaj.getValueAt(table_silaj.getSelectedRow(), 4).toString();
				
					int kapasite = Integer.parseInt(selectKapasite);
					int rasyon = Integer.parseInt(selectRasyon);
					int deger = Integer.parseInt(selectDeger);
					
					int igunluk = (kapasite * rasyon) ;
					String sgunluk = String.valueOf(igunluk);
					
					int iyillik = (igunluk * 365);
					String syillik = String.valueOf(iyillik);
					
					int ifiyat = (iyillik * deger);
					String sfiyat = String.valueOf(ifiyat);
					
					int ipaket = (iyillik / 1000);
					String spaket = String.valueOf(ipaket);
					
					try {
						boolean control = silaj.updateSilaj(selectSirano, selectTarih, selectKapasite, selectRasyon, selectDeger, sgunluk, syillik, sfiyat, spaket);
						if(control) {
							Helper.showMsg("success");
							updateSilajModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					
				}
			}
		});
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Hesaplama Tarihi : ");
		lblNewLabel_3_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_3_1.setBounds(10, 455, 144, 35);
		panel_silaj.add(lblNewLabel_3_3_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(191, 464, 137, 19);
		panel_silaj.add(dateChooser_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Hayvan Kapasitesi : ");
		lblNewLabel_3_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_2_1.setBounds(10, 495, 155, 35);
		panel_silaj.add(lblNewLabel_3_1_2_1);
		
		fld_skapaiste = new JTextField();
		fld_skapaiste.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_skapaiste.setColumns(10);
		fld_skapaiste.setBounds(191, 502, 137, 21);
		panel_silaj.add(fld_skapaiste);
		fld_skapaiste.addKeyListener(kl);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("Rasyon De\u011Feri : ");
		lblNewLabel_3_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_2_1.setBounds(10, 535, 127, 35);
		panel_silaj.add(lblNewLabel_3_2_2_1);
		
		fld_srasyon = new JTextField();
		fld_srasyon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_srasyon.setColumns(10);
		fld_srasyon.setBounds(191, 542, 137, 21);
		panel_silaj.add(fld_srasyon);
		fld_srasyon.addKeyListener(kl);
		for(int m = 0; m < rasyon.getRasyonList().size(); m++) {
			fld_srasyon.setText(rasyon.getRasyonList().get(m).getSilaj());
		}
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Fiyat(kg) : ");
		lblNewLabel_3_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_1_1_1.setBounds(10, 573, 127, 35);
		panel_silaj.add(lblNewLabel_3_2_1_1_1);
		
		fld_sfiyat = new JTextField();
		fld_sfiyat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sfiyat.setColumns(10);
		fld_sfiyat.setBounds(191, 580, 137, 21);
		panel_silaj.add(fld_sfiyat);
		fld_sfiyat.addKeyListener(kl);
		
		JButton btn_silajhesapla = new JButton("Hesapla");
		btn_silajhesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
				String date3 = "";
				try {
					date3 = sdf3.format(dateChooser_2.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date3.length() == 0  ) {
					Helper.showMsg("Lütfen geçerli bir tarih seçiniz !");
				}
				else {
					String kapasite = fld_skapaiste.getText();
					int selectkapasite = Integer.parseInt(kapasite);
					
					String rasyon = fld_srasyon.getText();
					int selectrasyon = Integer.parseInt(rasyon);
					
					String deger = fld_sfiyat.getText();
					int selectdeger = Integer.parseInt(deger);
					
					int selectgunluk = selectkapasite * selectrasyon;
					String gunluk = String.valueOf(selectgunluk);
					
					int selectyillik = (selectgunluk * 365) ;
					String yillik = String.valueOf(selectyillik);
					
					int selectfiyat = selectyillik * selectdeger;
					String fiyat = String.valueOf(selectfiyat);
					
					int selectpaket = (selectyillik / 1000);
					String paket = String.valueOf(selectpaket);
					
				
				if(fld_skapaiste.getText().length() == 0 || fld_sfiyat.getText().length() == 0 || fld_srasyon.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						boolean control = silaj.addSilaj(date3, kapasite, rasyon, deger, gunluk, yillik, fiyat, paket);
						if(control) {
							Helper.showMsg("success");
							fld_skapaiste.setText(null);
							fld_sfiyat.setText(null);
							updateSilajModel();
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
			}
		});
		btn_silajhesapla.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/save.png")));
		btn_silajhesapla.setForeground(Color.BLUE);
		btn_silajhesapla.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_silajhesapla.setBackground(Color.WHITE);
		btn_silajhesapla.setBounds(417, 520, 121, 28);
		panel_silaj.add(btn_silajhesapla);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/m\u0131s\u0131r.png")));
		lblNewLabel_2_1_1.setBounds(610, 502, 62, 64);
		panel_silaj.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("S\u0131ra NO : ");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1.setBounds(912, 513, 73, 35);
		panel_silaj.add(lblNewLabel_3_1_1_1_1);
		
		fld_silajsirano = new JTextField();
		fld_silajsirano.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_silajsirano.setColumns(10);
		fld_silajsirano.setBounds(995, 520, 137, 21);
		panel_silaj.add(fld_silajsirano);
		
		JButton btn_silajsil = new JButton("Sil");
		btn_silajsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_silajsirano.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					if(Helper.confirm("sure")) {
						int selectSira = Integer.parseInt(fld_silajsirano.getText());
						try {
							boolean control = silaj.deleteSilaj(selectSira);
							Helper.showMsg("success");
							fld_silajsirano.setText(null);
							updateSilajModel();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_silajsil.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/delete.png")));
		btn_silajsil.setForeground(Color.RED);
		btn_silajsil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_silajsil.setBackground(Color.WHITE);
		btn_silajsil.setBounds(1142, 517, 107, 25);
		panel_silaj.add(btn_silajsil);
		
		JPanel panel_fabrikayem = new JPanel();
		panel_fabrikayem.setBackground(Color.WHITE);
		tabbedPane.addTab("FABRÝKA YEMÝ", null, panel_fabrikayem, null);
		panel_fabrikayem.setLayout(null);
		
		JScrollPane scrollPane_fabrikayem = new JScrollPane();
		scrollPane_fabrikayem.setBounds(10, 10, 1239, 439);
		panel_fabrikayem.add(scrollPane_fabrikayem);
		
		table_yem = new JTable(yemModel);
		scrollPane_fabrikayem.setViewportView(table_yem);
		table_yem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_yemsira.setText(table_yem.getValueAt(table_yem.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_yem.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectSirano = Integer.parseInt(table_yem.getValueAt(table_yem.getSelectedRow(), 0).toString());
					String selectTarih = table_yem.getValueAt(table_yem.getSelectedRow(), 1).toString();
					String selectKapasite = table_yem.getValueAt(table_yem.getSelectedRow(), 2).toString();
					String selectRasyon = table_yem.getValueAt(table_yem.getSelectedRow(), 3).toString();
					String selectDeger = table_yem.getValueAt(table_yem.getSelectedRow(), 4).toString();
				
					int kapasite = Integer.parseInt(selectKapasite);
					int rasyon = Integer.parseInt(selectRasyon);
					int deger = Integer.parseInt(selectDeger);
					
					int igunluk = (kapasite * rasyon) ;
					String sgunluk = String.valueOf(igunluk);
					
					int iyillik = (igunluk * 365);
					String syillik = String.valueOf(iyillik);
					
					int ifiyat = (iyillik * deger);
					String sfiyat = String.valueOf(ifiyat);
					
					int ipaket = (iyillik / 50);
					String spaket = String.valueOf(ipaket);
					
					try {
						boolean control = yem.updateYem(selectSirano, selectTarih, selectKapasite, selectRasyon, selectDeger, sgunluk, syillik, sfiyat, spaket);
						if(control) {
							Helper.showMsg("success");
							updateYemModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Hesaplama Tarihi : ");
		lblNewLabel_3_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_3_1_1.setBounds(10, 455, 144, 35);
		panel_fabrikayem.add(lblNewLabel_3_3_1_1);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(191, 464, 137, 19);
		panel_fabrikayem.add(dateChooser_3);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Hayvan Kapasitesi : ");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_2_1_1.setBounds(10, 495, 155, 35);
		panel_fabrikayem.add(lblNewLabel_3_1_2_1_1);
		
		fld_fkapasite = new JTextField();
		fld_fkapasite.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_fkapasite.setColumns(10);
		fld_fkapasite.setBounds(191, 502, 137, 21);
		panel_fabrikayem.add(fld_fkapasite);
		fld_fkapasite.addKeyListener(kl);
		
		JLabel lblNewLabel_3_2_2_1_1 = new JLabel("Rasyon De\u011Feri : ");
		lblNewLabel_3_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_2_1_1.setBounds(10, 535, 127, 35);
		panel_fabrikayem.add(lblNewLabel_3_2_2_1_1);
		
		fld_frasyon = new JTextField();
		fld_frasyon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_frasyon.setColumns(10);
		fld_frasyon.setBounds(191, 542, 137, 21);
		panel_fabrikayem.add(fld_frasyon);
		fld_frasyon.addKeyListener(kl);
		for(int b = 0; b < rasyon.getRasyonList().size(); b++) {
			fld_frasyon.setText(rasyon.getRasyonList().get(b).getYem());
		}
		
		JLabel lblNewLabel_3_2_1_1_1_1 = new JLabel("Fiyat(kg) : ");
		lblNewLabel_3_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2_1_1_1_1.setBounds(10, 573, 127, 35);
		panel_fabrikayem.add(lblNewLabel_3_2_1_1_1_1);
		
		fld_ffiyat = new JTextField();
		fld_ffiyat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ffiyat.setColumns(10);
		fld_ffiyat.setBounds(191, 580, 137, 21);
		panel_fabrikayem.add(fld_ffiyat);
		fld_ffiyat.addKeyListener(kl);
		
		JButton btn_yemhesap = new JButton("Hesapla");
		btn_yemhesap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
				String date4 = "";
				try {
					date4 = sdf4.format(dateChooser_3.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date4.length() == 0  ) {
					Helper.showMsg("Lütfen geçerli bir tarih seçiniz !");
				}
				else {
					String kapasite = fld_fkapasite.getText();
					int selectkapasite = Integer.parseInt(kapasite);
					
					String rasyon = fld_frasyon.getText();
					int selectrasyon = Integer.parseInt(rasyon);
					
					String deger = fld_ffiyat.getText();
					int selectdeger = Integer.parseInt(deger);
					
					int selectgunluk = selectkapasite * selectrasyon;
					String gunluk = String.valueOf(selectgunluk);
					
					int selectyillik = (selectgunluk * 365) ;
					String yillik = String.valueOf(selectyillik);
					
					int selectfiyat = selectyillik * selectdeger;
					String fiyat = String.valueOf(selectfiyat);
					
					int selectpaket = (selectyillik / 50);
					String paket = String.valueOf(selectpaket);
					
				if(fld_ffiyat.getText().length() == 0 || fld_fkapasite.getText().length() == 0 || fld_frasyon.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						boolean control = yem.addYem(date4, kapasite, rasyon, deger, gunluk, yillik, fiyat, paket);
						if(control) {
							Helper.showMsg("success");
						fld_fkapasite.setText(null);
						fld_ffiyat.setText(null);
						updateYemModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				}
			}
		});
		btn_yemhesap.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/save.png")));
		btn_yemhesap.setForeground(Color.BLUE);
		btn_yemhesap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_yemhesap.setBackground(Color.WHITE);
		btn_yemhesap.setBounds(417, 520, 121, 28);
		panel_fabrikayem.add(btn_yemhesap);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/sack.png")));
		lblNewLabel_2_1_1_1.setBounds(610, 502, 62, 64);
		panel_fabrikayem.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("S\u0131ra NO : ");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_1.setBounds(912, 513, 73, 35);
		panel_fabrikayem.add(lblNewLabel_3_1_1_1_1_1);
		
		fld_yemsira = new JTextField();
		fld_yemsira.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_yemsira.setColumns(10);
		fld_yemsira.setBounds(995, 520, 137, 21);
		panel_fabrikayem.add(fld_yemsira);
		
		JButton btn_yemsil = new JButton("Sil");
		btn_yemsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_yemsira.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir deger giriniz !");
				}else {
					int selectSira = Integer.parseInt(fld_yemsira.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = yem.deleteYem(selectSira);
							if(control) {
								Helper.showMsg("success");
								fld_yemsira.setText(null);
								updateYemModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_yemsil.setIcon(new ImageIcon(DepoGUI.class.getResource("/View/delete.png")));
		btn_yemsil.setForeground(Color.RED);
		btn_yemsil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_yemsil.setBackground(Color.WHITE);
		btn_yemsil.setBounds(1142, 517, 107, 25);
		panel_fabrikayem.add(btn_yemsil);
		fld_deger.addKeyListener(kl);
	}
	public void updateSamanModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_saman.getModel();
		clearModel.setRowCount(0);
		for(int j = 0; j < saman.getSamanList().size(); j++) {
			samanData[0] = saman.getSamanList().get(j).getSira_no();
			samanData[1] = saman.getSamanList().get(j).getTarih();
			samanData[2] = saman.getSamanList().get(j).getKapasite();
			samanData[3] = saman.getSamanList().get(j).getRasyon();
			samanData[4] = saman.getSamanList().get(j).getDeger();
			samanData[5] = saman.getSamanList().get(j).getGunluk_gider();
			samanData[6] = saman.getSamanList().get(j).getYillik_gider();
			samanData[7] = saman.getSamanList().get(j).getFiyat();
			samanData[8] = saman.getSamanList().get(j).getKucuk_balya();
			samanData[9] = saman.getSamanList().get(j).getBuyuk_balya();
			samanModel.addRow(samanData);
		}
	}
	public void updateKuruotModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_kuruot.getModel();
		clearModel.setRowCount(0);
		for(int k = 0 ; k < kuruot.getKuruotList().size(); k++) {
			kuruotData[0] = kuruot.getKuruotList().get(k).getSira_no();
			kuruotData[1] = kuruot.getKuruotList().get(k).getTarih();
			kuruotData[2] = kuruot.getKuruotList().get(k).getKapasite();
			kuruotData[3] = kuruot.getKuruotList().get(k).getRasyon();
			kuruotData[4] = kuruot.getKuruotList().get(k).getDeger();
			kuruotData[5] = kuruot.getKuruotList().get(k).getGunluk_gider();
			kuruotData[6] = kuruot.getKuruotList().get(k).getYillik_gider();
			kuruotData[7] = kuruot.getKuruotList().get(k).getFiyat();
			kuruotData[8] = kuruot.getKuruotList().get(k).getKucuk_balya();
			kuruotData[9] = kuruot.getKuruotList().get(k).getBuyuk_balya();
			kuruotModel.addRow(kuruotData);
		}
	}
	public void updateSilajModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_silaj.getModel();
		clearModel.setRowCount(0);
		for(int l = 0; l < silaj.getSilajList().size(); l++) {
			silajData[0] = silaj.getSilajList().get(l).getSira_no();
			silajData[1] = silaj.getSilajList().get(l).getTarih();
			silajData[2] = silaj.getSilajList().get(l).getKapasite();
			silajData[3] = silaj.getSilajList().get(l).getRasyon();
			silajData[4] = silaj.getSilajList().get(l).getDeger();
			silajData[5] = silaj.getSilajList().get(l).getGunluk_gider();
			silajData[6] = silaj.getSilajList().get(l).getYillik_gider();
			silajData[7] = silaj.getSilajList().get(l).getFiyat();
			silajData[8] = silaj.getSilajList().get(l).getPaket();
			silajModel.addRow(silajData);
		}
	}
	public void updateYemModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_yem.getModel();
		clearModel.setRowCount(0);
		for(int a = 0; a < yem.getYemList().size(); a++) {
			yemData[0] = yem.getYemList().get(a).getSira_no();
			yemData[1] = yem.getYemList().get(a).getTarih();
			yemData[2] = yem.getYemList().get(a).getKapasite();
			yemData[3] = yem.getYemList().get(a).getRasyon();
			yemData[4] = yem.getYemList().get(a).getDeger();
			yemData[5] = yem.getYemList().get(a).getGunluk_gider();
			yemData[6] = yem.getYemList().get(a).getYillik_gider();
			yemData[7] = yem.getYemList().get(a).getFiyat();
			yemData[8] = yem.getYemList().get(a).getPaket();
			yemModel.addRow(yemData);
		}
	}
}
