package org.exemple2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Criar os rotores
        Rotor rotor1 = new Rotor();
        rotor1.setWiring("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        rotor1.setNotchPosition(5);

        Rotor rotor2 = new Rotor();
        rotor2.setWiring("AJDKSIRUXBLHWTMCQGZNPYFVOE");
        rotor2.setNotchPosition(12);

        Rotor rotor3 = new Rotor();
        rotor3.setWiring("BDFHJLCPRTXVZNYEIWGAKMUSQO");
        rotor3.setNotchPosition(20);

        Rotor[] rotors = {rotor1, rotor2, rotor3};

        // Criar o plugboard
        Plugboard plugboard = new Plugboard();

        // Criar a máquina Enigma
        EnigmaMachine enigma = new EnigmaMachine(rotors, plugboard);

        // Configurar a posição inicial dos rotores
        int[] rotorPositions = {0, 0, 0};
        enigma.configureRotors(rotorPositions);

        // Configurar o plugboard
        enigma.configurePlugboard("AT BS DE FM IR KN LZ OW PV XY");

        // Opção de menu
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criptografar mensagem");
        System.out.println("2 - Decifrar mensagem");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer do teclado

        if (opcao == 1) {
            // Criptografar uma mensagem
            System.out.println("Digite a mensagem a ser criptografada:");
            String message = scanner.nextLine();

            String encryptedMessage = enigma.encryptMessage(message);

            System.out.println("Mensagem criptografada: " + encryptedMessage);
        } else if (opcao == 2) {
            // Decifrar uma mensagem
            System.out.println("Digite a mensagem a ser decifrada:");
            String message = scanner.nextLine();

            String decryptedMessage = enigma.decryptMessage(message);

            System.out.println("Mensagem decifrada: " + decryptedMessage);
        } else {
            System.out.println("Opção inválida!");
        }
    }

}
