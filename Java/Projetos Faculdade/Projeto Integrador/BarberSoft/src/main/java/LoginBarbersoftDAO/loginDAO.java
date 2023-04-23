/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBarbersoftDAO;

import br.edu.unifio.barbersoft.telaInicialCliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author educo
 */
public class loginDAO {

    
    
    public void cadastrarCliente(String nomeCliente, String emailCliente, String senhaCliente, String cidadeCliente) {
        try {
            Connection conexao = new conexao().getConnection();
            String sql = "insert into cliente (nomecliente, emailcliente, senhacliente, cidadecliente) values ('" + nomeCliente + "', '" + emailCliente + "', '" + senhaCliente + "', '" + cidadeCliente + "')";
            PreparedStatement statment = conexao.prepareStatement(sql);
            statment.execute();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("LoginBarbersoftDAO.loginDAO.cadastrarCliente()");
        }
    }
    
    public void cadastrarAdm(String nomeAdm, String emailAdm, String senhaAdm, String cidadeAdm) {
        try {
            Connection conexao = new conexao().getConnection();
            String sql = "insert into adm (nomeadm, emailadm, senhaadm, cidadeadm) values ('" + nomeAdm + "', '" + emailAdm + "', '" + senhaAdm + "', '" + cidadeAdm + "')";
            PreparedStatement statment = conexao.prepareStatement(sql);
            statment.execute();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("LoginBarbersoftDAO.loginDAO.cadastrarAdm");
        }

    }
    
    public void LoginCli(String emailCliente, String senhaCliente){
         
        try {
            Connection conexao = new conexao().getConnection();
            String sql = "SELECT emailcliente,senhacliente FROM cliente WHERE emailcliente = '"+emailCliente+"' AND senhacliente = '"+senhaCliente+"'";
            System.out.println(sql);
            PreparedStatement statment = conexao.prepareStatement(sql);
            ResultSet rs = statment.executeQuery();
            
            
            if(rs.next()){
                System.out.println("Possui");
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                
                telaInicialCliente t = new telaInicialCliente();
                t.setVisible(true);
                                           
        
            } else {
                System.out.println("Não possui");
                JOptionPane.showMessageDialog(null, "Senha ou email incorretos!");
                
               
            }
            
                    
            conexao.close();        
                
                               
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("LoginBarbersoftDAO.loginDAO.cadastrarCliente()");
            
        }
      
            
    }
    
    public void LoginAdm(String emailAdm, String senhaAdm){
         
        try {
            Connection conexao = new conexao().getConnection();
            String sql = "SELECT emailadm,senhaadm FROM adm WHERE emailadm = '"+emailAdm+"' AND senhaadm = '"+senhaAdm+"'";
            System.out.println(sql);
            PreparedStatement statment = conexao.prepareStatement(sql);
            ResultSet rs = statment.executeQuery();
            
            
            if(rs.next()){
                System.out.println("Possui");
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                
                telaInicialCliente t = new telaInicialCliente();
                t.setVisible(true);
                                           
        
            } else {
                System.out.println("Não possui");
                JOptionPane.showMessageDialog(null, "Senha ou email incorretos!");
                
               
            }
            
                    
            conexao.close();        
                
                               
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("LoginBarbersoftDAO.loginDAO.cadastrarCliente()");
            
        }
      
            
    }

}
