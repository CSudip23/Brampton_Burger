package Burgers;


import java.util.*;

/**
 *
 * @author sudipchitroda
 */
public class RegularHams extends Burger {
    
    Scanner sc = new Scanner(System.in);
    
    public RegularHams(String breadRoll, String meat, String name, Double price) {
        super(breadRoll, meat, name, price);
    }
    
    @Override
    public void addToppings(String toppingsName, Double toppingsPrice){
        if(toppings.size() < super.getSize()){
            
            toppings.put(toppingsName, toppingsPrice);
        }
    }
    
    @Override
    public void putToppings(int size, Burger ham) {
        
        Data dt = new Data();
        
        int count;
        
        do{
            System.out.println("How many toppings would you like. You have maximum "+ size + " toppings");
            count = sc.nextInt();
            if(count > ham.getSize()){
                System.out.println("Errr... You can choose maximum " + ham.getSize() +" toppings. Let's try again.\n");
            }
        }while(count > 4);
       
        System.out.println("Select your toppings: ");
        dt.populateLists();
        for (int i = 0; i < dt.values.size(); i++) {
            System.out.println((i+1) + " " + dt.values.get(i));
        }
        do{
            int i = sc.nextInt();
            ham.addToppings(dt.values.get(i-1), dt.cost.get(i-1));
            count--;
        }while(count > 0);
    } 

    }
    

