package modelo;

//Clase que representa un trabajador tipo Supervisor
public class Supervisor extends Trabajador {
    public Supervisor(String nombre, String apellido, int horasTrabajadas) {
        super(nombre, apellido, horasTrabajadas, 30);
    }
}
