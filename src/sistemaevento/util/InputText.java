package sistemaevento.util;

import javax.swing.JTextField;

public class InputText extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1024822934324500323L;
	
	public InputText(int size){
		super(size);
		this.addKeyListener(new java.awt.event.KeyAdapter() {
	  	      public void keyTyped(java.awt.event.KeyEvent evt) {
	  	          letrasKeyTyped(evt);
	  	      }
	  	  });
	}
    private void letrasKeyTyped(java.awt.event.KeyEvent evt) {                                             
        char c=evt.getKeyChar();
        if((c<'a' || c>'z' )&&(c<'A' || c>'Z' )) evt.consume();
    }   
}
