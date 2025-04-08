package co.edu.uptc.view;

import java.awt.*;
import javax.swing.*;

public class RegisterParking extends JFrame {

    public RegisterParking() {
        super("Registro de Parking");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Fila 0: Nombre Parqueadero
        JLabel parkingName = new JLabel("Nombre Parqueadero:");
        parkingName.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        formPanel.add(parkingName, gbc);

        JTextField parkingText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        formPanel.add(parkingText, gbc);

        // Fila 1: Dirección
        JLabel direction = new JLabel("Dirección:");
        direction.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        formPanel.add(direction, gbc);

        JTextField directionText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        formPanel.add(directionText, gbc);

        // Fila 2: Espacios disponibles
        JLabel availableSpaces = new JLabel("Espacios Disponibles:");
        availableSpaces.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        formPanel.add(availableSpaces, gbc);

        JTextField availableSpacesText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.7;
        formPanel.add(availableSpacesText, gbc);

        // Fila 3: Horario de Atención
        JLabel openingHours = new JLabel("Horario De Atención:");
        openingHours.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        formPanel.add(openingHours, gbc);

        JComboBox<String> openingHoursCombo = new JComboBox<>(new String[]{"Lunes a Viernes", "Fines de semana", "Todos los días"});
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.7;
        formPanel.add(openingHoursCombo, gbc);

        // Fila 4: Hora de Inicio
        JLabel initialHours = new JLabel("Hora De Inicio:");
        initialHours.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.3;
        formPanel.add(initialHours, gbc);

        JComboBox<String> initialHoursCombo = new JComboBox<>(new String[]{"6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM"});
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.7;
        formPanel.add(initialHoursCombo, gbc);

        // Fila 5: Botón Registrar
        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setOpaque(true);
        registerButton.setBorderPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        formPanel.add(registerButton, gbc);

        // Acción del botón
        registerButton.addActionListener(e -> {
            showConfirmationPane();
        });

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);
        setVisible(true);
    }

    // Método que muestra el panel emergente
    public void showConfirmationPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Confirmación", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel);

        JLabel messageLabel = new JLabel("Parqueadero registrado con éxito", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);
        panel.add(Box.createVerticalStrut(10));

        Object[] options = { createButton("Aceptar") };

        JOptionPane.showOptionDialog(
            this,
            panel,
            "",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(Color.LIGHT_GRAY);
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }
}