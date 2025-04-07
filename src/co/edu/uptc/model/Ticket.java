package co.edu.uptc.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private String recepcionista;
    private String placa;
    private double valor;
    private static final double TARIFA_HORA = 2000;
    

    public Ticket(LocalDateTime horaEntrada, String recepcionista, String placa) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = null;
        this.placa = placa;
    }

	public void registrarSalida(){
        this.horaSalida = LocalDateTime.now();
    }

    public double calcularTotalPago(){
        valor = 0;
        if (horaSalida == null) {
            throw new IllegalStateException("El vehículo aún no ha salido.");
        }
        // Calcular la duración en minutos
        long minutosEstacionado = Duration.between(horaEntrada, horaSalida).toMinutes();

        // Redondear al alza cada fracción de hora
        long horas = (minutosEstacionado + 59) / 60; 

        return valor = horas * TARIFA_HORA;
    }

    public double calcularCambio(double dineroRecibido){
        double total = calcularTotalPago();
        if (dineroRecibido < total) {
            throw new IllegalArgumentException("El dinero recibido es insuficiente.");
        }
        return dineroRecibido - total;
    }


    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getRecepcionista() {
        return recepcionista;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
