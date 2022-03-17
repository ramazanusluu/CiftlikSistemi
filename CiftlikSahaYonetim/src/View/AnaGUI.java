package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Kullanici;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnaGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();

	private JPanel contentPane_ana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaGUI frame = new AnaGUI(kullanici);
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
	public AnaGUI(Kullanici kullanici) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnaGUI.class.getResource("/View/uygulama.png")));
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("ANA EKRAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane_ana = new JPanel();
		contentPane_ana.setBackground(Color.WHITE);
		contentPane_ana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_ana);
		contentPane_ana.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanýcý : " + kullanici.getName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 310, 35);
		contentPane_ana.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(617, 10, 75, 35);
		contentPane_ana.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u00C7IKI\u015E");
		btnNewButton.setIcon(new ImageIcon(AnaGUI.class.getResource("/View/out.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lgui = new LoginGUI();
				lgui.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1178, 10, 97, 21);
		contentPane_ana.add(btnNewButton);
		
		JLabel lbl_secilen = new JLabel(" ");
		lbl_secilen.setForeground(Color.BLACK);
		lbl_secilen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_secilen.setBounds(10, 35, 203, 45);
		contentPane_ana.add(lbl_secilen);
		
		Image imgseccalisan = new ImageIcon(this.getClass().getResource("psnll(2).png")).getImage();
		Image imgcalisan = new ImageIcon(this.getClass().getResource("psnll.png")).getImage();
		
		JLabel lbl_personel = new JLabel();
		lbl_personel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_personel.setIcon(new ImageIcon(imgseccalisan));
				lbl_secilen.setText("PERSONEL");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_personel.setIcon(new ImageIcon(imgcalisan));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					PersonelGUI pgui = new PersonelGUI(kullanici);
					pgui.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbl_personel.setIcon(new ImageIcon(imgcalisan));
		lbl_personel.setBounds(645, 73, 300, 300);
		contentPane_ana.add(lbl_personel);
		Image imghyavnsec = new ImageIcon(this.getClass().getResource("hayvanlar(2).png")).getImage();
		Image imghayvan = new ImageIcon(this.getClass().getResource("hayvanlar.png")).getImage();
		
		JLabel lbl_hayvan = new JLabel();
		lbl_hayvan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_hayvan.setIcon(new ImageIcon(imghyavnsec));
				lbl_secilen.setText("HAYVANLAR");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_hayvan.setIcon(new ImageIcon(imghayvan));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					HayvanGUI hgui = new HayvanGUI(kullanici);
					hgui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_hayvan.setIcon(new ImageIcon(imghayvan));
		lbl_hayvan.setBounds(335, 73, 300, 300);
		contentPane_ana.add(lbl_hayvan);
		
		Image imgsecekipman = new ImageIcon(this.getClass().getResource("aracgerec(2).png")).getImage();
		Image imgekipman = new ImageIcon(this.getClass().getResource("aracgerec.png")).getImage();
		
		JLabel lbl_ekipman = new JLabel("");
		lbl_ekipman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ekipman.setIcon(new ImageIcon(imgsecekipman));
				lbl_secilen.setText("EKÝPMANLAR");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_ekipman.setIcon(new ImageIcon(imgekipman));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					EkipmanGUI ekipman = new EkipmanGUI(kullanici);
					ekipman.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_ekipman.setIcon(new ImageIcon(imgekipman));
		lbl_ekipman.setBackground(Color.WHITE);
		lbl_ekipman.setBounds(955, 73, 300, 300);
		contentPane_ana.add(lbl_ekipman);
		Image imgsecziyaret = new ImageIcon(this.getClass().getResource("misafir(2).jpg")).getImage();
		Image imgziyaretci = new ImageIcon(this.getClass().getResource("misafir.jpg")).getImage();
		
		JLabel lbl_ziyaretci = new JLabel();
		lbl_ziyaretci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ziyaretci.setIcon(new ImageIcon(imgsecziyaret));
				lbl_secilen.setText("ZÝYARETÇÝ");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_ziyaretci.setIcon(new ImageIcon(imgziyaretci));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					ZiyaretciGUI zgui = new ZiyaretciGUI(kullanici);
					zgui.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbl_ziyaretci.setIcon(new ImageIcon(imgziyaretci));
		lbl_ziyaretci.setBounds(25, 73, 300, 300);
		contentPane_ana.add(lbl_ziyaretci);
		
		Image imgdepo = new ImageIcon(this.getClass().getResource("samanlýk.png")).getImage();
		Image imgsecdepo = new ImageIcon(this.getClass().getResource("samanlýk(2).png")).getImage();
		
		JLabel lbl_depo = new JLabel();
		lbl_depo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_depo.setIcon(new ImageIcon(imgsecdepo));
				lbl_secilen.setText("DEPOLAR");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_depo.setIcon(new ImageIcon(imgdepo));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					DepoGUI dgui = new DepoGUI(kullanici);
					dgui.setVisible(true);
					dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_depo.setIcon(new ImageIcon(imgdepo));
		lbl_depo.setBounds(335, 383, 300, 300);
		contentPane_ana.add(lbl_depo);
		
		Image imggelir = new ImageIcon(this.getClass().getResource("tablo.png")).getImage();
		Image imgsecgelir = new ImageIcon(this.getClass().getResource("tablo(2).png")).getImage();
		
		JLabel lbl_durum = new JLabel();
		lbl_durum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_durum.setIcon(new ImageIcon(imgsecgelir));
				lbl_secilen.setText("GELÝR-GÝDER");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_durum.setIcon(new ImageIcon(imggelir));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					KazancGUI kgui = new KazancGUI(kullanici);
					kgui.setVisible(true);
					dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_durum.setIcon(new ImageIcon(imggelir));
		lbl_durum.setBounds(645, 383, 300, 300);
		contentPane_ana.add(lbl_durum);
		
		Image imgciftlik = new ImageIcon(this.getClass().getResource("farming.png")).getImage();
		Image imgsecciftlik = new ImageIcon(this.getClass().getResource("farming (2).png")).getImage();
		
		JLabel lbl_ciftlik = new JLabel("");
		lbl_ciftlik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ciftlik.setIcon(new ImageIcon(imgsecciftlik));
				lbl_secilen.setText("ÇÝFTLÝK");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_ciftlik.setIcon(new ImageIcon(imgciftlik));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					CiftlikGUI	cGUI = new CiftlikGUI(kullanici);
					cGUI.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbl_ciftlik.setIcon(new ImageIcon(imgciftlik));
		lbl_ciftlik.setBounds(955, 383, 300, 300);
		contentPane_ana.add(lbl_ciftlik);
		
		Image imgrasyon = new ImageIcon(this.getClass().getResource("rasyonyem.png")).getImage();
		Image imgsecrasyon = new ImageIcon(this.getClass().getResource("rasyonyem(2).png")).getImage();
		
		JLabel lbl_rasyon = new JLabel("");
		lbl_rasyon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_rasyon.setIcon(new ImageIcon(imgsecrasyon));
				lbl_secilen.setText("RASYON");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_rasyon.setIcon(new ImageIcon(imgrasyon));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					RasyonGUI rgui = new RasyonGUI(kullanici); 
					rgui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_rasyon.setIcon(new ImageIcon(imgrasyon));
		lbl_rasyon.setBounds(25, 383, 300, 300);
		contentPane_ana.add(lbl_rasyon);
	}
}
