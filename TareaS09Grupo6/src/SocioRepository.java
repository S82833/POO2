
import java.util.List;

/**
 * Interfaz que define las operaciones para gestionar socios almacenados en la base de datos
 */
public interface SocioRepository {

    void agregar(Socio socio);         // Guarda
    Socio buscar(String id);           // Busca por ID
    List<Socio> imprimir();            // Todos los socios
}
