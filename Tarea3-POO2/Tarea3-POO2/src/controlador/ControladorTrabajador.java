package controlador;

import factory.TrabajadorFactory;
import modelo.Trabajador;
import vista.VistaTrabajador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Controlador que contiene toda la logica del sistema de trabajadores
public class ControladorTrabajador {

    private VistaTrabajador vista;
    private TrabajadorFactory factory;
    private List<Trabajador> listaTrabajadores = new ArrayList<>();

    public ControladorTrabajador(VistaTrabajador vista, TrabajadorFactory factory) {
        this.vista = vista;
        this.factory = factory;

//        vista.agregarListenerAgregar(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agregarTrabajador();
//            }
//        });
        
        vista.agregarListenerAgregar(e -> agregarTrabajador());

//        vista.agregarListenerReporte(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                generarReporte();
//            }
//        });
        vista.agregarListenerReporte(e -> generarReporte());

//        vista.agregarListenerCombo(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actualizarPagoHora();
//            }
//        });
        vista.agregarListenerCombo(e -> actualizarPagoHora());
    }

    // Metodo para iniciar el programa y mostrar la vista
    public void iniciar() {
        vista.setVisible(true);
    }

    // Metodo para agregar un trabajador a la lista
    private void agregarTrabajador() {
        try {
            String nombre = vista.getTextoNombre();
            String apellido = vista.getTextoApellido();
            String textoHoras = vista.getTextoHoras();
            String tipo = vista.getTipoSeleccionado();

            // Validación de campos vacíos
            if (nombre.isEmpty() && apellido.isEmpty() && textoHoras.isEmpty()) {
                throw new IllegalArgumentException("Todos los campos estan vacios.");
            }

            if (nombre.isEmpty()) {
                throw new IllegalArgumentException("El campo NOMBRE esta vacio.");
            }
            if (apellido.isEmpty()) {
                throw new IllegalArgumentException("El campo APELLIDO esta vacio.");
            }
            if (textoHoras.isEmpty()) {
                throw new IllegalArgumentException("El campo HORAS esta vacio.");
            }

            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                throw new IllegalArgumentException("El NOMBRE solo debe contener letras.");
            }

            if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                throw new IllegalArgumentException("El APELLIDO solo debe contener letras.");
            }

            int horas;
            try {
                horas = Integer.parseInt(textoHoras);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Las HORAS deben ser un numero entero.");
            }

            if (horas < 0) {
                throw new IllegalArgumentException("Las HORAS no pueden ser negativas.");
            }

            // Crear trabajador
            Trabajador t = factory.generarTrabajador(tipo, nombre, apellido, horas);
            listaTrabajadores.add(t);
            vista.agregarTrabajador(t.toString());
            vista.limpiarCampos();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de validación", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Metodo para generar el reporte de trabajadores
    private void generarReporte() {
        if (listaTrabajadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay trabajadores registrados", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Function<Trabajador, String> convertir = t -> t.getNombre() + " " + t.getApellido() + " - S/." + t.getSueldo();
        try (PrintWriter writer = new PrintWriter(new FileWriter("reporte_trabajadores.txt"))) {
            listaTrabajadores.stream()
                    .map(convertir)
                    .forEach(writer::println);
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte.");
        }
    }

    // Metodo para actualizar automaticamente el pago por hora segun el tipo
    private void actualizarPagoHora() {
        String tipo = vista.getTipoSeleccionado();
        int pago;

        switch (tipo.toLowerCase()) {
            case "oficinista":
                pago = 20;
                break;
            case "tecnico":
                pago = 25;
                break;
            case "supervisor":
                pago = 30;
                break;
            default:
                pago = 0;
                break;
        }
        vista.setTextoPago(String.valueOf(pago));
    }
}
