
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Main del sistema
 * Registra socios y sus rutinas, genera reportes en CSV y HTML
 */
public class Main {

    // Variables globales estáticas
    private static final SocioRepository repoSocio = new SocioMySQLRepository();
    private static final RutinaRepository repoRutina = new RutinaArchivoRepository("rutinas.txt");
    private static final GestorReportes gestor = new GestorReportes();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 ->
                    agregarSocio();  // Agrega nuevo socio
                case 2 ->
                    listarSocios(); // Muestra lista de socios
                case 3 ->
                    registrarRutina(); // Registra una nueva rutina
                case 4 ->
                    listarRutinas(); // Muestra todas las rutinas
                case 5 ->
                    generarReporteCSV(); // Genera reporte en CSV
                case 6 ->
                    generarReporteHTML(); // Genera reporte en HTML
                case 0 ->
                    System.out.println("Programa finalizado.");
                default ->
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);
    }
    
    
    // Muestra el menú principal en consola
    private static void mostrarMenu() {
        System.out.println("\n=== GYM TRACKER ===");
        System.out.println("1. Agregar socio");
        System.out.println("2. Listar socios");
        System.out.println("3. Registrar rutina");
        System.out.println("4. Listar rutinas");
        System.out.println("5. Generar reporte CSV");
        System.out.println("6. Generar reporte HTML");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }
    
    
    // Agrega un nuevo socio al sistema si el ID no existe
    private static void agregarSocio() {
        System.out.print("ID (ej. S001): ");
        String id = sc.nextLine();

        if (repoSocio.buscar(id) != null) {
            System.out.println("Ese ID ya existe.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Membresia (Basico/Premium): ");
        String membresia = sc.nextLine();
        System.out.print("Meses de duracion: ");
        int meses = Integer.parseInt(sc.nextLine());

        LocalDate inicio = LocalDate.now();
        LocalDate fin = inicio.plusMonths(meses);

        repoSocio.agregar(new Socio(id, nombre, edad, email, membresia, inicio, fin));
        System.out.println("Socio agregado exitosamente.");
    }
    
    
    // Muestra en consola todos los socios registrados
    private static void listarSocios() {
        List<Socio> lista = repoSocio.imprimir();
        System.out.println("--- LISTA DE SOCIOS ---");
        for (Socio s : lista) {
            System.out.println(s.getId() + " | " + s.getNombre() + " | " + s.getMembresia());
        }
    }
    
    
    // Registra una nueva rutina para un socio existente
    private static void registrarRutina() {
        System.out.print("ID Socio: ");
        String id = sc.nextLine();

        if (repoSocio.buscar(id) == null) {
            System.out.println("No existe ese socio.");
            return;
        }

        System.out.print("Ejercicio: ");
        String ejercicio = sc.nextLine();
        System.out.print("Minutos: ");
        int minutos = Integer.parseInt(sc.nextLine());
        System.out.print("Calorias: ");
        int calorias = Integer.parseInt(sc.nextLine());

        Rutina r = new Rutina(id, LocalDate.now(), ejercicio, minutos, calorias);
        repoRutina.agregar(r);
        System.out.println("Rutina registrada correctamente.");
    }
    
    
    // Muestra todas las rutinas registradas en el sistema
    private static void listarRutinas() {
        List<Rutina> lista = repoRutina.imprimir();
        System.out.println("--- LISTA DE RUTINAS ---");
        for (Rutina r : lista) {
            System.out.println(r.getIdSocio() + " | " + r.getFecha() + " | " + r.getEjercicio() + " | " + r.getMinutos() + " min | " + r.getCalorias() + " cal");
        }
    }
    
    
    // Genera reporte en formato CSV
    private static void generarReporteCSV() {
        gestor.setEstrategia(new ReporteCSV());
        gestor.generar(repoSocio.imprimir(), repoRutina.imprimir());
    }

    // Genera reporte en formato HTML
    private static void generarReporteHTML() {
        gestor.setEstrategia(new ReporteHTML());
        gestor.generar(repoSocio.imprimir(), repoRutina.imprimir());
    }
}
