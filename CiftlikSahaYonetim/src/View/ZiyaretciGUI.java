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

import Model.Arac;
import Model.Kullanici;
import Model.Misafir;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Helper.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ZiyaretciGUI extends JFrame {
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();
	
	static Kullanici kullanici = new Kullanici();
	
	Misafir misafir = new Misafir();
	Arac arac = new Arac();

	private JPanel contentPane;
	private JTable table_misafir;
	private JTextField fld_misafirad;
	private JTextField fld_misafirtc;
	private JTextField textField_3;
	private JTextField fld_misaifrid;
	private DefaultTableModel misafirModel = null;
	private Object[] misafirData = null;
	private JTextField fld_plaka;
	private JTextField fld_soforad;
	private JTextField fld_sofortc;
	private JTextField fld_aracgelis;
	private JTextField fld_aracid;
	private DefaultTableModel aracModel = null;
	private Object[] aracData = null;
	private JTable table_arac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZiyaretciGUI frame = new ZiyaretciGUI(kullanici);
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
	public ZiyaretciGUI(Kullanici kullanici) throws SQLException {
		//Misafir model
		misafirModel = new DefaultTableModel();
		Object[] colMisafirName = new Object[5];
		colMisafirName[0] = "ID";
		colMisafirName[1] = "Ad Soyad";
		colMisafirName[2] = "TC No";
		colMisafirName[3] = "Ziyaret Tarihi";
		colMisafirName[4] = "Ziyaret Nedeni";
		misafirModel.setColumnIdentifiers(colMisafirName);
		misafirData = new Object[5];
		for(int i = 0; i<misafir.getMisafirList().size(); i++) {
			misafirData[0] = misafir.getMisafirList().get(i).getId();
			misafirData[1] = misafir.getMisafirList().get(i).getAd_soyad();
			misafirData[2] = misafir.getMisafirList().get(i).getTcno();
			misafirData[3] = misafir.getMisafirList().get(i).getZiyaret_tarih();
			misafirData[4] = misafir.getMisafirList().get(i).getNeden();
			misafirModel.addRow(misafirData);
		}
		//Arac Model
		aracModel = new DefaultTableModel();
		Object[] colAracName = new Object[7];
		colAracName[0] = "ID";
		colAracName[1] = "Plaka";
		colAracName[2] = "Cinsi";
		colAracName[3] = "Þoför Adý";
		colAracName[4] = "Þoför TC No";
		colAracName[5] = "Geliþ Tarihi";
		colAracName[6] = "Geliþ Sebebi";
		aracModel.setColumnIdentifiers(colAracName);
		aracData = new Object[7];
		for(int j = 0; j<arac.getAracList().size(); j++) {
			aracData[0] = arac.getAracList().get(j).getId();
			aracData[1] = arac.getAracList().get(j).getPlaka();
			aracData[2] = arac.getAracList().get(j).getCinsi();
			aracData[3] = arac.getAracList().get(j).getSofor_ad();
			aracData[4] = arac.getAracList().get(j).getSofor_tc();
			aracData[5] = arac.getAracList().get(j).getGelis_tarih();
			aracData[6] = arac.getAracList().get(j).getGelis_sebep();
			aracModel.addRow(aracData);
		}
		
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ZiyaretciGUI.class.getResource("/View/uygulama.png")));
		setTitle("Z\u0130YARET\u00C7\u0130 EKRANI");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanýcý : " +kullanici.getName());
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
				AnaGUI agui = new AnaGUI(kullanici);
				agui.setVisible(true);
				dispose();
			}
		});
		btnAnaMen.setIcon(new ImageIcon(ZiyaretciGUI.class.getResource("/View/out.png")));
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 41, 1265, 658);
		contentPane.add(tabbedPane);
		
		JPanel panel_misafir = new JPanel();
		panel_misafir.setBackground(Color.WHITE);
		tabbedPane.addTab("MÝSAFÝR", null, panel_misafir, null);
		panel_misafir.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 10, 918, 611);
		panel_misafir.add(scrollPane);
		
		table_misafir = new JTable(misafirModel);
		scrollPane.setViewportView(table_misafir);
		table_misafir.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_misaifrid.setText(table_misafir.getValueAt(table_misafir.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_misafir.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_misafir.getValueAt(table_misafir.getSelectedRow(), 0).toString());
					String selectName = table_misafir.getValueAt(table_misafir.getSelectedRow(), 1).toString();
					String selectTCno = table_misafir.getValueAt(table_misafir.getSelectedRow(), 2).toString();
					String selectTarih = table_misafir.getValueAt(table_misafir.getSelectedRow(), 3).toString();
					String selectNeden = table_misafir.getValueAt(table_misafir.getSelectedRow(), 4).toString();
					try {
						boolean control = misafir.updateMisafir(selectID, selectName, selectTCno, selectTarih, selectNeden);
						if(control) {
							Helper.showMsg("success");
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("family.png")));
		lblNewLabel_2.setBounds(94, 12, 118, 55);
		panel_misafir.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ziyaret\u00E7i Misafir Bilgilerini Giriniz");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1.setBounds(29, 80, 266, 41);
		panel_misafir.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ad\u0131 Soyad\u0131 :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(29, 123, 104, 33);
		panel_misafir.add(lblNewLabel_3);
		
		fld_misafirad = new JTextField();
		fld_misafirad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_misafirad.setColumns(10);
		fld_misafirad.setBounds(159, 129, 136, 19);
		panel_misafir.add(fld_misafirad);
		
		JLabel lblNewLabel_4 = new JLabel("T.C. No :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(29, 155, 104, 33);
		panel_misafir.add(lblNewLabel_4);
		
		fld_misafirtc = new JTextField();
		fld_misafirtc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_misafirtc.setColumns(10);
		fld_misafirtc.setBounds(159, 161, 136, 19);
		panel_misafir.add(fld_misafirtc);
		fld_misafirtc.addKeyListener(kl);
		
		JLabel lblNewLabel_5 = new JLabel("Ziyaret Tarihi : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(29, 184, 104, 33);
		panel_misafir.add(lblNewLabel_5);
		
		JLabel fld_sebep = new JLabel("Ziyaret Sebebi : ");
		fld_sebep.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fld_sebep.setBounds(29, 215, 120, 33);
		panel_misafir.add(fld_sebep);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(159, 221, 136, 19);
		panel_misafir.add(textField_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(Color.WHITE);
		dateChooser.setBounds(159, 190, 136, 19);
		panel_misafir.add(dateChooser);
		
		JButton btn_kullanicikaydet = new JButton("Kaydet");
		btn_kullanicikaydet.addActionListener(new ActionListener() {
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
					if(fld_misafirad.getText().length() == 0 || fld_misafirtc.getText().length() == 0 || textField_3.getText().length() == 0 ) {
						Helper.showMsg("fill");
					}
					else {
						try {
							boolean control = misafir.addMisafir(fld_misafirad.getText(), fld_misafirtc.getText(), date, textField_3.getText());
							if(control) {
								Helper.showMsg("success");
								fld_misafirad.setText(null);
								fld_misafirtc.setText(null);
								textField_3.setText(null);
								updateMisafirModel();
								
							}
								
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_kullanicikaydet.setIcon(new ImageIcon(ZiyaretciGUI.class.getResource("/View/save.png")));
		btn_kullanicikaydet.setForeground(Color.BLUE);
		btn_kullanicikaydet.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_kullanicikaydet.setBackground(Color.WHITE);
		btn_kullanicikaydet.setBounds(109, 258, 95, 21);
		panel_misafir.add(btn_kullanicikaydet);
		
		
		
		JLabel lblNewLabel_9 = new JLabel("Silmek \u0130stedi\u011Finiz Misafir");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(29, 320, 262, 41);
		panel_misafir.add(lblNewLabel_9);
		
		fld_misaifrid = new JTextField();
		fld_misaifrid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_misaifrid.setColumns(10);
		fld_misaifrid.setBounds(137, 371, 136, 19);
		panel_misafir.add(fld_misaifrid);
		
		JLabel lblNewLabel_10 = new JLabel("Id :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(29, 363, 104, 33);
		panel_misafir.add(lblNewLabel_10);
		
		JButton btn_kullanicisil = new JButton("Sil");
		btn_kullanicisil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_misaifrid.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir ziyaretçi seçiniz !");
				}
				else {
					if(Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_misaifrid.getText());
						try {
							boolean control = misafir.deleteMisafir(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_misaifrid.setText(null);
								updateMisafirModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
				
				
			}
		});
		btn_kullanicisil.setIcon(new ImageIcon(ZiyaretciGUI.class.getResource("/View/delete.png")));
		btn_kullanicisil.setForeground(Color.RED);
		btn_kullanicisil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btn_kullanicisil.setBackground(Color.WHITE);
		btn_kullanicisil.setBounds(104, 410, 95, 21);
		panel_misafir.add(btn_kullanicisil);
		
		JPanel panel_arac = new JPanel();
		panel_arac.setBackground(Color.WHITE);
		tabbedPane.addTab("ARAÇ", null, panel_arac, null);
		panel_arac.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(332, 10, 918, 611);
		panel_arac.add(scrollPane_1);
		
		table_arac = new JTable(aracModel);
		scrollPane_1.setViewportView(table_arac);
		table_arac.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
			try {
				fld_aracid.setText(table_arac.getValueAt(table_arac.getSelectedRow(), 0).toString());
			} catch (Exception e2) {
				// TODO: handle exception
			}	
			}
		});
		table_arac.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_arac.getValueAt(table_arac.getSelectedRow(), 0).toString());
					String selectPlaka = table_arac.getValueAt(table_arac.getSelectedRow(), 1).toString();
					String selectCins = table_arac.getValueAt(table_arac.getSelectedRow(), 2).toString();
					String selectSad = table_arac.getValueAt(table_arac.getSelectedRow(), 3).toString();
					String selectStc = table_arac.getValueAt(table_arac.getSelectedRow(), 4).toString();
					String selectTarih = table_arac.getValueAt(table_arac.getSelectedRow(), 5).toString();
					String selectSebep = table_arac.getValueAt(table_arac.getSelectedRow(), 6).toString();
					try {
						boolean control = arac.updateArac(selectID, selectPlaka, selectCins, selectSad, selectStc, selectTarih, selectSebep);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				
				}
			}
		});
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ZiyaretciGUI.class.getResource("/View/car.png")));
		lblNewLabel_6.setBounds(127, 10, 64, 57);
		panel_arac.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Ziyaret\u00E7i Ara\u00E7 Bilgilerini Giriniz");
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2_1_1.setBounds(40, 77, 248, 41);
		panel_arac.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Plaka : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(30, 120, 104, 33);
		panel_arac.add(lblNewLabel_3_1);
		
		fld_plaka = new JTextField();
		fld_plaka.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_plaka.setColumns(10);
		fld_plaka.setBounds(160, 126, 136, 19);
		panel_arac.add(fld_plaka);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cinsi : ");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(30, 152, 104, 33);
		panel_arac.add(lblNewLabel_4_1);
		
		fld_soforad = new JTextField();
		fld_soforad.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_soforad.setColumns(10);
		fld_soforad.setBounds(160, 187, 136, 19);
		panel_arac.add(fld_soforad);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u015Eof\u00F6r Ad\u0131 : ");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(30, 181, 104, 33);
		panel_arac.add(lblNewLabel_5_1);
		
		JLabel fld_sebep_1 = new JLabel("\u015Eof\u00F6r TC :");
		fld_sebep_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fld_sebep_1.setBounds(30, 212, 120, 33);
		panel_arac.add(fld_sebep_1);
		
		fld_sofortc = new JTextField();
		fld_sofortc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sofortc.setColumns(10);
		fld_sofortc.setBounds(160, 218, 136, 19);
		panel_arac.add(fld_sofortc);
		fld_sofortc.addKeyListener(kl);
		
		JComboBox comboBox_arac = new JComboBox();
		comboBox_arac.setModel(new DefaultComboBoxModel(new String[] {"se\u00E7iniz", "otomobil", "kamyonet", "kamyon", "t\u0131r"}));
		comboBox_arac.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_arac.setBackground(Color.WHITE);
		comboBox_arac.setBounds(160, 155, 136, 21);
		panel_arac.add(comboBox_arac);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(160, 250, 136, 19);
		panel_arac.add(dateChooser_1);
		
		JButton btn_arackaydet = new JButton("Kaydet");
		btn_arackaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String secim = comboBox_arac.getSelectedItem().toString();
				
				if(secim.equals("seçiniz") || fld_plaka.getText().length() == 0 || fld_soforad.getText().length() == 0 || fld_sofortc.getText().length() == 0 || fld_aracgelis.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}
				else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = "";
					try {
						date = sdf.format(dateChooser_1.getDate());
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if (date.length() == 0) {
						Helper.showMsg("lütfen geçerli bir tarih giriniz");
					}
					else {
						try {
							boolean control = arac.addArac(fld_plaka.getText(), secim, fld_soforad.getText(), fld_sofortc.getText(), date, fld_aracgelis.getText());
							if(control) {
								Helper.showMsg("success");
								fld_plaka.setText(null);
								fld_soforad.setText(null);
								fld_sofortc.setText(null);
								fld_aracgelis.setText(null);
								updateAracModel();
								
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
					}
				}
			}
		});
		btn_arackaydet.setIcon(new ImageIcon(ZiyaretciGUI.class.getResource("/View/save.png")));
		btn_arackaydet.setForeground(Color.BLUE);
		btn_arackaydet.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btn_arackaydet.setBackground(Color.WHITE);
		btn_arackaydet.setBounds(109, 322, 95, 21);
		panel_arac.add(btn_arackaydet);
		
		
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Geli\u015F Tarihi : ");
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1_1.setBounds(30, 244, 104, 33);
		panel_arac.add(lblNewLabel_5_1_1);
		
		JLabel fld_sebep_1_1 = new JLabel("Geli\u015F Nedeni");
		fld_sebep_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fld_sebep_1_1.setBounds(30, 275, 120, 33);
		panel_arac.add(fld_sebep_1_1);
		
		fld_aracgelis = new JTextField();
		fld_aracgelis.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_aracgelis.setColumns(10);
		fld_aracgelis.setBounds(160, 281, 136, 19);
		panel_arac.add(fld_aracgelis);
		
		
		
		JLabel lblNewLabel_9_1 = new JLabel("Silmek \u0130stedi\u011Finiz Arac");
		lblNewLabel_9_1.setForeground(Color.RED);
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_9_1.setBounds(74, 405, 189, 41);
		panel_arac.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Id :");
		lblNewLabel_10_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_10_1.setBounds(40, 450, 104, 33);
		panel_arac.add(lblNewLabel_10_1);
		
		fld_aracid = new JTextField();
		fld_aracid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_aracid.setColumns(10);
		fld_aracid.setBounds(160, 456, 136, 19);
		panel_arac.add(fld_aracid);
		
		JButton btn_aracsil = new JButton("Sil");
		btn_aracsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_aracid.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir araç seçiniz");
				}
				else {
					if(Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_aracid.getText());
						try {
							boolean control = arac.deleteArac(selectID);
							Helper.showMsg("success");
							fld_aracid.setText(null);
							updateAracModel();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
				
			}
		});
		btn_aracsil.setIcon(new ImageIcon(ZiyaretciGUI.class.getResource("/View/delete.png")));
		btn_aracsil.setForeground(Color.RED);
		btn_aracsil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btn_aracsil.setBackground(Color.WHITE);
		btn_aracsil.setBounds(115, 497, 95, 21);
		panel_arac.add(btn_aracsil);
	}
	public void updateMisafirModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_misafir.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<misafir.getMisafirList().size(); i++) {
			misafirData[0] = misafir.getMisafirList().get(i).getId();
			misafirData[1] = misafir.getMisafirList().get(i).getAd_soyad();
			misafirData[2] = misafir.getMisafirList().get(i).getTcno();
			misafirData[3] = misafir.getMisafirList().get(i).getZiyaret_tarih();
			misafirData[4] = misafir.getMisafirList().get(i).getNeden();
			misafirModel.addRow(misafirData);
		}
	}
	public void updateAracModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_arac.getModel();
		clearModel.setRowCount(0);
		for(int j = 0; j<arac.getAracList().size(); j++) {
			aracData[0] = arac.getAracList().get(j).getId();
			aracData[1] = arac.getAracList().get(j).getPlaka();
			aracData[2] = arac.getAracList().get(j).getCinsi();
			aracData[3] = arac.getAracList().get(j).getSofor_ad();
			aracData[4] = arac.getAracList().get(j).getSofor_tc();
			aracData[5] = arac.getAracList().get(j).getGelis_tarih();
			aracData[6] = arac.getAracList().get(j).getGelis_sebep();
			aracModel.addRow(aracData);
		}
}
}
