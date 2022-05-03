package com.example.inventario.Utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    //Convierte un array de strings en una lista de strings
    public static List<String> convertArrayStringListString(final String[] arrayString){

        //Contiene la lista
        List<String> lista = new ArrayList<>();

        //Recorre el array de strings
        for(String string: arrayString)
            lista.add(string);

        //Devuelve el resultado
        return lista;
    }
}
