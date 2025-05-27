
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio que permite trabajar con socios en la base de datos MySQL
 */
public class SocioMySQLRepository implements SocioRepository {

    // Datos de conexión a la base de datos local
    private static final String URL = "jdbc:mysql://localhost:3306/db_gimnasio?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    
    //Conexión a la base de datos  en la nube
    /*private static final String url = "jdbc:mysql://caboose.proxy.rlwy.net:15726/railway";
    private static final String user = "root";
    private static final String pass = "yGeIVzkjxJZsryTfLwptlTAcqxNGWzSQ";*/

    
    // Método que retorna una conexión activa a MySQL
    private Connection getConexion() throws java.sql.SQLException {
        return DriverManager.getConnection(URL, USER, PASS); //url,user,pass (railway)
    }
    
    
    // Agrega un socio a la base de datos 
    @Override
    public void agregar(Socio s) {
        String sql = "INSERT INTO socio "
                + "(id, nombre, edad, email, membresia, fecha_inicio, fecha_fin) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = this.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getId());
            ps.setString(2, s.getNombre());
            ps.setInt(3, s.getEdad());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getMembresia());
            ps.setDate(6, Date.valueOf(s.getFechaInicio()));
            ps.setDate(7, Date.valueOf(s.getFechaFin()));
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al agregar socio: " + e.getMessage());
        }
    }
    
    
    // Busca un socio por ID en la base de datos
    @Override
    public Socio buscar(String id) {
        String sql = "SELECT * FROM socio WHERE id = ?";
        try (Connection con = this.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Socio(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("email"),
                        rs.getString("membresia"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                );
            }
        } catch (Exception e) {
            System.err.println("Error al buscar socio: " + e.getMessage());
        }
        return null;
    }
    
    
    // Retorna una lista con todos los socios registrados
    @Override
    public List<Socio> imprimir() {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT * FROM socio";

        try (Connection con = this.getConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Socio(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("email"),
                        rs.getString("membresia"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()
                ));
            }
        } catch (Exception e) {
            System.err.println("Error al listar socios: " + e.getMessage());
        }
        return lista;
    }
}
