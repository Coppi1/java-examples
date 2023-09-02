package ExercicioDiagrama;

public class cliente extends pessoa {
    int id;

    @Override
    public void imprimeDados() {
        System.out.println("ID: "+this.id);
        super.imprimeDados();

    }
}
