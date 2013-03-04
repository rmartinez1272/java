/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mod2.entities;

import java.io.Serializable;

/**
 *
 * @author paul
 */
public class Comando implements Serializable{
    private String textoComando;
    private String usuario;
    private String ipCliente;
    private String fechaHora;
    private Cliente cliente;

    /**
     * @return the textoComando
     */
    public String getTextoComando() {
        return textoComando;
    }

    /**
     * @param textoComando the textoComando to set
     */
    public void setTextoComando(String textoComando) {
        this.textoComando = textoComando;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the ipCliente
     */
    public String getIpCliente() {
        return ipCliente;
    }

    /**
     * @param ipCliente the ipCliente to set
     */
    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

    /**
     * @return the fechaHora
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
