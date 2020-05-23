public class porHoras extends Empleado {
    double sueldo=50*horasTrabajadas;
    public porHoras(String nombre, int horasTrabajadas, int ventas) {
        super(nombre, horasTrabajadas,  ventas);
        this.sueldo=sueldo;
    }

    @Override
    public double getSueldo() {
        return sueldo =50*horasTrabajadas;
    }

    @Override
    public String toString() {
        return "porHoras{" +
                ", nombre='" + nombre + ", sueldo=" + sueldo +'\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", ventas=" + ventas +
                '}';
    }
}
