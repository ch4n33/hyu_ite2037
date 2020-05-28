package com.company;

public abstract class Oil {
    private String company;
    private String oilType;
    private double consumerPrice;//소비자 가격
    Oil(){
    }
    Oil(String company, String oilType){
        this.company = company;
        this.oilType = oilType;
        this.consumerPrice = 0;
    }
    /*getter methods--------------------------*/
    public double getConsumerPrice() {
        return consumerPrice;
    }
    /*setter methods--------------------------*/
    public void setOilPrice() {
        this.consumerPrice = this.getOilPrice();
    }

    @Override public String toString() {
        return "company:" + this.company + "\noil type:" + this.oilType;
    }
    public abstract double getOilPrice();//calculate consumer price..

}