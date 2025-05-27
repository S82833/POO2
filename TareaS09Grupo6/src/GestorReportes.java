
import java.util.List;

/**
 * Permite seleccionar y ejecutar una estrategia de reporte
 */
public class GestorReportes {

    private GeneradorReporte estrategia;   // Estrategia actual
    
    
    // Asigna la estrategia que se usará para generar el reporte(CSV o HTML)
    public void setEstrategia(GeneradorReporte estrategia) {
        this.estrategia = estrategia;
    }
    
    
    // Ejecuta la estrategia seleccionada para generar el reporte
    public void generar(List<Socio> socios, List<Rutina> rutinas) {
        if (this.estrategia == null) {
            System.out.println("Primero elija un tipo de reporte.");
            return;
        }
        this.estrategia.generar(socios, rutinas);
    }
}
