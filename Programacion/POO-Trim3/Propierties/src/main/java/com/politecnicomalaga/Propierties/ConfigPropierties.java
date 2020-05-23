package com.politecnicomalaga.Propierties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropierties {
    public final static String ARCHIVO_PROPERTIES = "config.properties";
    private Properties properties;
    public ConfigPropierties() throws IOException {
        File archivoPropiedades = new File(ARCHIVO_PROPERTIES);
        properties = new Properties();
        if (archivoPropiedades.exists()){
            properties.load(new FileInputStream(archivoPropiedades));
        }
    }

    public String getPropertie(String nombrePropiedad){
        return properties.getProperty(nombrePropiedad);
    }

    public void setPropertie(String propertie,String value){
        properties.setProperty(propertie,value);
    }

    public void guardar() throws IOException {
        FileOutputStream output = new FileOutputStream(ARCHIVO_PROPERTIES);
        properties.store(output,"Configuración");
    }
}
