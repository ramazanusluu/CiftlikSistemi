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

import Model.Yonetici;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Helper.*;
import java.awt.Toolkit;

public class YoneticiGUI extends JFrame {
	
	static Yonetici yonetici = new Yonetici();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	private JPanel contentPane_yonetici;
	private JTextField fld_adsoyad;
	private JTextField fld_tcno;
	private JTextField fld_kuladi;
	private JTextField fld_sifre;
	private JTextField fld_telefon;
	private JTextField fld_id;
	private JTable table_kullanici;
	private DefaultTableModel kullaniciModel = null;
	private Object[]  kullaniciData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiGUI frame = new YoneticiGUI(yonetici);
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
	public YoneticiGUI(Yonetici yonetici) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(YoneticiGUI.class.getResource("/View/uygulama.png")));
		
		kullaniciModel = new DefaultTableModel();
		Object[] colKullaniciName = new Object[7];
		colKullaniciName[0] = "ID";
		colKullaniciName[1] = "Ad Soyad";
		colKullaniciName[2] = "TC No";
		colKullaniciName[3] = "Kullanýcý Adý";
		colKullaniciName[4] = "Sifre";
		colKullaniciName[5] = "Telefon";
		colKullaniciName[6] = "Yetki";
		kullaniciModel.setColumnIdentifiers(colKullaniciName);
		kullaniciData = new Object[7];
		for(int i=0; i< yonetici.getKullaniciList().size(); i++) {
			kullaniciData[0] = yonetici.getKullaniciList().get(i).getId();
			kullaniciData[1] = yonetici.getKullaniciList().get(i).getName();
			kullaniciData[2] = yonetici.getKullaniciList().get(i).getTcno();
			kullaniciData[3] = yonetici.getKullaniciList().get(i).getUsername();
			kullaniciData[4] = yonetici.getKullaniciList().get(i).getPassword();
			kullaniciData[5] = yonetici.getKullaniciList().get(i).getPhone();
			kullaniciData[6] = yonetici.getKullaniciList().get(i).getType();
			kullaniciModel.addRow(kullaniciData);
			
		}
		
		
		setTitle("Y\u00D6NET\u0130C\u0130 EKRANI ");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane_yonetici = new JPanel();
		contentPane_yonetici.setBackground(Color.WHITE);
		contentPane_yonetici.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_yonetici);
		contentPane_yonetici.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ho\u015Fgeldiniz Say\u0131n ; " + yonetici.getName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 310, 35);
		contentPane_yonetici.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(617, 10, 75, 35);
		contentPane_yonetici.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u00C7IKI\u015E");
		btnNewButton.setIcon(new ImageIcon(YoneticiGUI.class.getResource("/View/out.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBounds(1190, 10, 85, 21);
		contentPane_yonetici.add(btnNewButton);
		
		JScrollPane scrollPane_kullanici = new JScrollPane();
		scrollPane_kullanici.setBounds(10, 56, 962, 645);
		contentPane_yonetici.add(scrollPane_kullanici);
		
		table_kullanici = new JTable(kullaniciModel);
		scrollPane_kullanici.setViewportView(table_kullanici);
		table_kullanici.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_id.setText(table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_kullanici.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 0).toString());
					String selectName = table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 1).toString();
					String selectTcno = table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 2).toString();
					String selectKuladi = table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 3).toString();
					String selectSifre = table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 4).toString();
					String selectTelefon = table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 5).toString();
					String selectType = table_kullanici.getValueAt(table_kullanici.getSelectedRow(), 6).toString();
				
				try {
					boolean control = yonetici.updateKullanici(selectID, selectName, selectTcno, selectKuladi, selectSifre, selectTelefon ,selectType);
					if(control) {
						Helper.showMsg("success");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				}
			}
		});
		
		JLabel lbl_kullanicilogo = new JLabel(new ImageIcon(getClass().getResource("kullanici.png")));
		lbl_kullanicilogo.setBounds(1096, 56, 75, 70);
		contentPane_yonetici.add(lbl_kullanicilogo);
		
		JLabel lblNewLabel_2 = new JLabel("Yeni Kullan\u0131c\u0131 Bilgilerini Giriniz...");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(998, 136, 262, 41);
		contentPane_yonetici.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ad\u0131 Soyad\u0131 :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(998, 179, 104, 33);
		contentPane_yonetici.add(lblNewLabel_3);
		
		fld_adsoyad = new JTextField();
		fld_adsoyad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_adsoyad.setColumns(10);
		fld_adsoyad.setBounds(1106, 187, 136, 19);
		contentPane_yonetici.add(fld_adsoyad);
		//fld_adsoyad.addKeyListener(hl);
		
		JLabel lblNewLabel_4 = new JLabel("T.C. No :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(998, 211, 104, 33);
		contentPane_yonetici.add(lblNewLabel_4);
		
		fld_tcno = new JTextField();
		fld_tcno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(1106, 216, 136, 19);
		contentPane_yonetici.add(fld_tcno);
		fld_tcno.addKeyListener(kl);
		
		JLabel lblNewLabel_5 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(998, 240, 104, 33);
		contentPane_yonetici.add(lblNewLabel_5);
		
		fld_kuladi = new JTextField();
		fld_kuladi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kuladi.setColumns(10);
		fld_kuladi.setBounds(1106, 248, 136, 19);
		contentPane_yonetici.add(fld_kuladi);
		
		JLabel lblNewLabel_6 = new JLabel("\u015Eifre :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(998, 271, 104, 33);
		contentPane_yonetici.add(lblNewLabel_6);
		
		fld_sifre = new JTextField();
		fld_sifre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sifre.setColumns(10);
		fld_sifre.setBounds(1106, 279, 136, 19);
		contentPane_yonetici.add(fld_sifre);
		
		JLabel lblNewLabel_7 = new JLabel("Telefon No :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(998, 303, 104, 33);
		contentPane_yonetici.add(lblNewLabel_7);
		
		fld_telefon = new JTextField();
		fld_telefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_telefon.setColumns(10);
		fld_telefon.setBounds(1106, 311, 136, 19);
		contentPane_yonetici.add(fld_telefon);
		fld_telefon.addKeyListener(kl);
		
		JLabel lblNewLabel_8 = new JLabel("Yetki :");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(998, 335, 104, 33);
		contentPane_yonetici.add(lblNewLabel_8);
		
		JComboBox comboBox_yetki = new JComboBox();
		comboBox_yetki.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_yetki.setModel(new DefaultComboBoxModel(new String[] {"seciniz","yonetici", "calisan", "veteriner"}));
		comboBox_yetki.setBackground(Color.WHITE);
		comboBox_yetki.setBounds(1106, 342, 136, 21);
		contentPane_yonetici.add(comboBox_yetki);
		
		
		
		JButton btn_kullanicikaydet = new JButton("Kaydet");
		btn_kullanicikaydet.setIcon(new ImageIcon(YoneticiGUI.class.getResource("/View/save.png")));
		btn_kullanicikaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yetki = comboBox_yetki.getSelectedItem().toString();
				if(fld_adsoyad.getText().length()==0 || fld_tcno.getText().length()==0 || fld_kuladi.getText().length()==0 || fld_sifre.getText().length()==0 || fld_telefon.getText().length()==0 || yetki.equals("seciniz")) {
					Helper.showMsg("Lütfen boþ alanlarý doldurunuz veya yetki seçiniz");
				}	
				else {
					
					try {
						boolean kontrol = yonetici.addKullanici(fld_adsoyad.getText(), fld_tcno.getText(), fld_kuladi.getText(), fld_sifre.getText(), fld_telefon.getText(), yetki);
						if(kontrol) {
							Helper.showMsg("success");
							fld_adsoyad.setText(null);
							fld_tcno.setText(null);
							fld_kuladi.setText(null);
							fld_sifre.setText(null);
							fld_telefon.setText(null);
							updateKullaniciModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_kullanicikaydet.setForeground(Color.BLUE);
		btn_kullanicikaydet.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_kullanicikaydet.setBackground(Color.WHITE);
		btn_kullanicikaydet.setBounds(1073, 395, 95, 21);
		contentPane_yonetici.add(btn_kullanicikaydet);
		
		JLabel lblNewLabel_9 = new JLabel("Silmek \u0130stedi\u011Finiz Kullan\u0131c\u0131;");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(998, 590, 262, 41);
		contentPane_yonetici.add(lblNewLabel_9);
		
		fld_id = new JTextField();
		fld_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_id.setColumns(10);
		fld_id.setBounds(1106, 641, 136, 19);
		contentPane_yonetici.add(fld_id);
		
		JButton btn_kullanicisil = new JButton("Sil");
		btn_kullanicisil.setIcon(new ImageIcon(YoneticiGUI.class.getResource("/View/delete.png")));
		btn_kullanicisil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_id.getText().length()==0) {
					Helper.showMsg("Lütfen geçerli bir kullanýcý seçiniz !");
				}
				else {
					if(Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_id.getText());
						try {
							boolean control = yonetici.deleteKullanici(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_id.setText(null);
								updateKullaniciModel();
							}
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			}
		});
		btn_kullanicisil.setForeground(Color.RED);
		btn_kullanicisil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btn_kullanicisil.setBackground(Color.WHITE);
		btn_kullanicisil.setBounds(1073, 680, 95, 21);
		contentPane_yonetici.add(btn_kullanicisil);
		
		JLabel lblNewLabel_10 = new JLabel("Id :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(998, 633, 104, 33);
		contentPane_yonetici.add(lblNewLabel_10);
		
	}
		public void updateKullaniciModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_kullanici.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i< yonetici.getKullaniciList().size(); i++) {
			kullaniciData[0] = yonetici.getKullaniciList().get(i).getId();
			kullaniciData[1] = yonetici.getKullaniciList().get(i).getName();
			kullaniciData[2] = yonetici.getKullaniciList().get(i).getTcno();
			kullaniciData[3] = yonetici.getKullaniciList().get(i).getUsername();
			kullaniciData[4] = yonetici.getKullaniciList().get(i).getPassword();
			kullaniciData[5] = yonetici.getKullaniciList().get(i).getPhone();
			kullaniciData[6] = yonetici.getKullaniciList().get(i).getType();
			kullaniciModel.addRow(kullaniciData);
			
		}
	}
}
