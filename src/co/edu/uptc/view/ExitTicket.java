package co.edu.uptc.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ExitTicket extends JFrame {

    public ExitTicket() {
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
                "Fecha de salida: DD/MM/AAAA\n" +
                "Hora de salida: hh:mm:ss\n\n" +
                "Recibo No. ###\n" +
                "Placa: ###-###\n\n" +
                "Valor del Servicio: $$$", centerStyle);
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

        JButton btnRegistrarPago = new JButton("Registrar Pago");
        btnRegistrarPago.setBackground(Color.LIGHT_GRAY);
        btnRegistrarPago.setFont(new Font("Arial", Font.BOLD, 13));

        JButton btnVolverMenu = new JButton("Volver al menú");
        btnVolverMenu.setBackground(Color.LIGHT_GRAY);
        btnVolverMenu.setFont(new Font("Arial", Font.BOLD, 13));

        buttonPanel.add(btnRegistrarPago);
        buttonPanel.add(btnVolverMenu);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panel.add(buttonPanel, gbc);

        add(panel);
        setVisible(true);
    }
}


