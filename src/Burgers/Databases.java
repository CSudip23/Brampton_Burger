package Burgers;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author sudipchitroda
 */
public class Databases {
    
    public void createDatabase(){
        
        try
        {
            
            Connection con = DriverManager.getConnection("jdbc:sqlite:Database/Burgers/Brampton.db");
            Statement statement = con.createStatement();
         
            statement.execute("CREATE TABLE IF NOT EXISTS Burgers(name TEXT, breadroll TEXT, meat TEXT, price REAL,"
                    + "side1 TEXT DEFAULT ' ', side2 TEXT DEFAULT ' ', side3 TEXT DEFAULT ' ', side4 TEXT DEFAULT ' ', side5 TEXT DEFAULT ' ', "
                    + "side6 TEXT DEFAULT ' ', totalAmount REAL)");
            
            statement.execute("CREATE TABLE IF NOT EXISTS Orders (Id INTEGER PRIMARY KEY AUTOINCREMENT, dateOrdered DATETIME, totalPrice REAL)");
            
            statement.close();
            con.close();
        
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong: "+e.getMessage());
        }
    }
    
    
    public void insertOrders(Data data){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try
        {
            
            Connection con = DriverManager.getConnection("jdbc:sqlite:Database/Burgers/Brampton.db");
            Statement s1 = con.createStatement();
            
            s1.execute("INSERT INTO Orders(dateOrdered, totalPrice) values ('" + df.format(now) + "'," + data.getTotalValue() +")");
            
            s1.close();
            con.close();
        
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong: "+e.getMessage());
        }
    }
    
    public void insertBurgers(Burger burger){
        
        String[] s2 = burger.getExtras();
        
        try
        {
            
            Connection con = DriverManager.getConnection("jdbc:sqlite:Database/Burgers/Brampton.db");
            Statement s1 = con.createStatement();
            
            s1.execute("INSERT INTO Burgers values('" + burger.getname()+ "', '" + burger.getBreadRoll() + "', '" + burger.getmeat()+ "'," +
                    burger.getprice() + ",'" + s2[0] + "', '" + s2[1] + "', '" + s2[2] + "', '" + s2[3] + "', '" + s2[4] + "', '" +
                            s2[5] + "', " + burger.getTotal() +")");
            
            s1.close();
            con.close();
        
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong: "+e.getMessage());
        }
    }
    
}
