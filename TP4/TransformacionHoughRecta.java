package TP4;

import java.util.ArrayList;

public class TransformacionHoughRecta {
    private int[][] acumulador;
    private int maxRho;
    private int numAngulos;

    public TransformacionHoughRecta(int ancho, int alto, int numAngulos) {
        this.numAngulos = numAngulos;
        this.maxRho = (int) Math.sqrt(ancho * ancho + alto * alto);
        this.acumulador = new int[2 * maxRho][numAngulos];
    }

    public void detectarLineas(int[][] imagen) {
        int ancho = imagen.length;
        int alto = imagen[0].length;

        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (imagen[x][y] > 0) {
                    for (int theta = 0; theta < numAngulos; theta++) {
                        double radianes = Math.toRadians(theta * 180.0 / numAngulos);
                        int rho = (int) (x * Math.cos(radianes) + y * Math.sin(radianes));
                        rho += maxRho;
                        if (rho >= 0 && rho < 2 * maxRho) {
                            acumulador[rho][theta]++;
                        }
                    }
                }
            }
        }
    }

    public ArrayList<int[]> obtenerLineas(int umbral) {
        ArrayList<int[]> lineas = new ArrayList<>();

        for (int rho = 0; rho < 2 * maxRho; rho++) {
            for (int theta = 0; theta < numAngulos; theta++) {
                if (acumulador[rho][theta] >= umbral) {
                    lineas.add(new int[]{rho - maxRho, theta});
                }
            }
        }

        return lineas;
    }

    public void imprimirAcumulador() {
        for (int rho = 0; rho < acumulador.length; rho++) {
            for (int theta = 0; theta < acumulador[rho].length; theta++) {
                System.out.print(acumulador[rho][theta] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] imagen = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };

        TransformacionHoughRecta hough = new TransformacionHoughRecta(imagen.length, imagen[0].length, 180);
        hough.detectarLineas(imagen);

        System.out.println("Acumulador:");
        hough.imprimirAcumulador();

        ArrayList<int[]> lineas = hough.obtenerLineas(6);
        System.out.println("Líneas detectadas:");
        for (int[] linea : lineas) {
            System.out.println("Rho: " + linea[0] + ", Theta: " + linea[1]);
        }
    }
}
