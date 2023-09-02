import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testeInsert {

        public void inserirDados(String nome, String email, String telefone){
                try{
                        Conexao conexao1 = new Conexao();
                        String sql = "insert into clientes (nome, email, telefone) values ('" + nome + "', '" + email + "', '" + telefone + "')";
                        PreparedStatement statement = conexao1.conectar().prepareStatement(sql);

                        int linhasafetadas = statement.executeUpdate();
                        if (linhasafetadas > 0){
                                System.out.println("Cliente cadastrado no BD");
                        } else {
                                System.out.println("Erro, nenhuma linha afetada");
                        }
                        conexao1.desconectar(conexao1.conn);

                }
                catch (SQLException e){
                        e.printStackTrace();
                        System.out.println("erro ao acessar BD");
                }
        }

        public void exluirDados(int id){
                try{
                        Conexao conexao2 = new Conexao();
                        String sql = "delete from clientes where id ='" + id + "'";
                        PreparedStatement stm = conexao2.conectar().prepareStatement(sql);

                        int linhasafetadas = stm.executeUpdate();
                        if (linhasafetadas > 0){
                                System.out.println("Cliente cadastrado no BD");
                        } else {
                                System.out.println("Erro, nenhuma linha afetada");
                        }
                        conexao2.desconectar(conexao2.conn);


                } catch (SQLException e){
                        e.printStackTrace();
                        System.out.println("Erro ao excluir");
                }
        }

}
