package co.edu.uptc.view;

import co.edu.uptc.model.Parking;
import co.edu.uptc.model.Ticket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class Report extends JFrame {

    public Report(LocalDate fecha, Parking parking) {
        super("Reporte de Ventas 📊");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel principal
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(245, 248, 255));
        contentPanel.setLayout(new BorderLayout(20, 20));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("📅 Reporte del día: " + fecha);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Contenedor central (estadísticas + tabla)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(20, 20));
        centerPanel.setOpaque(false);

        // Sección de estadísticas
        JPanel statsPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        statsPanel.setOpaque(false);

        // Datos
        List<Ticket> tickets = parking.getTicketsDelDia(fecha);
        double totalIngresos = tickets.stream().mapToDouble(Ticket::getValue).sum();
        int totalVehiculos = tickets.size();

        statsPanel.add(createStatCard("💰 Ingresos totales", "$" + String.format("%.2f", totalIngresos)));
        statsPanel.add(createStatCard("🚗 Vehículos atendidos", String.valueOf(totalVehiculos)));

        centerPanel.add(statsPanel, BorderLayout.NORTH);

        // Tabla de detalles
        String[] columns = { "Placa", "Entrada", "Salida", "Valor", "Recepcionista" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Ticket t : tickets) {
            model.addRow(new Object[] {
                    t.getPlate(),
                    t.getEntryTime(),
                    t.getDepartureTime() != null ? t.getDepartureTime() : "En curso",
                    String.format("$%.2f", t.getValue()),
                    t.getRecepcionist()
            });
        }

        JTable table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setGridColor(new Color(220, 220, 220));
        table.setShowGrid(true);

        JScrollPane tableScroll = new JScrollPane(table);
        centerPanel.add(tableScroll, BorderLayout.CENTER);

        contentPanel.add(centerPanel, BorderLayout.CENTER);

        // Botón cerrar
        JButton closeButton = new JButton("Cerrar");
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        closeButton.setBackground(new Color(57, 157, 255));
        closeButton.setForeground(Color.WHITE);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.addActionListener(e -> {
            dispose();
            new AdminMenu();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(closeButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(contentPanel);
        setVisible(true);
    }

    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(15, 20, 15, 20)));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setForeground(Color.GRAY);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        valueLabel.setForeground(new Color(30, 30, 30));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }
}
