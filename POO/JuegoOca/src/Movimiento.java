public class Movimiento {
    private String tipoMovimiento;
    int numeroDeCasilla;

    public Movimiento(String tipoMovimiento, int nuevaCasilla){
        this.tipoMovimiento=tipoMovimiento;
        this.numeroDeCasilla=nuevaCasilla;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getNuevaCasilla() {
        return numeroDeCasilla;
    }

    public void setNuevaCasilla(int nuevaCasilla) {
        this.numeroDeCasilla = nuevaCasilla;
    }

    @Override
    public String toString() {
        return "Movimiento{" + tipoMovimiento + '\'' +
                ", nuevaCasilla=" + numeroDeCasilla +
                '}';
    }
}
