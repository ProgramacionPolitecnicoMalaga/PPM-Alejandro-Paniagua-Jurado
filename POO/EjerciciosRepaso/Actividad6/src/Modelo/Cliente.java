package Modelo;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String NIF;
    private String cuentaBancaria;

    public Cliente(String nombre,String apellidos,String NIV,String cuentaBancaria){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIV;
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return " \nCliente{ \n" +
                "  nombre: " + nombre + "\n" +
                "  apellidos: " + apellidos + "\n" +
                "  NIV: " + NIF + "\n" +
                "  cuentaBancaria: " + cuentaBancaria + "\n" +
                '}';
    }
}
