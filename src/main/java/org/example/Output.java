package org.example;

public class Output {
    private StringBuilder text;

    public Output() {
        text = new StringBuilder();
    }

    public void append(int numeric) {
        text.append((char) (numeric + 'A'));
    }

    public String getText() {
        return text.toString();
    }
}
