package Helper;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
	
	public static void optionPaneChangeButtonText() {
		UIManager.put("OptionPane.cancelButtonText", "Iptal");
		UIManager.put("OptionPane.noButtonText", "Hay�r");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
		UIManager.put("OptionPane.messageForeground", Color.black);
		
		
	}
	
	
	
public static void showMsg(String str) {
	String msg;
	optionPaneChangeButtonText();
	switch(str) {
	case "fill":
		msg = "L�tfen t�m alanlar� doldurunuz !";
		break;
	case "hata":
		msg = "Hatal� giri� tekrar deneyiniz...";
		break;
	case "success":
		msg = "��lem ba�ar�l�";
		break;
		default:
		msg = str;
		
	}
	JOptionPane.showMessageDialog(null, msg, "MESAJ", JOptionPane.INFORMATION_MESSAGE);
}

public static boolean confirm(String str) {
	optionPaneChangeButtonText();
	String msg;
	switch(str) {
	case "sure":
		msg = "Bu i�lemi ger�ekle�tirmek istiyor musun";
		break;
		default:
			msg = str;
			break;
	}
	int res = JOptionPane.showConfirmDialog(null, msg,"D�KKAT !", JOptionPane.YES_NO_OPTION);
	if(res == 0) {
		return true;
	}else {
		return false;
	}
}

}
