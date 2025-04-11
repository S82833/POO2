/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class PiranhaPlant extends Enemigo{
    public PiranhaPlant() {
        this.setNombreEnemigo("Piranha Plant");
        this.setVida(70);
        this.setDaño(10);
        this.setVelocidad("Estática");
        this.setTamaño("Grande");
        this.setHabilidadEspecial("Muerde desde las tuberías");
    }
}
