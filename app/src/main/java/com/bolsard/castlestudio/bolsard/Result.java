/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsard.castlestudio.bolsard;

/**
 *
 * @author malmonte
 */
public class Result {
    private String codigo;
    private String emisor;
    private int ultNegociado;
    private float precioPorentaje;
    private float tirPorcentaje;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public int getUltNegociado() {
        return ultNegociado;
    }

    public void setUltNegociado(int ultNegociado) {
        this.ultNegociado = ultNegociado;
    }

    public float getPrecioPorentaje() {
        return precioPorentaje;
    }

    public void setPrecioPorentaje(float precioPorentaje) {
        this.precioPorentaje = precioPorentaje;
    }

    public float getTirPorcentaje() {
        return tirPorcentaje;
    }

    public void setTirPorcentaje(float tirPorcentaje) {
        this.tirPorcentaje = tirPorcentaje;
    }
    
    
}