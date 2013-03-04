/*

 */
package com.mod2.dao;


import com.mod2.entities.Cliente;
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
public class DAOClientes implements IDao {
    private Connection cn ;

    public DAOClientes() {
        conectarse();
    }
    
    @Override
    public void conectarse(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/favoritos?user=root&password=mario13");
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
    public void insertar(IParam cliente){
        PreparedStatement st;
        Cliente cl = this.MoldeaCliente(cliente);
        
        int x =0;
        try {
            st = this.cn.prepareStatement
("Insert into Clientes (id,Nombres,Apellido1,Apellido2,Direccion,Telefono,Celular,Email) values (?,?,?,?,?,?,?,?)");
            st.setString(1, cl.getCodigo());
            st.setString(2, cl.getNombre());
            st.setString(3, cl.getApellido1());
            st.setString(4, cl.getApellido2());
            st.setString(5, cl.getDireccion());
            st.setString(6, cl.getTelefono());
            st.setString(7, cl.getCelular());
            st.setString(8, cl.getEmail());
            x = st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void modifica(IParam cliente){
        PreparedStatement st;
        Cliente cl = this.MoldeaCliente(cliente);
        int x =0;
        try {
            st = this.cn.prepareStatement
("Update Clientes set Nombres=?,Apellido1=?,Apellido2=?,Direccion=?,Telefono=?,Celular=?,Email=? where id=?");
            st.setString(1, cl.getNombre());
            st.setString(2, cl.getApellido1());
            st.setString(3, cl.getApellido2());
            st.setString(4, cl.getDireccion());
            st.setString(5, cl.getTelefono());
            st.setString(6, cl.getCelular());
            st.setString(7, cl.getEmail());
            st.setString(8, cl.getCodigo());
            x = st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void elimina(IParam cliente){
        PreparedStatement st;
        Cliente cl = this.MoldeaCliente(cliente);
        int x =0;
        try {
            st = this.cn.prepareStatement("Delete from Clientes  where id=?");
            st.setString(1, cl.getCodigo());
            x = st.executeUpdate(); 
        } catch (Exception e) {
        }
    }
    
    @Override
    public ArrayList listar(Filtro filtro){
        ArrayList listaClientes = new ArrayList();
        Cliente cl;
        try {
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            String sSql="Select id,Nombres,Apellido1,Apellido2,Direccion,Telefono,Celular,Email from Clientes";
            String sSqlFiltro="";
            if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false & filtro.isBfiltro3()==false){
                sSqlFiltro=" where Nombres = '" + filtro.getValor1() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==true & filtro.isBfiltro3()==false){
                sSqlFiltro=" where Apellido1 = '" + filtro.getValor2() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==false & filtro.isBfiltro3()==true){
                sSqlFiltro=" where Apellido2 = '" + filtro.getValor3() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==true & filtro.isBfiltro3()==false){
                sSqlFiltro=" where Nombres = '" + filtro.getValor1() + "' and Apellido1 = '" + filtro.getValor2() + "'";
            }else if (!filtro.isBfiltro1()==false & filtro.isBfiltro2()==true & filtro.isBfiltro3()==true){
                sSqlFiltro=" where Apellido1 = '" + filtro.getValor2() + "' and Apellido2 = '" + filtro.getValor3() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false & filtro.isBfiltro3()==true){
                sSqlFiltro=" where Nombres = '" + filtro.getValor1() + "' and Apellido2 = '" + filtro.getValor3() + "'";
            }else if(filtro.isBfiltro1()==true & filtro.isBfiltro2()==true & filtro.isBfiltro3()==true){
                sSqlFiltro=" where Nombres = '" + filtro.getValor1() + "' and Apellido1 = '" + filtro.getValor2() + "' and Apellido2 = '" + filtro.getValor3() + "'";
            }
            sSql += sSqlFiltro;
            rs = st.executeQuery(sSql);            
            while(rs.next()){
                cl = new Cliente(rs.getString("id"), rs.getString("Nombres"), rs.getString("Apellido1"), rs.getString("Apellido2"), rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("Celular"), rs.getString("Email"));
                listaClientes.add(cl);
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }
    
    @Override
    public int conteo(){
        int x=0;
        try {
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("Select count(*) num from Clientes");
            while(rs.next()){
                x = rs.getInt("num"); 
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
        }
        return x;
    }
    
    private Cliente MoldeaCliente(IParam p){
        Cliente cl =null;
        if (p instanceof Cliente) {
            cl = (Cliente) p;
            
        }
        return cl;
    }
    
}
