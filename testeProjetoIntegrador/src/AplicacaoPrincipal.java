import javax.swing.*;
import java.sql.Connection;

public class AplicacaoPrincipal {

    public static void main(String[] args) {

        //String nameCli = JOptionPane.showInputDialog(null, "Digite o nome: ");
        //String emailCli = JOptionPane.showInputDialog(null, "Digite o email: ");
        //String telefoneCli = JOptionPane.showInputDialog(null, "Digite o telefone: ");

        testeInsert test = new testeInsert();
        //test.inserirDados(nameCli, emailCli, telefoneCli);


        int idCli = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente que deseja apagar"));
        test.exluirDados(idCli);

    }


}
