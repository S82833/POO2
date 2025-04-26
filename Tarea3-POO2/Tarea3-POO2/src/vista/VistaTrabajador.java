package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//Vista grafica que permite capturar datos del trabajador
public class VistaTrabajador extends JFrame {
    private JTextField campoNombre = new JTextField(10);
    private JTextField campoApellido = new JTextField(10);
    private JTextField campoHoras = new JTextField(5);
    private JTextField campoPago = new JTextField(5);
    private JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Oficinista", "Tecnico", "Supervisor"});
    private JButton botonAgregar = new JButton("Agregar");
    private JButton botonReporte = new JButton("Generar Reporte");
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private JList<String> listaTrabajadores = new JList<>(modeloLista);

    public VistaTrabajador() {
        setTitle("Sistema de Trabajadores");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de texto y ComboBox
        add(new JLabel("Nombre:"));
        add(campoNombre);

        add(new JLabel("Apellido:"));
        add(campoApellido);

        add(new JLabel("Horas trabajadas:"));
        add(campoHoras);

        add(new JLabel("Tipo de trabajador:"));
        add(comboTipo);

        add(new JLabel("Pago por hora:"));
        campoPago.setEditable(false); // No editable
        add(campoPago);
        setTextoPago("20");

        // Lista de trabajadores (con scroll)
        JScrollPane scrollPane = new JScrollPane(listaTrabajadores);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        add(scrollPane);

        // Panel para los botones abajo
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonAgregar);
        panelBotones.add(botonReporte);
        add(panelBotones);
        
        setLocationRelativeTo(null); 
    }

    // Metodo para obtener el nombre ingresado
    public String getTextoNombre() {
        return campoNombre.getText().trim();
    }

    // Metodo para obtener el apellido ingresado
    public String getTextoApellido() {
        return campoApellido.getText().trim();
    }

    // Metodo para obtener las horas ingresadas
    public String getTextoHoras() {
        return campoHoras.getText().trim();
    }

    // Metodo para obtener el texto del pago por hora
    public String getTextoPago() {
        return campoPago.getText().trim();
    }

    // Metodo para obtener el tipo de trabajador seleccionado
    public String getTipoSeleccionado() {
        return (String) comboTipo.getSelectedItem();
    }

    // Metodo para setear el pago por hora en el campo
    public void setTextoPago(String texto) {
        campoPago.setText(texto);
    }

    // Metodo para limpiar todos los campos
    public void limpiarCampos() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoHoras.setText("");
        comboTipo.setSelectedIndex(0);
        campoPago.setText("");
    }

    // Metodo para agregar un trabajador a la lista
    public void agregarTrabajador(String texto) {
        modeloLista.addElement(texto);
    }

    // Metodo para agregar el listener al botón agregar
    public void agregarListenerAgregar(ActionListener listener) {
        botonAgregar.addActionListener(listener);
    }

    // Metodo para agregar el listener al botón reporte
    public void agregarListenerReporte(ActionListener listener) {
        botonReporte.addActionListener(listener);
    }

    // Metodo para agregar un listener al cambio de selección en el ComboBox
    public void agregarListenerCombo(ActionListener listener) {
        comboTipo.addActionListener(listener);
    }
}
