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
import java.util.Scanner;
import java.util.Set;

public class Examen {    
    //Factory para crear objetos pregunta
    private PreguntaFactory preguntaFactory = new PreguntaFactory();
    //Scanner para leer al usuario
    Scanner scanner = new Scanner(System.in);
    //Una lista para almacenar las preguntas aleatorias que vamos a instanciar
    private List<Pregunta> preguntas = new ArrayList<>();
    private List<String> respuestas = new ArrayList<>();
    private int calificacion = 0;
    List<Integer> numUsados = new ArrayList<>();

    
    public Examen(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            int tipoAleatorio = generarAleatorio(0, 2);
            while(numUsados.contains(tipoAleatorio)){
                tipoAleatorio = generarAleatorio(0, 2);
            }
            //Todas las listas tienen el mismo tamaño, son las reglas del negocio
            int preguntaAleatoria = generarAleatorio(0, Marcar.listaEnunciadosM.size()-1);
            this.preguntas.add(preguntaFactory.generarPregunta(tipoAleatorio, preguntaAleatoria));
            switch (tipoAleatorio) {
            case 0: // Marcar
                Marcar.listaEnunciadosM.remove(preguntaAleatoria);
                Marcar.listaOpcionesM.remove(preguntaAleatoria);
                Marcar.listaRespuestasM.remove(preguntaAleatoria);
                if(Marcar.listaEnunciadosM.isEmpty()){
                    this.numUsados.add(0);
                }
                break;
            case 1: // Completar
                Completar.listaEnunciadosC.remove(preguntaAleatoria);
                Completar.listaRespuestasC.remove(preguntaAleatoria);
                if(Completar.listaEnunciadosC.isEmpty()){
                    this.numUsados.add(1);
                }
                break;
            case 2: // Verdadero / Falso
                VerdaderoFalso.listaEnunciadosVF.remove(preguntaAleatoria);
                VerdaderoFalso.listaRespuestasVF.remove(preguntaAleatoria);
                if(VerdaderoFalso.listaEnunciadosVF.isEmpty()){
                    this.numUsados.add(2);
                }
                break;
            }   
        }
    }
    
    public void mostrarPreguntasYGuardarRespuestas(){
        for(Pregunta pregunta :preguntas){
            pregunta.mostrarPregunta();
            this.respuestas.add(scanner.nextLine());
            System.out.println("\n");
        }
    }
    
    public void calificarExamen(){
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            String respuesta = respuestas.get(i);
            boolean x = pregunta.esCorrecta(respuesta);
            System.out.println(x);
            if (x) {
                this.calificacion += 2;
            }
        }
    }
    
    public void mostrarCalificacion(){
        System.out.println("La calificacion del examen es: " + this.calificacion + "/20");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static int generarAleatorio(int inicio, int fin){
        return (int) (Math.random()* (fin-inicio+1)+inicio);
    }
    
}
