/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.util;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

/**
 *
 * @author Mayra
 */
public class Generic {
   public static MensajeLbl mensaje;
   public enum BanderaSiNo{
       SI ,NO ;
   }
    public enum Estado{
       A,//ACTIVO
       I,//INACTIVO
       E;//ELIMINADO
   }

     
    public static Estado StringToEstado(String text){
        if(text.equals("ACTIVO") || text.equals("A")){
            return Estado.A;
        }
        else if (text.equals("INACTIVO") || text.equals("I")){
                 return Estado.I;
            }
        else if (text.equals("ELIMINADO") || text.equals("E")){
            return Estado.E;
       }
        return null;
    }
//   public static TransporteDTO.EstadoTransporte StringToEstadoTransporte(String text){
//       if(text.equals("ACTIVO") || text.equals("A")){
//           return TransporteDTO.EstadoTransporte.A;
//       }
//       else if (text.equals("INACTIVO") || text.equals("P")){
//                return TransporteDTO.EstadoTransporte.P;
//           }
//       else if (text.equals("REPARACION") || text.equals("R")){
//                return TransporteDTO.EstadoTransporte.R;
//      }
//       return null;
//   }
//   
//    public static UsuarioDTO StringToUsuario(String usu){
//        UsuarioDTO usuario=new UsuarioDTO();
//        
//        return usuario;
//    }
      public static String EstadoToString(Estado estado){
       if(estado == Estado.A){return "ACTIVO";}
       else{if(estado == Estado.I){return "INACTIVO";}
       else {return " ";}
       }
   }
      
   public static Long StringToLong(String text){
       if (text.equals(""))
           return null;
       else
        return Long.parseLong(text); 
   }
   
   public static String LongToString(Long num){
       return String.valueOf(num); 
   }
      
   @SuppressWarnings("deprecation")
public static Date StringToDate(String text){
       return new Date(text);
   }
   public static String DateToString(Date date){
       if (date != null){
           @SuppressWarnings("deprecation")
		String se=date.getDay()+"/"+date.getMonth()+"/"+date.getYear();
          return se;
       }else
           return "";
   }
   /**
    * Agrega componentes a un panel determinado
     * @param panel el panel al cual se la va agregar
     * @param constraints el gridlayout
     * @param componente el componente que se agregara
     * @param posX la posicion inicial en x
     * @param posY la posicion inicial en y
     * @param ancho cuantas celdas quiere q ocupe en ancho
     * @param alto cuantas celdas quiere que ocupe en alto
    */
    public static void addComponent(JPanel panel,GridBagConstraints constraints,Component componente,int posX,int posY, int ancho,int alto){
        constraints.gridx = posY;
        constraints.gridy = posX;
        constraints.gridwidth =ancho;
        constraints.gridheight = alto;
        panel.add (componente, constraints);
    }
   
    public static Combobox EstadoCombobox(){
        String[] rutasImagenes ={"/Imagenes/noAplica_icon.png","/Imagenes/activo_icon.png","/Imagenes/inactivo_icon.png"};       
        ArrayList<String> itemsCombobox = new ArrayList<String>();
        itemsCombobox.add("--------");
        itemsCombobox.add("ACTIVO");
        itemsCombobox.add("INACTIVO");
        Combobox comboboxEstado = new Combobox(itemsCombobox.size(), itemsCombobox, 200,26, rutasImagenes);
        return comboboxEstado;
    }
    
    public static Combobox RolCombobox(){
        String[] rutasImagenes ={"/Imagenes/secretaria_icon.png","/Imagenes/box_icon.png","/Imagenes/administrador_icon.png"};       
        ArrayList<String> itemsCombobox = new ArrayList<String>();
        itemsCombobox.add("--------");
        itemsCombobox.add("SECRETARIA");
        itemsCombobox.add("BODEGUERO");
        itemsCombobox.add("ADMINISTRADOR");
        Combobox RolCombobox = new Combobox(itemsCombobox.size(), itemsCombobox, 200,26, rutasImagenes);
        return RolCombobox;
    }
    
    
    public enum Rol{
        A,//administrador
        S,//secretaria
        B; //bodeguero
        public boolean isAdministrador(){return this== A;}
        public boolean isBodeguero(){return this== B;}
        public boolean isSecretaria(){return this== S;}
    }
    
    public static Rol StringToRol(String text){
       if(text.equals("ADMINISTRADOR") || text.equals("A")){
           return Rol.A;
       }
       else if (text.equals("SECRETARIA") || text.equals("S")){
                return Rol.S;
           }
       else if (text.equals("BODEGUERO") || text.equals("B")){
           return Rol.B;
      }
       return null;
   }
    
    public static String RolToString(Rol rol){
        if(rol == Rol.A){return "ADMINISTRADOR";}
        else{if(rol == Rol.S){return "SECRETARIA";}
        else{if(rol == Rol.B){return "BODEGUERO";}
        		}
        	}
    	return null;
    	}
    
    
}
