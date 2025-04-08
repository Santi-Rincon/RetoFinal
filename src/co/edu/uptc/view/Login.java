package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.presenter.Presenter;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheck;

    public Login() {
        super("Login");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con título
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Bienvenido al Sistema de Parking UPTC", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // Panel central con formulario
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo Usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel("Usuario:"), gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        centerPanel.add(usernameField, gbc);

        // Campo Contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(new JLabel("Contraseña:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        centerPanel.add(passwordField, gbc);

        // Checkbox para mostrar contraseña
        showPasswordCheck = new JCheckBox("Mostrar contraseña");
        showPasswordCheck.addActionListener(e -> {
            passwordField.setEchoChar(showPasswordCheck.isSelected() ? (char) 0 : '•');
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        centerPanel.add(showPasswordCheck, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior con botón
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(160, 40));

        bottomPanel.add(loginButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Acción por defecto al presionar Enter
        getRootPane().setDefaultButton(loginButton);

        // Acción del botón de login
        loginButton.addActionListener(e -> checkLogin());

        setVisible(true);
    }

    private void checkLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        Presenter presenter = Presenter.getInstance();

        if (presenter.login(username, password)) {
            String userType = presenter.getUserType(username);

            switch (userType) {
                case "Admin":
                    JOptionPane.showMessageDialog(this, "Bienvenido administrador.");
                    new AdminMenu();
                    break;
                case "Recepcionist":
                    JOptionPane.showMessageDialog(this, "Bienvenido recepcionista.");
                    // new RecepcionistMenu().setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Usuario válido, pero tipo no identificado.");
                    break;
            }

            dispose(); // Cerrar login
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }
}
