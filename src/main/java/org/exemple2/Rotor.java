package org.exemple2;

public class Rotor {
    private int position;
    private int[] wiring;
    private int notchPosition;

    public void setInitialPosition(int position) {
        this.position = position;
    }

    public void rotate() {
        position = (position + 1) % 26;
    }

    public int processForward(int input) {
        int offset = (input + position) % 26;
        int output = (wiring[offset] - position + 26) % 26;
        rotate();
        return output;
    }

    public int processBackward(int input) {
        int offset = (input + position) % 26;
        for (int i = 0; i < wiring.length; i++) {
            if ((wiring[i] - position + 26) % 26 == offset) {
                int output = (i - position + 26) % 26;
                rotate();
                return output;
            }
        }
        throw new IllegalArgumentException("Invalid input for rotor.");
    }

    // Example rotor wiring: "EKMFLGDQVZNTOWYHXUSPAIBRCJ"
    public void setWiring(String wiringString) {
        this.wiring = new int[26];
        for (int i = 0; i < wiringString.length(); i++) {
            int input = i;
            int output = wiringString.charAt(i) - 'A';
            wiring[input] = output;
        }
    }

    public void setNotchPosition(int notchPosition) {
        if (notchPosition < 0 || notchPosition > 25) {
            throw new IllegalArgumentException("Invalid notch position.");
        }
        this.notchPosition = notchPosition;
    }

    public boolean atNotch() {
        return position == notchPosition;
    }
}
