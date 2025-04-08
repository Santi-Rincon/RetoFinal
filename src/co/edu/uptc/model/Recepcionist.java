package co.edu.uptc.model;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Recepcionist extends User {
    private String nombres;
    private String apellidos;

    public Recepcionist(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña);
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String nombreCompleto(){
        return nombres + " " + apellidos;
    }

    public void registrarIngresoVehiculo(Parking parqueadero, String placa, LocalDateTime horaIngreso) {
        Ticket ticket = new Ticket(horaIngreso, this.nombreCompleto(), placa);
        parqueadero.agregarTicket(ticket);
    }

    public void registrarSalidaVehiculo(Parking parqueadero, String placa, LocalDateTime horaSalida, double pago) {
        Ticket ticket = new Ticket(horaSalida, this.nombreCompleto(), placa);
        parqueadero.registrarSalida(placa, horaSalida, pago);
    }

    public void mostrarEspaciosDisponibles(Parking parqueadero) {
        int espaciosDisponibles = parqueadero.getEspaciosDisponibles();
        JOptionPane.showMessageDialog(null, "Espacios disponibles: " + espaciosDisponibles);
        if (espaciosDisponibles <= 5) {
            JOptionPane.showMessageDialog(null, "Quedan pocos espacios disponibles", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

}