package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.presenter.Presenter;

public class ModifyReceptionist extends JFrame {

    public ModifyReceptionist() {
        super("Modificar Recepcionista");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Panel superior: Volver + Título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(20, 10, 10, 10));

        // Botón Volver
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("← Volver");
        backButton.setFont(new Font("Arial", Font.PLAIN, 13));
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButtonPanel.add(backButton);
        topPanel.add(backButtonPanel, BorderLayout.WEST);

        // Título
        JLabel titleLabel = new JLabel("Digite las nuevas credenciales del usuario recepcionista:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Resto del código: formulario y lógica
        // (Todo lo que ya tenías desde la creación del formPanel y más abajo)

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel ccLabel = new JLabel("C.C:");
        ccLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        formPanel.add(ccLabel, gbc);

        JTextField ccField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(ccField, gbc);

        JLabel newPassLabel = new JLabel("Nueva Contraseña:");
        newPassLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(newPassLabel, gbc);

        JPasswordField newPassField = new JPasswordField(15);
        gbc.gridx = 1;
        formPanel.add(newPassField, gbc);

        JLabel repeatPassLabel = new JLabel("Repetir Nueva Contraseña:");
        repeatPassLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(repeatPassLabel, gbc);

        JPasswordField repeatPassField = new JPasswordField(15);
        gbc.gridx = 1;
        formPanel.add(repeatPassField, gbc);

        JLabel warningLabel = new JLabel("<html><div style='text-align: center;'>"
                + "Tenga en cuenta que la nueva contraseña no debe ser repetida,<br>"
                + "ni tener caracteres especiales y debe ser de 8 dígitos."
                + "</div></html>");
        warningLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        warningLabel.setForeground(Color.DARK_GRAY);
        warningLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(warningLabel, gbc);

        JButton modifyButton = new JButton("Modificar");
        modifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        modifyButton.setBackground(Color.LIGHT_GRAY);
        modifyButton.setOpaque(true);
        modifyButton.setBorderPainted(false);

        gbc.gridy = 4;
        formPanel.add(modifyButton, gbc);

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);
        setVisible(true);

        // Acción del botón Volver
        backButton.addActionListener(e -> {
            dispose();
            new AdminMenu();
        });

        // Acción del botón Modificar
        modifyButton.addActionListener(e -> {
            String cc = ccField.getText().trim();
            String newPass = new String(newPassField.getPassword()).trim();
            String repeatPass = new String(repeatPassField.getPassword()).trim();

            if (cc.isEmpty() || newPass.isEmpty() || repeatPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
                return;
            }

            if (!newPass.equals(repeatPass)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
                return;
            }

            boolean success = Presenter.getInstance().modifyRecepcionistCredentials(cc, newPass);

            if (success) {
                JOptionPane.showMessageDialog(this, "Contraseña modificada con éxito.");
                dispose();
                new AdminMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado. No se pudo modificar la contraseña.");
            }
        });
    }
}