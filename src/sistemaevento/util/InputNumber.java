package sistemaevento.util;

import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JTextField;

import org.omg.IOP.CodecPackage.FormatMismatch;

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
    private void numerosKeyTyped(java.awt.event.KeyEvent evt) {                                             
        char c=evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }    

    public Long getLong(){
    	return this.getText().length()>0?Long.parseLong(this.getText().trim()):null;
    }
}
