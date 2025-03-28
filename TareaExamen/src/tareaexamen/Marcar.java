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

public class Marcar extends Pregunta {
    private List<String> opciones;

    public Marcar(String enunciado, List<String> opciones, String respuestaCorrecta) {
        super(enunciado, respuestaCorrecta);
        this.opciones = opciones;
    }

    @Override
    public void mostrarPregunta() {
        String resultado = "Pregunta de seleccion multiple:\n" + getEnunciado() + "\n";
        for (int i = 0; i < opciones.size(); i++) {
            resultado += (char) ('A' + i) + ". " + opciones.get(i) + "\n";
        }
        System.out.println(resultado);
    }
       
    //Datos Estaticos
    public static List<String> listaEnunciadosM = new ArrayList<>();
    public static List<List<String>> listaOpcionesM = new ArrayList<>();
    public static List<String> listaRespuestasM = new ArrayList<>();

    static {
        List<String> op1 = new ArrayList<>();
        op1.add("HTML"); op1.add("CSS"); op1.add("Python"); op1.add("SQL");
        listaEnunciadosM.add("¿Cual de los siguientes es un lenguaje de programacion?");
        listaOpcionesM.add(op1);
        listaRespuestasM.add("C");

        List<String> op2 = new ArrayList<>();
        op2.add("//"); op2.add("<!-- -->"); op2.add("#"); op2.add("*");
        listaEnunciadosM.add("¿Que simbolo se usa para comentarios en Python?");
        listaOpcionesM.add(op2);
        listaRespuestasM.add("C");

        List<String> op3 = new ArrayList<>();
        op3.add("int"); op3.add("str"); op3.add("bool"); op3.add("float");
        listaEnunciadosM.add("¿Que tipo de dato representa el valor True en Python?");
        listaOpcionesM.add(op3);
        listaRespuestasM.add("C");

        List<String> op4 = new ArrayList<>();
        op4.add("for"); op4.add("loop"); op4.add("repeat"); op4.add("while");
        listaEnunciadosM.add("¿Cual es la estructura de control para repetir un bloque de codigo mientras una condicion es verdadera?");
        listaOpcionesM.add(op4);
        listaRespuestasM.add("D");

        List<String> op5 = new ArrayList<>();
        op5.add(":="); op5.add("=="); op5.add("="); op5.add("=>");
        listaEnunciadosM.add("¿Cual es el operador de asignacion en Python?");
        listaOpcionesM.add(op5);
        listaRespuestasM.add("E");

    }
}