package com.castlestudio.bolsard.Models;

/**
 * Created by andriusic on 08/05/16.
 */
public class StatisticResult {
    public String tax;
    public String code;
    public String price;
    public String expDate;

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
