public class Partida {
    public static void main(String[] args) {
        Jugador p1= new Jugador("verde", "RMS", 1);
        p1.avanzarCasillas(3);
        p1.avanzarCasillas(2);
        p1.avanzarCasillas(3);
        p1.avanzarCasillas(6);
        p1.avanzarCasillas(1);
        p1.undo();
        p1.retrocederCasillas(8);
        p1.avanzarCasillas(1);
        p1.avanzarCasillas(3);
        p1.retrocederCasillas(3);
        p1.LeerHistorial();
    }
}
