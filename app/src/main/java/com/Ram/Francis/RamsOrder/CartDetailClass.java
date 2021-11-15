package com.Ram.Francis.RamsOrder;

import java.io.Serializable;

/**
 * Created by emtorres on 12/8/2017.
 */

public class CartDetailClass implements Serializable {


    private int RamsNO;
    private int SpeedPercent;
    private int GBPercent;
    private int orderQuantity;
    private boolean typerepair;


    public int getRamsNO() {
        return RamsNO;
    }

    public void setRamsNO(int ramsNO) {
        this.RamsNO = ramsNO;
    }

    public int getSpeedPercent() {
        return SpeedPercent;
    }

    public void setSpeedPercent(int speedPercent) {
        this.SpeedPercent = speedPercent;
    }

    public int getGBPercent() {
        return GBPercent;
    }

    public void setGBPercent(int GBPercent) {
        this.GBPercent = GBPercent;
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
