package Burgers;

import java.util.HashMap;

/**
 *
 * @author sudipchitroda
 */
public class DeluxeHamburger extends Burger{

    public DeluxeHamburger(String breadRoll, String meat, String name, Double price) {
        super(breadRoll, meat, name, price);
    }
    
    @Override
    public void addToppings(String toppingsName, Double toppingsPrice){
        System.out.println("You cannot add more toppings!!");
    }
    
    public void upgradeCombo(){
        toppings = new HashMap<>();
        toppings.put("Drinks & Chips", 4.99);
    }

    @Override
    public void putToppings(int size, Burger ham) {
        System.out.println(" ");
    }
}
