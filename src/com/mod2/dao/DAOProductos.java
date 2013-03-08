/*

 */
package com.mod2.dao;


import com.mod2.entities.Productos;
import com.mod2.entities.Filtro;
import com.mod2.interfaces.IDao;
import com.mod2.interfaces.IParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class DAOProductos implements IDao {
    private Connection cn ;

    public DAOProductos() {
        conectarse();
    }
    
    @Override
    public void conectarse(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/favoritos?user=caricia&password=caricia");
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public void desconectarse(){
        try {
            this.cn.close();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void insertar(IParam p){
        PreparedStatement st;
        Productos pr = this.MoldeaProducto(p);
        int x =0;
        try {
            st = this.cn.prepareStatement
("Insert into productos (idproducto,descripcion,marca ,modelo,precio,detalles_tec) values (?,?,?,?,?,?)");
            st.setString(1, pr.getIdproducto() );
            st.setString(2, pr.getDescripcion() );
            st.setString(3, pr.getMarca());
            st.setString(4, pr.getModelo());
            st.setDouble(5, pr.getPrecio());
            st.setString(6, pr.getDetalles_tec());
            
            x = st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void modifica(IParam p){
        PreparedStatement st;
        Productos pr = this.MoldeaProducto(p);
        int x =0;
        try {
            st = this.cn.prepareStatement
("Update productos set descripcion=?,marca=?,modelo=?,precio=?,detalles_tec=? where idproducto=?");
            st.setString(1, pr.getIdproducto() );
            st.setString(2, pr.getDescripcion() );
            st.setString(3, pr.getMarca());
            st.setString(4, pr.getModelo());
            st.setDouble(5, pr.getPrecio());
            st.setString(6, pr.getDetalles_tec());
            x = st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void elimina(IParam p){
        PreparedStatement st;
        Productos pr = this.MoldeaProducto(p);
        int x =0;
        try {
            st = this.cn.prepareStatement("Delete from productos  where idproducto=?");
            st.setString(1, pr.getIdproducto() );
            x = st.executeUpdate(); 
        } catch (Exception e) {
        }
    }
    
    @Override
    public ArrayList listar(Filtro filtro){
        ArrayList lista = new ArrayList();
        Productos pr;
        try {
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            String sSql="Select idproducto,descripcion,marca,modelo,precio,detalles_tec from productos";
            String sSqlFiltro="";
            if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false & filtro.isBfiltro3()==false){
                sSqlFiltro=" where descripcion = '" + filtro.getValor1() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==true & filtro.isBfiltro3()==false){
                sSqlFiltro=" where marca = '" + filtro.getValor2() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==false & filtro.isBfiltro3()==true){
                sSqlFiltro=" where modelo = '" + filtro.getValor3() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==true & filtro.isBfiltro3()==false){
                sSqlFiltro=" where descripcion = '" + filtro.getValor1() + "' and marca = '" + filtro.getValor2() + "'";
            }else if (!filtro.isBfiltro1()==false & filtro.isBfiltro2()==true & filtro.isBfiltro3()==true){
                sSqlFiltro=" where descripcion = '" + filtro.getValor2() + "' and modelo = '" + filtro.getValor3() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false & filtro.isBfiltro3()==true){
                sSqlFiltro=" where descripcion = '" + filtro.getValor1() + "' and modelo = '" + filtro.getValor3() + "'";
            }else if(filtro.isBfiltro1()==true & filtro.isBfiltro2()==true & filtro.isBfiltro3()==true){
                sSqlFiltro=" where descripcion = '" + filtro.getValor1() + "' and marca = '" + filtro.getValor2() + "' and modelo = '" + filtro.getValor3() + "'";
            }
            sSql += sSqlFiltro;
            rs = st.executeQuery(sSql);            
            while(rs.next()){
                pr = new Productos(rs.getString("idproducto"), rs.getString("descripcion"), rs.getString("marca"), rs.getString("modelo"), rs.getDouble("precio"), rs.getString("detalles_tec"));
                lista.add(pr);
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    @Override
    public int conteo(){
        int x=0;
        try {
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("Select count(*) num from productos");
            while(rs.next()){
                x = rs.getInt("num"); 
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
        }
        return x;
    }
     private Productos MoldeaProducto(IParam p){
        Productos pr =null;
        if (p instanceof Productos) {
            pr = (Productos) p;
            
        }
        return pr;
    }
    
}
