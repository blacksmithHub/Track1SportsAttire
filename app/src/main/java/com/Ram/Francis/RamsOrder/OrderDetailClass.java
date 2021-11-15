package com.Ram.Francis.RamsOrder;

import java.io.Serializable;


public class OrderDetailClass implements Serializable {

    private int RamsNo;
    private int speedPercent;
    private int gbPercent;
    private int orderQuantity;
    private boolean typerepair;



    public OrderDetailClass() {
        this.RamsNo = 0;
        this.speedPercent = 0;
        this.gbPercent = 0;
        this.orderQuantity = 0;
        this.typerepair = false;
    }



    public OrderDetailClass(int RamsNo, int gbPercent, int speedPercent, int orderQuantity, boolean repairType) {
        this.RamsNo = RamsNo;
        this.gbPercent = gbPercent;
        this.speedPercent =  speedPercent;
        this.orderQuantity = orderQuantity;
        this.typerepair = repairType;

    }



    public int getRamsNo() {
        return RamsNo;
    }

    public void setRamsNo(int RamsNo) {
        this.RamsNo = RamsNo;
    }




    public int getSpeedPercent() {
        return speedPercent;

    }

    public void setSpeedPercent(int speedPercent) {
        this.speedPercent = speedPercent;
    }



    public int getGBPercent() {
        return gbPercent;
    }

    public void setGBPercent(int gbPercent) {
        this.gbPercent = gbPercent;
    }


    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public boolean isHaveRepair() {
        return typerepair;
    }



    public void setRepair(boolean haverepair) {
        this.typerepair = haverepair;
    }


    @Override
    public String toString() {
        return "OrderDetailClass{" +
                "RamsNo=" + RamsNo +
                ", SpeedPercent=" + (speedPercent)+
                ", GBPercent=" + (gbPercent) +
                ", orderQuantity=" + orderQuantity +
                ", repair=" + typerepair +
                '}';
    }
}