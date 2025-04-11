/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class ShyGuy extends Enemigo{
    public ShyGuy() {
        this.setNombreEnemigo("Shy Guy");
        this.setVida(35);
        this.setDaño(5);
        this.setVelocidad("Lenta");
        this.setTamaño("Pequeño");
        this.setHabilidadEspecial("Ataques inesperados");
    }
}
