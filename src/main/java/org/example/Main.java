package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] rotor1Wiring = {4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9};
        int[] rotor2Wiring = {0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4};
        int[] rotor3Wiring = {1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14};

        int[] plugboardMapping = {1, 3, 5, 7, 9, 11, 2, 15, 17, 19};
        Rotor[] rotors = {new Rotor(rotor1Wiring, 5), new Rotor(rotor2Wiring, 12), new Rotor(rotor3Wiring, 3)};
        Plugboard plugboard = new Plugboard(plugboardMapping);
        Enigma enigma = new Enigma(rotors, plugboard);


        String message = "AGI";
        Input input = new Input(message);
        int[] numeric = input.getNumeric();
        Output output = new Output();

        // Encripta a mensagem
        for (int i = 0; i < numeric.length; i++) {
            int encrypted = enigma.encrypt(numeric[i]);
            output.append(encrypted);
        }
        String encryptedMessage = output.getText();
        System.out.println("Mensagem criptografada: " + encryptedMessage);

        // Decripta a mensagem
        enigma.reset();

        input = new Input(encryptedMessage);
        numeric = input.getNumeric();
        output = new Output();
        for (int i = 0; i < numeric.length; i++) {
            int decrypted = enigma.decrypt(numeric[i]);
            output.append(decrypted);
        }
        String decryptedMessage = output.getText();
        System.out.println("Mensagem descriptografada: " + decryptedMessage);
    }
}
