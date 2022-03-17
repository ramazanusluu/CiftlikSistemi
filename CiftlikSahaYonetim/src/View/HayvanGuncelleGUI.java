package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Hayvan;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Helper.*;

public class HayvanGuncelleGUI extends JFrame {

	private JPanel contentPane;
	private static Hayvan hayvan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HayvanGuncelleGUI frame = new HayvanGuncelleGUI(hayvan);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HayvanGuncelleGUI(Hayvan hayvan) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HayvanGuncelleGUI.class.getResource("/View/uygulama.png")));
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(570, 290, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hayvan \u0130\u00E7in Yeni Durumu Se\u00E7iniz");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(92, 10, 273, 36);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_update = new JComboBox();
		comboBox_update.setModel(new DefaultComboBoxModel(new String[] {"Canl\u0131", "Sat\u0131ld\u0131", "\u00D6l\u00FC"}));
		comboBox_update.setBackground(Color.WHITE);
		comboBox_update.setBounds(143, 76, 161, 26);
		contentPane.add(comboBox_update);
		comboBox_update.setSelectedItem(hayvan.getDurum());
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String update = comboBox_update.getSelectedItem().toString();
				if(Helper.confirm("sure")) {
					try {
						boolean control = hayvan.updatedurum(hayvan.getId(), update);
						if(control) {
							Helper.showMsg("success");
							dispose();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(HayvanGuncelleGUI.class.getResource("/View/save.png")));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(174, 155, 107, 26);
		contentPane.add(btnNewButton);
	}
}
