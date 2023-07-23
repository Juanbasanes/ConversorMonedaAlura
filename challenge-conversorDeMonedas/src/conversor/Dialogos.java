package src.conversor;

import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dialogos {

    // Lista de opciones en el menú de conversion y retorno de la opcion elegida
    public static int mostrarMenu() {
        String[] opciones = {"Conversor de Monedas", "Conversor de Distancia", "Conversor de Temperatura"};
        List<String> opcionesList = Arrays.asList(opciones);

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversión:", "Menú de Conversión",
                JOptionPane.QUESTION_MESSAGE, null, opcionesList.toArray(), opcionesList.get(0));

        return opcionesList.indexOf(seleccion);
    }

    // Habilita a mostrar un mensaje en un cuadro de dialogo
    private static void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    // Muestra un mensaje de error en un cuadro de dialogo
    public static void mostrarMensajeError(String mensaje) {
        mostrarMensaje(mensaje, "Error");
    }

    // Informa la salida del programa y termina la ejecucion
    public static void informarSalida(String mensaje) {
        mostrarMensaje(mensaje, "Mensaje");
        System.exit(0);
    }

    // Pregunta al usuario si desea realizar otra conversion, si este elige no o cancelar se cierra el programa y se activa informarSalida()
    public static boolean confirmarNuevaConversion() {
        int opcion = JOptionPane.showOptionDialog(null, "¿Desea realizar otra conversión?", "Mensaje",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Si", "No", "Cancelar"}, "Si");

        if (opcion == JOptionPane.NO_OPTION || opcion == JOptionPane.CANCEL_OPTION) {
            informarSalida("Programa Terminado.");
            return false;
        }
        Main.main(null); // En caso de seleccionar una opcion distinta a No o Cancelar (Si), volver al menu inicial
        return true;
    }

    // Obtiene una cantidad a convertir ingresada por el usuario
    public static Double obtenerCantidad(String conversor) {
        try {
            String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese el valor a convertir:", conversor, JOptionPane.QUESTION_MESSAGE);

            if (cantidadStr == null && !confirmarNuevaConversion()) {
                return null; // Si se seleccionó "Cancelar" y no se desea continuar, retornamos null
            }

            return Double.parseDouble(cantidadStr);
        } catch (NumberFormatException e) {
            mostrarMensajeError("Error: El valor ingresado no es un número válido. Por favor, ingrese un número.");
            return obtenerCantidad(conversor); // Llamamos nuevamente al método para obtener una nueva cantidad válida
        }
    }

    // Seleccion de moneda a convertir y filtro para que no pueda repetirse en la moneda destino
    public static String obtenerMoneda(String mensaje, String monedaExcluida) {
        String[] opciones = {"Peso", "Dólar", "Euro", "Libra", "Yen", "Won"};
        List<String> opcionesFiltradas = Arrays.stream(opciones)
                .filter(opcion -> !opcion.equalsIgnoreCase(monedaExcluida))
                .collect(Collectors.toList());

        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, "Moneda", JOptionPane.QUESTION_MESSAGE, null, opcionesFiltradas.toArray(), opcionesFiltradas.get(0));

        if (seleccion == null && !confirmarNuevaConversion()) {
            return null; // Si se selecciona cancelar no se continua
        }

        return seleccion;
    }

    // Seleccion de unidad de distancia a convertir y filtro para que no pueda repetirse en la unidad de distancia de destino
    public static String obtenerUnidadDistancia(String mensaje, String unidadExcluida) {
        String[] opciones = {"Metro", "Kilómetro", "Milla", "Centímetro", "Milímetro", "Pie", "Pulgada"};
        List<String> opcionesFiltradas = Arrays.stream(opciones)
                .filter(opcion -> !opcion.equalsIgnoreCase(unidadExcluida))
                .collect(Collectors.toList());

        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, "Unidad de Distancia", JOptionPane.QUESTION_MESSAGE, null, opcionesFiltradas.toArray(), opcionesFiltradas.get(0));

        if (seleccion == null && !confirmarNuevaConversion()) {
            return null; // Si se selecciona cancelar no se continua
        }

        return seleccion;
    }

    // Seleccion de escala de temperatura a convertir y filtro para que no pueda repetirse en la escala de temperatura de destino
    public static String obtenerEscalaTemperatura(String mensaje, String escalaExcluida) {
        String[] opciones = {"Celsius", "Fahrenheit", "Kelvin"};
        List<String> opcionesFiltradas = Arrays.stream(opciones)
                .filter(opcion -> !opcion.equalsIgnoreCase(escalaExcluida))
                .collect(Collectors.toList());

        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, "Escala de Temperatura", JOptionPane.QUESTION_MESSAGE, null, opcionesFiltradas.toArray(), opcionesFiltradas.get(0));

        if (seleccion == null && !confirmarNuevaConversion()) {
            return null; // Si se selecciona cancelar no se continua
        }

        return seleccion;
    }

    // Muestra el resultado de la conversion
    public static void mostrarResultado(String conversor, double cantidad, String unidadOrigen, String unidadDestino, double resultado) {
        String titulo = conversor;
        String mensaje = cantidad + " " + unidadOrigen + " equivale a " + resultado + " " + unidadDestino;

        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
