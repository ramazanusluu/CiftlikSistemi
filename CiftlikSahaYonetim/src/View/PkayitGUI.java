package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Kullanici;
import Model.Personel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import Helper.*;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PkayitGUI extends JFrame {
	static Kullanici kullanici = new Kullanici();
	
	HarfList hf = new HarfList();
	KeyList kl = new KeyList();
	
	Personel personel = new Personel();
	
	private JPanel contentPane;
	private JTextField fld_adsoyad;
	private JTextField fld_tcno;
	private JTextField fld_telefon;
	private JTextField fld_adres;
	private JTextField fld_resim;
	private JTextField fld_gorev;
	private JTextField fld_maas;
	private JTextField fld_iban;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PkayitGUI frame = new PkayitGUI(kullanici);
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
	public PkayitGUI(Kullanici kullanici) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PkayitGUI.class.getResource("/View/uygulama.png")));
		setTitle("Personel Kay\u0131t Ekran\u0131");
		setBackground(Color.WHITE);
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
						PersonelGUI  pegui = new PersonelGUI(kullanici);
						pegui.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnKapat.setIcon(new ImageIcon(PkayitGUI.class.getResource("/View/out.png")));
		btnKapat.setForeground(Color.RED);
		btnKapat.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnKapat.setBackground(Color.WHITE);
		btnKapat.setBounds(864, 10, 110, 21);
		contentPane.add(btnKapat);
		
		JLabel lblNewLabel = new JLabel("Personel Genel Bilgilerini Giriniz");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 136, 313, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Ad\u0131 Soyad\u0131 : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 169, 110, 35);
		contentPane.add(lblNewLabel_2);
		
		fld_adsoyad = new JTextField();
		fld_adsoyad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_adsoyad.setBounds(130, 175, 149, 21);
		contentPane.add(fld_adsoyad);
		fld_adsoyad.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("T.C. No :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 197, 110, 35);
		contentPane.add(lblNewLabel_2_1);
		
		fld_tcno = new JTextField();
		fld_tcno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(130, 203, 149, 21);
		contentPane.add(fld_tcno);
		fld_tcno.addKeyListener(kl);
		
		JLabel lblNewLabel_2_2 = new JLabel("Cinsiyet : ");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 225, 110, 35);
		contentPane.add(lblNewLabel_2_2);
		
		JRadioButton rdbtn_erkek = new JRadioButton("Erkek");
		rdbtn_erkek.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtn_erkek.setBackground(Color.WHITE);
		rdbtn_erkek.setBounds(204, 233, 75, 21);
		contentPane.add(rdbtn_erkek);
		
		JRadioButton rdbtnKz = new JRadioButton("Kad\u0131n");
		rdbtnKz.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnKz.setBackground(Color.WHITE);
		rdbtnKz.setBounds(130, 233, 75, 21);
		contentPane.add(rdbtnKz);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnKz);
		bg.add(rdbtn_erkek);
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefon : ");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(10, 255, 110, 35);
		contentPane.add(lblNewLabel_2_3);
		
		fld_telefon = new JTextField();
		fld_telefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_telefon.setColumns(10);
		fld_telefon.setBounds(130, 261, 149, 21);
		contentPane.add(fld_telefon);
		fld_telefon.addKeyListener(kl);
		
		JLabel lblNewLabel_2_4 = new JLabel("Adres : ");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(10, 284, 110, 35);
		contentPane.add(lblNewLabel_2_4);
		
		fld_adres = new JTextField();
		fld_adres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_adres.setColumns(10);
		fld_adres.setBounds(130, 290, 149, 21);
		contentPane.add(fld_adres);
		
		JLabel lblNewLabel_2_5 = new JLabel("Resim : ");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_5.setBounds(10, 312, 110, 35);
		contentPane.add(lblNewLabel_2_5);
		
		fld_resim = new JTextField();
		fld_resim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_resim.setColumns(10);
		fld_resim.setBounds(130, 318, 102, 21);
		contentPane.add(fld_resim);
		fld_resim.addKeyListener(kl);
		fld_resim.addKeyListener(hf);
		
		JPanel panel_resimsec = new JPanel();
		panel_resimsec.setBounds(728, 136, 246, 296);
		contentPane.add(panel_resimsec);
		panel_resimsec.setLayout(null);
		
		JLabel lbl_resim = new JLabel("");
		lbl_resim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_resim.setBounds(10, 10, 226, 276);
		panel_resimsec.add(lbl_resim);
		
		JButton btn_sec = new JButton("...");
		btn_sec.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sec.setBackground(Color.WHITE);
		btn_sec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChosser = new JFileChooser();
				if(fileChosser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
					fld_resim.setText(fileChosser.getSelectedFile().getAbsolutePath());
					ImageIcon imgThisImg = new ImageIcon(fileChosser.getSelectedFile().getAbsolutePath());
					lbl_resim.setIcon(imgThisImg);
				}
				
			}
		});
		btn_sec.setBounds(237, 318, 42, 21);
		contentPane.add(btn_sec);
	
		
		JLabel lblPersonelIBilgilerini = new JLabel("Personel \u0130\u015F Bilgilerini Giriniz");
		lblPersonelIBilgilerini.setForeground(Color.BLUE);
		lblPersonelIBilgilerini.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPersonelIBilgilerini.setBounds(10, 357, 313, 35);
		contentPane.add(lblPersonelIBilgilerini);
		
		JLabel lblNewLabel_2_6 = new JLabel("Ba\u015Flama Tarihi : ");
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_6.setBounds(10, 390, 110, 35);
		contentPane.add(lblNewLabel_2_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(130, 400, 149, 21);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_2_7 = new JLabel("G\u00F6revi :");
		lblNewLabel_2_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_7.setBounds(10, 423, 110, 35);
		contentPane.add(lblNewLabel_2_7);
		
		fld_gorev = new JTextField();
		fld_gorev.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_gorev.setColumns(10);
		fld_gorev.setBounds(130, 429, 149, 21);
		contentPane.add(fld_gorev);
		
		JLabel lblPersonelMaliBilgilerini = new JLabel("Personel Mali Bilgilerini Giriniz");
		lblPersonelMaliBilgilerini.setForeground(Color.BLUE);
		lblPersonelMaliBilgilerini.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPersonelMaliBilgilerini.setBounds(10, 468, 313, 35);
		contentPane.add(lblPersonelMaliBilgilerini);
		
		JLabel lblNewLabel_2_8 = new JLabel("Maa\u015F : ");
		lblNewLabel_2_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_8.setBounds(10, 501, 110, 35);
		contentPane.add(lblNewLabel_2_8);
		
		fld_maas = new JTextField();
		fld_maas.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_maas.setColumns(10);
		fld_maas.setBounds(130, 507, 87, 21);
		contentPane.add(fld_maas);
		fld_maas.addKeyListener(kl);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("IBAN : ");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 529, 110, 35);
		contentPane.add(lblNewLabel_2_1_1);
		
		fld_iban = new JTextField();
		fld_iban.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_iban.setColumns(10);
		fld_iban.setBounds(130, 535, 149, 21);
		contentPane.add(fld_iban);
		
		JComboBox comboBox_para = new JComboBox();
		comboBox_para.setModel(new DefaultComboBoxModel(new String[] {"TL", "Dolar", "Euro"}));
		comboBox_para.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox_para.setBackground(Color.WHITE);
		comboBox_para.setBounds(223, 507, 56, 21);
		contentPane.add(comboBox_para);
		
		JButton btnNewButton = new JButton("KAYDET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String para = fld_maas.getText();
				String secim = comboBox_para.getSelectedItem().toString();
				String maas = para +" "+ secim;
				String cinsiyet = null;
				if(rdbtnKz.isSelected()) {
					cinsiyet = "Kadýn";
				}
				if(rdbtn_erkek.isSelected()) {
					cinsiyet = "Erkek";
				}
				
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
				if(cinsiyet == null || fld_adsoyad.getText().length() == 0 || fld_tcno.getText().length() == 0 || fld_telefon.getText().length() == 0 || fld_adres.getText().length() == 0 || fld_gorev.getText().length() == 0 || fld_iban.getText().length() == 0){
				Helper.showMsg("fill");	
				}else {
					try {
						boolean control = personel.addPersonel(fld_adsoyad.getText(), fld_tcno.getText(), cinsiyet, fld_telefon.getText(), fld_adres.getText(), fld_resim.getText(), date, fld_gorev.getText(), maas, fld_iban.getText());
						if(control) {
							Helper.showMsg("success");
							fld_adsoyad.setText(null);
							fld_tcno.setText(null);
							fld_telefon.setText(null);
							fld_adres.setText(null);
							fld_resim.setText(null);
							fld_gorev.setText(null);
							fld_maas.setText(null);
							fld_iban.setText(null);
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				
				}
			}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(PkayitGUI.class.getResource("/View/save.png")));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(783, 523, 132, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PkayitGUI.class.getResource("/View/employee.png")));
		lblNewLabel_3.setBounds(445, 48, 75, 72);
		contentPane.add(lblNewLabel_3);
		
		
		
	}
}
