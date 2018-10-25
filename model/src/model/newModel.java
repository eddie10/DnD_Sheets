/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author myuniverese
 */
public class newModel {
    
    
    
    /*
    
    this method is the first method you should run to create the player and the Player ID
    this inserts the PID into all 4 tables as well as the name of the player in the
    Player table
    the PID is the primary key in all the tables
    
    
    
    */
    public static void playerDBupdate(String Name,int PID) throws SQLException{
    
         //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  Player (Name,PID) values (?,?); " ;
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, Name);
            pstmt.setDouble(2, PID);
            pstmt.executeUpdate();
        
            
            
         String query1 = "insert into  Main_Sheet  (PID) values (?); " ;

            PreparedStatement pstmt1 = conn.prepareStatement(query1);
       
         pstmt1.setDouble(1, PID);
            
            pstmt1.executeUpdate();
            
             String query2 = "insert into  RP_Info  (PID) values (?); " ;

            PreparedStatement pstmt2 = conn.prepareStatement(query2);
       
         pstmt2.setDouble(1, PID);
            
            pstmt2.executeUpdate();
            String query3 = "insert into Spell_Sheet   (PID) values (?); " ;

            PreparedStatement pstmt3 = conn.prepareStatement(query3);
       
         pstmt3.setDouble(1, PID);
            
            pstmt3.executeUpdate();
        
        
        System.out.println("updated");
        
        
        
        
        
        
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    
    }
    
    
    
    
    /*
    
    the method below is used to insert text in to a row in the Main Sheet. DBcolumn is the 
    column you want to insert into the mainsheet. columnValue is a string data type and PID corresponds t=
  to the row of the player you want to insert to.
    
    
    this is for Text inserting
    
    MainsheetDBinsertInt method is for inserting integer data type into the table
    
    
    */
     public static void RP_InfoDBinsertText(String DBcolumn, String columnValue, int PID){
    
    //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  RP_Info  ("+ DBcolumn  + ") values (?) where PID="+PID +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    
    }public static void RP_InfoDBinsertInt(String DBcolumn, int columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  RP_Info  ("+ DBcolumn  + ") values (?) where PID="+PID +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setInt(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("   int value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }
    public static void RP_InfoDBupdateInt(String DBcolumn, int columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "UPDATE RP_Info SET "+ DBcolumn  +" = "+ columnValue  +"WHERE PID = "+ PID  +" ;"; 
          
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setInt(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("   int value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }public static void RP_InfoDBupdateString(String DBcolumn, String columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "UPDATE RP_Info SET "+ DBcolumn  +" = ? WHERE PID = "+ PID; 
          
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, columnValue);
            
            pstmt.executeUpdate();
        
      
        
        System.out.println("   String value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
     public static void MainsheetDBinsertText(String DBcolumn, String columnValue, int PID){
    
    //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  Main_Sheet  ("+ DBcolumn  + ") values (?) where PID="+PID +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    
    }public static void MainsheetDBinsertInt(String DBcolumn, int columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  Main_Sheet  ("+ DBcolumn  + ") values (?) where PID="+PID +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setInt(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("   int value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }
    public static void MainsheetDBupdateInt(String DBcolumn, int columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "UPDATE Main_Sheet SET "+ DBcolumn  +" = "+ columnValue  +"WHERE PID = "+ PID  +" ;"; 
          
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setInt(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("   int value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }public static void MainsheetDBupdateString(String DBcolumn, String columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "UPDATE Main_Sheet SET "+ DBcolumn  +" = ? WHERE PID = "+ PID; 
          
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, columnValue);
            
            pstmt.executeUpdate();
        
      
        
        System.out.println("   String value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }
    
    public static void Spell_SheetDBinsertText(String DBcolumn, String columnValue, int PID){
    
    //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  Spell_Sheet  ("+ DBcolumn  + ") values (?) where PID="+PID +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    
    }public static void Spell_SheetDBinsertInt(String DBcolumn, int columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "insert into  Spell_Sheet  ("+ DBcolumn  + ") values (?) where PID="+PID +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setInt(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("   int value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }
    public static void Spell_SheetDBupdateInt(String DBcolumn, int columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "UPDATE Spell_Sheet SET "+ DBcolumn  +" = "+ columnValue  +"WHERE PID = "+ PID  +" ;"; 
          
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setInt(1, columnValue);
            
            pstmt.executeUpdate();
        
        
        
        System.out.println("   int value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }public static void Spell_SheetDBupdateString(String DBcolumn, String columnValue, int PID){
     //SQLiteJDBCDriverConnection.connect();
         Connection conn = null;
          String query = "UPDATE Spell_Sheet SET "+ DBcolumn  +" = ? WHERE PID = "+ PID; 
          
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
PreparedStatement pstmt = conn.prepareStatement(query);
       
         pstmt.setString(1, columnValue);
            
            pstmt.executeUpdate();
        
      
        
        System.out.println("   String value updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    
    
    
    
    
    
    }
    
    
    /*
    
    
    the method below returns a string . it grabs the field from the column you want in the mainsheet
    where DBcolumn = the column you want to get the info from
    and PID is the player you want to get it from
    */
    
    
    
    public static String  DBColumnvalueString(String SQLtable,String DBcolumn,int PID){
       Connection conn = null;
          String returnString=null;
       
       String query = "select "+ DBcolumn   +" from "+ SQLtable  +" where PID = "+  PID    +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
           // System.out.println("Connection to SQLite has been established.");
            
                    Statement stmt  = conn.createStatement();
                    ResultSet rs    = stmt.executeQuery(query);
        System.out.println(query);
         while(rs.next()){
               returnString =rs.getString(DBcolumn);
              System.out.println(" string value is " + rs.getString(DBcolumn));
            }
        
        System.out.println("updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    return returnString;

    }
    public static int  DBColumnvalueInt(String SQLtable,String DBcolumn,int PID){
       Connection conn = null;
          int returnInt=0;
       
       String query = "select "+ DBcolumn   +" from "+ SQLtable  +" where PID = "+  PID    +";"; 
        try {
            // db parameters
            String url = "jdbc:sqlite:./WindowsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
           // System.out.println("Connection to SQLite has been established.");
            
                    Statement stmt  = conn.createStatement();
                    ResultSet rs    = stmt.executeQuery(query);
        System.out.println(query);
         while(rs.next()){
               returnInt =rs.getInt(DBcolumn);
              System.out.println(" string value is " + rs.getString(DBcolumn));
            }
        
        System.out.println("updated");
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    return returnInt;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    

