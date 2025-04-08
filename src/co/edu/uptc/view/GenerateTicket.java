package co.edu.uptc.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class GenerateTicket extends JFrame {

    public GenerateTicket() {
        super("Generar Ticket");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Crear el JTextPane y aplicar estilos
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);

        // Estilo de texto centrado y en negrita
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet centerStyle = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerStyle, StyleConstants.ALIGN_CENTER);
        StyleConstants.setBold(centerStyle, true);
        StyleConstants.setFontSize(centerStyle, 14);
        StyleConstants.setFontFamily(centerStyle, "SansSerif");

        try {
            doc.insertString(doc.getLength(),
                "ParkingUPTC.\n\n" +
                "Avenida Central del Norte 39-115. Tunja, Boyacá.\n\n" +
                "Fecha de ingreso: DD/MM/AAAA\n" +
                "Hora de ingreso: hh:mm:ss\n\n" +
                "Recibo No. ###\n" +
                "Placa: ###-###", centerStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        doc.setParagraphAttributes(0, doc.getLength(), centerStyle, false);

        JScrollPane scrollPane = new JScrollPane(textPane);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setBackground(Color.LIGHT_GRAY);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.setBackground(Color.LIGHT_GRAY);

        // Acción del botón Imprimir: mostrar el pane
        btnImprimir.addActionListener(e -> {
            Pane(); // <-- Aquí llamas al método que no estaba siendo ejecutado
        });

        buttonPanel.add(btnImprimir);
        buttonPanel.add(btnVolver);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panel.add(buttonPanel, gbc);

        add(panel);
        setVisible(true);
    }

    public void Pane() {
        // Panel principal con diseño vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Alerta", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel);

        JLabel messageLabel = new JLabel("Imprimiendo...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);
        panel.add(Box.createVerticalStrut(10));

        Object[] options = {
            createButton("Aceptar"),
            createButton("Cancelar")
        };

        int result = JOptionPane.showOptionDialog(
                this,  // usar `this` para centrarlo en el frame actual
                panel,
                "", // Título del cuadro
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (result == 0) {
            System.out.println("Aceptar presionado");
        } else if (result == 1) {
            System.out.println("Cancelar presionado");
        }
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(Color.LIGHT_GRAY);
        return button;
    }
}