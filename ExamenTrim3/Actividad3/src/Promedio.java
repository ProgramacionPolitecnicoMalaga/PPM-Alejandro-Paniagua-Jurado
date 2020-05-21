import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Promedio {
    int promedio(int num1, int num2, int num3){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "a = " + num1 + "; b = " + num2, "; c = "+ num3);
        return (num1 + num2 + num3)/3;
    }
}
