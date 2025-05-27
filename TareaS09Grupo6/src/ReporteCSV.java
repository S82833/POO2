
import java.io.PrintWriter;
import java.util.List;

/**
 * Estrategia que permite generar un reporte en formato CSV
 */
public class ReporteCSV implements GeneradorReporte {
    
    // Genera el archivo reporte.csv con información de los socios y sus rutinas
    @Override
    public void generar(List<Socio> socios, List<Rutina> rutinas) {

        try (PrintWriter pw = new PrintWriter("reporte.csv")) {
            pw.println("ID,Nombre,Membresia,CaloriasTotales,MinutosTotales");

            for (Socio s : socios) {
                int calTotal = 0;
                int minTotal = 0;

                for (Rutina r : rutinas) {
                    if (r.getIdSocio().equals(s.getId())) {
                        calTotal += r.getCalorias();
                        minTotal += r.getMinutos();
                    }
                }

                pw.println(s.getId() + "," + s.getNombre() + "," + s.getMembresia() + ","
                         + calTotal + "," + minTotal);
            }

            System.out.println("Reporte CSV generado correctamente (reporte.csv)");
        } catch (Exception ex) {
            System.err.println("Error al generar CSV: " + ex.getMessage());
        }
    }
}
