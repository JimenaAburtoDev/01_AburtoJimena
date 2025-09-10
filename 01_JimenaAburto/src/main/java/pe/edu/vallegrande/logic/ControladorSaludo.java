package pe.edu.vallegrande.logic;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControladorSaludo {

    public static void mostrarSaludo(JFrame ventana) {
        ResourceBundle mensajes = ResourceBundle.getBundle("Mensajes", Locale.getDefault());

        String nombre = JOptionPane.showInputDialog(ventana, mensajes.getString("input"));
        if (nombre != null && !nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(ventana, mensajes.getString("saludo") + " " + nombre + "! ¡Buen trabajo!");
        } else {
            JOptionPane.showMessageDialog(ventana, mensajes.getString("error"));
        }
    }
}