/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mod2.controller;

import com.mod2.dao.DAOClientes;
import com.mod2.dao.DAOProductos;
import com.mod2.entities.Cliente;
import com.mod2.entities.Filtro;
import com.mod2.entities.Productos;
import com.mod2.interfaces.IDao;
import com.mod2.interfaces.IParam;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mmixco
 */
public class Controller extends DefaultTableModel {
    private int numreg=0; 
    private String data[][];
    private IDao dao;
    private ArrayList lista;
    private Filtro filtro = new Filtro(false,false,false,"","","");

    public Controller(String p) {
        super();
        if (p.equals("Productos")) dao = new DAOProductos();
        if (p.equals("Clientes")) dao = new DAOClientes();        
        data=getRows();
        setDataVector(data,getCols());
    }
     
    public Controller() {
        super();
         data=getRows();
        setDataVector(data,getCols());
    }
    
    public String[][] getRows(){
         if (dao instanceof DAOProductos) {
           return getrowProductos();
         }else{
             return  getrowsCLientes();
           }
        
  }

  public String[] getCols(){
         if (dao instanceof DAOProductos) {
           return getColsProductos();
         }else{
             return  getColsClientes();
           }
         
     
    
  }
  
  private String[] getColsClientes(){  
         
  String[] Encabezados={new String("Código"),new String("Nombres"),new String("Apellido_1"),new String("Apellido_2"),new String("Dirección"),new String("Teléfono"),new String("Celular"),new String("Email")};
    return Encabezados;    
    
  }
  
  
    private String[] getColsProductos(){  
                 
  String[] Encabezados={new String("idproducto"),new String("descripcion"),new String("marca"),new String("modelo"),new String("precio"),new String("detalles_tec")};
    return Encabezados;    
    
  }
  
  public boolean isCellEditable(int row,int column){
        return false;
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    return data[rowIndex][columnIndex];
  }
  
  public void agregar(IParam iparam){
      dao.insertar(iparam);
  }
  
  public void modificar(IParam iparam){
      dao.modifica(iparam);
  }
  
  public void elimina(IParam iparam){
      dao.elimina(iparam);
  }

    /**
     * @return the listaClientes
     */
    public ArrayList getLista() {
        return lista;
    }

    /**
     * @return the filtro
     */
    public Filtro getFiltro() {
        return filtro;
    }

    /**
     * @param filtro the filtro to set
     */
    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
  
    
    private  String[][] getrowsCLientes(){
         ArrayList lista;
        numreg = dao.conteo();
        data=new String[numreg][8];
         try{
          lista = dao.listar(this.filtro);
          this.lista = lista;     
          Cliente cl;
          for(int fila=0;fila<numreg;fila++){
              cl = (Cliente)lista.get(fila);
              data[fila][0]= cl.getCodigo();
              data[fila][1]= cl.getNombre();
              data[fila][2]= cl.getApellido1();
              data[fila][3]= cl.getApellido2();
              data[fila][4]= cl.getDireccion();
              data[fila][5]= cl.getTelefono();
              data[fila][6]= cl.getCelular();
              data[fila][7]= cl.getEmail();
          }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
       
    }
 
    private String[][] getrowProductos(){
        ArrayList lista;
        numreg = dao.conteo();
        data=new String[numreg][6];
        try{
          lista = dao.listar(this.filtro);
          this.lista = lista;     
          Productos pr;
          for(int fila=0;fila<numreg;fila++){
              pr = (Productos)lista.get(fila);
              data[fila][0]= pr.getIdproducto();
              data[fila][1]= pr.getDescripcion();
              data[fila][2]= pr.getMarca();
              data[fila][3]= pr.getModelo();
              data[fila][4]= pr.getPrecio().toString();
              data[fila][5]= pr.getDetalles_tec();

          }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
           
        }    

                
    }

 
    
        
    

