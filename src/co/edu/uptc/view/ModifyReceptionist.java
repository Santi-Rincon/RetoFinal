package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

        // Título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(30, 10, 20, 10));

        JLabel titleLabel = new JLabel("Digite las nuevas credenciales del usuario recepcionista:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        contentPanel.add(titlePanel, BorderLayout.NORTH);

        // Formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Fila 0: C.C
        JLabel ccLabel = new JLabel("C.C:");
        ccLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        formPanel.add(ccLabel, gbc);

        JTextField ccField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        formPanel.add(ccField, gbc);

        // Fila 1: Nueva contraseña
        JLabel newPassLabel = new JLabel("Nueva Contraseña:");
        newPassLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(newPassLabel, gbc);

        JPasswordField newPassField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(newPassField, gbc);

        // Fila 2: Repetir nueva contraseña
        JLabel repeatPassLabel = new JLabel("Repetir Nueva Contraseña:");
        repeatPassLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(repeatPassLabel, gbc);

        JPasswordField repeatPassField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(repeatPassField, gbc);

        // Advertencia (fila 3)
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
        gbc.weightx = 1.0;
        formPanel.add(warningLabel, gbc);

        // Botón modificar (fila 4)
        JButton modifyButton = new JButton("Modificar");
        modifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        modifyButton.setBackground(Color.LIGHT_GRAY);
        modifyButton.setOpaque(true);
        modifyButton.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(modifyButton, gbc);

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);
        setVisible(true);

        modifyButton.addActionListener(e -> {
            String cc = ccField.getText().trim();
            String newPass = new String(newPassField.getPassword()).trim();
            String repeatPass = new String(repeatPassField.getPassword()).trim();

            // Validación de campos
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
