
import java.time.LocalDate;

/**
 * Representa una sesión de ejercicio realizada por un socio del gimnasio
 */
public class Rutina {

    private String idSocio;
    private LocalDate fecha;
    private String ejercicio;
    private int minutos;
    private int calorias;
    
    
    // Constructor
    public Rutina(String idSocio, LocalDate fecha,String ejercicio, int minutos, int calorias) {
        this.idSocio = idSocio;
        this.fecha = fecha;
        this.ejercicio = ejercicio;
        this.minutos = minutos;
        this.calorias = calorias;
    }

    // Getters
    public String getIdSocio() {
        return this.idSocio;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public String getEjercicio() {
        return this.ejercicio;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public int getCalorias() {
        return this.calorias;
    }
    
    
    // Convierte a una línea de texto con separadores
    @Override
    public String toString() {
        return this.idSocio + "|" + this.fecha + "|" + this.ejercicio + "|" + this.minutos + "|" + this.calorias;
    }
    
    
    // Crea un objeto rutina a partir de una línea de texto
    public static Rutina fromString(String linea) {
        String[] p = linea.split("\\|");
        return new Rutina(
                p[0],
                LocalDate.parse(p[1]),
                p[2],
                Integer.parseInt(p[3]),
                Integer.parseInt(p[4])
        );
    }
}
