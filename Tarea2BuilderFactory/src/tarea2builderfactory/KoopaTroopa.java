/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class KoopaTroopa extends Enemigo{
    public KoopaTroopa() {
        this.setNombreEnemigo("Koopa Troopa");
        this.setVida(50);
        this.setDaño(7);
        this.setVelocidad("Media");
        this.setTamaño("Mediano");
        this.setHabilidadEspecial("Se esconde en su caparazón");
    }
}
