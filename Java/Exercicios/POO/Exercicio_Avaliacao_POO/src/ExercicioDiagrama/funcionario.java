package ExercicioDiagrama;

public class funcionario extends pessoa {
    double salario;

    public double calculaImposto(){
        Double desconto = this.salario * 0.03;
        this.salario -= desconto;
        return this.salario;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Salario: "+this.salario);
    }
}
