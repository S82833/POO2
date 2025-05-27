
import java.io.PrintWriter;
import java.util.List;

/**
 * Estrategia que permite generar un reporte en formato HTML
 */
public class ReporteHTML implements GeneradorReporte {
    
    // Genera el archivo reporte.html con información de los socios y sus rutinas
    @Override
    public void generar(List<Socio> socios, List<Rutina> rutinas) {

        try (PrintWriter pw = new PrintWriter("reporte.html")) {
            pw.println("<html><head><title>Reporte de Socios</title></head><body>");
            pw.println("<h1>Actividad de Socios</h1>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>ID</th><th>Nombre</th><th>Membresía</th>"
                     + "<th>Calorías Totales</th><th>Minutos Totales</th></tr>");

            for (Socio s : socios) {
                int calTotal = 0;
                int minTotal = 0;

                for (Rutina r : rutinas) {
                    if (r.getIdSocio().equals(s.getId())) {
                        calTotal += r.getCalorias();
                        minTotal += r.getMinutos();
                    }
                }

                pw.println("<tr><td>" + s.getId() + "</td><td>" + s.getNombre() + "</td><td>"
                         + s.getMembresia() + "</td><td>" + calTotal + "</td><td>" + minTotal + "</td></tr>");
            }

            pw.println("</table></body></html>");
            System.out.println("Reporte HTML generado (reporte.html).");
        } catch (Exception ex) {
            System.err.println("Error al generar HTML: " + ex.getMessage());
        }
    }
}
