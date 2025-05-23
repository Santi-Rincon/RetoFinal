package co.edu.uptc.view;

import co.edu.uptc.model.Schedule;
import co.edu.uptc.presenter.Presenter;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterParking extends JFrame {

    public RegisterParking() {
        super("Registro de Parking");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(30, 10, 20, 10));

        JButton backButton = new JButton("← Volver");
        backButton.setFont(new Font("Arial", Font.BOLD, 12));
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(e -> {
            dispose();
            new AdminMenu();
        });

        titlePanel.add(backButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Digite los siguientes datos para registrar un parqueadero:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

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

        JComboBox<String> openingHoursCombo = new JComboBox<>(
                new String[] { "Lunes a Viernes", "Fines de semana", "Todos los días" });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.7;
        formPanel.add(openingHoursCombo, gbc);

        JLabel initialHours = new JLabel("Hora De Inicio:");
        initialHours.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.3;
        formPanel.add(initialHours, gbc);

        JComboBox<String> initialHoursCombo = new JComboBox<>(
                new String[] { "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM" });
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.7;
        formPanel.add(initialHoursCombo, gbc);

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

        registerButton.addActionListener(e -> {
            String name = parkingText.getText();
            String address = directionText.getText();
            int spaces;

            try {
                spaces = Integer.parseInt(availableSpacesText.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido en 'Espacios Disponibles'.");
                return;
            }

            String days = (String) openingHoursCombo.getSelectedItem();
            String startHour = (String) initialHoursCombo.getSelectedItem();

            // Creamos un Schedule simple
            Schedule[] schedules = new Schedule[1];
            schedules[0] = new Schedule(days, startHour, "6:00 PM");

            // Llamamos al Presenter para registrar
            Presenter.getInstance().registerParking(name, address, spaces, schedules);

            showConfirmationPane(); // Muestra confirmación y reinicia ventana
        });

        contentPanel.add(titlePanel, BorderLayout.NORTH);
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

        JButton acceptButton = createButton("Aceptar");

        acceptButton.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            dispose();
            new RegisterParking();
        });

        Object[] options = { acceptButton };

        JOptionPane.showOptionDialog(
                this,
                panel,
                "Confirmación",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
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
