package TP3;

import java.util.Arrays;

public class Hopfield {
    private int[][] pesos;
    private int n;

    public Hopfield(int n) {
        this.n = n;
        this.pesos = new int[n][n];
    }

    public void entrenar(int[] patron) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    pesos[i][j] += patron[i] * patron[j];
                }
            }
        }
    }

    public int[] recuperar(int[] entrada) {
        int[] salida = Arrays.copyOf(entrada, entrada.length);

        for (int i = 0; i < n; i++) {
            int suma = 0;
            for (int j = 0; j < n; j++) {
                suma += pesos[i][j] * entrada[j];
            }
            salida[i] = suma >= 0 ? 1 : -1;
        }

        return salida;
    }

    public static void main(String[] args) {
        int[] patron = {1, -1, 1, -1, 1, -1, 1, -1, 1};

        Hopfield red = new Hopfield(patron.length);

        red.entrenar(patron);

        int[] entradaConRuido = {1, -1, 1, 1, -1, -1, 1, -1, 1};

        int[] salida = red.recuperar(entradaConRuido);

        System.out.println("Patrón recuperado: " + Arrays.toString(salida));
    }
}