/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaevento.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Mayrita
 */
public class Fecha extends Date{

        

    /**
	 * 
	 */
	private static final long serialVersionUID = -3301872521069051461L;

	//en fecha obtenemos la fecha y hora del sistema
    public Fecha() {
    }
        
    //Obtenemos el valor del año, mes, día,
    //hora, minuto y segundo del sistema
    //usando el método get y el parámetro correspondiente

    public static String getFechaActual(){
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = Calendar.MONTH;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return anio+"-"+(mes-1)+"-"+dia;
    }

    public static String getHoraActual(){
        Calendar fecha = new GregorianCalendar();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        return hora+":"+minuto+":"+segundo;
    }
    public static void main(String [] args){
        String s="d";
        System.out.println(s.matches("[0-9|.]+"));
        System.out.println(Fecha.getFechaActual());
    }
    
    @SuppressWarnings("deprecation")
	public static Date fecha(String fecha){
        Date date=new Date();
        String[] array=fecha.split("-");
        date.setYear(Integer.parseInt(array[0]));
        date.setMonth(Integer.parseInt(array[1]));
        date.setDate(Integer.parseInt(array[2]));
        return date;
    }
    
    public static String fecha(Date fecha){
        @SuppressWarnings("deprecation")
		String date = ""+fecha.getYear()+"-"+fecha.getMonth()+"-"+fecha.getDay();
        return date;
    }

    @SuppressWarnings("deprecation")
	@Override
    public String toString() {
        return  ""+this.getYear()+"-"+this.getMonth()+"-"+this.getDay();
    }
    
}