
import java.time.LocalDate;

/**
 * Representa a un socio del gimnasio con datos personales, tipo de membresía y fechas de vigencia
 */
public class Socio {

    private String id;            // Ej. S001
    private String nombre;
    private int edad;
    private String email;
    private String membresia;     // Basico o Premium
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    
    // Constructor
    public Socio(String id, String nombre, int edad, String email,String membresia, LocalDate inicio, LocalDate fin) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.membresia = membresia;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
    }

    // Getters
    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMembresia() {
        return this.membresia;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }
    
    
    // Convierte a una línea de texto con separadores
    @Override
    public String toString() {
        return this.id + "|" + this.nombre + "|" + this.edad + "|" + this.email + "|" + this.membresia + "|" + this.fechaInicio + "|" + this.fechaFin;
    }
    
    
    // Crea un objeto socio a partir de una línea de texto
    public static Socio fromString(String linea) {
        String[] p = linea.split("\\|");
        return new Socio(
                p[0],
                p[1],
                Integer.parseInt(p[2]),
                p[3],
                p[4],
                LocalDate.parse(p[5]),
                LocalDate.parse(p[6])
        );
    }
}
