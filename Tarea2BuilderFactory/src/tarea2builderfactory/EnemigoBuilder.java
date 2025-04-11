/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class EnemigoBuilder {
    private String nombreEnemigo;
    private int vida;
    private int daño;
    private String velocidad;
    private String tamaño;
    private String habilidadEspecial;

    public EnemigoBuilder setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
        return this;
    }

    public EnemigoBuilder setVida(int vida) {
        this.vida = vida;
        return this;
    }

    public EnemigoBuilder setDaño(int daño) {
        this.daño = daño;
        return this;
    }

    public EnemigoBuilder setVelocidad(String velocidad) {
        this.velocidad = velocidad;
        return this;
    }

    public EnemigoBuilder setTamaño(String tamaño) {
        this.tamaño = tamaño;
        return this;
    }

    public EnemigoBuilder setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
        return this;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public int getVida() {
        return vida;
    }

    public int getDaño() {
        return daño;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }
    
    public EnemigoPersonalizado build(){
        return EnemigoPersonalizado.crearDesdeEnemigoBuilder(this);
    }
    
}
