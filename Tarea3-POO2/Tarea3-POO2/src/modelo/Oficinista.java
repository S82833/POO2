package modelo;

//Clase que representa un trabajador tipo Oficinista
public class Oficinista extends Trabajador {
    public Oficinista(String nombre, String apellido, int horasTrabajadas) {
        super(nombre, apellido, horasTrabajadas, 20);
    }
}
