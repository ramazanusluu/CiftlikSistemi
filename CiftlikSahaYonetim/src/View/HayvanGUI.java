package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.Hayvan;
import Model.Kullanici;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Helper.*;
import javax.swing.JTable;

public class HayvanGUI extends JFrame {
	static Kullanici kullanici = new Kullanici();
	Hayvan hayvan = new Hayvan();

	private JPanel contentPane;
	private JTextField fld_hayvanid;
	private DefaultTableModel hayvanModel = null;
	private Object[]  hayvanData = null;
	private JTable table_hayvan;
	private JPopupMenu hayvanMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HayvanGUI frame = new HayvanGUI(kullanici);
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
	public HayvanGUI(Kullanici kullanici) throws SQLException {
		
		hayvanModel = new DefaultTableModel();
		Object[] colHayvanName = new Object[14];
		colHayvanName[0] = "ID";
		colHayvanName[1] = "Kulak Küpe No";
		colHayvanName[2] = "Ýþletme Küpe No";
		colHayvanName[3] = "Adý";
		colHayvanName[4] = "Cinsi";
		colHayvanName[5] = "Cinsiyet";
		colHayvanName[6] = "Doðum Tarihi";
		colHayvanName[7] = "Kayýt Tarihi";
		colHayvanName[8] = "Anne Küpe No";
		colHayvanName[9] = "Anne Verim Puaný";
		colHayvanName[10] = "Baba Küpe No";
		colHayvanName[11] = "Baba Verim Puaný";
		colHayvanName[12] = "Verim puaný";
		colHayvanName[13] = "Durumu";
		hayvanModel.setColumnIdentifiers(colHayvanName);
		hayvanData = new Object[14];
		for(int i = 0; i < hayvan.getHayvanList().size(); i++) {
			hayvanData[0] = hayvan.getHayvanList().get(i).getId();
			hayvanData[1] = hayvan.getHayvanList().get(i).getK_kupe_no();
			hayvanData[2] = hayvan.getHayvanList().get(i).getI_kupe_no();
			hayvanData[3] = hayvan.getHayvanList().get(i).getName();
			hayvanData[4] = hayvan.getHayvanList().get(i).getCinsi();
			hayvanData[5] = hayvan.getHayvanList().get(i).getCinsiyet();
			hayvanData[6] = hayvan.getHayvanList().get(i).getD_tarih();
			hayvanData[7] = hayvan.getHayvanList().get(i).getKayit_tarih();
			hayvanData[8] = hayvan.getHayvanList().get(i).getAnne_küpe();
			hayvanData[9] = hayvan.getHayvanList().get(i).getAnne_verim();
			hayvanData[10] = hayvan.getHayvanList().get(i).getBaba_küpe();
			hayvanData[11] = hayvan.getHayvanList().get(i).getBaba_verim();
			hayvanData[12] = hayvan.getHayvanList().get(i).getVerim_puan();
			hayvanData[13] = hayvan.getHayvanList().get(i).getDurum();
			hayvanModel.addRow(hayvanData);
			
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(HayvanGUI.class.getResource("/View/uygulama.png")));
		setTitle("Hayvan Bilgi Ekran\u0131");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 : " + kullanici.getName());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 310, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOL\u039ER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(617, 10, 75, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAnaMen = new JButton("Ana Men\u00FC");
		btnAnaMen.setIcon(new ImageIcon(HayvanGUI.class.getResource("/View/out.png")));
		btnAnaMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaGUI a = new AnaGUI(kullanici);
				a.setVisible(true);
				dispose();
			}
		});
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		
		JScrollPane scrollPane_hayvan = new JScrollPane();
		scrollPane_hayvan.setBounds(10, 56, 1264, 597);
		contentPane.add(scrollPane_hayvan);
		
		hayvanMenu = new JPopupMenu();
		JMenuItem UpdateMenu = new JMenuItem("Güncelle");
		hayvanMenu.add(UpdateMenu);
		
		UpdateMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selID = Integer.parseInt(table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 0).toString());
				Hayvan selectHayvan = hayvan.getFetch(selID);
				HayvanGuncelleGUI  hugui = new HayvanGuncelleGUI(selectHayvan);
				hugui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				hugui.setVisible(true);
				hugui.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						try {
							updateHayvanModel();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
			}
		});
		
		
		table_hayvan = new JTable(hayvanModel);
		table_hayvan.setComponentPopupMenu(hayvanMenu);
		table_hayvan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point point  = e.getPoint();
				int selectedRow = table_hayvan.rowAtPoint(point);
				table_hayvan.setRowSelectionInterval(selectedRow, selectedRow);
				
			}
		});
		scrollPane_hayvan.setViewportView(table_hayvan);
		table_hayvan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_hayvanid.setText(table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_hayvan.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 0).toString());
					String selectKupe = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 1).toString();
					String selectIKupe = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 2).toString();
					String selectName = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 3).toString();
					String selectCins = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 4).toString();
					String selectCinsiyet = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 5).toString();
					String selectDogum = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 6).toString();
					String selectKayit = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 7).toString();
					String selectAnnekupe = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 8).toString();
					String selectAnneverim = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 9).toString();
					String selectBabakupe= table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 10).toString();
					String selectBabaverim = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 11).toString();
					String selectverim = table_hayvan.getValueAt(table_hayvan.getSelectedRow(), 12).toString();
					try {
						boolean control = hayvan.updateHayvan(selectID, selectKupe, selectIKupe , selectName, selectCins, selectCinsiyet, selectDogum, selectKayit, selectAnnekupe, selectAnneverim, selectBabakupe, selectBabaverim, selectverim);
						if(control) {
							Helper.showMsg("success");
							updateHayvanModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		JButton btn_sil = new JButton("S\u0130L");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_hayvanid.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir hayvan seçiniz !");
				}else {
					int selectID = Integer.parseInt(fld_hayvanid.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = hayvan.deleteHayvan(selectID); 
							if(control) {
								Helper.showMsg("success");
								fld_hayvanid.setText(null);
								updateHayvanModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_sil.setIcon(new ImageIcon(HayvanGUI.class.getResource("/View/delete.png")));
		btn_sil.setBackground(Color.WHITE);
		btn_sil.setForeground(Color.RED);
		btn_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_sil.setBounds(1178, 670, 94, 21);
		contentPane.add(btn_sil);
		
		fld_hayvanid = new JTextField();
		fld_hayvanid.setBackground(Color.WHITE);
		fld_hayvanid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_hayvanid.setBounds(1078, 672, 96, 19);
		contentPane.add(fld_hayvanid);
		fld_hayvanid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Id : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1044, 670, 24, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_yenikayit = new JButton("Yeni Kay\u0131t");
		btn_yenikayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HayvanKayitGUI hkgui = new HayvanKayitGUI(kullanici);
					hkgui.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btn_yenikayit.setIcon(new ImageIcon(HayvanGUI.class.getResource("/View/login.png")));
		btn_yenikayit.setBackground(Color.WHITE);
		btn_yenikayit.setForeground(Color.BLUE);
		btn_yenikayit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_yenikayit.setBounds(10, 673, 141, 21);
		contentPane.add(btn_yenikayit);
	}
	public void updateHayvanModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_hayvan.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i < hayvan.getHayvanList().size(); i++) {
			hayvanData[0] = hayvan.getHayvanList().get(i).getId();
			hayvanData[1] = hayvan.getHayvanList().get(i).getK_kupe_no();
			hayvanData[2] = hayvan.getHayvanList().get(i).getI_kupe_no();
			hayvanData[3] = hayvan.getHayvanList().get(i).getName();
			hayvanData[4] = hayvan.getHayvanList().get(i).getCinsi();
			hayvanData[5] = hayvan.getHayvanList().get(i).getCinsiyet();
			hayvanData[6] = hayvan.getHayvanList().get(i).getD_tarih();
			hayvanData[7] = hayvan.getHayvanList().get(i).getKayit_tarih();
			hayvanData[8] = hayvan.getHayvanList().get(i).getAnne_küpe();
			hayvanData[9] = hayvan.getHayvanList().get(i).getAnne_verim();
			hayvanData[10] = hayvan.getHayvanList().get(i).getBaba_küpe();
			hayvanData[11] = hayvan.getHayvanList().get(i).getBaba_verim();
			hayvanData[12] = hayvan.getHayvanList().get(i).getVerim_puan();
			hayvanData[13] = hayvan.getHayvanList().get(i).getDurum();
			hayvanModel.addRow(hayvanData);
			
		}
	}
}
