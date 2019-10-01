package Burgers;

/**
 *
 * @author sudipchitroda
 */

public class HamOrders {
    
    public static void main(String[] args) {
        
        Data dt = new Data();
        Databases db = new Databases();
        db.createDatabase();
        
        dt.getOrder();
        
        db.insertOrders(dt);
    }
}

