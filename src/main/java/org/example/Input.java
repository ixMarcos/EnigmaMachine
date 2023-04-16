package org.example;

public class Input {
    private String text;

    public Input(String text) {
        this.text = text;
    }

    public int[] getNumeric() {
        int[] numeric = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            numeric[i] = text.charAt(i) - 'A';
        }
        return numeric;
    }
}
