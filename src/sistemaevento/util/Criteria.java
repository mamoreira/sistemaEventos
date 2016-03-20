/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaevento.util;

import java.math.BigDecimal;

/**
 *
 * @author Mayra
 */
public class Criteria {
    private String query;
    private String aliase;
    private String tablaPrincipal;
    
    public Criteria(String tabla) {
        tablaPrincipal=tabla;
        query="Select * from "+tabla;
    }

   public Criteria(String tabla,String aliase) {
       this.aliase=aliase;
        query="Select * from "+tabla+" "+aliase;
    }
   
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
    public Criteria addEqualsIfNotNull(String columna,Object value){
        if(addWhere()){
            if(value != null){
                query=query+columna+" = '"+ value +"' ";
            }
        }
        else{
            if(value != null){
                query=query+"and "+columna+" = '"+ value +"' ";
            }
        }
        return this;
    }
    
    public Criteria addEqualsIfNotNull(String columna,Object value,String aliase){
        if(addWhere()){
            if(value != null){
                query=query+aliase+"."+columna+" = "+ value +" ";
            }
        }
        else{
            if(value != null){
                query=query+"and "+aliase+"."+columna+" = '"+ value +"' ";
            }
        }
        return this;
    }
    
    public Criteria addEqualsNumIfNotNull(String columna,BigDecimal value){
        if(addWhere()){
            if(value.scale()!= 0 || value != null){
                query=query+columna+" = "+ value +" ";
            }
        }
        else{
            if(value.scale()!= 0|| value != null){
                query=query+"and "+columna+" = "+ value +" ";
            }
        }
        return this;
    }
    public Criteria addEqualsOrIfNotNull(String columna,Object value,String aliase){
        if(addWhere()){
            if(value != null){
                query=query+aliase+"."+columna+" = "+ value +" ";
            }
        }
        else{
            if(value != null){
                query=query+"or "+aliase+"."+columna+" = '"+ value +"' ";
            }
        }
        return this;
    }
       
    public Criteria addSql(String sql){
        query=query+sql;
        return this;
    }
       
    public Criteria addLikeIfNotNull(String columna,Object value){
        if(addWhere()){
            if(value != null){
                query=query+columna+" like '%"+ value +"%' ";
            }
        }
        else{
            if(value != null){
                query=query+"and "+columna+" like '%"+ value +"%' ";
            }
        }
        return this;
    }
    
        public Criteria addLikeIfNotNull(String columna,Object value,String aliase){
        if(addWhere()){
            if(value != null){
                query=query+aliase+"."+columna+" like '%"+ value +"%' ";
            }
        }
        else{
            if(value != null){
                query=query+"and "+aliase+"."+columna+" like '%"+ value +"%' ";
            }
        }
        return this;
    }
    
    public Criteria addEquals (String columna,Object value){
        if(addWhere()){
            if(value != null){
                query=query+columna+" = "+ value+" ";
            }
        }
        else{
            if(value != null){
                query=query+"and "+columna+" = "+ value+" ";
            }
        }
        return this;
    }
       
    public Criteria addJoin(String...tablas){
        for (String nombre : tablas){
            query=query+" join "+nombre;
        }
        return this;
    }
       
    public Criteria addLeftJoin(String...tablas){
        for (String nombre : tablas){
            query=query+" left join "+nombre;
        }
        return this;
    }
    private boolean addWhere(){
        String[] palabrasSeparadas = query.split(" ");
        int i=0,size=palabrasSeparadas.length;
        for (String palabrasSeparada : palabrasSeparadas) {
            i++;
            if (palabrasSeparada.equals("where") && i==size) {                
                return true;
            }
            if (palabrasSeparada.equals("where") ) {                
                return false;
            }
        }
        query=query+" where ";
        return true;
    } 
}
