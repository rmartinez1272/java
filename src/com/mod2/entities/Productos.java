/*

 */
package com.mod2.entities;

import com.mod2.interfaces.IParam;
import java.io.Serializable;

/**
 *
 * @author mmixco
 */
public class Productos implements Serializable, IParam{
    private String idproducto;
    private String descripcion;
    private String marca;
    private String modelo;
    private Double precio;
    private String detalles_tec;

    
    public Productos() {
        
    }
    public Productos(String idproducto, String descripcion, String marca, String modelo, double precio, String detalles_tec) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.detalles_tec = detalles_tec;
            
    }

    /**
     * @return the idproducto
     */
    public String getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
        
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the detalles_tec
     */
    public String getDetalles_tec() {
        return detalles_tec;
    }

    /**
     * @param detalles_tec the detalles_tec to set
     */
    public void setDetalles_tec(String detalles_tec) {
        this.detalles_tec = detalles_tec;
    }

}
