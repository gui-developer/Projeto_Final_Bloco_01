package Model;

import java.util.Scanner;

public class Validacao {
    public static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("Entrada inválida! Por favor, digite um número inteiro.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}