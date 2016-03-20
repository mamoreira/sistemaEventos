package sistemaevento.util;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JTextField;

public class InputNumber extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1024822934324500323L;
	
	public InputNumber(int size){
		super(size);
		this.addKeyListener(new java.awt.event.KeyAdapter() {
	  	      public void keyTyped(java.awt.event.KeyEvent evt) {
	  	    	numerosKeyTyped(evt);
	  	      }
	  	  });
	}
    private void numerosKeyTyped(java.awt.event.KeyEvent e) {                                             
        char caracter=e.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter !='.')){e.consume();
        }
        if (caracter == '.' && this.getText().contains(".")) {
        	e.consume();
        	}
    }    

    public Long getLong(){
    	return this.getText().length()>0?Long.parseLong(this.getText()):null;
    }
    public BigDecimal getBig(){
    	return this.getText().length()>0?new BigDecimal(this.getText()):null;
    }
}
