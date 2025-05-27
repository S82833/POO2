
import java.util.List;

/**
 * Interfaz que define el comportamiento común para generar reportes
 */
public interface GeneradorReporte {

    void generar(List<Socio> socios, List<Rutina> rutinas);
}
