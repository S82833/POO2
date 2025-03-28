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

public class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String enunciado, String respuestaCorrecta) {
        super(enunciado, respuestaCorrecta);
    }

    @Override
    public void mostrarPregunta() {
        System.out.println("Pregunta de verdadero o falso:\n" + getEnunciado() + "\nOpciones: Verdadero / Falso");
    }

    //Datos Estaticos
    public static List<String> listaEnunciadosVF = new ArrayList<>();
    public static List<String> listaRespuestasVF = new ArrayList<>();

    static {
        listaEnunciadosVF.add("En Python, las listas pueden contener distintos tipos de datos.");
        listaRespuestasVF.add("Verdadero");

        listaEnunciadosVF.add("El ciclo for solo puede usarse con listas.");
        listaRespuestasVF.add("Falso");

        listaEnunciadosVF.add("La funcion input() sirve para mostrar texto en pantalla.");
        listaRespuestasVF.add("Falso");

        listaEnunciadosVF.add("int(\"10\") convierte una cadena a un entero.");
        listaRespuestasVF.add("Verdadero");

        listaEnunciadosVF.add("Python es un lenguaje de programacion compilado.");
        listaRespuestasVF.add("Falso");
    }
}