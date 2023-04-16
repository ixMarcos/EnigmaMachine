package org.exemple2;

public class EnigmaMachine {
    private Rotor[] rotors;
    private Plugboard plugboard;

    public EnigmaMachine(Rotor[] rotors, Plugboard plugboard) {
        this.rotors = rotors;
        this.plugboard = plugboard;
    }

    public void configureRotors(int[] rotorPositions) {
        for (int i = 0; i < rotorPositions.length; i++) {
            rotors[i].setInitialPosition(rotorPositions[i]);
        }
    }

    public void configurePlugboard(String plugboardSettings) {
        plugboard.configure(plugboardSettings);
    }

    public String encryptMessage(String message) {
        String result = "";
        for (char c : message.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int input = c - 'A';
                input = plugboard.process(input);
                for (Rotor rotor : rotors) {
                    input = rotor.processForward(input);
                }
                input = (input + 26) % 26;
                input = plugboard.process(input);
                result += (char) (input + 'A');
                rotateRotors();
            } else {
                result += c;
            }
        }
        return result;
    }

    public String decryptMessage(String message) {
        String result = "";
        for (char c : message.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int input = c - 'A';
                input = plugboard.process(input);
                for (int i = rotors.length - 1; i >= 0; i--) {
                    input = rotors[i].processBackward(input);
                }
                input = (input + 26) % 26;
                input = plugboard.process(input);
                result += (char) (input + 'A');
                rotateRotors();
            } else {
                result += c;
            }
        }
        return result;
    }

    private void rotateRotors() {
        for (int i = rotors.length - 1; i >= 0; i--) {
            if (rotors[i].atNotch()) {
                if (i == 0) {
                    rotors[rotors.length - 1].rotate();
                } else {
                    rotors[i - 1].rotate();
                }
            }
            rotors[i].rotate();
        }
    }
}

