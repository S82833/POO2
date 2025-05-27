
import java.util.List;

/**
 * Interfaz que define las operaciones para gestionar rutinas almacenadas en archivo TXT
 */
public interface RutinaRepository {

    void agregar(Rutina rutina);                 // Guarda
    List<Rutina> buscar(String idSocio);         // Rutinas de un socio
    List<Rutina> imprimir();                     // Todas las rutinas
}
