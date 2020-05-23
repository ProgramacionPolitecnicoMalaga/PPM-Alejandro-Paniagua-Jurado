package com.politecnicomalaga.FactoryMethod;

import com.politecnicomalaga.Viewers.DataViewer;
import com.politecnicomalaga.Viewers.TextDataViewer;

public class FactoryText implements ViewerInterface {
    @Override
    public DataViewer crearViewer() {
        return new TextDataViewer();
    }
}
