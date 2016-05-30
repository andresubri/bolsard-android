/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.castlestudio.bolsard.Models;

/**
 *
 * @author malmonte
 */
//Result model to represent the data extracted
public class EmissionsResult {
    private String code;
    private String publisher;
    private String lastNegociated;
    private String pricePercentage;
    private String tirPercentage;

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

    public String getLastNegociated() {
        return lastNegociated;
    }

    public void setLastNegociated(String lastNegociated) {
        this.lastNegociated = lastNegociated;
    }

    public String getPricePercentage() {
        return pricePercentage;
    }

    public void setPricePercentage(String pricePercentage) {
        this.pricePercentage = pricePercentage;
    }

    public String getTirPercentage() {
        return tirPercentage;
    }

    public void setTirPercentage(String tirPercentage) {
        this.tirPercentage = tirPercentage;
    }
}