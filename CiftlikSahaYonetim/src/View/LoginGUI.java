package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import Helper.*;
import Model.Kullanici;
import Model.Veteriner;
import Model.Yonetici;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane_giris;
	private JTextField fld_yoneticikuladi;
	private JPasswordField fld_yoneticisifre;
	private JTextField fld_kullanicikuladi;
	private JPasswordField fld_kullanicisifre;
	private JTextField fld_veterinerkuladi;
	private JPasswordField fld_veterinersifre;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/View/uygulama.png")));
		setTitle("G\u0130R\u0130\u015E EKRANI");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane_giris = new JPanel();
		contentPane_giris.setBackground(Color.WHITE);
		contentPane_giris.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_giris);
		contentPane_giris.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("uygulama.png")));
		lbl_logo.setBounds(607, 88, 115, 57);
		contentPane_giris.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("MOL\u039ER");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(607, 155, 115, 51);
		contentPane_giris.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00C7\u0130FTL\u0130K SAHA Y\u00D6NET\u0130M S\u0130STEM\u0130 ");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(420, 216, 488, 57);
		contentPane_giris.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane_giris = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_giris.setBackground(Color.WHITE);
		tabbedPane_giris.setBounds(420, 313, 474, 273);
		contentPane_giris.add(tabbedPane_giris);
		
		JPanel panel_yonetici = new JPanel();
		panel_yonetici.setBackground(Color.WHITE);
		tabbedPane_giris.addTab("Yönetici", null, panel_yonetici, null);
		panel_yonetici.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(50, 47, 152, 33);
		panel_yonetici.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u015Eifre :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(50, 95, 152, 33);
		panel_yonetici.add(lblNewLabel_3);
		
		fld_yoneticikuladi = new JTextField();
		fld_yoneticikuladi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Helper.showMsg("fill");
				}
			}
		});
		fld_yoneticikuladi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_yoneticikuladi.setBounds(212, 53, 194, 26);
		panel_yonetici.add(fld_yoneticikuladi);
		fld_yoneticikuladi.setColumns(10);
		
		fld_yoneticisifre = new JPasswordField();
		fld_yoneticisifre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
					if(fld_yoneticikuladi.getText().length() == 0 || fld_yoneticisifre.getText().length() == 0 ) {
						Helper.showMsg("fill");
					}
					else {
						
						try {
							Connection con = conn.connDb();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("SELECT*FROM kullanici WHERE type = 'yonetici'");
							while(rs.next()) {
								if(fld_yoneticikuladi.getText().equals(rs.getString("username")) && fld_yoneticisifre.getText().equals(rs.getString("password"))) {
									Yonetici yntc = new Yonetici();
									yntc.setId(rs.getInt("id"));
									yntc.setName(rs.getString("name"));
									yntc.setTcno(rs.getString("tcno"));
									yntc.setUsername(rs.getString("username"));
									yntc.setPassword(rs.getString("password"));
									yntc.setPhone(rs.getString("phone"));
									yntc.setType(rs.getString("type"));
									YoneticiGUI yGUI = new YoneticiGUI(yntc);
									yGUI.setVisible(true);
									dispose();
								}
						
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		fld_yoneticisifre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_yoneticisifre.setBounds(212, 100, 194, 28);
		panel_yonetici.add(fld_yoneticisifre);
		
		JButton btn_yoneticigiris = new JButton("G\u0130R\u0130\u015E");
		btn_yoneticigiris.setIcon(new ImageIcon(LoginGUI.class.getResource("/View/login.png")));
		btn_yoneticigiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_yoneticikuladi.getText().length() == 0 || fld_yoneticisifre.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}
				else {
					
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT*FROM kullanici WHERE type = 'yonetici'");
						while(rs.next()) {
							if(fld_yoneticikuladi.getText().equals(rs.getString("username")) && fld_yoneticisifre.getText().equals(rs.getString("password"))) {
								Yonetici yntc = new Yonetici();
								yntc.setId(rs.getInt("id"));
								yntc.setName(rs.getString("name"));
								yntc.setTcno(rs.getString("tcno"));
								yntc.setUsername(rs.getString("username"));
								yntc.setPassword(rs.getString("password"));
								yntc.setPhone(rs.getString("phone"));
								yntc.setType(rs.getString("type"));
								YoneticiGUI yGUI = new YoneticiGUI(yntc);
								yGUI.setVisible(true);
								dispose();
							}
					
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btn_yoneticigiris.setForeground(Color.BLUE);
		btn_yoneticigiris.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_yoneticigiris.setBackground(Color.WHITE);
		btn_yoneticigiris.setBounds(306, 191, 100, 26);
		panel_yonetici.add(btn_yoneticigiris);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u015Eifreyi G\u00F6ster");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					fld_yoneticisifre.setEchoChar((char)0);
				}
				else {
					fld_yoneticisifre.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chckbxNewCheckBox.setForeground(Color.RED);
		chckbxNewCheckBox.setBounds(297, 142, 109, 21);
		panel_yonetici.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("KAPAT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(LoginGUI.class.getResource("/View/out.png")));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBounds(50, 191, 100, 26);
		panel_yonetici.add(btnNewButton);
		
		JPanel panel_kullanici = new JPanel();
		panel_kullanici.setBackground(Color.WHITE);
		tabbedPane_giris.addTab("Kullanýcý", null, panel_kullanici, null);
		panel_kullanici.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(49, 47, 152, 33);
		panel_kullanici.add(lblNewLabel_2_1);
		
		fld_kullanicikuladi = new JTextField();
		fld_kullanicikuladi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Helper.showMsg("fill");
				}
			}
		});
		fld_kullanicikuladi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kullanicikuladi.setColumns(10);
		fld_kullanicikuladi.setBounds(211, 53, 194, 26);
		panel_kullanici.add(fld_kullanicikuladi);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u015Eifre :");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(49, 95, 152, 33);
		panel_kullanici.add(lblNewLabel_3_1);
		
		fld_kullanicisifre = new JPasswordField();
		fld_kullanicisifre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(fld_kullanicikuladi.getText().length() == 0 || fld_kullanicisifre.getText().length() == 0 ) {
						Helper.showMsg("fill");
					}
					else {
						
						try {
							Connection con = conn.connDb();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("SELECT*FROM kullanici WHERE type = 'calisan'");
							while(rs.next()) {
								if(fld_kullanicikuladi.getText().equals(rs.getString("username")) && fld_kullanicisifre.getText().equals(rs.getString("password"))) {
									Kullanici kul = new Kullanici();
									kul.setId(rs.getInt("id"));
									kul.setName(rs.getString("name"));
									kul.setTcno(rs.getString("tcno"));
									kul.setUsername(rs.getString("username"));
									kul.setPassword(rs.getString("password"));
									kul.setPhone(rs.getString("phone"));
									kul.setType(rs.getString("type"));
									AnaGUI aGUI = new AnaGUI(kul);
									aGUI.setVisible(true);
									dispose();
								}
								
						
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		fld_kullanicisifre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kullanicisifre.setBounds(211, 100, 194, 28);
		panel_kullanici.add(fld_kullanicisifre);
		
		JButton btn_kullanicigiris = new JButton("G\u0130R\u0130\u015E");
		btn_kullanicigiris.setIcon(new ImageIcon(LoginGUI.class.getResource("/View/login.png")));
		btn_kullanicigiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_kullanicikuladi.getText().length() == 0 || fld_kullanicisifre.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}
				else {
					
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT*FROM kullanici WHERE type = 'calisan'");
						while(rs.next()) {
							if(fld_kullanicikuladi.getText().equals(rs.getString("username")) && fld_kullanicisifre.getText().equals(rs.getString("password"))) {
								Kullanici kul = new Kullanici();
								kul.setId(rs.getInt("id"));
								kul.setName(rs.getString("name"));
								kul.setTcno(rs.getString("tcno"));
								kul.setUsername(rs.getString("username"));
								kul.setPassword(rs.getString("password"));
								kul.setPhone(rs.getString("phone"));
								kul.setType(rs.getString("type"));
								AnaGUI aGUI = new AnaGUI(kul);
								aGUI.setVisible(true);
								dispose();
							}
							
					
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_kullanicigiris.setForeground(Color.BLUE);
		btn_kullanicigiris.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_kullanicigiris.setBackground(Color.WHITE);
		btn_kullanicigiris.setBounds(305, 191, 100, 26);
		panel_kullanici.add(btn_kullanicigiris);
		
		JButton btnNewButton_1 = new JButton("KAPAT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginGUI.class.getResource("/View/out.png")));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(50, 191, 100, 26);
		panel_kullanici.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u015Eifreyi G\u00F6ster");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					fld_kullanicisifre.setEchoChar((char)0);
				}
				else {
					fld_kullanicisifre.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox_1.setForeground(Color.RED);
		chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(297, 142, 109, 21);
		panel_kullanici.add(chckbxNewCheckBox_1);
		
		JPanel panel_veteriner = new JPanel();
		panel_veteriner.setBackground(Color.WHITE);
		tabbedPane_giris.addTab("Veteriner", null, panel_veteriner, null);
		panel_veteriner.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(49, 46, 152, 33);
		panel_veteriner.add(lblNewLabel_2_2);
		
		fld_veterinerkuladi = new JTextField();
		fld_veterinerkuladi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Helper.showMsg("fill");
				}
			}
			
		});
		fld_veterinerkuladi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_veterinerkuladi.setColumns(10);
		fld_veterinerkuladi.setBounds(211, 52, 194, 26);
		panel_veteriner.add(fld_veterinerkuladi);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u015Eifre :");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(49, 94, 152, 33);
		panel_veteriner.add(lblNewLabel_3_2);
		
		fld_veterinersifre = new JPasswordField();
		fld_veterinersifre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(fld_veterinerkuladi.getText().length() == 0 || fld_veterinersifre.getText().length() == 0) {
						Helper.showMsg("fill");
					}
					else {
						try {
							Connection con = conn.connDb();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("SELECT*FROM kullanici WHERE type = 'veteriner'");
							while(rs.next()) {
								if(fld_veterinerkuladi.getText().equals(rs.getString("username")) && fld_veterinersifre.getText().equals(rs.getString("password"))) {
									Veteriner veteriner = new Veteriner();
									veteriner.setId(rs.getInt("id"));
									veteriner.setName(rs.getString("name"));
									veteriner.setTcno(rs.getString("tcno"));
									veteriner.setUsername(rs.getString("username"));
									veteriner.setPassword(rs.getString("password"));
									veteriner.setPhone(rs.getString("phone"));
									veteriner.setType(rs.getString("type"));
									VeterinerGUI vgui = new VeterinerGUI(veteriner);
									vgui.setVisible(true);
									dispose();
								}
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				
				}
			}
		});
		fld_veterinersifre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_veterinersifre.setBounds(211, 99, 194, 28);
		panel_veteriner.add(fld_veterinersifre);
		
		JButton btn_veterinergiris = new JButton("G\u0130R\u0130\u015E");
		btn_veterinergiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_veterinerkuladi.getText().length() == 0 || fld_veterinersifre.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT*FROM kullanici WHERE type = 'veteriner'");
						while(rs.next()) {
							if(fld_veterinerkuladi.getText().equals(rs.getString("username")) && fld_veterinersifre.getText().equals(rs.getString("password"))) {
								Veteriner veteriner = new Veteriner();
								veteriner.setId(rs.getInt("id"));
								veteriner.setName(rs.getString("name"));
								veteriner.setTcno(rs.getString("tcno"));
								veteriner.setUsername(rs.getString("username"));
								veteriner.setPassword(rs.getString("password"));
								veteriner.setPhone(rs.getString("phone"));
								veteriner.setType(rs.getString("type"));
								VeterinerGUI vgui = new VeterinerGUI(veteriner);
								vgui.setVisible(true);
								dispose();
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_veterinergiris.setIcon(new ImageIcon(LoginGUI.class.getResource("/View/login.png")));
		btn_veterinergiris.setForeground(Color.BLUE);
		btn_veterinergiris.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_veterinergiris.setBackground(Color.WHITE);
		btn_veterinergiris.setBounds(305, 191, 100, 26);
		panel_veteriner.add(btn_veterinergiris);
		
		JButton btnNewButton_2 = new JButton("KAPAT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(LoginGUI.class.getResource("/View/out.png")));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(50, 191, 100, 26);
		panel_veteriner.add(btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\u015Eifreyi G\u00F6ster");
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_2.isSelected()) {
					fld_veterinersifre.setEchoChar((char)0);
				}
				else {
					fld_veterinersifre.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox_2.setForeground(Color.RED);
		chckbxNewCheckBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		chckbxNewCheckBox_2.setBounds(295, 142, 109, 21);
		panel_veteriner.add(chckbxNewCheckBox_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(34, 655, 1227, 43);
		contentPane_giris.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("                      # Sisteme giri\u015F yapmak i\u00E7in \u00F6nce kullan\u0131c\u0131 t\u00FCr\u00FCn\u00FC se\u00E7ip kullan\u0131c\u0131 ad\u0131 ve \u015Fifrenizi giriniz. Ard\u0131ndan giri\u015F butonuna t\u0131klay\u0131n\u0131z # ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(53, 0, 1136, 43);
		panel.add(lblNewLabel_4);
	}
}
