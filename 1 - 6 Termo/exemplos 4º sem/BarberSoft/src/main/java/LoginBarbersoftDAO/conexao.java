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
public class conexao {
    
        public Connection getConnection() throws SQLException{
            
            try {
                Class.forName("org.postgresql.Driver");
                Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BarberSoftTest", "postgres", "123");
                return conexao;
            } catch (ClassNotFoundException ex) {
                System.out.println("Drive BD não localizado");
            } catch (SQLException ex) {
                System.out.println("Ocorreu um erro ao acessar o banco");
            }
            return null;
            
            
            
        }
}
