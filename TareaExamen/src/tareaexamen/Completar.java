/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaexamen;

/**
 *
 * @author simon
 */

import java.util.ArrayList;
import java.util.List;

public class Completar extends Pregunta {

    public Completar(String enunciado, String respuestaCorrecta) {
        super(enunciado, respuestaCorrecta);
    }

    @Override
    public void mostrarPregunta() {
        System.out.println("Pregunta de completar:\n" + getEnunciado());
    }
    
    //Datos Estaticos
    public static List<String> listaEnunciadosC = new ArrayList<>();
    public static List<String> listaRespuestasC = new ArrayList<>();

    static {
    listaEnunciadosC.add("En Python, la palabra clave para definir una funcion es ___");
    listaRespuestasC.add("def");

    listaEnunciadosC.add("La funcion que se usa para imprimir en consola es ___");
    listaRespuestasC.add("print");

    listaEnunciadosC.add("Para leer datos del usuario se usa la funcion ___");
    listaRespuestasC.add("input");

    listaEnunciadosC.add("El tipo de datos que representa verdadero o falso es ___");
    listaRespuestasC.add("bool");

    listaEnunciadosC.add("Una coleccion ordenada y mutable se llama ___");
    listaRespuestasC.add("list");

    }
}