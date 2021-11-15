package com.chady.chadmac.jeansOrderApp;

import java.io.Serializable;


public class OrderDetailClass implements Serializable {

    private int jeansNo;
    private int lengthPercent;
    private int waistPercent;
    private int orderQuantity;
    private boolean typerepair;



    public OrderDetailClass() {
        this.jeansNo = 0;
        this.lengthPercent = 0;
        this.waistPercent = 0;
        this.orderQuantity = 0;
        this.typerepair = false;
    }



    public OrderDetailClass(int jeansNo, int waistpercent, int lengthpercent, int orderQuantity, boolean repairType) {
        this.jeansNo = jeansNo;
        this.waistPercent = waistpercent;
        this.lengthPercent =  lengthpercent;
        this.orderQuantity = orderQuantity;
        this.typerepair = repairType;

    }



    public int getJeansNo() {
        return jeansNo;
    }

    public void setJeansNo(int jeansNo) {
        this.jeansNo = jeansNo;
    }




    public int getLengthPercent() {
        return lengthPercent;

    }

    public void setLengthPercent(int lengthpercent) {
        this.lengthPercent = lengthpercent;
    }



    public int getWaistPercent() {
        return waistPercent;
    }

    public void setWaistPercent(int waistpercent) {
        this.waistPercent = waistpercent;
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
                "jeansNo=" + jeansNo +
                ", lengthPercent=" + (lengthPercent)+
                ", waistPercent=" + (waistPercent) +
                ", orderQuantity=" + orderQuantity +
                ", repair=" + typerepair +
                '}';
    }
}
