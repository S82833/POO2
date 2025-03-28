/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareaexamen;

/**
 *
 * @author simon
 */
public class TareaExamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Examen examen = new Examen(10);
        examen.mostrarPreguntasYGuardarRespuestas();
        examen.calificarExamen();
        examen.mostrarCalificacion();
    }
    
}
