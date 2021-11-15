package com.chady.chadmac.jeansOrderApp;

import java.io.Serializable;

/**
 * Created by emtorres on 12/8/2017.
 */

public class CartDetailClass implements Serializable {


    private int jeansNo;
    private int lengthPercent;
    private int waistPercent;
    private int orderQuantity;
    private boolean typerepair;


    public int getJeansNo() {
        return jeansNo;
    }

    public void setJeansNo(int jeansNo) {
        this.jeansNo = jeansNo;
    }

    public int getLengthPercent() {
        return lengthPercent;
    }

    public void setLengthPercent(int lengthPercent) {
        this.lengthPercent = lengthPercent;
    }

    public int getWaistPercent() {
        return waistPercent;
    }

    public void setWaistPercent(int waistPercent) {
        this.waistPercent = waistPercent;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public boolean isTyperepair() {
        return typerepair;
    }

    public void setTyperepair(boolean typerepair) {
        this.typerepair = typerepair;
    }





}
