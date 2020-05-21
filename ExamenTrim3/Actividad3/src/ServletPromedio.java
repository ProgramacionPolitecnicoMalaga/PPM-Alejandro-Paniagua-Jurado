import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "promedio", urlPatterns = {"/promedio"})
public class ServletPromedio extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Promedio promedio = new Promedio();
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Los operandos recibidos son " + num1 + " , " + num2+ " y " + num3);
        int resultado = promedio.promedio(num1, num2, num3);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "El resultado es " + resultado);
        request.setAttribute("resultado", resultado);
        RequestDispatcher vista = request.getRequestDispatcher("promedio.jsp");
        vista.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
