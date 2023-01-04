package com.bolsadeideas.springboot.di.app;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony",100);
        Producto producto2 = new Producto("Bicicleta Bianchi aro 26",200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2,4);

        return Arrays.asList(linea1, linea2);
    }
    @Bean("itemsFacturaOficina")
    @Primary
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor LG",250);
        Producto producto2 = new Producto("Notebook Asus",500);
        Producto producto3 = new Producto("Impresora HP",150);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2,4);
        ItemFactura linea3 = new ItemFactura(producto3,3);

        return Arrays.asList(linea1, linea2, linea3);
    }

}
