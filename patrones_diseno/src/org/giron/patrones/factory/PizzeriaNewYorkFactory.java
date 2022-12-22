package org.giron.patrones.factory;

import org.giron.patrones.factory.producto.PizzaNewYorkItaliana;
import org.giron.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.giron.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory {
    @Override
    PizzaProducto crearPizza(String tipo) {
        /*PizzaProducto producto = null;

        switch (tipo){
            case "vegetaria":
                producto = new PizzaNewYorkVegetariana();
                break;
        }*/

        //Java 13
        return switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPepperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
    }
}
