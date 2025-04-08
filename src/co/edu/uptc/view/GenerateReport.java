package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class GenerateReport extends JFrame {

    public GenerateReport() {
        super("Generar Reporte");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Panel de título
        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(30, 10, 20, 10));

        JLabel titleLabel = new JLabel("Digite la fecha de la que desea el reporte:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titlePanel.add(titleLabel);
        contentPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel del formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Etiqueta Fecha
        JLabel dateLabel = new JLabel("Fecha:");
        dateLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(dateLabel, gbc);

        // Campo de texto para la fecha
        JTextField dateField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(dateField, gbc);

        // Botón Generar Reporte
        JButton generateButton = new JButton("Generar Reporte");
        generateButton.setFont(new Font("Arial", Font.BOLD, 14));
        generateButton.setBackground(Color.LIGHT_GRAY);
        generateButton.setOpaque(true);
        generateButton.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(generateButton, gbc);

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);
        setVisible(true);
    }
}