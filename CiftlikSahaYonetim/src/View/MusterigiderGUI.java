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

import Helper.HarfList;
import Helper.KeyList;
import Model.Kullanici;
import Model.Musterigider;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Helper.*;

public class MusterigiderGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();
	Musterigider musteri = new Musterigider();
	KeyList kl = new KeyList();

	private JPanel contentPane;
	private JTextField fld_name;
	private JTextField fld_tcno;
	private JTextField fld_telefon;
	private JTextField fld_adres;
	private JTextField fld_sil;
	private JTable table_gider_musteri;
	private DefaultTableModel musteriModel = null;
	private Object[]  musteriData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusterigiderGUI frame = new MusterigiderGUI(kullanici);
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
	public MusterigiderGUI(Kullanici kullanici) throws SQLException {
		musteriModel = new DefaultTableModel();
		Object[] colMusteriName = new Object[5];
		colMusteriName[0] = "ID";
		colMusteriName[1] = "Ad Soyad";
		colMusteriName[2] = "TC NO / Vergi NO";
		colMusteriName[3] = "Telefon";
		colMusteriName[4] = "Adres";
		musteriModel.setColumnIdentifiers(colMusteriName);
		musteriData = new Object[9];
		for(int i = 0; i<musteri.getMusteriList().size(); i++) {
			musteriData[0] = musteri.getMusteriList().get(i).getId();
			musteriData[1] = musteri.getMusteriList().get(i).getName();
			musteriData[2] = musteri.getMusteriList().get(i).getTcno();
			musteriData[3] = musteri.getMusteriList().get(i).getTelefon();
			musteriData[4] = musteri.getMusteriList().get(i).getAdres();
			musteriModel.addRow(musteriData);
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusterigiderGUI.class.getResource("/View/uygulama.png")));
		setBackground(Color.WHITE);
		setTitle("M\u00FC\u015Fteri Kay\u0131t Ekran\u0131");
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
		btnKapat.setIcon(new ImageIcon(MusterigiderGUI.class.getResource("/View/out.png")));
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
		
		JLabel lblNewLabel_7_4 = new JLabel("Ad Soyad : ");
		lblNewLabel_7_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_4.setBounds(10, 489, 104, 33);
		contentPane.add(lblNewLabel_7_4);
		
		fld_name = new JTextField();
		fld_name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_name.setColumns(10);
		fld_name.setBounds(154, 495, 136, 19);
		contentPane.add(fld_name);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("TC NO / Vergi NO : ");
		lblNewLabel_7_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_1_2.setBounds(10, 519, 134, 33);
		contentPane.add(lblNewLabel_7_1_2);
		
		fld_tcno = new JTextField();
		fld_tcno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(154, 525, 136, 19);
		fld_tcno.addKeyListener(kl);
		contentPane.add(fld_tcno);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("Telefon : ");
		lblNewLabel_7_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_2_1.setBounds(10, 549, 104, 33);
		contentPane.add(lblNewLabel_7_2_1);
		
		fld_telefon = new JTextField();
		fld_telefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_telefon.setColumns(10);
		fld_telefon.setBounds(154, 555, 136, 19);
		fld_telefon.addKeyListener(kl);
		contentPane.add(fld_telefon);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Adres : ");
		lblNewLabel_7_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_1_1_1.setBounds(10, 579, 134, 33);
		contentPane.add(lblNewLabel_7_1_1_1);
		
		fld_adres = new JTextField();
		fld_adres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_adres.setColumns(10);
		fld_adres.setBounds(154, 585, 136, 19);
		contentPane.add(fld_adres);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tahsilat Makbuz Bilgileri");
		lblNewLabel_2_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 463, 175, 33);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JButton btn_kaydet_1 = new JButton("Kaydet");
		btn_kaydet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_name.getText().length() == 0 || fld_tcno.getText().length() == 0 || fld_telefon.getText().length() == 0 || fld_adres.getText().length() == 0) {
				Helper.showMsg("fill");	
				}else {
					try {
						boolean control = musteri.addMusteri(fld_name.getText(), fld_tcno.getText(), fld_telefon.getText(), fld_adres.getText());
						if(control) {
							Helper.showMsg("success");
							fld_name.setText(null);
							fld_tcno.setText(null);
							fld_telefon.setText(null);
							fld_adres.setText(null);
							updateMusteriModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_kaydet_1.setIcon(new ImageIcon(MusterigiderGUI.class.getResource("/View/save.png")));
		btn_kaydet_1.setForeground(Color.BLUE);
		btn_kaydet_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet_1.setBackground(Color.WHITE);
		btn_kaydet_1.setBounds(408, 532, 122, 27);
		contentPane.add(btn_kaydet_1);
		
		JLabel lblNewLabel_7_3_1 = new JLabel("ID : ");
		lblNewLabel_7_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_3_1.setBounds(691, 529, 72, 33);
		contentPane.add(lblNewLabel_7_3_1);
		
		fld_sil = new JTextField();
		fld_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sil.setColumns(10);
		fld_sil.setBounds(757, 535, 109, 19);
		contentPane.add(fld_sil);
		
		JButton btn_sil_1 = new JButton("Sil");
		btn_sil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_sil.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir müþteri seçiniz !");
				}else {
					int SelectId = Integer.parseInt(fld_sil.getText());
					if(Helper.confirm("sure")) {
						try {
							Boolean control = musteri.deleteMusteri(SelectId);
							if(control) {
								Helper.showMsg("success");
								fld_sil.setText(null);
								updateMusteriModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
				
			}
		});
		btn_sil_1.setIcon(new ImageIcon(MusterigiderGUI.class.getResource("/View/delete.png")));
		btn_sil_1.setForeground(Color.RED);
		btn_sil_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil_1.setBackground(Color.WHITE);
		btn_sil_1.setBounds(886, 533, 85, 21);
		contentPane.add(btn_sil_1);
		
		JScrollPane scrollPane_gider_musteri = new JScrollPane();
		scrollPane_gider_musteri.setBounds(10, 43, 964, 413);
		contentPane.add(scrollPane_gider_musteri);
		
		table_gider_musteri = new JTable(musteriModel);
		scrollPane_gider_musteri.setViewportView(table_gider_musteri);
		table_gider_musteri.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
			try {
				fld_sil.setText(table_gider_musteri.getValueAt(table_gider_musteri.getSelectedRow(), 0).toString());
			} catch (Exception e2) {
				// TODO: handle exception
			}	
			}
		});
		table_gider_musteri.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectId = Integer.parseInt(table_gider_musteri.getValueAt(table_gider_musteri.getSelectedRow(), 0).toString());
					String selectName = table_gider_musteri.getValueAt(table_gider_musteri.getSelectedRow(), 1).toString();
					String selectTcno = table_gider_musteri.getValueAt(table_gider_musteri.getSelectedRow(), 2).toString();
					String selectTelefon = table_gider_musteri.getValueAt(table_gider_musteri.getSelectedRow(), 3).toString();
					String selectAdres = table_gider_musteri.getValueAt(table_gider_musteri.getSelectedRow(), 4).toString();
					
					try {
						boolean control = musteri.updateMusteri(selectId, selectName, selectTcno, selectTelefon, selectAdres);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
	}
	public void updateMusteriModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_gider_musteri.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<musteri.getMusteriList().size(); i++) {
			musteriData[0] = musteri.getMusteriList().get(i).getId();
			musteriData[1] = musteri.getMusteriList().get(i).getName();
			musteriData[2] = musteri.getMusteriList().get(i).getTcno();
			musteriData[3] = musteri.getMusteriList().get(i).getTelefon();
			musteriData[4] = musteri.getMusteriList().get(i).getAdres();
			musteriModel.addRow(musteriData);
		}
		}
}
