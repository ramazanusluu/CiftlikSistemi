package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Helper.*;
import Model.Ciftlik;
import Model.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Toolkit;

public class CiftlikGUI extends JFrame {
	
	static Kullanici kullanici = new Kullanici();
	
	KeyList kl = new KeyList();
	HarfList hl = new HarfList();
	
	Ciftlik ciftlik = new Ciftlik();
	
	private JPanel contentPane;
	private JTextField fld_isletmeno;
	private JTextField fld_isletmead;
	private JTextField fld_adres;
	private JTextField fld_telefon;
	private JTextField fld_kurulusyil;
	private JTextField fld_kapasite;
	private JTable table_ciftlik;
	private DefaultTableModel ciftlikModel = null;
	private Object[] ciftlikData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CiftlikGUI frame = new CiftlikGUI(kullanici);
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
	public CiftlikGUI(Kullanici kullanici) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CiftlikGUI.class.getResource("/View/uygulama.png")));
		
		ciftlikModel = new DefaultTableModel();
		Object[] colciftlikName = new Object[6];
		colciftlikName[0] = "Ýþletme No";
		colciftlikName[1] = "Ýþletme Adý";
		colciftlikName[2] = "Adres";
		colciftlikName[3] = "Telefon";
		colciftlikName[4] = "Kuruluþ Yýlý";
		colciftlikName[5] = "Kapasite";
		ciftlikModel.setColumnIdentifiers(colciftlikName);
		ciftlikData = new Object[6];
		for(int i=0; i<ciftlik.getCiftlikList().size(); i++) {
			ciftlikData[0] = ciftlik.getCiftlikList().get(i).getIsletme_no();
			ciftlikData[1] = ciftlik.getCiftlikList().get(i).getName();
			ciftlikData[2] = ciftlik.getCiftlikList().get(i).getAdres();
			ciftlikData[3] = ciftlik.getCiftlikList().get(i).getTelefon();
			ciftlikData[4] = ciftlik.getCiftlikList().get(i).getKurulus_yil();
			ciftlikData[5] = ciftlik.getCiftlikList().get(i).getKapasite();
			ciftlikModel.addRow(ciftlikData);
			
		}
		
		
		
		
		
		setResizable(false);
		setTitle("\u00C7\u0130FTL\u0130K B\u0130LG\u0130 EKRANI");
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
		btnAnaMen.setIcon(new ImageIcon(CiftlikGUI.class.getResource("/View/out.png")));
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
		
		JLabel lbl_ciftliklogo = new JLabel(new ImageIcon(getClass().getResource("ciftlikevi.png")));
		lbl_ciftliklogo.setBounds(607, 103, 95, 79);
		contentPane.add(lbl_ciftliklogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 232, 1146, 39);
		contentPane.add(scrollPane);
		
		table_ciftlik = new JTable(ciftlikModel);
		scrollPane.setViewportView(table_ciftlik);
		table_ciftlik.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(e.getType() == TableModelEvent.UPDATE) {
					String selectIsletmeno = table_ciftlik.getValueAt(table_ciftlik.getSelectedRow(), 0).toString();
					String selectIsletmead = table_ciftlik.getValueAt(table_ciftlik.getSelectedRow(), 1).toString();
					String selectAdres = table_ciftlik.getValueAt(table_ciftlik.getSelectedRow(), 2).toString();
					String selectTelefon = table_ciftlik.getValueAt(table_ciftlik.getSelectedRow(), 3).toString();
					String selectKurulusyil = table_ciftlik.getValueAt(table_ciftlik.getSelectedRow(), 4).toString();
					String selectKapasite = table_ciftlik.getValueAt(table_ciftlik.getSelectedRow(), 5).toString();
				
					try {
						boolean control = ciftlik.updateCiftlik(selectIsletmeno, selectIsletmead, selectAdres, selectTelefon, selectKurulusyil, selectKapasite);
						if(control) {
							Helper.showMsg("success");
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("\u00C7iflik Bilgilerini Giriniz...");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(566, 323, 228, 35);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.setIcon(new ImageIcon(CiftlikGUI.class.getResource("/View/save.png")));
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_isletmeno.getText().length() == 0 || fld_isletmead.getText().length() == 0 || fld_adres.getText().length() == 0 || fld_telefon.getText().length() == 0 || fld_kurulusyil.getText().length() == 0 || fld_kapasite.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = ciftlik.addCiftlik(fld_isletmeno.getText(), fld_isletmead.getText(), fld_adres.getText(), fld_telefon.getText(), fld_kurulusyil.getText(), fld_kapasite.getText());
						if(control) {
							Helper.showMsg("success");
							fld_isletmeno.setText(null);
							fld_isletmead.setText(null);
							fld_adres.setText(null);
							fld_telefon.setText(null);
							fld_kurulusyil.setText(null);
							fld_kapasite.setText(null);
							updateCiftlikModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_kaydet.setBackground(Color.WHITE);
		btn_kaydet.setForeground(Color.RED);
		btn_kaydet.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btn_kaydet.setBounds(617, 624, 137, 21);
		contentPane.add(btn_kaydet);
		
		JLabel lblNewLabel_3 = new JLabel("\u0130\u015Fletme No : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(537, 368, 127, 35);
		contentPane.add(lblNewLabel_3);
		
		fld_isletmeno = new JTextField();
		fld_isletmeno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_isletmeno.setColumns(10);
		fld_isletmeno.setBounds(674, 377, 137, 21);
		contentPane.add(fld_isletmeno);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u0130\u015Fletme Ad\u0131 : ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(537, 408, 127, 35);
		contentPane.add(lblNewLabel_3_1);
		
		fld_isletmead = new JTextField();
		fld_isletmead.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_isletmead.setColumns(10);
		fld_isletmead.setBounds(674, 417, 137, 21);
		contentPane.add(fld_isletmead);
		
		JLabel lblNewLabel_3_2 = new JLabel("Adres : ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(537, 448, 127, 35);
		contentPane.add(lblNewLabel_3_2);
		
		fld_adres = new JTextField();
		fld_adres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_adres.setColumns(10);
		fld_adres.setBounds(674, 457, 137, 21);
		contentPane.add(fld_adres);
		
		JLabel lblNewLabel_3_3 = new JLabel("Telefon : ");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_3.setBounds(537, 488, 127, 35);
		contentPane.add(lblNewLabel_3_3);
		
		fld_telefon = new JTextField();
		fld_telefon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_telefon.setColumns(10);
		fld_telefon.setBounds(674, 497, 137, 21);
		contentPane.add(fld_telefon);
		fld_telefon.addKeyListener(kl);
		
		JLabel lblNewLabel_3_4 = new JLabel("Kurulu\u015F Y\u0131l\u0131 : ");
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_4.setBounds(537, 528, 127, 35);
		contentPane.add(lblNewLabel_3_4);
		
		fld_kurulusyil = new JTextField();
		fld_kurulusyil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kurulusyil.setColumns(10);
		fld_kurulusyil.setBounds(674, 537, 137, 21);
		contentPane.add(fld_kurulusyil);
		fld_kurulusyil.addKeyListener(kl);
		
		JLabel lblNewLabel_3_5 = new JLabel("Kapasite : ");
		lblNewLabel_3_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_5.setBounds(537, 568, 127, 35);
		contentPane.add(lblNewLabel_3_5);
		
		fld_kapasite = new JTextField();
		fld_kapasite.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fld_kapasite.setColumns(10);
		fld_kapasite.setBounds(674, 577, 137, 21);
		contentPane.add(fld_kapasite);
		fld_kapasite.addKeyListener(kl);
	}
	public void updateCiftlikModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_ciftlik.getModel();
		clearModel.setRowCount(0);
		for(int i=0; i<ciftlik.getCiftlikList().size(); i++) {
			ciftlikData[0] = ciftlik.getCiftlikList().get(i).getIsletme_no();
			ciftlikData[1] = ciftlik.getCiftlikList().get(i).getName();
			ciftlikData[2] = ciftlik.getCiftlikList().get(i).getAdres();
			ciftlikData[3] = ciftlik.getCiftlikList().get(i).getTelefon();
			ciftlikData[4] = ciftlik.getCiftlikList().get(i).getKurulus_yil();
			ciftlikData[5] = ciftlik.getCiftlikList().get(i).getKapasite();
			ciftlikModel.addRow(ciftlikData);
			
		}
	}
}
