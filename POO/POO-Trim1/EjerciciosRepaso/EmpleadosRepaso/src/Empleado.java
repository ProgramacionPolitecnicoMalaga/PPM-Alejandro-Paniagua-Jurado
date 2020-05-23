public abstract class Empleado {
    String nombre;
    double sueldo=0.0;
    int horasTrabajadas=0;
    int ventas=0;

    public Empleado(String nombre, int horasTrabajadas, int ventas) {
        this.nombre = nombre;

        this.horasTrabajadas=horasTrabajadas;
        this.ventas=ventas;
    }
    public abstract double getSueldo();


    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int getVentas() {
        return ventas;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", horasTrabajadas=" + horasTrabajadas +
                ", ventas=" + ventas +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
