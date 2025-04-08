package co.edu.uptc.view;

import co.edu.uptc.presenter.Presenter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        super("Login");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior (título)
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Bienvenido Al Sistema De Parking Uptc", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setPreferredSize(new Dimension(0, 80));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // Panel central con formulario
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel formPanel = new JPanel(new GridBagLayout());

  
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Usuario:"), gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Contraseña:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        // Añadir formPanel al centro
        centerPanel.add(formPanel);
        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior con botón
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setFocusPainted(false);
        bottomPanel.add(loginButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Acción del botón de login
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

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
                        // Aquí iría: new RecepcionistMenu().setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Usuario válido, pero tipo no identificado.");
                        break;
                }

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        setVisible(true);
    }
}
