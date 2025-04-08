package co.edu.uptc.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Parking {
    private String name;
    private String address;
    private int totalSpaces;
    private int occupiedSpaces;
    private Schedule[] schedule;
    private List<Ticket> tickets = new ArrayList<>();
    private Map<String, Ticket> parkedVehicles = new HashMap<>();
    private Recepcionist recepcionist;

    public Parking(String nombre, String direccion, int totalEspacios, Schedule[] horario) {
        this.name = nombre;
        this.address = direccion;
        this.totalSpaces = totalEspacios;
        this.schedule = horario;
    }

    public String crearHorarios() {
        Schedule[] horarios = new Schedule[3];
        horarios[0] = new Schedule("Lunes a Viernes", "08:00", "18:00");
        horarios[1] = new Schedule("Sábado", "08:00", "12:00");
        horarios[2] = new Schedule("Domingos y festivos", "08:00", "18:00");

        return horarios.toString();
    }

    public int getEspaciosDisponibles() {
        return totalSpaces - occupiedSpaces;
    }

    public void agregarTicket(Ticket ticket) {
        tickets.add(new Ticket(LocalDateTime.now(), recepcionist.nombreCompleto(), ticket.getPlaca()));
        parkedVehicles.put(ticket.getPlaca(), ticket);
        occupiedSpaces++;
    }

    public void registrarSalida(String placa, LocalDateTime horaSalida, double pago) {
        if (parkedVehicles.containsKey(placa)) {
            Ticket ticket = parkedVehicles.get(placa);
            ticket.registrarSalida();
            ticket.calcularTotalPago();
            ticket.calcularCambio(pago);
        }

        parkedVehicles.remove(placa);
        occupiedSpaces--;
    }

    public void generarReporteVentas(LocalDate fecha) {
        double totalIngresos = 0;
        int totalVehiculos = 0;
        Map<String, Double[]> recepcionistas = new HashMap<>();

        for (Ticket ticket : tickets) {
            if (ticket.getHoraEntrada().toLocalDate().equals(fecha)) {
                totalIngresos += ticket.getValor();
                totalVehiculos++;

                String recepcionista = ticket.getRecepcionista();
                recepcionistas.putIfAbsent(recepcionista, new Double[] { 0.0, 0.0 });
                recepcionistas.get(recepcionista)[0] += ticket.getValor();
                recepcionistas.get(recepcionista)[1]++;
            }
        }

        JOptionPane.showMessageDialog(null, "Reporte de ventas del " + fecha + "\n" +
                "Total ingresos: " + totalIngresos + "\n" +
                "Total vehículos: " + totalVehiculos + "\n" +
                "Detalles por recepcionista: ");

        for (Map.Entry<String, Double[]> entry : recepcionistas.entrySet()) {
            JOptionPane.showMessageDialog(null, "Recepcionista: " + entry.getKey() + "\n" +
                    "Total Ingresos: " + entry.getValue()[0] + "\n" +
                    "Número de vehículos: " + entry.getValue()[1].intValue());
        }
    }

}
