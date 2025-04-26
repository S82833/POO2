import controlador.ControladorTrabajador;
import factory.TrabajadorFactory;
import vista.VistaTrabajador;

/**
 * Clase principal que lanza la aplicación.
 */
public class main {
    public static void main(String[] args) {
        VistaTrabajador vista = new VistaTrabajador();
        TrabajadorFactory factory = new TrabajadorFactory();
        ControladorTrabajador controlador = new ControladorTrabajador(vista, factory);
        controlador.iniciar();
    }
}
