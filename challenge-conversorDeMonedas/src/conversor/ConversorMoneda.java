package src.conversor;

import java.text.DecimalFormat;

public class ConversorMoneda {

    // Tipo de cambio 23/7/2023

    private static final double DOLAR_A_PESO = 269.24; // Tasa de cambio real (1 Dólar = 269.42 Pesos argentinos)
    private static final double EURO_A_PESO = 299.76;  // Tasa de cambio real (1 Euro = 322.86 Pesos argentinos)
    private static final double LIBRA_A_PESO = 346.14; // Tasa de cambio real (1 Libra = 404.71 Pesos argentinos)
    private static final double YEN_A_PESO = 1.90;   // Tasa de cambio real (1 Yen = 0.08 Pesos argentinos)
    private static final double WON_A_PESO = 0.21;  // Tasa de cambio real (1 Won = 0.006 Pesos argentinos)

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) {
        switch (monedaOrigen.toLowerCase()) {
            case "peso":
                return convertirDesdePeso(cantidad, monedaDestino);
            case "dolar":
            case "dólar":
                return convertirADolar(cantidad, monedaDestino);
            case "euro":
                return convertirAEuro(cantidad, monedaDestino);
            case "libra":
                return convertirALibra(cantidad, monedaDestino);
            case "yen":
                return convertirAYen(cantidad, monedaDestino);
            case "won":
                return convertirAWon(cantidad, monedaDestino);
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }

    private static double convertirDesdePeso(double cantidad, String monedaDestino) {
        switch (monedaDestino.toLowerCase()) {
            case "dolar":
            case "dólar":
                return Double.parseDouble(df.format(cantidad / DOLAR_A_PESO));
            case "euro":
                return Double.parseDouble(df.format(cantidad / EURO_A_PESO));
            case "libra":
                return Double.parseDouble(df.format(cantidad / LIBRA_A_PESO));
            case "yen":
                return Double.parseDouble(df.format(cantidad / YEN_A_PESO));
            case "won":
                return Double.parseDouble(df.format(cantidad / WON_A_PESO));
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }

    private static double convertirADolar(double cantidad, String monedaDestino) {
        switch (monedaDestino.toLowerCase()) {
            case "peso":
                return Double.parseDouble(df.format(cantidad * DOLAR_A_PESO));
            case "euro":
                return Double.parseDouble(df.format(cantidad * DOLAR_A_PESO / EURO_A_PESO));
            case "libra":
                return Double.parseDouble(df.format(cantidad * DOLAR_A_PESO / LIBRA_A_PESO));
            case "yen":
                return Double.parseDouble(df.format(cantidad * DOLAR_A_PESO / YEN_A_PESO));
            case "won":
                return Double.parseDouble(df.format(cantidad * DOLAR_A_PESO / WON_A_PESO));
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }

     private static double convertirAEuro(double cantidad, String monedaDestino) {
        switch (monedaDestino.toLowerCase()) {
            case "peso":
                return Double.parseDouble(df.format(cantidad / EURO_A_PESO));
            case "dolar":
            case "dólar":
                return Double.parseDouble(df.format(cantidad * EURO_A_PESO / DOLAR_A_PESO));
            case "libra":
                return Double.parseDouble(df.format(cantidad * EURO_A_PESO / LIBRA_A_PESO));
            case "yen":
                return Double.parseDouble(df.format(cantidad * EURO_A_PESO / YEN_A_PESO));
            case "won":
                return Double.parseDouble(df.format(cantidad * EURO_A_PESO / WON_A_PESO));
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }

    private static double convertirALibra(double cantidad, String monedaDestino) {
        switch (monedaDestino.toLowerCase()) {
            case "peso":
                return Double.parseDouble(df.format(cantidad / LIBRA_A_PESO));
            case "dolar":
            case "dólar":
                return Double.parseDouble(df.format(cantidad * LIBRA_A_PESO / DOLAR_A_PESO));
            case "euro":
                return Double.parseDouble(df.format(cantidad * LIBRA_A_PESO / EURO_A_PESO));
            case "yen":
                return Double.parseDouble(df.format(cantidad * LIBRA_A_PESO / YEN_A_PESO));
            case "won":
                return Double.parseDouble(df.format(cantidad * LIBRA_A_PESO / WON_A_PESO));
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }

    private static double convertirAYen(double cantidad, String monedaDestino) {
        switch (monedaDestino.toLowerCase()) {
            case "peso":
                return Double.parseDouble(df.format(cantidad / YEN_A_PESO));
            case "dolar":
            case "dólar":
                return Double.parseDouble(df.format(cantidad * YEN_A_PESO / DOLAR_A_PESO));
            case "euro":
                return Double.parseDouble(df.format(cantidad * YEN_A_PESO / EURO_A_PESO));
            case "libra":
                return Double.parseDouble(df.format(cantidad * YEN_A_PESO / LIBRA_A_PESO));
            case "won":
                return Double.parseDouble(df.format(cantidad * YEN_A_PESO / WON_A_PESO));
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }

    private static double convertirAWon(double cantidad, String monedaDestino) {
        switch (monedaDestino.toLowerCase()) {
            case "peso":
                return Double.parseDouble(df.format(cantidad / WON_A_PESO));
            case "dolar":
            case "dólar":
                return Double.parseDouble(df.format(cantidad * WON_A_PESO / DOLAR_A_PESO));
            case "euro":
                return Double.parseDouble(df.format(cantidad * WON_A_PESO / EURO_A_PESO));
            case "libra":
                return Double.parseDouble(df.format(cantidad * WON_A_PESO / LIBRA_A_PESO));
            case "yen":
                return Double.parseDouble(df.format(cantidad * WON_A_PESO / YEN_A_PESO));
            default:
                throw new IllegalArgumentException("Moneda no válida");
        }
    }
}
