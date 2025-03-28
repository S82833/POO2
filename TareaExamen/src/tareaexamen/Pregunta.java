/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaexamen;

/**
 *
 * @author simon
 */
public abstract class Pregunta {
    private String enunciado;
    private String respuestaCorrecta;

    public Pregunta(String enunciado, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public boolean esCorrecta(String respuestaUsuario) {
        return respuestaUsuario.equalsIgnoreCase(respuestaCorrecta);
    }
    public abstract void mostrarPregunta();
    
}
