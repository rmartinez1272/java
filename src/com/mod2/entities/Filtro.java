/*

 */
package com.mod2.entities;

import java.io.Serializable;

/**
 *
@mmixco
 */
public class Filtro implements Serializable{
    private boolean bfiltro1;
    private boolean bfiltro2;
    private boolean bfiltro3;
    private String valor1;
    private String valor2;
    private String valor3;

    public Filtro() {
    }
    
    public Filtro(boolean bfiltro1, boolean bfiltro2, boolean bfiltro3, String valor1, String valor2, String valor3) {
        this.bfiltro1 = bfiltro1;
        this.bfiltro2 = bfiltro2;
        this.bfiltro3 = bfiltro3;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
    }

    /**
     * @return the bfiltro1
     */
    public boolean isBfiltro1() {
        return bfiltro1;
    }

    /**
     * @param bfiltro1 the bfiltro1 to set
     */
    public void setBfiltro1(boolean bfiltro1) {
        this.bfiltro1 = bfiltro1;
    }

    /**
     * @return the bfiltro2
     */
    public boolean isBfiltro2() {
        return bfiltro2;
    }

    /**
     * @param bfiltro2 the bfiltro2 to set
     */
    public void setBfiltro2(boolean bfiltro2) {
        this.bfiltro2 = bfiltro2;
    }

    /**
     * @return the bfiltro3
     */
    public boolean isBfiltro3() {
        return bfiltro3;
    }

    /**
     * @param bfiltro3 the bfiltro3 to set
     */
    public void setBfiltro3(boolean bfiltro3) {
        this.bfiltro3 = bfiltro3;
    }

    /**
     * @return the valor1
     */
    public String getValor1() {
        return valor1;
    }

    /**
     * @param valor1 the valor1 to set
     */
    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    /**
     * @return the valor2
     */
    public String getValor2() {
        return valor2;
    }

    /**
     * @param valor2 the valor2 to set
     */
    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    /**
     * @return the valor3
     */
    public String getValor3() {
        return valor3;
    }

    /**
     * @param valor3 the valor3 to set
     */
    public void setValor3(String valor3) {
        this.valor3 = valor3;
    }
}
