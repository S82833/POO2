/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class Lakitu extends Enemigo{
    public Lakitu() {
        this.setNombreEnemigo("Lakitu");
        this.setVida(60);
        this.setDaño(6);
        this.setVelocidad("Media");
        this.setTamaño("Pequeño");
        this.setHabilidadEspecial("Lanza Spinies desde las nubes");
    }
}
