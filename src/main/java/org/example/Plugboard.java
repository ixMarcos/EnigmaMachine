package org.example;

public class Plugboard {
    private int[] mapping;

    public Plugboard(int[] mapping) {
        this.mapping = mapping;
    }

    public int swap(int input) {
        return mapping[input];
    }

    public int[] getMapping() {
        return mapping;
    }
}
