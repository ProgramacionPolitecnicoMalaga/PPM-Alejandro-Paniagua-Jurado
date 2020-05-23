public class miMain {
    public static void main(String[] args) {
        Asalariado asalariado=new Asalariado("Paco", 9, 10);
        porHoras PorHoras=new porHoras("Jose", 8, 10);
        Comisionado comisionado=new Comisionado("Ale", 10,10);
        System.out.println(asalariado.toString());
        System.out.println(PorHoras.toString());
        System.out.println(comisionado.toString());
    }
}
