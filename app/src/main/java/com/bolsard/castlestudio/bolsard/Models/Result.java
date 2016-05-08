/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsard.castlestudio.bolsard.Models;

/**
 *
 * @author malmonte
 */
public class Result {
    private String code;
    private String publisher;
    private int lastNegociated;
    private float pricePercentage;
    private float tirPercentage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getLastNegociated() {
        return lastNegociated;
    }

    public void setLastNegociated(int lastNegociated) {
        this.lastNegociated = lastNegociated;
    }

    public float getPricePercentage() {
        return pricePercentage;
    }

    public void setPricePercentage(float pricePercentage) {
        this.pricePercentage = pricePercentage;
    }

    public float getTirPercentage() {
        return tirPercentage;
    }

    public void setTirPercentage(float tirPercentage) {
        this.tirPercentage = tirPercentage;
    }
}