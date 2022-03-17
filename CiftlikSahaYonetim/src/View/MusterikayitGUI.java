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
import Model.Musterigelir;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import Helper.*;

public class MusterikayitGUI extends JFrame {
	

	static Kullanici kullanici = new Kullanici();
	Musterigelir musteri = new Musterigelir();
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();
	
	private JPanel contentPane;
	private JTextField fld_name;
	private JTextField fld_tcno;
	private JTextField fld_telefon;
	private JTextField fld_aders;
	private JTextField fld_id;
	private JTable table_gelir_musteri;
	private DefaultTableModel musteriModel = null;
	private Object[]  musteriData = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusterikayitGUI frame = new MusterikayitGUI(kullanici);
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
	public MusterikayitGUI(Kullanici kullanici) throws SQLException {
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
		
		
		
		
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusterikayitGUI.class.getResource("/View/uygulama.png")));
		setResizable(false);
		setTitle("M\u00FC\u015Fteri Kay\u0131t Ekran\u0131");
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
		btnKapat.setIcon(new ImageIcon(MusterikayitGUI.class.getResource("/View/out.png")));
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KazancGUI kgui = new KazancGUI(kullanici);
					kgui.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnKapat.setForeground(Color.RED);
		btnKapat.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnKapat.setBackground(Color.WHITE);
		btnKapat.setBounds(864, 10, 110, 21);
		contentPane.add(btnKapat);
		
		JLabel lblNewLabel_7 = new JLabel("Ad Soyad : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 489, 104, 33);
		contentPane.add(lblNewLabel_7);
		
		fld_name = new JTextField();
		fld_name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_name.setColumns(10);
		fld_name.setBounds(154, 495, 136, 19);
		contentPane.add(fld_name);
		
		JLabel lblNewLabel_7_1 = new JLabel("TC NO / Vergi NO : ");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(10, 519, 134, 33);
		contentPane.add(lblNewLabel_7_1);
		
		fld_tcno = new JTextField();
		fld_tcno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(154, 525, 136, 19);
		contentPane.add(fld_tcno);
		fld_tcno.addKeyListener(kl);
		
		JLabel lblNewLabel_7_2 = new JLabel("Telefon : ");
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_2.setBounds(10, 549, 104, 33);
		contentPane.add(lblNewLabel_7_2);
		
		fld_telefon = new JTextField();
		fld_telefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_telefon.setColumns(10);
		fld_telefon.setBounds(154, 555, 136, 19);
		contentPane.add(fld_telefon);
		fld_telefon.addKeyListener(kl);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Adres : ");
		lblNewLabel_7_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_1_1.setBounds(10, 579, 134, 33);
		contentPane.add(lblNewLabel_7_1_1);
		
		fld_aders = new JTextField();
		fld_aders.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_aders.setColumns(10);
		fld_aders.setBounds(154, 585, 136, 19);
		contentPane.add(fld_aders);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tahsilat Makbuz Bilgileri");
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 463, 175, 33);
		contentPane.add(lblNewLabel_2_1_1);
		
		JScrollPane scrollPane_gelir_musteri = new JScrollPane();
		scrollPane_gelir_musteri.setBounds(10, 43, 963, 410);
		contentPane.add(scrollPane_gelir_musteri);
		
		table_gelir_musteri = new JTable(musteriModel);
		scrollPane_gelir_musteri.setViewportView(table_gelir_musteri);
		table_gelir_musteri.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				fld_id.setText(table_gelir_musteri.getValueAt(table_gelir_musteri.getSelectedRow(), 0).toString());
			}
		});
		table_gelir_musteri.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectId = Integer.parseInt(table_gelir_musteri.getValueAt(table_gelir_musteri.getSelectedRow(), 0).toString());
					String selectName = table_gelir_musteri.getValueAt(table_gelir_musteri.getSelectedRow(), 1).toString();
					String selectTcno = table_gelir_musteri.getValueAt(table_gelir_musteri.getSelectedRow(), 2).toString();
					String selectTelefon = table_gelir_musteri.getValueAt(table_gelir_musteri.getSelectedRow(), 3).toString();
					String selectAdres = table_gelir_musteri.getValueAt(table_gelir_musteri.getSelectedRow(), 4).toString();
					try {
						boolean control = musteri.updateMusteri(selectId, selectName, selectTcno, selectTelefon, selectAdres);
						if(control) {
							Helper.showMsg("success");
							updateMusteriModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_name.getText().length() == 0 || fld_tcno.getText().length() == 0 || fld_telefon.getText().length() == 0 || fld_aders.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = musteri.addMusteri(fld_name.getText(), fld_tcno.getText(), fld_telefon.getText(), fld_aders.getText());
						if(control) {
							Helper.showMsg("success");
							fld_name.setText(null);
							fld_tcno.setText(null);
							fld_aders.setText(null);
							fld_telefon.setText(null);
							updateMusteriModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
		});
		btn_kaydet.setIcon(new ImageIcon(MusterikayitGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setBounds(362, 526, 122, 27);
		contentPane.add(btn_kaydet);
		
		JLabel lblNewLabel_7_3 = new JLabel("ID : ");
		lblNewLabel_7_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_3.setBounds(694, 519, 72, 33);
		contentPane.add(lblNewLabel_7_3);
		
		fld_id = new JTextField();
		fld_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_id.setColumns(10);
		fld_id.setBounds(760, 525, 109, 19);
		contentPane.add(fld_id);
		
		JButton btn_sil = new JButton("Sil");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_id.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir müþteri seçiniz !");
				}
				else {
					int selectID = Integer.parseInt(fld_id.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = musteri.deleteMusteri(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_id.setText(null);
								updateMusteriModel();
							}
 						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil.setIcon(new ImageIcon(MusterikayitGUI.class.getResource("/View/delete.png")));
		btn_sil.setForeground(Color.RED);
		btn_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil.setBackground(Color.WHITE);
		btn_sil.setBounds(889, 523, 85, 21);
		contentPane.add(btn_sil);
	}
	public void updateMusteriModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_gelir_musteri.getModel();
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
