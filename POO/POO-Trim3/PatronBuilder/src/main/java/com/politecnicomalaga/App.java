package com.politecnicomalaga;

import com.politecnicomalaga.Builder.Builder;
import com.politecnicomalaga.Builder.Director;
import com.politecnicomalaga.Pack.Pack;

import java.util.Scanner;

public class App {
    public static Pack pack;
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Elija el tipo de pack\n" +
                "1. Pack básico\n" +
                "2. Pack romance\n" +
                "3. Pack familiar\n" +
                "4. Pack padres relajados\n" +
                "5. Pack deluxe\n" +
                "6. Pack deluxe familiar\n" +
                "Elija: ");

        int tipoPack = lectorTeclado.nextInt();

        Builder packBuilder = new Builder();
        Director packDirector = new Director(packBuilder);


        switch (tipoPack){
            case 1:
                pack = packDirector.entregarPackBasico();
                break;
            case 2:
                pack = packDirector.entregarPackRomance();
                break;
            case 3:
                pack = packDirector.entregarPackFamiliar();
                break;
            case 4:
                pack = packDirector.entregarPackPadresRelajados();
                break;
            case 5:
                pack = packDirector.entregarPackDeluxe();
                break;
            case 6:
                pack = packDirector.entregarPackDeluxeFamiliar();
                break;
        }

        System.out.println(pack);
    }
}
