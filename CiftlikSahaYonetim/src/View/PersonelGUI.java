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

import Helper.Helper;
import Model.Kullanici;
import Model.Personel;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PersonelGUI extends JFrame {
	static Kullanici kullanici = new Kullanici();
	
	Personel personel = new Personel();
	
	private JPanel contentPane;
	private JTable table_personel;
	private JTextField fld_personelid;
	private DefaultTableModel personelModel = null;
	private Object[]  personelData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelGUI frame = new PersonelGUI(kullanici);
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
	public PersonelGUI(Kullanici kullanici) throws SQLException {
		
		personelModel = new DefaultTableModel();
		Object[] colPersonelName = new Object[11];
		colPersonelName[0] = "id";
		colPersonelName[1] = "Ad Soyad";
		colPersonelName[2] = "T.C. No";
		colPersonelName[3] = "Cinsiyet";
		colPersonelName[4] = "Tefeon";
		colPersonelName[5] = "Adres";
		colPersonelName[6] = "resim";
		colPersonelName[7] = "Baþlama Tarihi";
		colPersonelName[8] = "Görev";
		colPersonelName[9] = "Maaþ";
		colPersonelName[10] = "IBAN";
		personelModel.setColumnIdentifiers(colPersonelName);
		personelData = new Object[11];
		for(int i = 0; i<personel.getPersonelList().size(); i++) {
			personelData[0] = personel.getPersonelList().get(i).getId();
			personelData[1] = personel.getPersonelList().get(i).getName();
			personelData[2] = personel.getPersonelList().get(i).getTcno();
			personelData[3] = personel.getPersonelList().get(i).getCinsiyet();
			personelData[4] = personel.getPersonelList().get(i).getTelefon();
			personelData[5] = personel.getPersonelList().get(i).getAdres();
			personelData[6] = personel.getPersonelList().get(i).getResim();
			personelData[7] = personel.getPersonelList().get(i).getBaslama_tarih();
			personelData[8] = personel.getPersonelList().get(i).getGorev();
			personelData[9] = personel.getPersonelList().get(i).getMaas();
			personelData[10] = personel.getPersonelList().get(i).getIban();
			personelModel.addRow(personelData);
			
		}
		
		
		setTitle("PERSONEL EKRANI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonelGUI.class.getResource("/View/uygulama.png")));
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 35, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanýcý : " + kullanici.getName());
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
		btnAnaMen.setForeground(Color.BLUE);
		btnAnaMen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAnaMen.setBackground(Color.WHITE);
		btnAnaMen.setBounds(1165, 10, 110, 21);
		contentPane.add(btnAnaMen);
		JPanel panel_resim = new JPanel();
		panel_resim.setBounds(10, 55, 244, 293);
		contentPane.add(panel_resim);
		panel_resim.setLayout(null);
		
		JLabel lbl_personelresim = new JLabel("");
		lbl_personelresim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_personelresim.setBounds(10, 10, 224, 273);
		panel_resim.add(lbl_personelresim);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 55, 1011, 646);
		contentPane.add(scrollPane);
		
		table_personel = new JTable(personelModel);
		scrollPane.setViewportView(table_personel);
		table_personel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					fld_personelid.setText(table_personel.getValueAt(table_personel.getSelectedRow(), 0).toString());
					 String selectResim = table_personel.getValueAt(table_personel.getSelectedRow(), 6).toString();
					 ImageIcon imgThisImg = new ImageIcon(selectResim);
					 lbl_personelresim.setIcon(imgThisImg);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table_personel.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_personel.getValueAt(table_personel.getSelectedRow(), 0).toString());
					String selectName = table_personel.getValueAt(table_personel.getSelectedRow(), 1).toString();
					String selectTcno = table_personel.getValueAt(table_personel.getSelectedRow(), 2).toString();
					String selectCinsiyet = table_personel.getValueAt(table_personel.getSelectedRow(), 3).toString();
					String selectTelefon = table_personel.getValueAt(table_personel.getSelectedRow(), 4).toString();
					String selectAdres = table_personel.getValueAt(table_personel.getSelectedRow(), 5).toString();
					String selectResim = table_personel.getValueAt(table_personel.getSelectedRow(), 6).toString();
					String selectBaslama_tarih = table_personel.getValueAt(table_personel.getSelectedRow(), 7).toString();
					String selectGorev = table_personel.getValueAt(table_personel.getSelectedRow(), 8).toString();
					String selectMaas = table_personel.getValueAt(table_personel.getSelectedRow(), 9).toString();
					String selectIban = table_personel.getValueAt(table_personel.getSelectedRow(), 10).toString();
					try {
						boolean control = personel.updatePersonel(selectID, selectName, selectTcno, selectCinsiyet, selectTelefon, selectAdres, selectResim, selectBaslama_tarih, selectGorev, selectMaas, selectIban);
						if(control) {
							Helper.showMsg("success");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		JButton btn_personelkaydet = new JButton("Yeni Kay\u0131t");
		btn_personelkaydet.setIcon(new ImageIcon(PersonelGUI.class.getResource("/View/login.png")));
		btn_personelkaydet.setForeground(Color.BLUE);
		btn_personelkaydet.setBackground(Color.WHITE);
		btn_personelkaydet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_personelkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PkayitGUI kgui = new PkayitGUI(kullanici);
				kgui.setVisible(true);
				dispose();
			}
		});
		btn_personelkaydet.setBounds(55, 415, 154, 35);
		contentPane.add(btn_personelkaydet);
		
		JLabel lblNewLabel_9 = new JLabel("Silmek \u0130stedi\u011Finiz Personel");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(10, 499, 251, 41);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Id :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(10, 542, 104, 33);
		contentPane.add(lblNewLabel_10);
		
		fld_personelid = new JTextField();
		fld_personelid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_personelid.setColumns(10);
		fld_personelid.setBounds(118, 550, 136, 19);
		contentPane.add(fld_personelid);
		
		JButton btn_personelsil = new JButton("Sil");
		btn_personelsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_personelid.getText().length() == 0) {
					Helper.showMsg("Lütfen geçerli bir personel seçiniz !");
				}
				else {
					int selectID = Integer.parseInt(fld_personelid.getText());
					if(Helper.confirm("sure")) {
						try {
							boolean control = personel.deletePersonel(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_personelid.setText(null);
								updatePersonelModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_personelsil.setIcon(new ImageIcon(PersonelGUI.class.getResource("/View/delete.png")));
		btn_personelsil.setForeground(Color.RED);
		btn_personelsil.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btn_personelsil.setBackground(Color.WHITE);
		btn_personelsil.setBounds(85, 589, 95, 21);
		contentPane.add(btn_personelsil);
	}
	public void updatePersonelModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_personel.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i<personel.getPersonelList().size(); i++) {
			personelData[0] = personel.getPersonelList().get(i).getId();
			personelData[1] = personel.getPersonelList().get(i).getName();
			personelData[2] = personel.getPersonelList().get(i).getTcno();
			personelData[3] = personel.getPersonelList().get(i).getCinsiyet();
			personelData[4] = personel.getPersonelList().get(i).getTelefon();
			personelData[5] = personel.getPersonelList().get(i).getAdres();
			personelData[6] = personel.getPersonelList().get(i).getResim();
			personelData[7] = personel.getPersonelList().get(i).getBaslama_tarih();
			personelData[8] = personel.getPersonelList().get(i).getGorev();
			personelData[9] = personel.getPersonelList().get(i).getMaas();
			personelData[10] = personel.getPersonelList().get(i).getIban();
			personelModel.addRow(personelData);
			
		}
	
	}
}
