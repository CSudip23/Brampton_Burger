package Burgers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sudipchitroda
 */
public abstract class Burger {
    
    private String breadRoll;
    private String meat;
    private Double price;
    private String name;
    private int size;
    private double total;
    
    public Map<String, Double> toppings = new HashMap<>();
    
    public Burger(String breadRoll, String meat, String name, Double price){
        this.breadRoll = breadRoll;
        this.meat = meat;
        this.name = name;
        this.price = price;
    }
    
    public abstract void addToppings(String toppingsName, Double toppingsPrice);
    
    public abstract void putToppings(int size, Burger ham);
    
    public String getBreadRoll(){
        return this.breadRoll;
    }
    
    public String getmeat(){
        return this.meat;
    }
    
    public Double getprice(){
        return this.price;
    }
    
    public String getname(){
        return this.name;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setSize(int value){
        this.size = value;
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public double calculatePrice() {
        this.total = this.price;
        double value;
        for (Double dbl : toppings.values()){
            value = dbl;
            this.total = this.total + value;
    }
      
    System.out.println(this.getname() + "Burger on a " + this.getBreadRoll() + " with " + this.getmeat() + ", price is " + this.getprice());
    
    for (String keys : toppings.keySet()){
        System.out.println("Added " + keys + " for an extra " + toppings.get(keys));
    }
        
    System.out.printf("The total price is %.2f \n" ,this.total);
      
    return total;
    }
    
    public String[] getExtras(){
        String[] s1 = new String[6];
        int counter = -1;
        for (int i = 0; i < 6; i++) {
            s1[i] = " ";
        }
        for (String keys : toppings.keySet())
        {
            counter += 1;    
            s1[counter] = keys;
        }   
        return s1;
    }
}
