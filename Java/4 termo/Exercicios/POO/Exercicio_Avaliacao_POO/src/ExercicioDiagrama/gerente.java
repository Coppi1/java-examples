package ExercicioDiagrama;

public class gerente extends funcionario {
    String area;

    @Override
    public double calculaImposto() {
        Double desconto = this.salario * 0.05;
        this.salario -= desconto;
        return this.salario;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Setor: "+this.area);
    }
}
