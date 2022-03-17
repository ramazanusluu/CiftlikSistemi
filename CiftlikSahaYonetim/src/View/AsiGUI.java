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

import Model.Asi;
import Model.Hayvan;
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
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import Helper.*;

public class AsiGUI extends JFrame {
	
	static Veteriner veteriner = new Veteriner();
	Asi asi = new Asi();
	Hayvan hayvan = new Hayvan();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	private JPanel contentPane;
	private JTextField fld_asimarka;
	private JTextField fld_veteriner;
	private JTextField fld_sil;
	private JTable table_asi;
	private DefaultTableModel asiModel = null;
	private Object[] asiData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsiGUI frame = new AsiGUI(veteriner);
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
	public AsiGUI(Veteriner veteriner) throws SQLException {
		asiModel = new DefaultTableModel();
		Object[] colAsiName = new Object[10];
		colAsiName[0] = "Sýra NO";	
		colAsiName[1] = "Küpe NO";	
		colAsiName[2] = "Ýþletme Küpe NO";	
		colAsiName[3] = "Cinsi";	
		colAsiName[4] = "Cinsiyet";	
		colAsiName[5] = "Aþý Tarihi";	
		colAsiName[6] = "Uygulanan Aþý";	
		colAsiName[7] = "Aþý Markasý";	
		colAsiName[8] = "Diðer Uygulama Tarihi";	
		colAsiName[9] = "Veteriner";
		asiModel.setColumnIdentifiers(colAsiName);
		asiData = new Object[10];
		for(int i = 0; i<asi.getAsiList().size(); i++) {
			asiData[0] = asi.getAsiList().get(i).getSira_no();
			asiData[1] = asi.getAsiList().get(i).getKupe_no();
			asiData[2] = asi.getAsiList().get(i).getI_kupe_no();
			asiData[3] = asi.getAsiList().get(i).getCinsi();
			asiData[4] = asi.getAsiList().get(i).getCinsiyet();
			asiData[5] = asi.getAsiList().get(i).getAsi_tarih();
			asiData[6] = asi.getAsiList().get(i).getAsi();
			asiData[7] = asi.getAsiList().get(i).getAsi_marka();
			asiData[8] = asi.getAsiList().get(i).getDiger_tarih();
			asiData[9] = asi.getAsiList().get(i).getVeteriner();
			asiModel.addRow(asiData);
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AsiGUI.class.getResource("/View/uygulama.png")));
		setTitle("A\u015F\u0131 Ekran\u0131");
		setResizable(false);
		setBackground(Color.WHITE);
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
		btnAnaMen.setIcon(new ImageIcon(AsiGUI.class.getResource("/View/out.png")));
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JScrollPane scrollPane_asi = new JScrollPane();
		scrollPane_asi.setBounds(10, 55, 1263, 440);
		contentPane.add(scrollPane_asi);
		
