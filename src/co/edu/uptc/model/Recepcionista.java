package co.edu.uptc.model;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Recepcionista extends Usuario {
    private String nombres;
    private String apellidos;

    public Recepcionista(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña);
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String nombreCompleto(){
        return nombres + " " + apellidos;
    }

    public void registrarIngresoVehiculo(Parqueadero parqueadero, String placa, LocalDateTime horaIngreso) {
        Ticket ticket = new Ticket(horaIngreso, this.nombreCompleto(), placa);
        parqueadero.agregarTicket(ticket);
    }

    public void registrarSalidaVehiculo(Parqueadero parqueadero, String placa, LocalDateTime horaSalida, double pago) {
        Ticket ticket = new Ticket(horaSalida, this.nombreCompleto(), placa);
        parqueadero.registrarSalida(placa, horaSalida, pago);
    }

    public void mostrarEspaciosDisponibles(Parqueadero parqueadero) {
        int espaciosDisponibles = parqueadero.getEspaciosDisponibles();
        JOptionPane.showMessageDialog(null, "Espacios disponibles: " + espaciosDisponibles);
        if (espaciosDisponibles <= 5) {
            JOptionPane.showMessageDialog(null, "Quedan pocos espacios disponibles", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

}
