public class Comisionado extends Empleado{
    double sueldo=900+(50*ventas);
    public Comisionado(String nombre, int horasTrabajadas, int ventas) {
        super(nombre, horasTrabajadas,  ventas);
    }

    @Override
    public double getSueldo() {
        return sueldo=900+(50*ventas);
    }

    @Override
    public String toString() {
        return "Comisionado{" +
                ", nombre='" + nombre +", sueldo=" + sueldo + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", ventas=" + ventas +
                '}';
    }
}
