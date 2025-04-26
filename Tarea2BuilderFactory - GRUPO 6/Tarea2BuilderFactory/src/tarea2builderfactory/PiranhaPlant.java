
package tarea2builderfactory;


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
