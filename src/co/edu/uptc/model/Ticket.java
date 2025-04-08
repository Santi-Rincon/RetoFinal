package co.edu.uptc.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime entryTime;
    private LocalDateTime departureTime;
    private String recepcionist;
    private String plate;
    private double value;
    private static final double TARIFA_HORA = 2000;
    

    public Ticket(LocalDateTime entryTime, String recepcionist, String plate) {
        this.entryTime = entryTime;
        this.departureTime = null;
        this.plate = plate;
    }

	public void checkOut(){
        this.departureTime = LocalDateTime.now();
    }

    public double calculateTotalPayment(){
        value = 0;
        if (departureTime == null) {
            throw new IllegalStateException("El vehículo aún no ha salido.");
        }
        // Calcular la duración en minutos
        long minutesParked = Duration.between(entryTime, departureTime).toMinutes();

        // Redondear al alza cada fracción de hora
        long hours = (minutesParked + 59) / 60; 

        return value = hours * TARIFA_HORA;
    }

    public double calculateChange(double moneyReceived){
        double total = calculateTotalPayment();
        if (moneyReceived < total) {
            throw new IllegalArgumentException("El dinero recibido es insuficiente.");
        }
        return moneyReceived - total;
    }


    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getRecepcionist() {
        return recepcionist;
    }

    public String getPlate() {
        return plate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double valor) {
        this.value = valor;
    }

}
