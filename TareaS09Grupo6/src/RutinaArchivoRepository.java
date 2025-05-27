
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio que permite gestionar rutinas guardadas en archivo de texto
 */
public class RutinaArchivoRepository implements RutinaRepository {

    private File archivo; // Archivo donde se almacenan las rutinas

    // Constructor
    public RutinaArchivoRepository(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
        try {
            this.archivo.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Guarda una nueva rutina en el archivo de texto
    @Override
    public void agregar(Rutina r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.archivo, true))) {
            bw.write(r.toString());
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Devuelve la lista de rutinas realizadas por un socio específico
    @Override
    public List<Rutina> buscar(String idSocio) {
        List<Rutina> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Rutina r = Rutina.fromString(linea);
                if (r.getIdSocio().equals(idSocio)) {
                    lista.add(r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    // Devuelve la lista completa de todas las rutinas registradas
    @Override
    public List<Rutina> imprimir() {
        List<Rutina> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Rutina.fromString(linea));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
