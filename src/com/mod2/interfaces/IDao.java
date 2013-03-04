/*

 */
package com.mod2.interfaces;


import com.mod2.entities.Filtro;
import java.util.ArrayList;

/**
 *
@mmixco
 */
public interface IDao {
    
     public void conectarse();

     public void desconectarse();
     
     public void insertar(IParam iparam);
     
     public void modifica(IParam iparam);
     
     public void elimina(IParam iparam);
     
     public ArrayList listar(Filtro filtro);
     
     public int conteo();
     
     
    
}
