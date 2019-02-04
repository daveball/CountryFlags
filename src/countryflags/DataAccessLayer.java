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
    
    static String GetCapital( String Country) throws SQLException{
         
        
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
                String Query = "SELECT Capital FROM country where Country = '"+ Country  + "'" ;
                 System.out.println(Query);
                rs = stmt.executeQuery (Query);
                while(rs.next()){
                return rs.getString("Capital");
                }
                return "Error";
            }
         catch(SQLException e)
            {
                System.out.println("SQL exception occured" + e);
                 throw e;
            }
    //==========================================================='   
         
    }
    
    static ResultSet ReloadCountries() throws SQLException{
         
        
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
    

     static void AddCountry( String Country, String Capital) throws SQLException{
         
        
        try 
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } 
        catch(ClassNotFoundException e) 
            {
                System.out.println("Class not found "+ e);
            }

         System.out.println("JDBC Class found");
         

    //==========================================================='    
         try 
            {
                Connection con = DriverManager.getConnection ("jdbc:ucanaccess://.\\src\\data\\countries1.accdb"); 
                Statement stmt = (Statement) con.createStatement();
                String Query = "INSERT INTO Country (Country  , Capital) VALUES ('"+ Country + "' , '"+ Capital+"') ";
                 System.out.println(Query);
                stmt.executeUpdate(Query);
               
            }
         catch(SQLException e)
            {
                System.out.println("SQL exception occured" + e);
                 throw e;
            }
    //==========================================================='   
         
    }
    
    }

