package co.edu.uptc.view;

import co.edu.uptc.model.Parking;
import co.edu.uptc.model.Ticket;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.border.*;

public class Report extends JFrame {

    public Report(LocalDate fecha, Parking parking) {
        super("Reporte de ventas - " + fecha);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Obtener datos del modelo
        List<Ticket> tickets = parking.getTicketsDelDia(fecha);

        double totalIngresos = 0;
        int totalVehiculos = tickets.size();
        Map<String, Double[]> resumen = new HashMap<>();

        for (Ticket ticket : tickets) {
            totalIngresos += ticket.getValue();
            resumen.putIfAbsent(ticket.getRecepcionist(), new Double[]{0.0, 0.0});
            resumen.get(ticket.getRecepcionist())[0] += ticket.getValue();
            resumen.get(ticket.getRecepcionist())[1]++;
        }

        // Preparar arreglos para listas
        String[] nombres = resumen.keySet().toArray(new String[0]);
        String[] ingresos = resumen.values().stream()
                .map(v -> "$" + String.format("%.2f", v[0])).toArray(String[]::new);
        String[] vehiculos = resumen.values().stream()
                .map(v -> String.valueOf(v[1].intValue())).toArray(String[]::new);

        // Panel principal
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(new Color(242, 242, 242));

        // Panel superior con tarjetas de resumen
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        topPanel.setOpaque(false);
        topPanel.add(createCardLabel("Fecha", fecha.toString()));
        topPanel.add(createCardLabel("Total Ingresos", "$" + String.format("%.2f", totalIngresos)));
        topPanel.add(createCardLabel("Total Vehículos", String.valueOf(totalVehiculos)));

        // Panel de listas con scroll
        JPanel listPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        listPanel.setOpaque(false);
        listPanel.add(createListWithHeader("Nombre y Apellidos", nombres));
        listPanel.add(createListWithHeader("Total Ingreso", ingresos));
        listPanel.add(createListWithHeader("Total Vehículos", vehiculos));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Envolver topPanel y scrollPane en un panel
        JPanel centerWrapper = new JPanel();
        centerWrapper.setLayout(new BoxLayout(centerWrapper, BoxLayout.Y_AXIS));
        centerWrapper.setOpaque(false);
        centerWrapper.add(topPanel);
        centerWrapper.add(Box.createVerticalStrut(20));
        centerWrapper.add(scrollPane);

        contentPanel.add(centerWrapper, BorderLayout.CENTER);

        // Botón de volver
        JButton backButton = new JButton("Volver al menú");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(57, 157, 255));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setPreferredSize(new Dimension(180, 40));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(new EmptyBorder(10, 0, 20, 0));
        buttonPanel.add(backButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(contentPanel);
        setVisible(true);
    }

    private JPanel createCardLabel(String title, String value) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        JLabel label = new JLabel("<html><center><b>" + title + "</b><br>" + value + "</center></html>", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(50, 50, 50));
        card.add(label, BorderLayout.CENTER);
        card.setPreferredSize(new Dimension(120, 50));
        return card;
    }

    private JPanel createListWithHeader(String title, String[] data) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(242, 242, 242));

        JLabel header = new JLabel(title, SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(new Color(57, 157, 255));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBorder(new EmptyBorder(5, 5, 5, 5));

        JList<String> list = new JList<>(data);
        list.setFont(new Font("Arial", Font.PLAIN, 14));
        list.setSelectionBackground(new Color(189, 224, 254));
        list.setBackground(Color.WHITE);
        list.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panel.add(header, BorderLayout.NORTH);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        return panel;
    }
}
