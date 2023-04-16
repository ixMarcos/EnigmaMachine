package org.example;

public class Rotor {
    private int[] wiring;
    private int position;

    public Rotor(int[] wiring, int position) {
        this.wiring = wiring;
        this.position = position;
    }

    public int encrypt(int input) {
        int index = (input + position) % 26;
        if (index < 0) {
            index += 26;
        }
        int output = wiring[index] - position;
        if (output < 0) {
            output += 26;
        }
        return output;
    }

    public int decrypt(int input) {
        int index = (input + position) % 26;
        if (index < 0) {
            index += 26;
        }
        int output = -1;
        if (wiring[(index + position) % 26] == input + position) {
            output = index - position;
        } else {
            for (int i = 0; i < wiring.length; i++) {
                if (wiring[i] == (index + position) % 26) {
                    output = i - position;
                    break;
                }
            }
        }
        if (output < 0) {
            output += 26;
        }
        return output;
    }

    public boolean rotate() {
        position = (position + 1) % 26;
        return position == 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void reset() {
        position = 0;
    }
}
