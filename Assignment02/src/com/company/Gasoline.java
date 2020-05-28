package com.company;
import java.util.Random;

public class Gasoline extends Oil {

    private int price;
    private double VAT;
    Gasoline(){}
    Gasoline(int price, String company){
        super(company, "gasoline");
        this.price = price;
        Random random = new Random();
        this.VAT = (random.nextInt(30) + 1) / 100.0;
    }
    @Override public double getOilPrice(){
        return price* (1 +VAT);
    }
    @Override public String toString(){
        return super.toString()+"\nsupply price:"+price;
    }

}
