package co.edu.uptc.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Parqueadero {
    private String nombre;
    private String direccion;
    private int totalEspacios;
    private int espaciosOcupados;
    private Horario[] horario;
    private List<Ticket> tickets = new ArrayList<>();
    private Map<String, Ticket> vehiculosParqueados = new HashMap<>();
    private Recepcionista recepcionista;

    public Parqueadero(String nombre, String direccion, int totalEspacios, Horario[] horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.totalEspacios = totalEspacios;
        this.horario = horario;
    }

    public String crearHorarios(){
        Horario[] horarios = new Horario[3];
        horarios[0] = new Horario("Lunes a Viernes", "08:00", "18:00");
        horarios[1] = new Horario("Sábado", "08:00", "12:00");
        horarios[2] = new Horario("Domingos y festivos", "08:00", "18:00");

        return horarios.toString();
    } 
    

    public int getEspaciosDisponibles(){
        return totalEspacios - espaciosOcupados;
    }

    public void agregarTicket(Ticket ticket) {
        tickets.add(new Ticket(LocalDateTime.now(), recepcionista.nombreCompleto(), ticket.getPlaca()));
        vehiculosParqueados.put(ticket.getPlaca(), ticket);
        espaciosOcupados++;
    }

    public void registrarSalida(String placa, LocalDateTime horaSalida, double pago) {
        if (vehiculosParqueados.containsKey(placa)) {
            Ticket ticket = vehiculosParqueados.get(placa);
            ticket.registrarSalida();
            ticket.calcularTotalPago();
            ticket.calcularCambio(pago);
        }

        vehiculosParqueados.remove(placa);
        espaciosOcupados--;
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
                recepcionistas.putIfAbsent(recepcionista, new Double[]{0.0, 0.0});
                recepcionistas.get(recepcionista)[0] += ticket.getValor();
                recepcionistas.get(recepcionista)[1] ++;
            }
        }

        JOptionPane.showMessageDialog(null, "Reporte de ventas del " + fecha + "\n" +
                "Total ingresos: " + totalIngresos + "\n" +
                "Total vehículos: " + totalVehiculos + "\n" +
                "Detalles por recepcionista: ");

        for(Map.Entry<String, Double[]> entry : recepcionistas.entrySet()) {
            JOptionPane.showMessageDialog(null, "Recepcionista: " + entry.getKey() + "\n" +
                    "Total Ingresos: " + entry.getValue()[0] + "\n" +
                    "Número de vehículos: " + entry.getValue()[1].intValue());
        }
    }

}
