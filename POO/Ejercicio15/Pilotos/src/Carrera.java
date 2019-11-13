import java.sql.ClientInfoStatus;

public class Carrera {
    public static void main(String[] args) {
        RankingPilotos rankingPilotos = new RankingPilotos();

        System.out.println("La carrera va a comenzar!");
        rankingPilotos.TotaldePilotos();
        rankingPilotos.posicionPilotos();

        System.out.println("\n====================================\n");
        System.out.println(" Hamilton L. adelanta hasta la tercera posición y Magnussen K. hasta la novena posición\n");

       rankingPilotos.adelantarPiloto(rankingPilotos.getPiloto(4), 4,2);
       rankingPilotos.adelantarPiloto(rankingPilotos.getPiloto(11), 11,8);
       rankingPilotos.posicionPilotos();


        System.out.println("\n<====================================>\n");
        System.out.println("Los pilotos Albon A. y Grosjean R. han sido descalificados!\n");
        rankingPilotos.getPiloto(5).setDescalificado();
        rankingPilotos.getPiloto(4).setDescalificado();
        rankingPilotos.eliminarDescalificados();
        rankingPilotos.posicionPilotos();
    }
}
