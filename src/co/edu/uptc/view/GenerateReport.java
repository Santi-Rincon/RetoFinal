package co.edu.uptc.view;

import co.edu.uptc.model.Parking;
import co.edu.uptc.presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

        JLabel titleLabel = new JLabel("Digite la fecha de la que desea el reporte (yyyy-MM-dd):");
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
        generateButton.setBackground(new Color(57, 157, 255));
        generateButton.setForeground(Color.WHITE);
        generateButton.setOpaque(true);
        generateButton.setBorderPainted(false);
        generateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(generateButton, gbc);

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);

        // Acción al presionar el botón
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaTexto = dateField.getText().trim();
                if (fechaTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una fecha.", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    LocalDate fecha = LocalDate.parse("2025-04-08"); // yyyy-MM-dd
                    Parking parking = Presenter.getInstance().getParking();

                    if (parking != null) {
                        new Report(fecha, parking);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un parqueadero registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
