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

import Model.Ekipman;
import Model.Kullanici;
import Model.Personel;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import Helper.*;

public class EkipmanGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();
	Ekipman ekipman = new Ekipman();
	Personel personel = new Personel();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	private JPanel contentPane;
	private JTextField fld_ekipmanadi;
	private JTextField fld_marka;
	private JTextField fld_model;
	private JTextField fld_fiyat;
	private JTextField fld_kullanim;
	private JTextField fld_ekipmanid;
	private JTable table_ekipman;
	private DefaultTableModel ekipmanModel = null;
	private Object[]  ekipmanData = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EkipmanGUI frame = new EkipmanGUI(kullanici);
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
	public EkipmanGUI(Kullanici kullanici) throws SQLException {
		ekipmanModel = new DefaultTableModel();
		Object[] colEkipmanName = new Object[9];
		colEkipmanName[0] = "ID";
		colEkipmanName[1] = "Ekipman Adý";
		colEkipmanName[2] = "Cinsi";
		colEkipmanName[3] = "Marka";
		colEkipmanName[4] = "Model";
		colEkipmanName[5] = "Fiyat";
		colEkipmanName[6] = "Alým Tarihi";
		colEkipmanName[7] = "Alan Personel";
		colEkipmanName[8] = "Kullaným Amacý";
		ekipmanModel.setColumnIdentifiers(colEkipmanName);
		ekipmanData = new Object[9];
		for(int i = 0; i<ekipman.getEkipmanList().size(); i++) {
			ekipmanData[0] = ekipman.getEkipmanList().get(i).getId();
			ekipmanData[1] = ekipman.getEkipmanList().get(i).getName();
			ekipmanData[2] = ekipman.getEkipmanList().get(i).getCinsi();
			ekipmanData[3] = ekipman.getEkipmanList().get(i).getMarka();
			ekipmanData[4] = ekipman.getEkipmanList().get(i).getModel();
			ekipmanData[5] = ekipman.getEkipmanList().get(i).getFiyat();
			ekipmanData[6] = ekipman.getEkipmanList().get(i).getAlim_tarihi();
			ekipmanData[7] = ekipman.getEkipmanList().get(i).getAlan_personel();
			ekipmanData[8] = ekipman.getEkipmanList().get(i).getKullanim_amaci();
			ekipmanModel.addRow(ekipmanData);
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(EkipmanGUI.class.getResource("/View/uygulama.png")));
		setTitle("EK\u0130PMAN EKRANI");
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
		btnAnaMen.setIcon(new ImageIcon(EkipmanGUI.class.getResource("/View/out.png")));
		btnAnaMen.setBounds(1165, 10, 110, 21);
		btnAnaMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaGUI agui = new AnaGUI(kullanici);
				agui.setVisible(true);
				dispose();
			}
		});
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		contentPane.add(btnAnaMen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(282, 55, 993, 645);
		contentPane.add(scrollPane);
		
		table_ekipman = new JTable(ekipmanModel);
		scrollPane.setViewportView(table_ekipman);
		table_ekipman.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_ekipmanid.setText(table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_ekipman.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int SelectId = Integer.parseInt(table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 0).toString());
					String SelectName = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 1).toString();
					String SelectCins = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 2).toString();
					String SelectMarka = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 3).toString();
					String SelectModel = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 4).toString();
					String SelectFiyat = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 5).toString();
					String SelectDate = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 6).toString();
					String SelectPersonel = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 7).toString();
					String SelectAlan = table_ekipman.getValueAt(table_ekipman.getSelectedRow(), 8).toString();
					try {
						boolean control = ekipman.updateEkipman(SelectId, SelectName, SelectCins, SelectMarka, SelectModel, SelectFiyat, SelectDate, SelectPersonel, SelectAlan);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		JLabel lbl_tractor = new JLabel("");
		lbl_tractor.setIcon(new ImageIcon(EkipmanGUI.class.getResource("/View/tractor.png")));
		lbl_tractor.setBounds(105, 55, 67, 71);
		contentPane.add(lbl_tractor);
		
		JLabel lblNewLabel_3 = new JLabel("Ekipman Ad\u0131 :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 172, 104, 33);
		contentPane.add(lblNewLabel_3);
		
		fld_ekipmanadi = new JTextField();
		fld_ekipmanadi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ekipmanadi.setColumns(10);
		fld_ekipmanadi.setBounds(118, 180, 136, 19);
		contentPane.add(fld_ekipmanadi);
		
		JLabel lblNewLabel_4 = new JLabel("Cinsi :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 204, 104, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marka : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 233, 104, 33);
		contentPane.add(lblNewLabel_5);
		
		fld_marka = new JTextField();
		fld_marka.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_marka.setColumns(10);
		fld_marka.setBounds(118, 241, 136, 19);
		contentPane.add(fld_marka);
		
		JLabel lblNewLabel_6 = new JLabel("Model : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 264, 104, 33);
		contentPane.add(lblNewLabel_6);
		
		fld_model = new JTextField();
		fld_model.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_model.setColumns(10);
		fld_model.setBounds(118, 272, 136, 19);
		contentPane.add(fld_model);
		
		JLabel lblNewLabel_7 = new JLabel("Fiyat : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 296, 104, 33);
		contentPane.add(lblNewLabel_7);
		
		fld_fiyat = new JTextField();
		fld_fiyat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_fiyat.setColumns(10);
		fld_fiyat.setBounds(118, 304, 80, 19);
		fld_fiyat.addKeyListener(kl);
		contentPane.add(fld_fiyat);
		
		
		JLabel lblNewLabel_2 = new JLabel("Ekipman Bilgilerini Giriniz");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(37, 129, 217, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5_1 = new JLabel("Al\u0131m Tarihi : ");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(10, 325, 104, 33);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Alan Personel : ");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(10, 356, 104, 33);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Kullan\u0131m amac\u0131 :\r\n");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(10, 388, 118, 33);
		contentPane.add(lblNewLabel_7_1);
		
		fld_kullanim = new JTextField();
		fld_kullanim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kullanim.setColumns(10);
		fld_kullanim.setBounds(118, 396, 136, 19);
		contentPane.add(fld_kullanim);
		
		JComboBox comboBox_cins = new JComboBox();
		comboBox_cins.setModel(new DefaultComboBoxModel(new String[] {"se\u00E7iniz", "makine", "ara\u00E7-gere\u00E7"}));
		comboBox_cins.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_cins.setBackground(Color.WHITE);
		comboBox_cins.setBounds(118, 211, 136, 21);
		contentPane.add(comboBox_cins);
		
		JComboBox comboBox_personel = new JComboBox();
		comboBox_personel.setBackground(Color.WHITE);
		comboBox_personel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_personel.setBounds(118, 363, 136, 21);
		for(int i = 0; i<personel.getPersonelList().size(); i++) {
			comboBox_personel.addItem(personel.getPersonelList().get(i).getName());
		}
		contentPane.add(comboBox_personel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(118, 333, 136, 19);
		contentPane.add(dateChooser);
		
		JComboBox comboBox_para = new JComboBox();
		comboBox_para.setModel(new DefaultComboBoxModel(new String[] {"TL", "DOLAR", "EURO"}));
		comboBox_para.setBackground(Color.WHITE);
		comboBox_para.setBounds(201, 303, 53, 21);
		contentPane.add(comboBox_para);
		
		JButton btn_ekipmankaydet = new JButton("Kaydet");
		btn_ekipmankaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cins = comboBox_cins.getSelectedItem().toString();
				String personel = comboBox_personel.getSelectedItem().toString();
				String para = comboBox_para.getSelectedItem().toString();
				String fiyat = fld_fiyat.getText();
				String butce = fiyat + "-" + para; 
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
				if(cins.equals("seçiniz") || fld_ekipmanadi.getText().length() == 0 || fld_marka.getText().length() == 0 || fld_model.getText().length() == 0 || fld_fiyat.getText().length() == 0 || fld_kullanim.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = ekipman.addEkipman(fld_ekipmanadi.getText(), cins, fld_marka.getText(),  fld_model.getText(), butce, date, personel, fld_kullanim.getText());
						if(control) {
							Helper.showMsg("success");
							fld_ekipmanadi.setText(null);
							fld_marka.setText(null);
							fld_model.setText(null);
							fld_fiyat.setText(null);
							fld_kullanim.setText(null);
							updateEkipmanModel();
							
							
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
			}
		});
		btn_ekipmankaydet.setIcon(new ImageIcon(EkipmanGUI.class.getResource("/View/save.png")));
		btn_ekipmankaydet.setForeground(Color.BLUE);
		btn_ekipmankaydet.setBackground(Color.WHITE);
		btn_ekipmankaydet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_ekipmankaydet.setBounds(78, 446, 104, 27);
		contentPane.add(btn_ekipmankaydet);
		
		JLabel lblNewLabel_9 = new JLabel("Silmek \u0130stedi\u011Finiz Ekipman");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(40, 523, 214, 41);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Id :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(10, 566, 104, 33);
		contentPane.add(lblNewLabel_10);
		
		fld_ekipmanid = new JTextField();
		fld_ekipmanid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ekipmanid.setColumns(10);
		fld_ekipmanid.setBounds(118, 574, 136, 19);
		contentPane.add(fld_ekipmanid);
		
		JButton btn_ekipmansil = new JButton("Sil");
		btn_ekipmansil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_ekipmanid.getText().length() == 0 ) {
					Helper.showMsg("Lütfen geçerli bir ekipman seçiniz !");
				}
				else {
					if(Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_ekipmanid.getText());
						try {
							boolean control = ekipman.deleteEkipman(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_ekipmanid.setText(null);
								updateEkipmanModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_ekipmansil.setIcon(new ImageIcon(EkipmanGUI.class.getResource("/View/delete.png")));
		btn_ekipmansil.setForeground(Color.RED);
		btn_ekipmansil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btn_ekipmansil.setBackground(Color.WHITE);
		btn_ekipmansil.setBounds(85, 613, 95, 21);
		contentPane.add(btn_ekipmansil);
	}
	public void updateEkipmanModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_ekipman.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<ekipman.getEkipmanList().size(); i++) {
			ekipmanData[0] = ekipman.getEkipmanList().get(i).getId();
			ekipmanData[1] = ekipman.getEkipmanList().get(i).getName();
			ekipmanData[2] = ekipman.getEkipmanList().get(i).getCinsi();
			ekipmanData[3] = ekipman.getEkipmanList().get(i).getMarka();
			ekipmanData[4] = ekipman.getEkipmanList().get(i).getModel();
			ekipmanData[5] = ekipman.getEkipmanList().get(i).getFiyat();
			ekipmanData[6] = ekipman.getEkipmanList().get(i).getAlim_tarihi();
			ekipmanData[7] = ekipman.getEkipmanList().get(i).getAlan_personel();
			ekipmanData[8] = ekipman.getEkipmanList().get(i).getKullanim_amaci();
			ekipmanModel.addRow(ekipmanData);
		}
		
	}
}
