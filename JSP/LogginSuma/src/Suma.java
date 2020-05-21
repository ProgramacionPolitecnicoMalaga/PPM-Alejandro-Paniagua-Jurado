import java.util.logging.Level;
import java.util.logging.Logger;

public class Suma {
    public int sumar(int num1, int num2) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Numero1 = " + num1 + "; Numero2 = " + num2);
        return num1 + num2;
    }
}
