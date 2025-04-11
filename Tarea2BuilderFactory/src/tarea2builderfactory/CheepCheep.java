/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class CheepCheep extends Enemigo{
    public CheepCheep() {
        this.setNombreEnemigo("Cheep Cheep");
        this.setVida(30);
        this.setDaño(4);
        this.setVelocidad("Media");
        this.setTamaño("Pequeño");
        this.setHabilidadEspecial("Nadar rápidamente bajo el agua");
    }
}
