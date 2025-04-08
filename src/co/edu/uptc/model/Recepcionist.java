package co.edu.uptc.model;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Recepcionist extends User {
    private String nombres;
    private String apellidos;
    private String telofono;
    private String direccion;   
    private String email;

    public Recepcionist(String usuario, String nombres, String apellidos, String telofono, String direccion,String email, String contraseña) {
        super(usuario, contraseña);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telofono = telofono;
        this.direccion = direccion; 
        this.email = email; 

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