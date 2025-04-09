package co.edu.uptc.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import javax.swing.JOptionPane;

public class Parking {
    private static Parking instance;

    private String name;
    private String address;
    private int totalSpaces;
    private int occupiedSpaces;
    private Schedule[] schedule;
    private List<Ticket> tickets = new ArrayList<>();
    private Map<String, Ticket> parkedVehicles = new HashMap<>();
    private Recepcionist recepcionist;

    private Parking(String name, String address, int totalSpaces, Schedule[] schedule) {
        this.name = name;
        this.address = address;
        this.totalSpaces = totalSpaces;
        this.schedule = schedule;
    }

    // Método para obtener la instancia única
    public static Parking getInstance(String name, String address, int totalSpaces, Schedule[] schedule) {
        if (instance == null) {
            instance = new Parking(name, address, totalSpaces, schedule);
        }
        return instance;
    }

    // Método adicional para obtener la instancia ya creada (sin parámetros)
    public static Parking getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Parking aún no ha sido inicializado.");
        }
        return instance;
    }

    public String createSchedules() {
        Schedule[] schedules = new Schedule[3];
        schedules[0] = new Schedule("Lunes a Viernes", "08:00", "18:00");
        schedules[1] = new Schedule("Sábado", "08:00", "12:00");
        schedules[2] = new Schedule("Domingos y festivos", "08:00", "18:00");
        return Arrays.toString(schedules);
    }

    public List<Ticket> getTicketsDelDia(LocalDate fecha) {
        List<Ticket> delDia = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getEntryTime().toLocalDate().equals(fecha)) {
                delDia.add(ticket);
            }
        }
        return delDia;
    }

    public int getEspaciosDisponibles() {
        return totalSpaces - occupiedSpaces;
    }

    public Ticket getTicketPorPlaca(String plate) {
        return parkedVehicles.get(plate);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(new Ticket(LocalDateTime.now(), recepcionist.fullName(), ticket.getPlate()));
        parkedVehicles.put(ticket.getPlate(), ticket);
        occupiedSpaces++;
    }

    public void checkOut(String plate, LocalDateTime departureTime, double payment) {
        if (parkedVehicles.containsKey(plate)) {
            Ticket ticket = parkedVehicles.get(plate);
            ticket.checkOut();
            ticket.calculateTotalPayment();
            ticket.calculateChange(payment);
        }

        parkedVehicles.remove(plate);
        occupiedSpaces--;
    }

    public void generateSalesReport(LocalDate date) {
        double totalIncome = 0;
        int totalVehicles = 0;
        Map<String, Double[]> recepcionists = new HashMap<>();

        for (Ticket ticket : tickets) {
            if (ticket.getEntryTime().toLocalDate().equals(date)) {
                totalIncome += ticket.getValue();
                totalVehicles++;

                String recepcionist = ticket.getRecepcionist();
                recepcionists.putIfAbsent(recepcionist, new Double[] { 0.0, 0.0 });
                recepcionists.get(recepcionist)[0] += ticket.getValue();
                recepcionists.get(recepcionist)[1]++;
            }
        }

        JOptionPane.showMessageDialog(null, "Reporte de ventas del " + date + "\n" +
                "Total ingresos: " + totalIncome + "\n" +
                "Total vehículos: " + totalVehicles + "\n" +
                "Detalles por recepcionista: ");

        for (Map.Entry<String, Double[]> entry : recepcionists.entrySet()) {
            JOptionPane.showMessageDialog(null, "Recepcionista: " + entry.getKey() + "\n" +
                    "Total Ingresos: " + entry.getValue()[0] + "\n" +
                    "Número de vehículos: " + entry.getValue()[1].intValue());
        }
    }
}
