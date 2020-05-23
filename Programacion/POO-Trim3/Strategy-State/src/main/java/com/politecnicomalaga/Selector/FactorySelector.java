package com.politecnicomalaga.Selector;

public class FactorySelector {
    public static SelectorMejorProducto getFiltro(int opcion){
        switch (opcion){
            case SelectorMejorProducto.SELECTOR_VALORACION:
                return new SelectorValoracion();
                case SelectorMejorProducto.SELECTOR_PRECIO:
                    return new SelectorPrecio();
                    case SelectorMejorProducto.SELECTOR_PRECIO_VALORACION:
                        return new SelectorRatio();
            default:
                return new SelectorValoracion();
        }
    }
}
