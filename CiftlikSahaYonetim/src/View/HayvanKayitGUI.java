package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Hayvan;
import Model.Kullanici;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import Helper.*;

public class HayvanKayitGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();
	Hayvan hayvan = new Hayvan();

	private JPanel contentPane;
	private JTextField fld_kupeno;
	private JTextField fld_ikupeno;
	private JTextField fld_annekupe;
	private JTextField fld_babakupe;
	private JTextField fld_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HayvanKayitGUI frame = new HayvanKayitGUI(kullanici);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HayvanKayitGUI(Kullanici kullanici) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HayvanKayitGUI.class.getResource("/View/uygulama.png")));
		setBackground(Color.WHITE);
		setTitle("Hayvan Kay\u0131t Ekran\u0131");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(275, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 75, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnKapat = new JButton("KAPAT");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HayvanGUI hgui = new HayvanGUI(kullanici);
					hgui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnKapat.setIcon(new ImageIcon(HayvanKayitGUI.class.getResource("/View/out.png")));
		btnKapat.setForeground(Color.RED);
		btnKapat.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnKapat.setBackground(Color.WHITE);
		btnKapat.setBounds(864, 10, 110, 21);
		contentPane.add(btnKapat);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(HayvanKayitGUI.class.getResource("/View/inek.png")));
		lblNewLabel.setBounds(447, 49, 75, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Hayvan Kimlik Bilgilerini Giriniz");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(154, 136, 275, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hayvan Anne-Baba Bilgilerini Giriniz");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(557, 136, 307, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Kulak K\u00FCpe No :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(154, 181, 120, 33);
		contentPane.add(lblNewLabel_3);
		
		fld_kupeno = new JTextField();
		fld_kupeno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kupeno.setColumns(10);
		fld_kupeno.setBounds(278, 187, 136, 19);
		contentPane.add(fld_kupeno);
		
		JLabel lblNewLabel_4 = new JLabel("\u0130\u015Fletme K\u00FCpe No :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(154, 213, 120, 33);
		contentPane.add(lblNewLabel_4);
		
		fld_ikupeno = new JTextField();
		fld_ikupeno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ikupeno.setColumns(10);
		fld_ikupeno.setBounds(278, 219, 136, 19);
		contentPane.add(fld_ikupeno);
		
		JLabel lblNewLabel_5 = new JLabel("Cinsi : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(153, 277, 120, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cinsiyet : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(153, 308, 120, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Do\u011Fum Tarihi : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(153, 340, 120, 33);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_cins = new JComboBox();
		comboBox_cins.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "Holstein", "Simental", "Montofon", "Jersey"}));
		comboBox_cins.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_cins.setBackground(Color.WHITE);
		comboBox_cins.setBounds(277, 283, 136, 21);
		contentPane.add(comboBox_cins);
		
		fld_name = new JTextField();
		fld_name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_name.setColumns(10);
		fld_name.setBounds(278, 252, 136, 19);
		contentPane.add(fld_name);
		
		JRadioButton rdbtnDisi = new JRadioButton("Di\u015Fi");
		rdbtnDisi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnDisi.setBackground(Color.WHITE);
		rdbtnDisi.setBounds(277, 316, 75, 21);
		contentPane.add(rdbtnDisi);
		
		JRadioButton rdbtn_erkek = new JRadioButton("Erkek");
		rdbtn_erkek.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtn_erkek.setBackground(Color.WHITE);
		rdbtn_erkek.setBounds(351, 316, 75, 21);
		contentPane.add(rdbtn_erkek);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnDisi);
		bg.add(rdbtn_erkek);
		
		JDateChooser dogumtarih = new JDateChooser();
		dogumtarih.setBounds(277, 348, 136, 19);
		contentPane.add(dogumtarih);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hayvan Genel Bilgilerini Giriniz");
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(153, 399, 275, 35);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Kay\u0131t Tarihi : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(153, 444, 120, 33);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Verim Puan\u0131 :");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(153, 476, 120, 33);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Durumu : ");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(153, 505, 120, 33);
		contentPane.add(lblNewLabel_5_1);
		
		JComboBox comboBox_durum = new JComboBox();
		comboBox_durum.setModel(new DefaultComboBoxModel(new String[] {"Canl\u0131", "\u00D6l\u00FC", "Sat\u0131ld\u0131"}));
		comboBox_durum.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_durum.setBackground(Color.WHITE);
		comboBox_durum.setBounds(277, 511, 136, 21);
		contentPane.add(comboBox_durum);
		
		JDateChooser kayittarih = new JDateChooser();
		kayittarih.setBounds(277, 452, 136, 19);
		contentPane.add(kayittarih);
		
		JComboBox comboBox_verim = new JComboBox();
		comboBox_verim.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "D\u00FC\u015F\u00FCk", "Orta", "Y\u00FCksek"}));
		comboBox_verim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_verim.setBackground(Color.WHITE);
		comboBox_verim.setBounds(277, 482, 136, 21);
		contentPane.add(comboBox_verim);
		
		JLabel lblNewLabel_4_2 = new JLabel("Anne K\u00FCpe No :");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_2.setBounds(557, 187, 132, 33);
		contentPane.add(lblNewLabel_4_2);
		
		fld_annekupe = new JTextField();
		fld_annekupe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_annekupe.setColumns(10);
		fld_annekupe.setBounds(699, 195, 136, 19);
		contentPane.add(fld_annekupe);
		
		JLabel lblNewLabel_5_2 = new JLabel("Anne Verim Puan\u0131 :");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_2.setBounds(557, 216, 132, 33);
		contentPane.add(lblNewLabel_5_2);
		
		JComboBox comboBox_anneverim = new JComboBox();
		comboBox_anneverim.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "D\u00FC\u015F\u00FCk", "Orta", "Y\u00FCksek"}));
		comboBox_anneverim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_anneverim.setBackground(Color.WHITE);
		comboBox_anneverim.setBounds(699, 224, 136, 21);
		contentPane.add(comboBox_anneverim);
		
		JLabel lblNewLabel_4_3 = new JLabel("Baba K\u00FCpe No : ");
		lblNewLabel_4_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_3.setBounds(557, 247, 132, 33);
		contentPane.add(lblNewLabel_4_3);
		
		fld_babakupe = new JTextField();
		fld_babakupe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_babakupe.setColumns(10);
		fld_babakupe.setBounds(699, 256, 136, 19);
		contentPane.add(fld_babakupe);
		
		JLabel lblNewLabel_5_3 = new JLabel("Baba Verim Puan\u0131 :");
		lblNewLabel_5_3.setBackground(Color.WHITE);
		lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_3.setBounds(557, 277, 132, 33);
		contentPane.add(lblNewLabel_5_3);
		
		JComboBox comboBox_babaverim = new JComboBox();
		comboBox_babaverim.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "D\u00FC\u015F\u00FCk", "Orta", "Y\u00FCksek"}));
		comboBox_babaverim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_babaverim.setBackground(Color.WHITE);
		comboBox_babaverim.setBounds(699, 285, 136, 21);
		contentPane.add(comboBox_babaverim);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.setIcon(new ImageIcon(HayvanKayitGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cins = comboBox_cins.getSelectedItem().toString();
				String verim = comboBox_verim.getSelectedItem().toString();
				String durum = comboBox_durum.getSelectedItem().toString();
				String anneVerim = comboBox_anneverim.getSelectedItem().toString();
				String babaVerim = comboBox_babaverim.getSelectedItem().toString();
				String cinsiyet = null;
				if(rdbtnDisi.isSelected()) {
					cinsiyet = "Diþi";
				}
				if(rdbtn_erkek.isSelected()) {
					cinsiyet = "Erkek";
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dogumdate = "";
				try {
					dogumdate = sdf.format(dogumtarih.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(dogumdate.length() == 0  ) {
					Helper.showMsg("Lütfen geçerli bir doðum tarihi giriniz !");
				}
				else {
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					String kayitdate = "";
					try {
						kayitdate = sdf2.format(kayittarih.getDate());
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if(kayitdate.length() == 0  ) {
						Helper.showMsg("Lütfen geçerli bir kayit tarihi giriniz !");
					}
					else {
						if(cinsiyet == null || cins.equals("Seçiniz") || verim.equals("Seçiniz") || anneVerim.equals("Seçiniz") || babaVerim.equals("Seçiniz") ||
								fld_kupeno.getText().length() == 0 || fld_ikupeno.getText().length() == 0 || fld_annekupe.getText().length() == 0 || fld_babakupe.getText().length() == 0 || fld_name.getText().length() == 0){
							Helper.showMsg("fill");
						}
						else {
							try {
								boolean control = hayvan.addHayvan(fld_kupeno.getText(), fld_ikupeno.getText(), fld_name.getText(), cins, cinsiyet, dogumdate, kayitdate, fld_annekupe.getText(), anneVerim , fld_babakupe.getText(), babaVerim, verim, durum );
								if(control) {
									Helper.showMsg("success");
									fld_kupeno.setText(null);
									fld_ikupeno.setText(null);
									fld_name.setText(null);
									fld_annekupe.setText(null);
									fld_babakupe.setText(null);
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					}
				}
			}
		});
		btn_kaydet.setBounds(427, 568, 120, 26);
		contentPane.add(btn_kaydet);
		
		JLabel lblNewLabel_4_4 = new JLabel("Ad\u0131 : ");
		lblNewLabel_4_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_4.setBounds(154, 246, 120, 33);
		contentPane.add(lblNewLabel_4_4);
		
		
	}
}
