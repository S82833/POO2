/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class Goomba extends Enemigo{
    public Goomba() {
        this.setNombreEnemigo("Goomba");
        this.setVida(40);
        this.setDaño(5);
        this.setVelocidad("Lenta");
        this.setTamaño("Pequeño");
        this.setHabilidadEspecial("Ninguna");
    }
}
