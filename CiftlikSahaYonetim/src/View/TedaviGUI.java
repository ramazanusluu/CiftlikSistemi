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

import Model.Hayvan;
import Model.Kullanici;
import Model.Tedavi;
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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import Helper.*;
import javax.swing.JTable;

public class TedaviGUI extends JFrame {
	
	static Veteriner veteriner = new Veteriner();
	Tedavi tedavi = new Tedavi();
	Hayvan hayvan = new Hayvan();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();

	private JPanel contentPane;
	private JTextField fld_hastalik;
	private JTextField fld_tedavi;
	private JTextField fld_ilac;
	private JTextField fld_vet;
	private JTextField fld_sil;
	private JButton btn_kaydet;
	private DefaultTableModel tedaviModel = null;
	private Object[] tedaviData = null;
	private JTable table_tedavi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TedaviGUI frame = new TedaviGUI(veteriner);
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
	public TedaviGUI(Veteriner veteriner) throws SQLException {
		tedaviModel = new DefaultTableModel();
		Object[] colTedaviName = new Object[10];
		colTedaviName[0] = "Sýra NO";
		colTedaviName[1] = "Küpe NO";
		colTedaviName[2] = "Ýþletme Küpe NO";
		colTedaviName[3] = "Cinsi";
		colTedaviName[4] = "Cinsiyet";
		colTedaviName[5] = "Tedavi Tarihi";
		colTedaviName[6] = "Hastalýk";
		colTedaviName[7] = "Uygulanan Tedavi";
		colTedaviName[8] = "Kullanýlan Ýlaç";
		colTedaviName[9] = "Veteriner Hekim";
		tedaviModel.setColumnIdentifiers(colTedaviName);
		tedaviData = new Object[10];
		for(int i = 0; i<tedavi.getTedaviList().size(); i++) {
			tedaviData[0] = tedavi.getTedaviList().get(i).getSira_no();
			tedaviData[1] = tedavi.getTedaviList().get(i).getKupe_no();
			tedaviData[2] = tedavi.getTedaviList().get(i).getI_kupe_no();
			tedaviData[3] = tedavi.getTedaviList().get(i).getCinsi();
			tedaviData[4] = tedavi.getTedaviList().get(i).getCinsiyet();
			tedaviData[5] = tedavi.getTedaviList().get(i).getTedavi_tarih();
			tedaviData[6] = tedavi.getTedaviList().get(i).getHastalik();
			tedaviData[7] = tedavi.getTedaviList().get(i).getTedavi();
			tedaviData[8] = tedavi.getTedaviList().get(i).getIlac();
			tedaviData[9] = tedavi.getTedaviList().get(i).getVeteriner();
			tedaviModel.addRow(tedaviData);
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TedaviGUI.class.getResource("/View/uygulama.png")));
		setBackground(Color.WHITE);
		setTitle("Tedavi Ekran\u0131");
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
		btnAnaMen.setIcon(new ImageIcon(TedaviGUI.class.getResource("/View/out.png")));
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JScrollPane scrollPane_tedavi = new JScrollPane();
		scrollPane_tedavi.setBounds(10, 52, 1263, 440);
		contentPane.add(scrollPane_tedavi);
		
