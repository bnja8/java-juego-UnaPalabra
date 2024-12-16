import java.util.Scanner;

public class UnaPalabra {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "Benjamin";
        int vidasmax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < vidasmax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.print("Introduce una letra: ");

            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (Character.toLowerCase(palabraSecreta.charAt(i)) == letra) {
                    letrasAdivinadas[i] = palabraSecreta.charAt(i); // Usar la letra original
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (vidasmax - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Sin vidas. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }
}

