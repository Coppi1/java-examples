/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBarbersoftDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author educo
 */
public class conexaomysql {
    
        public Connection getConnection() throws SQLException{
            
            
            try {
                Connection conexaomysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "1234");
                return conexaomysql;
            } catch (SQLException ex) {
               System.out.println("Drive BD não localizado");              
            }          
             return null;
        }
}
