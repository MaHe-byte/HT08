package com.example.ht08;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class BottleDispenser {
    private int totalbtl;
    private double money;
    ArrayList<Bottle> bottles = new ArrayList<Bottle>(totalbtl);

    private static BottleDispenser BD = new BottleDispenser();



    public static BottleDispenser getInstance(){
        return BD;
    }


    private BottleDispenser() {
        totalbtl = 5;
        money = 0;

        bottles.add(new Bottle("Pepsi Max","Pepsi",0.3,0.5,1.8));
        bottles.add(new Bottle("Pepsi Max","Pepsi",0.9,1.5,2.2));
        bottles.add(new Bottle("Coca-Cola Zero","Coca-Cola",0.3,0.5,2.0));
        bottles.add(new Bottle("Coca-Cola Zero","Coca-Cola",0.9,1.5,2.5));
        bottles.add(new Bottle("Fanta Zero","Coca-Cola",0.3,0.5,1.95));


    }

    public void addMoney(TextView text, int money1) {
        money += money1;
        System.out.println("Klink! Added more money!");
        text.setText("Klink! Added more money!");
    }

    public void buyBottle(TextView text, String bottle, Double size) {

        for (int i = 0;i<totalbtl;i++) {
            if (bottle.equals(bottles.get(i).getName())) {
                if (size == bottles.get(i).getSize()){
                    if (money>(bottles.get(i).getPrice())){
                        totalbtl -= 1;
                        money -= bottles.get(i).getPrice();

                        System.out.println("KACHUNK! "+(bottles.get(i).getName())+" came out of the dispenser!");
                        text.setText("KACHUNK! "+(bottles.get(i).getName())+" came out of the dispenser!");
                        bottles.remove(i);
                        break;

                    }
                    else{
                        System.out.println("Add money first!");
                        text.setText("Add money first!");
                        break;
                    }

                }
                else{
                    text.setText("No "+bottle+" in "+size);
                    break;
                }
            }
            else{
                text.setText("Dispenser doesn't have "+bottle);
                System.out.println(bottles.get(i).getName());
            }

        }
    }

    public void returnMoney(TextView text) {
        System.out.print("Klink klink. Money came out! You got ");
        System.out.format(Locale.FRANCE,"%.2f€ back", money);
        text.setText("Klink klink. Money came out! You got "+money+"e");
        money = 0;
    }

    public void printBottles() {
        for (int i = 0;i<totalbtl;i++) {
            System.out.println((i+1)+". Name: "+bottles.get(i).getName());
            System.out.println("\tSize: "+bottles.get(i).getSize()+"\tPrice: "+bottles.get(i).getPrice());
        }
    }
}





