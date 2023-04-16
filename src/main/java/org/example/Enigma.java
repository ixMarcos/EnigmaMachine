package org.example;

public class Enigma {
    private Rotor[] rotors;
    private Plugboard plugboard;

    public Enigma(Rotor[] rotors, Plugboard plugboard) {
        this.rotors = rotors;
        this.plugboard = plugboard;
    }

    public int encrypt(int input) {
        int output = input;
        if (plugboard != null) {
            if (input >= 0 && input < plugboard.getMapping().length) {
                output = plugboard.swap(output);
            }
        }
        for (Rotor rotor : rotors) {
            output = rotor.encrypt(output);
        }
        if (plugboard != null) {
            if (output >= 0 && output < plugboard.getMapping().length) {
                output = plugboard.swap(output);
            }
        }
        for (Rotor rotor : rotors) {
            if (rotor.rotate()) {
                break;
            }
        }
        return output;
    }

    public int decrypt(int input) {
        int output = input;
        if (plugboard != null) {
            if (input >= 0 && input < plugboard.getMapping().length) {
                output = plugboard.swap(output);
            }
        }
        for (int i = rotors.length - 1; i >= 0; i--) {
            output = rotors[i].decrypt(output);
        }
        if (plugboard != null) {
            if (output >= 0 && output < plugboard.getMapping().length) {
                output = plugboard.swap(output);
            }
        }
        for (int i = rotors.length - 1; i >= 0; i--) {
            if (rotors[i].rotate()) {
                break;
            }
        }
        return output;
    }


    public void reset() {
        for (Rotor rotor : rotors) {
            rotor.reset();
        }
    }

    public void setRotorSettings(int[] settings) {
        for (int i = 0; i < settings.length; i++) {
            rotors[i].setPosition(settings[i]);
        }
    }

    public void setPlugboard(Plugboard plugboard) {
        this.plugboard = plugboard;
    }
}
