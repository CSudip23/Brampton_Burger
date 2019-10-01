package Burgers;

import java.util.*;

/**
 *
 * @author sudipchitroda
 */
public class Data {
    
    Scanner sc = new Scanner(System.in);
    
    private double totalValue = 0.0;
    
    List<String> values = new ArrayList<>();
    List<Double> cost = new ArrayList<>();
    
    public double getTotalValue(){
        return this.totalValue;
    }
    
    public void populateLists(){
        
        values.add("Lettuce");
        values.add("Tomato");
        values.add("Mushroom");
        values.add("Onion");
        values.add("Pickels");
        values.add("Jalepeno");
        values.add("Cheese");
        values.add("Bacon Strips");
        
        cost.add(0.99);
        cost.add(0.99);
        cost.add(0.99);
        cost.add(0.99);
        cost.add(0.99);
        cost.add(1.49);
        cost.add(1.99);
        cost.add(2.49);
    }
    
    public void getOrder(){
        
        Databases db = new Databases();
        
        int choice = 0;
        String meat;
        System.out.println("====================== Brampton's Burgers ======================");
        
        while (choice < 4){
            
            System.out.println("________________________________________________________________");
            System.out.println("Enter your choice for Burger:");
            System.out.println("1 Regular Hamburger");
            System.out.println("2 Healthy Burger");
            System.out.println("3 Deluxe Burger");
            System.out.println("4 Exit and get total Bill\n");
            
            choice = sc.nextInt();
            
            if (choice == 1) {
                
                System.out.println("Enter your choice of meat: (Veggie, Bacon, Beef or Chicken)");
                meat = sc.next();
                RegularHams reg = new RegularHams("White roll", meat, "Basic", 5.99);
                reg.setSize(4);
                reg.putToppings(reg.getSize(), reg);
                this.totalValue += reg.calculatePrice();
                db.insertBurgers(reg);
                
            } else if (choice == 2){
                
                System.out.println("Enter your choice of meat: (Veggie, Bacon, Beef or Chicken)");
                meat = sc.next();
                HealthyBurger healthy = new HealthyBurger(meat, "Healthy", 6.99);
                healthy.setSize(6);
                healthy.putToppings(healthy.getSize(), healthy);
                this.totalValue += healthy.calculatePrice();
                db.insertBurgers(healthy);
                
            } else if (choice == 3){
                
                System.out.println("Enter your choice of meat: (Veggie, Bacon, Beef or Chicken)");
                meat = sc.next();
                DeluxeHamburger deluxe = new DeluxeHamburger("White roll", meat, "Deluxe", 10.99);
                deluxe.upgradeCombo();
                this.totalValue += deluxe.calculatePrice();
                db.insertBurgers(deluxe);
                
            } else {
                System.out.println("Thank You for Ordering. Visit again!!!");
            }
        }
        System.out.printf("Your total due amount to be paid is $%.2f\n" , this.totalValue);
    }
}
