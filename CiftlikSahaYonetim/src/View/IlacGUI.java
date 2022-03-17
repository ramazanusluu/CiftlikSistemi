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

import Model.Ilac;
import Model.Veteriner;

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
import Helper.*;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class IlacGUI extends JFrame {
	static Veteriner veteriner = new Veteriner();
	
	Ilac ilac = new Ilac();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	private JPanel contentPane;
	private JTextField fld_name;
	private JTextField fld_miktar;
	private JTextField fld_veteriner;
	private JTextField fld_sil;
	private DefaultTableModel ilacModel = null;
	private Object[] ilacData = null;
	private JTable table_ilac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IlacGUI frame = new IlacGUI(veteriner);
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
	public IlacGUI(Veteriner veteriner) throws SQLException {
		ilacModel = new DefaultTableModel();
		Object[] colIlacName = new Object[8];
		colIlacName[0] = "ID";
		colIlacName[1] = "Kayýt Tarihi";
		colIlacName[2] = "Ýlaç Adý";
		colIlacName[3] = "Miktar";
		colIlacName[4] = "Ýlaç Tipi";
		colIlacName[5] = "Saklama Koþullarý";
		colIlacName[6] = "Son Kullaným Tarihi";
		colIlacName[7] = "Veteriner";
		ilacModel.setColumnIdentifiers(colIlacName);
		ilacData = new Object[8];
		for(int i = 0; i<ilac.getIlacList().size(); i++) {
			ilacData[0] = ilac.getIlacList().get(i).getId(); 
			ilacData[1] = ilac.getIlacList().get(i).getKayit_tarih(); 
			ilacData[2] = ilac.getIlacList().get(i).getName(); 
			ilacData[3] = ilac.getIlacList().get(i).getMiktar(); 
			ilacData[4] = ilac.getIlacList().get(i).getType(); 
			ilacData[5] = ilac.getIlacList().get(i).getSaklama(); 
			ilacData[6] = ilac.getIlacList().get(i).getSon_kullanim(); 
			ilacData[7] = ilac.getIlacList().get(i).getVeteriner();
			ilacModel.addRow(ilacData);
		}
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(IlacGUI.class.getResource("/View/uygulama.png")));
		setTitle("\u0130la\u00E7 Deposu");
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
		
		JButton btnAnaMen = new JButton("Ana Men\u00FC");
		btnAnaMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VeterinerGUI vgui = new VeterinerGUI(veteriner);
					vgui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		btnAnaMen.setIcon(new ImageIcon(IlacGUI.class.getResource("/View/out.png")));
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JScrollPane scrollPane_ilac = new JScrollPane();
		scrollPane_ilac.setBounds(327, 55, 948, 648);
		contentPane.add(scrollPane_ilac);
		
		table_ilac = new JTable(ilacModel);
		scrollPane_ilac.setViewportView(table_ilac);
		table_ilac.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
			try {
				fld_sil.setText(table_ilac.getValueAt(table_ilac.getSelectedRow(), 0).toString());
			} catch (Exception e2) {
				// TODO: handle exception
			}	
			}
		});
		table_ilac.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_ilac.getValueAt(table_ilac.getSelectedRow(), 0).toString());
					String selectKayit = table_ilac.getValueAt(table_ilac.getSelectedRow(), 1).toString();
					String selectName = table_ilac.getValueAt(table_ilac.getSelectedRow(), 2).toString();
					String selectMiktar = table_ilac.getValueAt(table_ilac.getSelectedRow(), 3).toString();
					String selectType = table_ilac.getValueAt(table_ilac.getSelectedRow(), 4).toString();
					String selectSaklama = table_ilac.getValueAt(table_ilac.getSelectedRow(), 5).toString();
					String selectKullanim = table_ilac.getValueAt(table_ilac.getSelectedRow(), 6).toString();
					
					try {
						boolean control = ilac.updateIlac(selectID, selectKayit, selectName, selectMiktar, selectType, selectSaklama, selectKullanim);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Kay\u0131t i\u00E7in ila\u00E7 bilgilerini giriniz");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 55, 298, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kay\u0131t Tarihi : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(21, 113, 147, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0130la\u00E7 Ad\u0131 :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(21, 145, 147, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Miktar : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(21, 174, 147, 33);
		contentPane.add(lblNewLabel_5);
		
		fld_name = new JTextField();
		fld_name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_name.setColumns(10);
		fld_name.setBounds(172, 151, 136, 19);
		contentPane.add(fld_name);
		
		JLabel lblNewLabel_6 = new JLabel("\u0130la\u00E7 Tipi : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(21, 205, 147, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Saklama Ko\u015Fullar\u0131 : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(21, 237, 147, 33);
		contentPane.add(lblNewLabel_7);
		
		fld_miktar = new JTextField();
		fld_miktar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_miktar.setColumns(10);
		fld_miktar.setBounds(172, 180, 68, 21);
		contentPane.add(fld_miktar);
		fld_miktar.addKeyListener(kl);
		
		JLabel lblNewLabel_5_1 = new JLabel("Son kullanma Tarihi :\r\n");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(21, 266, 147, 33);
		contentPane.add(lblNewLabel_5_1);
		
		JDateChooser dateChooser_sonkullanim = new JDateChooser();
		dateChooser_sonkullanim.setBounds(172, 274, 136, 19);
		contentPane.add(dateChooser_sonkullanim);
		
		JLabel lblNewLabel_6_1 = new JLabel("Veteriner : ");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(21, 297, 147, 33);
		contentPane.add(lblNewLabel_6_1);
		
		JDateChooser dateChooser_kayit = new JDateChooser();
		dateChooser_kayit.setBounds(172, 122, 136, 19);
		contentPane.add(dateChooser_kayit);
		
		JComboBox comboBox_birim = new JComboBox();
		comboBox_birim.setBackground(Color.WHITE);
		comboBox_birim.setModel(new DefaultComboBoxModel(new String[] {"Adet", "Koli"}));
		comboBox_birim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_birim.setBounds(246, 180, 62, 21);
		contentPane.add(comboBox_birim);
		
		JComboBox comboBox_ilactip = new JComboBox();
		comboBox_ilactip.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "A\u015EI", "\u0130\u011Fne", "Hap", "Krem", "Toz", "\u015Eurup", "Serum"}));
		comboBox_ilactip.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_ilactip.setBackground(Color.WHITE);
		comboBox_ilactip.setBounds(172, 212, 136, 21);
		contentPane.add(comboBox_ilactip);
		
		JComboBox comboBox_saklama = new JComboBox();
		comboBox_saklama.setModel(new DefaultComboBoxModel(new String[] {"Oda s\u0131cakl\u0131\u011F\u0131 (25\u00B0C)", "Buzdolab\u0131(2-8\u00B0C)"}));
		comboBox_saklama.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_saklama.setBackground(Color.WHITE);
		comboBox_saklama.setBounds(172, 244, 136, 21);
		contentPane.add(comboBox_saklama);
		
		fld_veteriner = new JTextField();
		fld_veteriner.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_veteriner.setColumns(10);
		fld_veteriner.setBounds(172, 305, 136, 19);
		fld_veteriner.setText(veteriner.getName());
		contentPane.add(fld_veteriner);
		fld_veteriner.addKeyListener(hl);
		fld_veteriner.addKeyListener(kl);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String birim = comboBox_birim.getSelectedItem().toString();
				String ilactip = comboBox_ilactip.getSelectedItem().toString();
				String saklama = comboBox_saklama.getSelectedItem().toString();
				String miktar = fld_miktar.getText();
				
				String miktar_birim = miktar + birim ;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(dateChooser_kayit.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date.length() == 0  ) {
					Helper.showMsg("Lütfen ilaç kayýt tarihini giriniz !");
				}
				else {
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					String date2 = "";
					try {
						date2 = sdf2.format(dateChooser_sonkullanim.getDate());
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if(date2.length() == 0  ) {
						Helper.showMsg("Lütfen son kullaným tarihini giriniz !");
					}
					else {
						if(ilactip.equals("Seçiniz") || fld_miktar.getText().length() == 0 || fld_name.getText().length() == 0 || fld_veteriner.getText().length() == 0) {
							Helper.showMsg("fill");
						}else {
							try {
								boolean control = ilac.addIlac(date, fld_name.getText(), miktar_birim, ilactip, saklama, date2, fld_veteriner.getText());
								if(control) {
									Helper.showMsg("success");
									fld_name.setText(null);
									fld_miktar.setText(null);
									updateIlacModel();
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						
					}
					}
			}
		});
		btn_kaydet.setIcon(new ImageIcon(IlacGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBounds(107, 359, 110, 27);
		contentPane.add(btn_kaydet);
		
		JLabel lblNewLabel_4_1 = new JLabel("ID :");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(21, 670, 52, 33);
		contentPane.add(lblNewLabel_4_1);
		
		fld_sil = new JTextField();
		fld_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sil.setColumns(10);
		fld_sil.setBounds(83, 676, 110, 19);
		contentPane.add(fld_sil);
		
		JButton btn_sil = new JButton("Sil");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_sil.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					if(Helper.confirm("sure")) {
						int selectId = Integer.parseInt(fld_sil.getText());
						try {
							boolean control = ilac.deleteIlac(selectId);
							if(control) {
								Helper.showMsg("success");
								fld_sil.setText(null);
								updateIlacModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil.setIcon(new ImageIcon(IlacGUI.class.getResource("/View/delete.png")));
		btn_sil.setForeground(Color.RED);
		btn_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil.setBackground(Color.WHITE);
		btn_sil.setBounds(203, 675, 110, 21);
		contentPane.add(btn_sil);
	}
	public void updateIlacModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_ilac.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<ilac.getIlacList().size(); i++) {
			ilacData[0] = ilac.getIlacList().get(i).getId(); 
			ilacData[1] = ilac.getIlacList().get(i).getKayit_tarih(); 
			ilacData[2] = ilac.getIlacList().get(i).getName(); 
			ilacData[3] = ilac.getIlacList().get(i).getMiktar(); 
			ilacData[4] = ilac.getIlacList().get(i).getType(); 
			ilacData[5] = ilac.getIlacList().get(i).getSaklama(); 
			ilacData[6] = ilac.getIlacList().get(i).getSon_kullanim(); 
			ilacData[7] = ilac.getIlacList().get(i).getVeteriner();
			ilacModel.addRow(ilacData);
		}
	}
}
