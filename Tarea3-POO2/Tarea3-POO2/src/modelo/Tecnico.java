package modelo;

//Clase que representa un trabajador tipo Tecnico
public class Tecnico extends Trabajador {
    public Tecnico(String nombre, String apellido, int horasTrabajadas) {
        super(nombre, apellido, horasTrabajadas, 25);
    }
}
