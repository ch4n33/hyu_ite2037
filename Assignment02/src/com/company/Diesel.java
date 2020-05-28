package com.company;
import java.util.Random;

public class Diesel extends Oil{
    private int price;
    private double VAT;
    private double envTax;

    Diesel(){}
    Diesel(int price, String company){
        super(company, "diesel");
        this.price = price;
        Random random = new Random();
        this.VAT = (random.nextInt(30) + 1) / 100.0;
        envTax = 500;
    }
    @Override public double getOilPrice(){
        return price*(1+VAT) + envTax;
    }
    @Override public String toString(){
        return super.toString() + "\nsupply price:"+ price;
    }
}
