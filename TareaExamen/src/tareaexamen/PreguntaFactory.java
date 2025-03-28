/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaexamen;

/**
 *
 * @author simon
 */
public class PreguntaFactory {

    public Pregunta generarPregunta(int tipo, int indice) {
        switch (tipo) {
            case 0: // Marcar
                return new Marcar(
                    Marcar.listaEnunciadosM.get(indice),
                    Marcar.listaOpcionesM.get(indice),
                    Marcar.listaRespuestasM.get(indice)
                );
            case 1: // Completar
                return new Completar(
                    Completar.listaEnunciadosC.get(indice),
                    Completar.listaRespuestasC.get(indice)
                );
            case 2: // Verdadero / Falso
                return new VerdaderoFalso(
                    VerdaderoFalso.listaEnunciadosVF.get(indice),
                    VerdaderoFalso.listaRespuestasVF.get(indice)
                );
            default:
                return null;
        }
    }
}
