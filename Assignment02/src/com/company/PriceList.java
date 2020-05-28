package com.company;

import com.sun.source.tree.WhileLoopTree;

public class PriceList {

    private Oil[][] pricelist;
    private int vertical;//행
    //1열은 휘발유, 2열은 경유
    PriceList(){
        this.pricelist = new Oil[2][2];
        this.vertical  = 2;
    }

    public int getVertical() {
        return vertical;
    }
    public void setPriceList(int i, int j, Oil oil){
        if (j ==0){
            Gasoline G = (Gasoline) oil;
            G.setOilPrice();
            pricelist[i][j] = G;
        }else if (j == 1){
            Diesel D = (Diesel)oil;
            D.setOilPrice();
            pricelist[i][j] = D;
        }
        pricelist[i][j].setOilPrice();
    }
    public void extendList(int amount){
        Oil[][] pricelist = new Oil[this.getVertical()+amount][2];
        for (int i=0; i<this.getVertical(); i++){
            pricelist[i][0] = this.pricelist[i][0];
            pricelist[i][1] = this.pricelist[i][1];
        }
        this.vertical += amount;
        this.pricelist = pricelist;
    }
    public String getRegionInfo(int i){
        Gasoline S0 = (Gasoline) pricelist[i][0];
        Diesel   S1 = (Diesel)   pricelist[i][1];

        return S0.toString()+"\n\n"+S1.toString();
    }
    public void printList(){
        System.out.println("            Gasoline       Diesel");
        System.out.println("========================================");
        for (int i=0; i<this.getVertical(); i++) {
            System.out.printf("Region #%2d  %8.2f %8.2f\n",i,this.pricelist[i][0].getConsumerPrice(),this.pricelist[i][1].getConsumerPrice());
        }
    }
}
