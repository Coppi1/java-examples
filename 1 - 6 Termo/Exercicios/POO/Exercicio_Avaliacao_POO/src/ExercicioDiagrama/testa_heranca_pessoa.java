package ExercicioDiagrama;

public class testa_heranca_pessoa {
    public static void main(String[] args){

        System.out.println("\nClasse Pessoa\n");

        pessoa p = new pessoa();
        p.nascimento = new data();
        p.nascimento.dia = 2;
        p.nascimento.mes = 8;
        p.nascimento.ano = 2001;
        p.nome = "Klebin";
        p.imprimeDados();

        System.out.println("\nClasse Funcionario\n");

        funcionario f = new funcionario();
        f.nascimento = new data();
        f.nascimento.dia = 9;
        f.nascimento.mes = 12;
        f.nascimento.ano = 1950;
        f.nome = "Adilsin";
        f.salario = 1400;
        f.imprimeDados();
        System.out.println("\nImposto calculado: ");
        f.calculaImposto();
        f.imprimeDados();

        System.out.println("\nClasse Gerente\n");

        gerente g = new gerente();
        g.nascimento = new data();
        g.nascimento.dia = 5;
        g.nascimento.mes = 10;
        g.nascimento.ano = 1987;
        g.nome = "Jorgin";
        g.salario = 5000;
        g.area = "Financeiro";
        g.imprimeDados();
        System.out.println("\nImposto calculado: ");
        g.calculaImposto();
        g.imprimeDados();

        System.out.println("\nClasse Cadastro\n");

        cadastroPessoas cad = new cadastroPessoas();
        cad.cadastrarPessoa(p);
        cad.cadastrarPessoa(f);
        cad.cadastrarPessoa(g);
        cad.imprimeDados();

    }
}
