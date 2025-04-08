package co.edu.uptc.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import co.edu.uptc.presenter.Presenter;

public class CreateReceptionist extends JFrame {

    private Presenter presenter = Presenter.getInstance();

    private JTextField ccField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public CreateReceptionist() {
        super("Crear Recepcionista");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Panel para el título
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

        JLabel titleLabel = new JLabel("Digite los siguientes datos para crear un usuario recepcionista:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        contentPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Campos
        ccField = addFormRow("C.C:", formPanel, gbc, 0, labelFont);
        nameField = addFormRow("Nombres:", formPanel, gbc, 1, labelFont);
        surnameField = addFormRow("Apellidos:", formPanel, gbc, 2, labelFont);
        phoneField = addFormRow("Teléfono:", formPanel, gbc, 3, labelFont);
        addressField = addFormRow("Dirección:", formPanel, gbc, 4, labelFont);
        emailField = addFormRow("E-mail:", formPanel, gbc, 5, labelFont);
        passwordField = new JPasswordField(15);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        // Botón Agregar
        JButton addButton = new JButton("Agregar");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(addButton, gbc);

        addButton.addActionListener(e -> {
            if (validarCampos()) {
                String usuario = ccField.getText();
                String nombres = nameField.getText();
                String apellidos = surnameField.getText();
                String telefono = phoneField.getText();
                String direccion = addressField.getText();
                String email = emailField.getText();
                String contraseña = new String(passwordField.getPassword());

                boolean creado = presenter.crearRecepcionista(usuario, nombres, apellidos, telefono, direccion, email, contraseña);

                if (creado) {
                    showConfirmationPane();
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe un usuario con esa C.C o correo.",
                            "Usuario duplicado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.",
                        "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            }
        });

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);
        setVisible(true);
    }

    private JTextField addFormRow(String labelText, JPanel panel, GridBagConstraints gbc, int y, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(label, gbc);

        JTextField textField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(textField, gbc);
        return textField;
    }

    private boolean validarCampos() {
        return !ccField.getText().trim().isEmpty()
            && !nameField.getText().trim().isEmpty()
            && !surnameField.getText().trim().isEmpty()
            && !phoneField.getText().trim().isEmpty()
            && !addressField.getText().trim().isEmpty()
            && !emailField.getText().trim().isEmpty()
            && passwordField.getPassword().length > 0;
    }

    private void limpiarCampos() {
        ccField.setText("");
        nameField.setText("");
        surnameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }

    private void showConfirmationPane() {
        String message = "<html><div style='text-align: center;'>Se ha enviado el correo al usuario recepcionista<br>con las credenciales de acceso!</div></html>";
        Object[] options = {"Aceptar", "Aceptar y volver al menú"};

        int result = JOptionPane.showOptionDialog(
                this,
                message,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (result == JOptionPane.YES_OPTION) {
            limpiarCampos();
        } else if (result == JOptionPane.NO_OPTION) {
            dispose();
            new AdminMenu();
        }
    }
}
