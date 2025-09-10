package pe.edu.vallegrande.logic;

import pe.edu.vallegrande.logic.ControladorSaludo;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class VentanaPrincipal {

    public static void mostrar() {
        // 1) Look & Feel Nimbus y ajuste de colores (tema azul noche)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            // Personalizar colores para un "blue night" look (opcional)
            UIManager.put("control", new Color(20, 24, 34));
            UIManager.put("info", new Color(20, 24, 34));
            UIManager.put("nimbusBase", new Color(10, 45, 80));
            UIManager.put("nimbusBlueGrey", new Color(30, 60, 90));
            UIManager.put("controlText", Color.WHITE);
            UIManager.put("text", Color.WHITE);
            UIManager.put("nimbusLightBackground", new Color(20, 24, 34));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2) Cargar bundle (idioma del sistema)
        ResourceBundle mensajes = ResourceBundle.getBundle("Mensajes", Locale.getDefault());

        // 3) Crear ventana
        JFrame ventana = new JFrame(mensajes.getString("titulo"));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 200);
        ventana.setLocationRelativeTo(null);

        // 4) Ícono (desde resources)
        try {
            ImageIcon icono = new ImageIcon(VentanaPrincipal.class.getClassLoader().getResource("icono.png"));
            if (icono != null) {
                ventana.setIconImage(icono.getImage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 5) Interfaz simple: botón para saludar
        JButton btnSaludar = new JButton(mensajes.getString("boton.saludar"));
        btnSaludar.addActionListener(e -> ControladorSaludo.mostrarSaludo(ventana));

        // 6) Menú ejemplo (con texto internacionalizado)
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu(mensajes.getString("menu.utiles"));
        menuBar.add(menu);
        ventana.setJMenuBar(menuBar);

        // 7) Layout
        JPanel content = new JPanel();
        content.setOpaque(false); // para que Nimbus muestre el color custom
        content.add(btnSaludar);
        ventana.setContentPane(content);

        ventana.setVisible(true);
    }

    // main para pruebas
    public static void main(String[] args) {
        // Opcional: forzar idioma para pruebas
        // Locale.setDefault(new Locale("es","PE"));
        SwingUtilities.invokeLater(VentanaPrincipal::mostrar);
    }
}