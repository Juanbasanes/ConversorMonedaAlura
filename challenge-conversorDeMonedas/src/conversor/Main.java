package src.conversor;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int opcionMenu = Dialogos.mostrarMenu();

            switch (opcionMenu) {
                case 0:
                    convertirMoneda();
                    break;
                case 1:
                    convertirDistancia();
                    break;
                case 2:
                    convertirTemperatura();
                    break;
                default:
                    // No es necesario en "do-while"
                    break;
            }

            if (!Dialogos.confirmarNuevaConversion()) {
                break;
            }
        }
    }

    // Conversion de moneda
    private static void convertirMoneda() {
        // Obtener la cantidad a convertir desde el usuario
        double cantidad = Dialogos.obtenerCantidad("Conversor de Moneda");
        if (cantidad != -1) {
            // Obtener las monedas de origen y destino
            String monedaOrigen = Dialogos.obtenerMoneda("Seleccione la moneda de origen:", "");
            String monedaDestino = Dialogos.obtenerMoneda("Seleccione la moneda de destino:", monedaOrigen);
            // Realizar la conversion y obtener el resultado
            double resultado = ConversorMoneda.convertirMoneda(cantidad, monedaOrigen, monedaDestino);
            // Mostrar resultado
            Dialogos.mostrarResultado("Conversión de Moneda", cantidad, monedaOrigen, monedaDestino, resultado);
        }
    }

    // Conversion de distancia
    private static void convertirDistancia() {
        // Obtener la cantidad a convertir
        double cantidad = Dialogos.obtenerCantidad("Conversor de Distancia");
        if (cantidad != -1) {
            // Obtener las unidades de distancia de origen y destino
            String unidadOrigen = Dialogos.obtenerUnidadDistancia("Seleccione la unidad de distancia de origen:", "");
            String unidadDestino = Dialogos.obtenerUnidadDistancia("Seleccione la unidad de distancia de destino:", unidadOrigen);
            // Realizar la conversion y obtener el resultado
            double resultado = ConversorDistancia.convertirDistancia(cantidad, unidadOrigen, unidadDestino);
            // Mostrar resultado
            Dialogos.mostrarResultado("Conversión de Distancia", cantidad, unidadOrigen, unidadDestino, resultado);
        }
    }

    // Conversion de temperatura
    private static void convertirTemperatura() {
        // Obtener la cantidad a convertir 
        double cantidad = Dialogos.obtenerCantidad("Conversor de Temperatura");
        if (cantidad != -1) {
            // Obtener las escalas de temperatura de origen y destino
            String escalaOrigen = Dialogos.obtenerEscalaTemperatura("Seleccione la escala de temperatura de origen:", "");
            String escalaDestino = Dialogos.obtenerEscalaTemperatura("Seleccione la escala de temperatura de destino:", escalaOrigen);
            // Realizar la conversion y obtener el resultado
            double resultado = ConversorTemperatura.convertirTemperatura(cantidad, escalaOrigen, escalaDestino);
            // Mostrar resultado 
            Dialogos.mostrarResultado("Conversión de Temperatura", cantidad, escalaOrigen, escalaDestino, resultado);
        }
    }
}
