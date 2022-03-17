package Helper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HarfList implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char caracter = e.getKeyChar();//hangi tusa basildigini okuyoruz
        if (((caracter < 'a') || (caracter > 'z'))  && (caracter != '\0')) {
        	e.consume();
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
