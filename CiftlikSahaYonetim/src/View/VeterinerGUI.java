package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Veteriner;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VeterinerGUI extends JFrame {
	
	static Veteriner veteriner = new Veteriner();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeterinerGUI frame = new VeterinerGUI(veteriner);
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
	public VeterinerGUI(Veteriner veteriner) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VeterinerGUI.class.getResource("/View/uygulama.png")));
		setTitle("Veteriner Hekim Ekran\u0131");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veteriner Hekim : " + veteriner.getName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 310, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(617, 10, 75, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u00C7IKI\u015E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginGUI lgui = new LoginGUI();
					lgui.setVisible(true);
					dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(VeterinerGUI.class.getResource("/View/out.png")));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1178, 10, 97, 21);
		contentPane.add(btnNewButton);
		
		JLabel lbl_secilen = new JLabel("");
		lbl_secilen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_secilen.setBounds(10, 56, 158, 40);
		contentPane.add(lbl_secilen);
		
		Image imgtedavi = new ImageIcon(this.getClass().getResource("veteriner.png")).getImage();
		Image imgsectedavi = new ImageIcon(this.getClass().getResource("veteriner (2).png")).getImage();
		
		JLabel lbl_tedavi = new JLabel("");
		lbl_tedavi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_tedavi.setIcon(new ImageIcon(imgsectedavi));
				lbl_secilen.setText("TEDAVÝ");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_tedavi.setIcon(new ImageIcon(imgtedavi));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
					try {
						TedaviGUI tgui = new TedaviGUI(veteriner);
						tgui.setVisible(true);
						dispose();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				
			}
		});
		lbl_tedavi.setIcon(new ImageIcon(imgtedavi));
		lbl_tedavi.setBackground(Color.WHITE);
		lbl_tedavi.setBounds(180, 171, 300, 300);
		contentPane.add(lbl_tedavi);
		
		Image imgasi = new ImageIcon(this.getClass().getResource("asi.png")).getImage();
		Image imgsecasi = new ImageIcon(this.getClass().getResource("asi (2).png")).getImage();
		
		JLabel lbl_asi = new JLabel("");
		lbl_asi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_asi.setIcon(new ImageIcon(imgsecasi));
				lbl_secilen.setText("AÞI");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_asi.setIcon(new ImageIcon(imgasi));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					AsiGUI agui = new AsiGUI(veteriner);
					agui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_asi.setIcon(new ImageIcon(imgasi));
		lbl_asi.setBounds(490, 171, 300, 300);
		contentPane.add(lbl_asi);
		
		Image imgilac = new ImageIcon(this.getClass().getResource("ilac.png")).getImage();
		Image imgsecilac = new ImageIcon(this.getClass().getResource("ilac (2).png")).getImage();
		
		JLabel lbl_ilac = new JLabel("");
		lbl_ilac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_ilac.setIcon(new ImageIcon(imgsecilac));
				lbl_secilen.setText("Ýlaç Deposu");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_ilac.setIcon(new ImageIcon(imgilac));
				lbl_secilen.setText(" ");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					IlacGUI igui = new IlacGUI(veteriner);
					igui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		lbl_ilac.setIcon(new ImageIcon(imgilac));
		lbl_ilac.setBounds(800, 171, 300, 300);
		contentPane.add(lbl_ilac);
		
		
	}
}