		table_tedavi = new JTable(tedaviModel);
		scrollPane_tedavi.setViewportView(table_tedavi);
		table_tedavi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_sil.setText(table_tedavi.getValueAt(table_tedavi.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_tedavi.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectSirano = Integer.parseInt(table_tedavi.getValueAt(table_tedavi.getSelectedRow(), 0).toString());
					String selectTarih = table_tedavi.getValueAt(table_tedavi.getSelectedRow(), 5).toString();
					String selectHastalik = table_tedavi.getValueAt(table_tedavi.getSelectedRow(), 6).toString();
					String selectTedavi = table_tedavi.getValueAt(table_tedavi.getSelectedRow(), 7).toString();
					String selectÝlac = table_tedavi.getValueAt(table_tedavi.getSelectedRow(), 8).toString();
					
					try {
						boolean control = tedavi.updateTedavi(selectSirano, selectTarih, selectHastalik, selectTedavi, selectÝlac);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Tedavi biligisi girmek istedi\u011Finiz hayvan\u0131 se\u00E7iniz.");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 502, 369, 35);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_hayvan = new JComboBox();
		comboBox_hayvan.setForeground(Color.BLUE);
		comboBox_hayvan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_hayvan.setBackground(Color.WHITE);
		comboBox_hayvan.setBounds(93, 596, 172, 29);
		for(int i = 0; i<hayvan.getCanlihayvanList().size(); i++) {
			comboBox_hayvan.addItem(new Itemhayvan(hayvan.getCanlihayvanList().get(i).getId(), hayvan.getCanlihayvanList().get(i).getK_kupe_no(), hayvan.getCanlihayvanList().get(i).getI_kupe_no(), hayvan.getCanlihayvanList().get(i).getCinsi(), hayvan.getCanlihayvanList().get(i).getCinsiyet()));
		}
		comboBox_hayvan.addActionListener( e -> {
			JComboBox c = (JComboBox) e.getSource();
			Itemhayvan item = (Itemhayvan) c.getSelectedItem();
		});
		contentPane.add(comboBox_hayvan);
		
		JLabel lblNewLabel_2_1 = new JLabel("Uygulanan tedavi bilgilerini giriniz");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(389, 502, 262, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Tedavi Tarihi : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(389, 545, 104, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hastal\u0131k : ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(389, 577, 104, 33);
		contentPane.add(lblNewLabel_4);
		
		fld_hastalik = new JTextField();
		fld_hastalik.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_hastalik.setColumns(10);
		fld_hastalik.setBounds(497, 582, 136, 19);
		contentPane.add(fld_hastalik);
		
		JLabel lblNewLabel_5 = new JLabel("Tedavi : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(389, 606, 104, 33);
		contentPane.add(lblNewLabel_5);
		
		fld_tedavi = new JTextField();
		fld_tedavi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_tedavi.setColumns(10);
		fld_tedavi.setBounds(497, 614, 136, 19);
		contentPane.add(fld_tedavi);
		
		JLabel lblNewLabel_6 = new JLabel("Kullan\u0131lan \u0130la\u00E7 :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(389, 637, 104, 33);
		contentPane.add(lblNewLabel_6);
		
		fld_ilac = new JTextField();
		fld_ilac.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_ilac.setColumns(10);
		fld_ilac.setBounds(497, 645, 136, 19);
		contentPane.add(fld_ilac);
		
		JLabel lblNewLabel_7 = new JLabel("Veteriner : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(389, 669, 104, 33);
		contentPane.add(lblNewLabel_7);
		
		fld_vet = new JTextField();
		fld_vet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_vet.setColumns(10);
		fld_vet.setBounds(497, 677, 136, 19);
		fld_vet.setText(veteriner.getName());
		contentPane.add(fld_vet);
		fld_vet.addKeyListener(hl);
		fld_vet.addKeyListener(kl);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(497, 550, 136, 19);
		contentPane.add(dateChooser);
		
		btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Itemhayvan item = (Itemhayvan) comboBox_hayvan.getSelectedItem();
				String kupeNo = item.getK_küpe_no();
				String ikupeNo = item.getI_kupe_no();
				String cins = item.getCinsi();
				String cinsiyet = item.getCinsiyet();
				
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
					if(fld_hastalik.getText().length() == 0 || fld_tedavi.getText().length() == 0 || fld_ilac.getText().length() == 0 || fld_vet.getText().length() == 0) {
						Helper.showMsg("fill");
					}else {
						try {
							boolean control = tedavi.addTedavi(kupeNo, ikupeNo, cins, cinsiyet, date, fld_hastalik.getText(), fld_tedavi.getText(), fld_ilac.getText(), fld_vet.getText());
							if(control) {
								Helper.showMsg("success");
								fld_hastalik.setText(null);
								fld_tedavi.setText(null);
								fld_ilac.setText(null);
								updateTedaviModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_kaydet.setIcon(new ImageIcon(TedaviGUI.class.getResource("/View/save.png")));
		btn_kaydet.setForeground(Color.BLUE);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setBounds(735, 601, 117, 24);
		contentPane.add(btn_kaydet);
		
		JLabel lblNewLabel_5_1 = new JLabel("S\u0131ra No :");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(962, 596, 68, 33);
		contentPane.add(lblNewLabel_5_1);
		
		fld_sil = new JTextField();
		fld_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_sil.setColumns(10);
		fld_sil.setBounds(1040, 604, 115, 19);
		contentPane.add(fld_sil);
		
		JButton btn_sil = new JButton("Sil");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_sil.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					if(Helper.confirm("sure")) {
						int SelectID = Integer.parseInt(fld_sil.getText());
						try {
							boolean control = tedavi.deleteTedavi(SelectID);
							if(control) {
								Helper.showMsg("success");
								fld_sil.setText(null);
								updateTedaviModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil.setIcon(new ImageIcon(TedaviGUI.class.getResource("/View/delete.png")));
		btn_sil.setForeground(Color.RED);
		btn_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil.setBackground(Color.WHITE);
		btn_sil.setBounds(1165, 601, 106, 24);
		contentPane.add(btn_sil);
		
	
	}
	public void updateTedaviModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_tedavi.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<tedavi.getTedaviList().size(); i++) {
			tedaviData[0] = tedavi.getTedaviList().get(i).getSira_no();
			tedaviData[1] = tedavi.getTedaviList().get(i).getKupe_no();
			tedaviData[2] = tedavi.getTedaviList().get(i).getI_kupe_no();
			tedaviData[3] = tedavi.getTedaviList().get(i).getCinsi();
			tedaviData[4] = tedavi.getTedaviList().get(i).getCinsiyet();
			tedaviData[5] = tedavi.getTedaviList().get(i).getTedavi_tarih();
			tedaviData[6] = tedavi.getTedaviList().get(i).getHastalik();
			tedaviData[7] = tedavi.getTedaviList().get(i).getTedavi();
			tedaviData[8] = tedavi.getTedaviList().get(i).getIlac();
			tedaviData[9] = tedavi.getTedaviList().get(i).getVeteriner();
			tedaviModel.addRow(tedaviData);
		}
	}
}
