package src.conversor;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ConversorDistancia {
    private static final DecimalFormat df = new DecimalFormat("#.##");
    private static final Map<String, Double> unidades = new HashMap<>();

    static {
        unidades.put("metro", 1.0);
        unidades.put("kilómetro", 0.001);
        unidades.put("centímetro", 100.0);
        unidades.put("milímetro", 1000.0);
        unidades.put("milla", 0.000621371);
        unidades.put("pie", 3.28084);
        unidades.put("pulgada", 39.3701);
    }

    public static double convertirDistancia(double cantidad, String unidadOrigen, String unidadDestino) {
        double factorConversion = unidades.get(unidadDestino.toLowerCase()) / unidades.get(unidadOrigen.toLowerCase());
        double resultado = cantidad * factorConversion;
        return Double.parseDouble(df.format(resultado));
    }
}