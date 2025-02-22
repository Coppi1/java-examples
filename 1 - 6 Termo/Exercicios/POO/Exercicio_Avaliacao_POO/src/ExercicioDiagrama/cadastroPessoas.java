package ExercicioDiagrama;

import java.util.ArrayList;

public class cadastroPessoas extends pessoa{
    int qtdatual;

    ArrayList<pessoa> cadPessoa = new ArrayList<>();

    public void cadastrarPessoa(pessoa p){
        this.cadPessoa.add(p);
        this.qtdatual += 1;
    }

    public void imprimeCadastro(){
        System.out.println("Qtd atual: "+this.qtdatual+"\n");
        for(int i=0; i<this.cadPessoa.size(); i++){
            System.out.println(cadPessoa.get(i).nome);
            System.out.println("Data de nascimento: "+cadPessoa.get(i).nascimento.dia + "/"+ cadPessoa.get(i).nascimento.mes
            + "/"+ cadPessoa.get(i).nascimento.ano);

            System.out.println("\n\n");
        }

    }

    @Override
    public void imprimeDados() {
        System.out.println("Cadastro de pessoas: \n");
        System.out.println("Qtd atual de cadastros: "+this.qtdatual+"\n\n");
        for(int i=0; i<this.cadPessoa.size(); i++) {
            System.out.println("ID: "+ (i+1));
            cadPessoa.get(i).imprimeDados();
            System.out.println("\n");
        }
    }
}