		table_asi = new JTable(asiModel);
		scrollPane_asi.setViewportView(table_asi);
		table_asi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_sil.setText(table_asi.getValueAt(table_asi.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_asi.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectSiraNo = Integer.parseInt(table_asi.getValueAt(table_asi.getSelectedRow(), 0).toString());
					String selectAsitarih = table_asi.getValueAt(table_asi.getSelectedRow(), 5).toString();
					String selectAsi = table_asi.getValueAt(table_asi.getSelectedRow(), 6).toString();
					String selectAsimarka = table_asi.getValueAt(table_asi.getSelectedRow(), 7).toString();
					String selectDigrTarih = table_asi.getValueAt(table_asi.getSelectedRow(), 8).toString();
					
					try {
						boolean control = asi.updateAsi(selectSiraNo, selectAsitarih, selectAsi, selectAsimarka, selectDigrTarih);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("A\u015F\u0131 biligisini girmek istedi\u011Finiz hayvan\u0131 se\u00E7iniz.");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 505, 369, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Uygulanan a\u015F\u0131 bilgilerini giriniz");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(389, 505, 262, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox comboBox_hayvan = new JComboBox();
		comboBox_hayvan.setForeground(Color.BLUE);
		comboBox_hayvan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_hayvan.setBackground(Color.WHITE);
		comboBox_hayvan.setBounds(93, 599, 172, 29);
		for(int j = 0; j<hayvan.getCanlihayvanList().size(); j++) {
			comboBox_hayvan.addItem(new Itemhayvan(hayvan.getCanlihayvanList().get(j).getId(), hayvan.getCanlihayvanList().get(j).getK_kupe_no(), hayvan.getCanlihayvanList().get(j).getI_kupe_no(), hayvan.getCanlihayvanList().get(j).getCinsi(), hayvan.getCanlihayvanList().get(j).getCinsiyet()));
		}
		comboBox_hayvan.addActionListener( e -> {
			JComboBox c = (JComboBox) e.getSource();
			Itemhayvan item = (Itemhayvan) c.getSelectedItem();
		});
		contentPane.add(comboBox_hayvan);
		
		JLabel lblNewLabel_3 = new JLabel("A\u015F\u0131 Tarihi : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(389, 548, 104, 33);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser ilk_asi_tarih = new JDateChooser();
		ilk_asi_tarih.setBounds(497, 553, 136, 19);
		contentPane.add(ilk_asi_tarih);
		
		JLabel lblNewLabel_4 = new JLabel("Uygulanan A\u015F\u0131 :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(389, 580, 104, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("A\u015F\u0131 Markas\u0131 : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(389, 609, 104, 33);
		contentPane.add(lblNewLabel_5);
		
		fld_asimarka = new JTextField();
		fld_asimarka.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_asimarka.setColumns(10);
		fld_asimarka.setBounds(497, 617, 136, 19);
		contentPane.add(fld_asimarka);
		
		JLabel lblNewLabel_6 = new JLabel("Sonraki Doz :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(389, 640, 104, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Veteriner : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(389, 672, 104, 33);
		contentPane.add(lblNewLabel_7);
		
		fld_veteriner = new JTextField();
		fld_veteriner.setText((String) null);
		fld_veteriner.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_veteriner.setColumns(10);
		fld_veteriner.setBounds(497, 680, 136, 19);
		fld_veteriner.setText(veteriner.getName());
		contentPane.add(fld_veteriner);
		fld_veteriner.addKeyListener(hl);
		fld_veteriner.addKeyListener(kl);
		
		JDateChooser dateChooser_sonraki = new JDateChooser();
		dateChooser_sonraki.setBounds(496, 650, 137, 19);
		contentPane.add(dateChooser_sonraki);
		

		JComboBox comboBox_asi = new JComboBox();
		comboBox_asi.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "\u015Eap", "Brucella", "Mastitis", "Septicemia", "Pat\u00F6rella", "S\u0131\u011F\u0131r Vebas\u0131", "\u015Earbon"}));
		comboBox_asi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_asi.setBackground(Color.WHITE);
		comboBox_asi.setBounds(497, 587, 136, 21);
		contentPane.add(comboBox_asi);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Itemhayvan item = (Itemhayvan) comboBox_hayvan.getSelectedItem();
				String kupeNo = item.getK_küpe_no();
				String ikupeNo = item.getI_kupe_no();
				String cins = item.getCinsi();
				String cinsiyet = item.getCinsiyet();
				
				String asilar = comboBox_asi.getSelectedItem().toString();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(ilk_asi_tarih.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(date.length() == 0  ) {
					Helper.showMsg("Lütfen aþý uygulama tarihini giriniz !");
				}
				else {
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					String date2 = "";
					try {
						date2 = sdf2.format(dateChooser_sonraki.getDate());
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if(date2.length() == 0  ) {
						Helper.showMsg("Lütfen diðer aþý uygulama tarihini giriniz !");
					}
					else {
						if(asilar.equals("Seçiniz") || fld_asimarka.getText().length() == 0 || fld_veteriner.getText().length() == 0) {
							Helper.showMsg("fill");
						}else {
							try {
								boolean control = asi.addAsi(kupeNo, ikupeNo, cins, cinsiyet, date, asilar, fld_asimarka.getText(), date2, fld_veteriner.getText());
								if(control) {
									Helper.showMsg("success");
									fld_asimarka.setText(null);
									updateAsiModel();
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					}
				}
			}
		});
		btn_kaydet.setIcon(new ImageIcon(AsiGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setBounds(735, 604, 117, 24);
		contentPane.add(btn_kaydet);
		
		JLabel lblNewLabel_5_1 = new JLabel("S\u0131ra No :");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(962, 599, 68, 33);
		contentPane.add(lblNewLabel_5_1);
		
		fld_sil = new JTextField();
		fld_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sil.setColumns(10);
		fld_sil.setBounds(1040, 607, 115, 19);
		contentPane.add(fld_sil);
		
		JButton btn_sil = new JButton("Sil");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_sil.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}else {
					if(Helper.confirm("sure")) {
						int selectSira = Integer.parseInt(fld_sil.getText());
						try {
							boolean control = asi.deleteAsi(selectSira);
							if(control) {
								Helper.showMsg("success");
								fld_sil.setText(null);
								updateAsiModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil.setIcon(new ImageIcon(AsiGUI.class.getResource("/View/delete.png")));
		btn_sil.setForeground(Color.RED);
		btn_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil.setBackground(Color.WHITE);
		btn_sil.setBounds(1165, 604, 106, 24);
		contentPane.add(btn_sil);
		
		
		
	}
	public void updateAsiModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_asi.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<asi.getAsiList().size(); i++) {
			asiData[0] = asi.getAsiList().get(i).getSira_no();
			asiData[1] = asi.getAsiList().get(i).getKupe_no();
			asiData[2] = asi.getAsiList().get(i).getI_kupe_no();
			asiData[3] = asi.getAsiList().get(i).getCinsi();
			asiData[4] = asi.getAsiList().get(i).getCinsiyet();
			asiData[5] = asi.getAsiList().get(i).getAsi_tarih();
			asiData[6] = asi.getAsiList().get(i).getAsi();
			asiData[7] = asi.getAsiList().get(i).getAsi_marka();
			asiData[8] = asi.getAsiList().get(i).getDiger_tarih();
			asiData[9] = asi.getAsiList().get(i).getVeteriner();
			asiModel.addRow(asiData);
		}
	}
}
