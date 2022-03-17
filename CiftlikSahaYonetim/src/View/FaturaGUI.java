package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.HarfList;
import Helper.Itemfatura;
import Helper.KeyList;
import Model.Ciftlik;
import Model.Fatura;
import Model.Gelir;
import Model.Kullanici;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Helper.*;

public class FaturaGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();
	Ciftlik ciftlik = new Ciftlik();
	Gelir gelir = new Gelir();
	Fatura fatura = new Fatura();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	private JPanel contentPane;
	private JTextField fld_isletmeno;
	private JTextField fld_isletmead;
	private JTextField fld_adres;
	private JTextField fld_telefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FaturaGUI frame = new FaturaGUI(kullanici);
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
	public FaturaGUI(Kullanici kullanici) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FaturaGUI.class.getResource("/View/uygulama.png")));
		setBackground(Color.WHITE);
		setTitle("Fatura Kay\u0131t Ekran\u0131");
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
		btnKapat.setIcon(new ImageIcon(FaturaGUI.class.getResource("/View/out.png")));
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KazancGUI kgui = new KazancGUI(kullanici);
					kgui.setVisible(true);
					dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnKapat.setForeground(Color.RED);
		btnKapat.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnKapat.setBackground(Color.WHITE);
		btnKapat.setBounds(864, 10, 110, 21);
		contentPane.add(btnKapat);
		
		JLabel lblNewLabel_2 = new JLabel("\u0130\u015Fletme Bilgileri Giriniz");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(80, 170, 228, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0130\u015Fletme No : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(51, 215, 127, 35);
		contentPane.add(lblNewLabel_3);
		
		fld_isletmeno = new JTextField();
		fld_isletmeno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_isletmeno.setColumns(10);
		fld_isletmeno.setBounds(188, 224, 137, 21);
		for(int i = 0; i<ciftlik.getCiftlikList().size(); i++) {
		fld_isletmeno.setText(ciftlik.getCiftlikList().get(i).getIsletme_no());
		}
		contentPane.add(fld_isletmeno);
		fld_isletmeno.addKeyListener(hl);
		fld_isletmeno.addKeyListener(kl);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u0130\u015Fletme Ad\u0131 : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(51, 255, 127, 35);
		contentPane.add(lblNewLabel_3_1);
		
		fld_isletmead = new JTextField();
		fld_isletmead.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_isletmead.setColumns(10);
		fld_isletmead.setBounds(188, 264, 137, 21);
		for(int j = 0; j<ciftlik.getCiftlikList().size(); j++) {
			fld_isletmead.setText(ciftlik.getCiftlikList().get(j).getName());
		}
		contentPane.add(fld_isletmead);
		fld_isletmead.addKeyListener(hl);
		fld_isletmead.addKeyListener(kl);
		
		JLabel lblNewLabel_3_2 = new JLabel("Adres : ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(51, 295, 127, 35);
		contentPane.add(lblNewLabel_3_2);
		
		fld_adres = new JTextField();
		fld_adres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_adres.setColumns(10);
		fld_adres.setBounds(188, 304, 137, 21);
		for(int k = 0; k<ciftlik.getCiftlikList().size(); k++) {
			fld_adres.setText(ciftlik.getCiftlikList().get(k).getAdres());
		}
		contentPane.add(fld_adres);
		fld_adres.addKeyListener(hl);
		fld_adres.addKeyListener(kl);
		
		JLabel lblNewLabel_3_3 = new JLabel("Telefon : ");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_3.setBounds(51, 335, 127, 35);
		contentPane.add(lblNewLabel_3_3);
		
		fld_telefon = new JTextField();
		fld_telefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_telefon.setColumns(10);
		fld_telefon.setBounds(188, 344, 137, 21);
		for(int n = 0; n<ciftlik.getCiftlikList().size(); n++) {
			fld_telefon.setText(ciftlik.getCiftlikList().get(n).getTelefon());
		}
		contentPane.add(fld_telefon);
		fld_telefon.addKeyListener(hl);
		fld_telefon.addKeyListener(kl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FaturaGUI.class.getResource("/View/fatura.png")));
		lblNewLabel.setBounds(469, 55, 64, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fatura i\u00E7in Tasilat No se\u00E7iniz");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(402, 170, 245, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("KDV Oran\u0131 Se\u00E7iniz (%)");
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(741, 170, 202, 35);
		contentPane.add(lblNewLabel_2_2);
		
		JComboBox comboBox_fatura = new JComboBox();
		comboBox_fatura.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_fatura.setBackground(Color.WHITE);
		comboBox_fatura.setBounds(436, 264, 167, 26);
		for(int i = 0; i<gelir.getGelirList().size(); i++) {
			comboBox_fatura.addItem(new Itemfatura(gelir.getGelirList().get(i).getSira_no(), gelir.getGelirList().get(i).getTahsilat(), gelir.getGelirList().get(i).getTarih(), gelir.getGelirList().get(i).getGelir_type(), gelir.getGelirList().get(i).getMiktar(), gelir.getGelirList().get(i).getName(), gelir.getGelirList().get(i).getTcno(), gelir.getGelirList().get(i).getAdres()));
		}
		comboBox_fatura.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Itemfatura item = (Itemfatura) c.getSelectedItem();
			System.out.println(item.getSira_no() + " - " + item.getTahsilat() + " - " + item.getTarih() + " - " + item.getType() + " - " + item.getFiyat() + " - " + item.getName() + " - " + item.getTcno() + " - " + item.getAdres());
		});
		contentPane.add(comboBox_fatura);
		
		JComboBox comboBox_kdv = new JComboBox();
		comboBox_kdv.setModel(new DefaultComboBoxModel(new String[] {"18", "8", "1"}));
		comboBox_kdv.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_kdv.setBackground(Color.WHITE);
		comboBox_kdv.setBounds(755, 264, 167, 26);
		contentPane.add(comboBox_kdv);
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kdv = comboBox_kdv.getSelectedItem().toString();
				Itemfatura item = (Itemfatura) comboBox_fatura.getSelectedItem();
				String tahsilat = item.getTahsilat();
				String tarih = item.getTarih();
				String type = item.getType();
				String fiyat = item.getFiyat();
				String name = item.getName();
				String tcno = item.getTcno();
				String adres = item.getAdres();
				
				int normalfiyat = Integer.parseInt(fiyat);
				int kdvoran = Integer.parseInt(kdv);
				int kdvfiyat = (((normalfiyat*kdvoran)/100)+normalfiyat);
				
				String kdvlifiyat = String.valueOf(kdvfiyat);
				
				if(fld_isletmeno.getText().length() == 0 || fld_isletmead.getText().length() == 0 || fld_adres.getText().length() == 0 || fld_telefon.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					boolean control = fatura.addFatura(fld_isletmeno.getText(), fld_isletmead.getText(), fld_adres.getText(), fld_telefon.getText(), tahsilat, tarih, type, fiyat, kdvlifiyat, name, tcno, adres);
					if(control) {
						Helper.showMsg("success");
					}
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(FaturaGUI.class.getResource("/View/save.png")));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(446, 456, 137, 35);
		contentPane.add(btnNewButton);
	}
}
