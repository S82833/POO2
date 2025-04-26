package modelo;

//Clase abstracta que representa un trabajador
public abstract class Trabajador {
    protected String nombre;
    protected String apellido;
    protected int horasTrabajadas;
    protected float pagoPorHora;
    protected float sueldo;

    public Trabajador(String nombre, String apellido, int horasTrabajadas, float pagoPorHora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
        this.sueldo = horasTrabajadas * pagoPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public float getPagoPorHora() {
        return pagoPorHora;
    }

    public float getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - Tipo: " + getClass().getSimpleName() + " - S/." + sueldo;
    }
}
