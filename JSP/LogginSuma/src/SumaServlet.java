import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="suma", urlPatterns = {"/suma"})
public class SumaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Suma suma = new Suma();
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Los numeros recibidos son " + num1 + " y " + num2);
        int resultado = suma.sumar(num1, num2);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "El resultado es " + resultado);
        request.setAttribute("resultado", resultado);
        RequestDispatcher vista = request.getRequestDispatcher("suma.jsp");
        vista.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
