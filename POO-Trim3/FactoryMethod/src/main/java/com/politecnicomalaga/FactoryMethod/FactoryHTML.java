package com.politecnicomalaga.FactoryMethod;

import com.politecnicomalaga.Viewers.DataViewer;
import com.politecnicomalaga.Viewers.HTMLDataViewer;

public class FactoryHTML implements ViewerInterface {
    @Override
    public DataViewer crearViewer() {
        return new HTMLDataViewer();
    }
}
