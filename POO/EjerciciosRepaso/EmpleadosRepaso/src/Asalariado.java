public class Asalariado extends Empleado {
    double sueldo=1200;

    public Asalariado(String nombre, int horasTrabajadas, int ventas) {
        super(nombre, horasTrabajadas,  ventas);
        this.sueldo=sueldo;
    }

    @Override
    public double getSueldo() {
        return 1200;
    }

    @Override
    public String toString() {
        return "Asalariado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", horasTrabajadas=" + horasTrabajadas +
                ", ventas=" + ventas +
                '}';
    }
}
