package factory;

import modelo.Trabajador;
import modelo.Oficinista;
import modelo.Tecnico;
import modelo.Supervisor;

//Factory para crear objetos Trabajador según su tipo
public class TrabajadorFactory {
    // Metodo que crea un trabajador dependiendo del tipo seleccionado
    public Trabajador generarTrabajador(String tipo, String nombre, String apellido, int horasTrabajadas) {
        switch (tipo.toLowerCase()) {
            case "oficinista":
                return new Oficinista(nombre, apellido, horasTrabajadas);
            case "tecnico":
                return new Tecnico(nombre, apellido, horasTrabajadas);
            case "supervisor":
                return new Supervisor(nombre, apellido, horasTrabajadas);
            default:
                throw new IllegalArgumentException("Tipo de trabajador no valido.");
        }
    }
}
