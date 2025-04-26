
package tarea2builderfactory;


public abstract class Enemigo {
    private String nombreEnemigo;
    private int vida;
    private int daño;
    private String velocidad;
    private String tamaño;
    private String habilidadEspecial;

    // Getters y Setters
    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    // Método común para mostrar los datos del enemigo
    public void mostrarEnemigo() {
        System.out.println("===============================================================");
        System.out.println("Se ha generado un enemigo de tipo: " + nombreEnemigo);
        System.out.println("Vida: " + vida);
        System.out.println("Daño: " + daño);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Tamaño: " + tamaño);
        System.out.println("Habilidad Especial: " + habilidadEspecial);
        System.out.println("===============================================================");
    }
}
