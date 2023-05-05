/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBarbersoftController;

import LoginBarbersoftDAO.conexao;
import LoginBarbersoftDAO.conexaomysql;
import LoginBarbersoftDAO.loginDAO;
import LoginBarbersoftDAO.loginDAOmysql;
import br.edu.unifio.barbersoft.telaCadastroBarbearia;
import br.edu.unifio.barbersoft.telaCadastroCliente;
import br.edu.unifio.barbersoft.telaI1Login;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author educo
 */
public class loginControlerMysql {
    
    public void casdastroClientesql(telaCadastroCliente view) throws SQLException{
        Connection conexao = new  conexaomysql().getConnection();
        loginDAOmysql cadastro = new loginDAOmysql();
        cadastro.cadastrarClientesql(view.getTxtCliNome().getText(), view.getTxtCliEmail().getText(), view.getPwCliSenha().getText(), view.getTxtCliCidade().getText(), 
                view.getFtxtCliTelefone().getText(), "teste");
       
    }
    
    public void loginUsuario(telaI1Login view) throws SQLException{
        
        Connection conexao = new  conexao().getConnection();
        loginDAO login = new loginDAO();
        login.LoginCli(view.getTxtEmailLogin().getText(), view.getPwSenhaLogin().getText());
           
    }
    public void cadastroAdm(telaCadastroBarbearia view) throws SQLException {
        Connection conexao = new conexao().getConnection();
        loginDAO cadastro = new loginDAO();
        cadastro.cadastrarAdm(view.getTxtAdmNomeF().getText(), view.getTxtAdmEmail().getText(), view.getPwAdmSenha().getText(), view.getTxtAdmCidade().getText());

    }
    public void loginAdm(telaI1Login view) throws SQLException{
        
        Connection conexao = new  conexao().getConnection();
        loginDAO login = new loginDAO();
        login.LoginAdm(view.getTxtEmailLogin().getText(), view.getPwSenhaLogin().getText());
           
    }
    
}
