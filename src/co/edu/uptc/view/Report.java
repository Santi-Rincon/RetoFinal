package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Report extends JFrame {

    public Report() {
        super("Reporte");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Panel superior con 3 tarjetas (cada una con un label)
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        topPanel.add(createCardLabel("Fecha"));
        topPanel.add(createCardLabel("Total Ingresos"));
        topPanel.add(createCardLabel("Total Vehículos Ingresados"));

        // Panel de listas con scroll
        JPanel listPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        listPanel.add(createListWithHeader("Nombre y Apellidos", new String[]{"Juan Pérez", "Ana Torres", "Carlos Ruiz"}));
        listPanel.add(createListWithHeader("Total Ingreso", new String[]{"$50000", "$40000", "$70000"}));
        listPanel.add(createListWithHeader("Total Vehículos", new String[]{"2", "1", "3"}));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Envolver topPanel y scrollPane en un panel con separación
        JPanel centerWrapper = new JPanel();
        centerWrapper.setLayout(new BoxLayout(centerWrapper, BoxLayout.Y_AXIS));
        centerWrapper.add(topPanel);
        centerWrapper.add(Box.createVerticalStrut(15)); // espacio entre labels y listas
        centerWrapper.add(scrollPane);

        contentPanel.add(centerWrapper, BorderLayout.CENTER);

        // Botón inferior
        JButton backButton = new JButton("Volver al menú");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setPreferredSize(new Dimension(160, 40));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        buttonPanel.add(backButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(contentPanel);
        setVisible(true);
    }

    // Método para crear tarjetas rectangulares con texto centrado
    private JPanel createCardLabel(String text) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        card.setBackground(Color.WHITE);
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        card.add(label, BorderLayout.CENTER);
        card.setPreferredSize(new Dimension(100, 40)); // <- altura más pequeña
        return card;
    }

    // Método para crear una lista con título y fondo gris
    private JPanel createListWithHeader(String title, String[] data) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel header = new JLabel(title, SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(Color.GRAY);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 13));
        header.setBorder(new EmptyBorder(5, 5, 5, 5));

        JList<String> list = new JList<>(data);
        list.setFont(new Font("Arial", Font.PLAIN, 13));

        panel.add(header, BorderLayout.NORTH);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        return panel;
    }
}