package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.Kullanici;
import Model.Rasyon;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Helper.*;

public class RasyonGUI extends JFrame {
	static Kullanici kullanici = new Kullanici();
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();
	Rasyon rasyon = new Rasyon();

	private JPanel contentPane;
	private JTable table_rasyon;
	private JTextField fld_bsaman;
	private JTextField fld_bkuruot;
	private JTextField fld_bsilaj;
	private JTextField fld_byem;
	private JTextField fld_isaman;
	private JTextField fld_ikuruot;
	private JTextField fld_isilaj;
	private JTextField fld_iyem;
	private JTextField fld_dsaman;
	private JTextField fld_dkuruot;
	private JTextField fld_dsilaj;
	private JTextField fld_dyem;
	private DefaultTableModel rasyonModel = null;
	private Object[] rasyonData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RasyonGUI frame = new RasyonGUI(kullanici);
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
	public RasyonGUI(Kullanici kullanici) throws SQLException {
		
		rasyonModel = new DefaultTableModel();
		Object[] colrasyonName = new Object[16];
		colrasyonName[0] = "B Saman";
		colrasyonName[1] = "B Kuru-ot";
		colrasyonName[2] = "B Silaj";
		colrasyonName[3] = "B Yem";
		colrasyonName[4] = "D Saman";
		colrasyonName[5] = "D Kuru-ot";
		colrasyonName[6] = "D Silaj";
		colrasyonName[7] = "D Yem";
		colrasyonName[8] = "Ý Saman";
		colrasyonName[9] = "Ý Kuru-ot";
		colrasyonName[10] = "Ý Silaj";
		colrasyonName[11] = "Ý Yem";
		colrasyonName[12] = "Saman";
		colrasyonName[13] = "Kuru-ot";
		colrasyonName[14] = "Silaj";
		colrasyonName[15] = "Yem";
		rasyonModel.setColumnIdentifiers(colrasyonName);
		rasyonData = new Object[16];
		for(int i = 0; i<rasyon.getRasyonList().size(); i++) {
			rasyonData[0] = rasyon.getRasyonList().get(i).getB_saman();
			rasyonData[1] = rasyon.getRasyonList().get(i).getB_kuruot();
			rasyonData[2] = rasyon.getRasyonList().get(i).getB_silaj();
			rasyonData[3] = rasyon.getRasyonList().get(i).getB_yem();
			rasyonData[4] = rasyon.getRasyonList().get(i).getD_saman();
			rasyonData[5] = rasyon.getRasyonList().get(i).getD_kuruot();
			rasyonData[6] = rasyon.getRasyonList().get(i).getD_silaj();
			rasyonData[7] = rasyon.getRasyonList().get(i).getD_yem();
			rasyonData[8] = rasyon.getRasyonList().get(i).getI_saman();
			rasyonData[9] = rasyon.getRasyonList().get(i).getI_kuruot();
			rasyonData[10] = rasyon.getRasyonList().get(i).getI_silaj();
			rasyonData[11] = rasyon.getRasyonList().get(i).getI_yem();
			rasyonData[12] = rasyon.getRasyonList().get(i).getSaman();
			rasyonData[13] = rasyon.getRasyonList().get(i).getKuruot();
			rasyonData[14] = rasyon.getRasyonList().get(i).getSilaj();
			rasyonData[15] = rasyon.getRasyonList().get(i).getYem();
			rasyonModel.addRow(rasyonData);
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RasyonGUI.class.getResource("/View/uygulama.png")));
		setBackground(Color.WHITE);
		setTitle("RASYON EKRANI");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 : " + kullanici.getName());
		lblNewLabel.setBounds(10, 10, 310, 35);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setBounds(617, 10, 75, 35);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		JButton btnAnaMen = new JButton("Ana Men\u00FC");
		btnAnaMen.setBounds(1165, 10, 110, 21);
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
		btnAnaMen.setIcon(new ImageIcon(RasyonGUI.class.getResource("/View/out.png")));
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		contentPane.add(btnAnaMen);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(617, 67, 75, 71);
		lblNewLabel_2.setIcon(new ImageIcon(RasyonGUI.class.getResource("/View/wheat.png")));
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 238));
		panel.setBounds(10, 177, 1263, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("# Bir hayvan\u0131n bir g\u00FCnde yiyece\u011Fi saman, kuru ot, silaj ve fabriba yemi gibi rasyon de\u011Ferlerini kilogram(kg) cinsinden giriniz #");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(205, 10, 948, 27);
		panel.add(lblNewLabel_3);
		
		JScrollPane scrollPane_rasyon = new JScrollPane();
		scrollPane_rasyon.setBounds(10, 262, 1263, 47);
		contentPane.add(scrollPane_rasyon);
		
		table_rasyon = new JTable(rasyonModel);
		scrollPane_rasyon.setViewportView(table_rasyon);
		table_rasyon.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					String b_saman = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 0).toString();
					int saman_b = Integer.parseInt(b_saman);
					String b_kuruot = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 1).toString();
					int kuruot_b = Integer.parseInt(b_kuruot);
					String b_silaj = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 2).toString();
					int silaj_b = Integer.parseInt(b_silaj);
					String b_yem = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 3).toString();
					int yem_b = Integer.parseInt(b_yem);
					String d_saman = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 4).toString();
					int saman_d = Integer.parseInt(d_saman);
					String d_kuruot = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 5).toString();
					int kuruot_d = Integer.parseInt(d_kuruot);
					String d_silaj = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 6).toString();
					int silaj_d = Integer.parseInt(d_silaj);
					String d_yem = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 7).toString();
					int yem_d = Integer.parseInt(d_yem);
					String i_saman = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 8).toString();
					int saman_i = Integer.parseInt(i_saman);
					String i_kuruot = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 9).toString();
					int kuruot_i = Integer.parseInt(i_kuruot);
					String i_silaj = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 10).toString();
					int silaj_i = Integer.parseInt(i_silaj);
					String i_yem = table_rasyon.getValueAt(table_rasyon.getSelectedRow(), 11).toString();
					int yem_i = Integer.parseInt(i_yem);
					
					int saman = saman_b + saman_d + saman_i;
					int kuruot = kuruot_b + kuruot_d + kuruot_i;
					int silaj = silaj_b + silaj_d + silaj_i;
					int yem = yem_b + yem_d + yem_i;
					
					String selectsaman = String.valueOf(saman);
					String selectkuruot = String.valueOf(kuruot);
					String selectsilaj = String.valueOf(silaj);
					String selectyem = String.valueOf(yem);
					
					try {
						boolean control = rasyon.updateRasyon(b_saman, b_kuruot, b_silaj, b_yem, d_saman, d_kuruot, d_silaj, d_yem, i_saman, i_kuruot, i_silaj, i_yem, selectsaman, selectkuruot, selectsilaj, selectyem);
						if(control) {
							Helper.showMsg("success");
							updateRasyonModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					
					
					
				}
				
				
			}
		});
		
		JLabel lblNewLabel_2_1 = new JLabel("Buza\u011F\u0131 i\u00E7in Rasyon De\u011Ferleri");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1.setBounds(58, 395, 262, 41);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Saman : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(58, 438, 104, 33);
		contentPane.add(lblNewLabel_3_1);
		
		fld_bsaman = new JTextField();
		fld_bsaman.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_bsaman.setColumns(10);
		fld_bsaman.setBounds(166, 446, 136, 19);
		contentPane.add(fld_bsaman);
		fld_bsaman.addKeyListener(kl);
		
		JLabel lblNewLabel_4 = new JLabel("Kuru Ot : ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(58, 470, 104, 33);
		contentPane.add(lblNewLabel_4);
		
		fld_bkuruot = new JTextField();
		fld_bkuruot.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_bkuruot.setColumns(10);
		fld_bkuruot.setBounds(166, 475, 136, 19);
		contentPane.add(fld_bkuruot);
		fld_bkuruot.addKeyListener(kl);
		
		JLabel lblNewLabel_5 = new JLabel("Silaj : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(58, 499, 104, 33);
		contentPane.add(lblNewLabel_5);
		
		fld_bsilaj = new JTextField();
		fld_bsilaj.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_bsilaj.setColumns(10);
		fld_bsilaj.setBounds(166, 507, 136, 19);
		contentPane.add(fld_bsilaj);
		fld_bsilaj.addKeyListener(kl);
		
		JLabel lblNewLabel_6 = new JLabel("Fabrika Yemi : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(58, 530, 104, 33);
		contentPane.add(lblNewLabel_6);
		
		fld_byem = new JTextField();
		fld_byem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_byem.setColumns(10);
		fld_byem.setBounds(166, 538, 136, 19);
		contentPane.add(fld_byem);
		fld_byem.addKeyListener(kl);
		
		
		JLabel lblNewLabel_2_2 = new JLabel("\u0130nek i\u00E7in Rasyon De\u011Ferleri");
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_2.setBounds(981, 395, 262, 41);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Saman : ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(981, 438, 104, 33);
		contentPane.add(lblNewLabel_3_2);
		
		fld_isaman = new JTextField();
		fld_isaman.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_isaman.setColumns(10);
		fld_isaman.setBounds(1089, 446, 136, 19);
		contentPane.add(fld_isaman);
		fld_isaman.addKeyListener(kl);
		
		JLabel lblNewLabel_4_1 = new JLabel("Kuru Ot :");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(981, 470, 104, 33);
		contentPane.add(lblNewLabel_4_1);
		
		fld_ikuruot = new JTextField();
		fld_ikuruot.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ikuruot.setColumns(10);
		fld_ikuruot.setBounds(1089, 475, 136, 19);
		contentPane.add(fld_ikuruot);
		fld_ikuruot.addKeyListener(kl);
		
		JLabel lblNewLabel_5_1 = new JLabel("Silaj : ");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(981, 499, 104, 33);
		contentPane.add(lblNewLabel_5_1);
		
		fld_isilaj = new JTextField();
		fld_isilaj.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_isilaj.setColumns(10);
		fld_isilaj.setBounds(1089, 507, 136, 19);
		contentPane.add(fld_isilaj);
		fld_isilaj.addKeyListener(kl);
		
		JLabel lblNewLabel_6_1 = new JLabel("Fabrika Yemi :");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(981, 530, 104, 33);
		contentPane.add(lblNewLabel_6_1);
		
		fld_iyem = new JTextField();
		fld_iyem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_iyem.setColumns(10);
		fld_iyem.setBounds(1089, 538, 136, 19);
		contentPane.add(fld_iyem);
		fld_iyem.addKeyListener(kl);
		
		JLabel lblNewLabel_2_3 = new JLabel("D\u00FCve/Dana i\u00E7in Rasyon De\u011Ferleri");
		lblNewLabel_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_3.setBounds(518, 395, 262, 41);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Saman :");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(518, 438, 104, 33);
		contentPane.add(lblNewLabel_3_3);
		
		fld_dsaman = new JTextField();
		fld_dsaman.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_dsaman.setColumns(10);
		fld_dsaman.setBounds(626, 446, 136, 19);
		contentPane.add(fld_dsaman);
		fld_dsaman.addKeyListener(kl);
		
		JLabel lblNewLabel_4_2 = new JLabel("Kuru Ot :");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_2.setBounds(518, 470, 104, 33);
		contentPane.add(lblNewLabel_4_2);
		
		fld_dkuruot = new JTextField();
		fld_dkuruot.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_dkuruot.setColumns(10);
		fld_dkuruot.setBounds(626, 475, 136, 19);
		contentPane.add(fld_dkuruot);
		fld_dkuruot.addKeyListener(kl);
		
		JLabel lblNewLabel_5_2 = new JLabel("Silaj : ");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_2.setBounds(518, 499, 104, 33);
		contentPane.add(lblNewLabel_5_2);
		
		fld_dsilaj = new JTextField();
		fld_dsilaj.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_dsilaj.setColumns(10);
		fld_dsilaj.setBounds(626, 507, 136, 19);
		contentPane.add(fld_dsilaj);
		fld_dsilaj.addKeyListener(kl);
		
		JLabel lblNewLabel_6_2 = new JLabel("Fabrika Yemi :");
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_2.setBounds(518, 530, 104, 33);
		contentPane.add(lblNewLabel_6_2);
		
		fld_dyem = new JTextField();
		fld_dyem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_dyem.setColumns(10);
		fld_dyem.setBounds(626, 538, 136, 19);
		contentPane.add(fld_dyem);
		fld_dyem.addKeyListener(kl);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectBsaman = Integer.parseInt(fld_bsaman.getText());
				int selectBkuruot = Integer.parseInt(fld_bkuruot.getText());
				int selectBsilaj = Integer.parseInt(fld_bsilaj.getText());
				int selectByem = Integer.parseInt(fld_byem.getText());
				int selectDsaman = Integer.parseInt(fld_dsaman.getText());
				int selectDkuruot = Integer.parseInt(fld_dkuruot.getText());
				int selectDsilaj = Integer.parseInt(fld_dsilaj.getText());
				int selectDyem = Integer.parseInt(fld_dyem.getText());
				int selectIsaman = Integer.parseInt(fld_isaman.getText());
				int selectIkuruot = Integer.parseInt(fld_ikuruot.getText());
				int selectIsilaj = Integer.parseInt(fld_isilaj.getText());
				int selectIyem = Integer.parseInt(fld_iyem.getText());
				
				int saman = selectBsaman + selectDsaman + selectIsaman;
				int kuruot = selectBkuruot + selectDkuruot + selectIkuruot;
				int silaj = selectBsilaj + selectDsilaj + selectIsilaj;
				int yem = selectByem + selectDyem + selectIyem;
				
				String saman2 = String.valueOf(saman);
				String kuruot2 = String.valueOf(kuruot);
				String silaj2 = String.valueOf(silaj);
				String yem2 = String.valueOf(yem);
				
				
				if(fld_bsaman.getText().length() == 0 || fld_bkuruot.getText().length() == 0 || fld_bsilaj.getText().length() == 0 || fld_byem.getText().length() == 0 || fld_isaman.getText().length() == 0 || fld_ikuruot.getText().length() == 0 || fld_isilaj.getText().length() == 0 || fld_iyem.getText().length() == 0 || fld_dsaman.getText().length() == 0 || fld_dkuruot.getText().length() == 0 || fld_dsilaj.getText().length() == 0 || fld_dyem.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = rasyon.addRasyon(fld_bsaman.getText(), fld_bkuruot.getText(), fld_bsilaj.getText(),  fld_byem.getText(), fld_isaman.getText(), fld_ikuruot.getText(), fld_isilaj.getText(), fld_iyem.getText(), fld_dsaman.getText(), fld_dkuruot.getText(), fld_dsilaj.getText(), fld_dyem.getText(), saman2, kuruot2, silaj2, yem2);
						Helper.showMsg("success");
						updateRasyonModel();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setIcon(new ImageIcon(RasyonGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBounds(600, 619, 136, 26);
		contentPane.add(btn_kaydet);
	}
	public void updateRasyonModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_rasyon.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<rasyon.getRasyonList().size(); i++) {
			rasyonData[0] = rasyon.getRasyonList().get(i).getB_saman();
			rasyonData[1] = rasyon.getRasyonList().get(i).getB_kuruot();
			rasyonData[2] = rasyon.getRasyonList().get(i).getB_silaj();
			rasyonData[3] = rasyon.getRasyonList().get(i).getB_yem();
			rasyonData[4] = rasyon.getRasyonList().get(i).getD_saman();
			rasyonData[5] = rasyon.getRasyonList().get(i).getD_kuruot();
			rasyonData[6] = rasyon.getRasyonList().get(i).getD_silaj();
			rasyonData[7] = rasyon.getRasyonList().get(i).getD_yem();
			rasyonData[8] = rasyon.getRasyonList().get(i).getI_saman();
			rasyonData[9] = rasyon.getRasyonList().get(i).getI_kuruot();
			rasyonData[10] = rasyon.getRasyonList().get(i).getI_silaj();
			rasyonData[11] = rasyon.getRasyonList().get(i).getI_yem();
			rasyonData[12] = rasyon.getRasyonList().get(i).getSaman();
			rasyonData[13] = rasyon.getRasyonList().get(i).getKuruot();
			rasyonData[14] = rasyon.getRasyonList().get(i).getSilaj();
			rasyonData[15] = rasyon.getRasyonList().get(i).getYem();
			rasyonModel.addRow(rasyonData);
		}
		
	}
}
