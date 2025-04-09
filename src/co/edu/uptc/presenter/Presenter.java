package co.edu.uptc.presenter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uptc.model.Admin;
import co.edu.uptc.model.Parking;
import co.edu.uptc.model.Schedule;
import co.edu.uptc.model.Ticket;
import co.edu.uptc.model.User;

public class Presenter {
    private static Presenter presenter;
    private Parking modelParking;
    private Admin admin = new Admin();

    private Presenter() {
        // Crea un usuario administrador por defecto
        new Admin("1", "1");
        System.out.println("Usuario administrador creado en Presenter!");
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("Creo instancia de Presenter!");
        }
        return presenter;
    }

    public boolean login(String username, String password) {
        return User.login(username, password);
    }

    public String getUserType(String username) {
        return User.getUserType(username);
    }

    // Nuevo método que retorna true si el recepcionista fue creado con éxito
    public boolean createRecepcionist(String user, String name, String lastname, String phone,
            String address, String email, String password) {
        // Validar si el username ya existe
        if (User.userExists(user)) {
            System.out.println("El usuario ya existe: " + user);
            return false;
        }

        admin.createRecepcionist(user, name, lastname, phone, address, email, password);
        System.out.println("Recepcionista creado exitosamente: " + user);
        return true;
    }

    // En clase Presenter.java
    public boolean modifyRecepcionistCredentials(String user, String newPassword) {
        return admin.changeRecepcionistCredentials(user, newPassword);
    }

    public void registerParking(String name, String address, int spaces, Schedule[] schedule) {
        admin.registerParking(name, address, spaces, schedule);
    }

    public Parking getParking() {
        return modelParking;
    }

    public boolean registrarEntrada(String placa, String recepcionista) {
        if (modelParking.getEspaciosDisponibles() <= 0) {
            return false;
        }
        Ticket ticket = new Ticket(LocalDateTime.now(), recepcionista, placa);
        modelParking.addTicket(ticket);
        return true;
    }

    public boolean registrarSalida(String placa, double pago) {
        Ticket ticket = modelParking.getTicketPorPlaca(placa);
        if (ticket == null) {
            return false;
        }
        modelParking.checkOut(placa, LocalDateTime.now(), pago);
        return true;
    }

    public void generarReporteDelDia(LocalDate fecha) {
        modelParking.generateSalesReport(fecha);
    }

}
