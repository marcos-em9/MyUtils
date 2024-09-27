import java.lang.reflect.Array;
import java.util.Arrays;

public class Utils {

    public static <T> void show(T dato) {
        if (dato == null) {
            System.out.println("null");
        } else if (dato.getClass().isArray()) {
            System.out.println(arrayToString(dato));
        } else {
            System.out.println(dato);
        }
    }

    // Función recursiva para manejar arrays multidimensionales
    private static String arrayToString(Object array) {
        if (!array.getClass().isArray()) {
            return String.valueOf(array);
        }

        int length = Array.getLength(array);
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object element = Array.get(array, i);
            // Llamada recursiva en caso de que el elemento sea un array
            sb.append(arrayToString(element));
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Pruebas con tipos simples
        show(1);                         // Salida: 1
        show("hola");                     // Salida: hola

        // Pruebas con arrays unidimensionales
        show(new int[]{1, 2, 3});         // Salida: {1, 2, 3}
        show(new char[]{'a', 'b', 'c'});  // Salida: {a, b, c}
        show(new boolean[]{true, false}); // Salida: {true, false}

        // Pruebas con arrays multidimensionales
        show(new int[][]{{1, 2}, {3, 4}});    // Salida: {{1, 2}, {3, 4}}
        show(new String[][]{{"a", "b"}, {"c", "d"}}); // Salida: {{a, b}, {c, d}}

        // Prueba con arrays complejos
        show(new Object[]{1, new int[]{2, 3}, "texto"}); // Salida: {1, {2, 3}, texto}
    }
}
