package com.politecnicomalaga;

public class ConversionDeMedidas {

    public Double inchACm(double inches){
        double cm=inches*2.54;
        return cm;
    }
    public Double cmAInch(double cm){
        double inches=cm/2.54;
        return inches;
    }
}
