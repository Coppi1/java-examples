package ExercicioDiagrama;

public class pessoa {
    String nome;
    data nascimento;

    public void imprimeDados(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Data de nascimento: "+this.nascimento.dia+"/"+this.nascimento.mes+"/"+this.nascimento.ano);
    }

}
