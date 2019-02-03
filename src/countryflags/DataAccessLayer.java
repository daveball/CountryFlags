/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countryflags;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author davem
 */
public class DataAccessLayer {
    
    static ResultSet GetCountries() throws SQLException{
         
        
        try 
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } 
        catch(ClassNotFoundException e) 
            {
                System.out.println("Class not found "+ e);
            }

         System.out.println("JDBC Class found");
         
          ResultSet rs;
    //==========================================================='    
         try 
            {
                Connection con = DriverManager.getConnection ("jdbc:ucanaccess://.\\src\\data\\countries1.accdb"); 
                Statement stmt = (Statement) con.createStatement();
           rs = stmt.executeQuery ("SELECT * FROM country");
                 return rs;
            }
         catch(SQLException e)
            {
                System.out.println("SQL exception occured" + e);
                 throw e;
            }
    //==========================================================='   
         
    }
    
     static String GetCapital( int ID) throws SQLException{
         
        
        try 
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } 
        catch(ClassNotFoundException e) 
            {
                System.out.println("Class not found "+ e);
            }

         System.out.println("JDBC Class found");
         
          ResultSet rs;
    //==========================================================='    
         try 
            {
                Connection con = DriverManager.getConnection ("jdbc:ucanaccess://.\\src\\data\\countries1.accdb"); 
                Statement stmt = (Statement) con.createStatement();
           rs = stmt.executeQuery ("SELECT Capital FROM country where ID = '"+ ID+ "'");
                 return rs.getString("Capital");
            }
         catch(SQLException e)
            {
                System.out.println("SQL exception occured" + e);
                 throw e;
            }
    //==========================================================='   
         
    }
    
    }

