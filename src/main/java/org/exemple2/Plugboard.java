package org.exemple2;

public class Plugboard {
    private int[] mapping = new int[26];

    public void configure(String settings) {
        // Limpar mapeamento atual
        for (int i = 0; i < mapping.length; i++) {
            mapping[i] = i;
        }

        // Configurar novas conexões
        String[] pairs = settings.split(" ");
        for (String pair : pairs) {
            int from = pair.charAt(0) - 'A';
            int to = pair.charAt(1) - 'A';
            mapping[from] = to;
            mapping[to] = from;
        }
    }

    public int process(int input) {
        return mapping[input];
    }
}

