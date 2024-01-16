package org.tienda.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.tienda.model.Producto;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<Producto> readProductsFromCsv(String filePath) throws IOException {
        List<Producto> productos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] nextLine;
            boolean headerSkipped = false;

            while((nextLine= reader.readNext()) != null){
                if(!headerSkipped){
                    headerSkipped = true;
                    continue;
                }
                String nombre = nextLine[0];
                String descripcion = nextLine[1];
                String categoria = nextLine[2];
                String subcategoria = nextLine[3];
                double precio = nextLine[4].isEmpty() ? 0.0 : Double.parseDouble(nextLine[4]);

                String img = nextLine[5];

                Producto producto = new Producto(nombre,descripcion,categoria,subcategoria,precio,img);
                productos.add(producto);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }
}
