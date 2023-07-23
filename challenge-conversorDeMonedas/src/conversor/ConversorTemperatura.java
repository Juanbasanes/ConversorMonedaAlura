package src.conversor;

import java.text.DecimalFormat;

public class ConversorTemperatura {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static double convertirTemperatura(double cantidad, String escalaOrigen, String escalaDestino) {
        switch (escalaOrigen.toLowerCase()) {
            case "celsius":
                return convertirDesdeCelsius(cantidad, escalaDestino.toLowerCase());
            case "fahrenheit":
                return convertirDesdeFahrenheit(cantidad, escalaDestino.toLowerCase());
            case "kelvin":
                return convertirDesdeKelvin(cantidad, escalaDestino.toLowerCase());
            default:
                throw new IllegalArgumentException("Escala de temperatura no válida");
        }
    }

    private static double convertirDesdeCelsius(double cantidad, String escalaDestino) {
        switch (escalaDestino) {
            case "celsius":
                return cantidad;
            case "fahrenheit":
                return Double.parseDouble(df.format((cantidad * 9 / 5) + 32));
            case "kelvin":
                return Double.parseDouble(df.format(cantidad + 273.15));
            default:
                throw new IllegalArgumentException("Escala de temperatura de destino no válida");
        }
    }

    private static double convertirDesdeFahrenheit(double cantidad, String escalaDestino) {
        switch (escalaDestino) {
            case "celsius":
                return Double.parseDouble(df.format((cantidad - 32) * 5 / 9));
            case "fahrenheit":
                return cantidad;
            case "kelvin":
                return Double.parseDouble(df.format((cantidad + 459.67) * 5 / 9));
            default:
                throw new IllegalArgumentException("Escala de temperatura de destino no válida");
        }
    }

    private static double convertirDesdeKelvin(double cantidad, String escalaDestino) {
        switch (escalaDestino) {
            case "celsius":
                return Double.parseDouble(df.format(cantidad - 273.15));
            case "fahrenheit":
                return Double.parseDouble(df.format(cantidad * 9 / 5 - 459.67));
            case "kelvin":
                return cantidad;
            default:
                throw new IllegalArgumentException("Escala de temperatura de destino no válida");
        }
    }
}
