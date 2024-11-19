package TP4;

import java.util.ArrayList;
import java.util.List;

public class TransformadaHoughCircunferencia {
    private static int width = 200;
    private static int height = 200;

    public static void main(String[] args) {
        int[][] image = new int[width][height];
        image[50][50] = 1;
        image[70][70] = 1;
        image[60][80] = 1;
        image[50][90] = 1;

        int maxRadius = 100;
        int[][][] accumulator = new int[width][height][maxRadius];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (image[x][y] == 1) {
                    for (int radius = 10; radius < maxRadius; radius++) {
                        for (int theta = 0; theta < 360; theta++) {
                            int a = (int) (x - radius * Math.cos(Math.toRadians(theta)));
                            int b = (int) (y - radius * Math.sin(Math.toRadians(theta)));
                            if (a >= 0 && a < width && b >= 0 && b < height) {
                                accumulator[a][b][radius]++;
                            }
                        }
                    }
                }
            }
        }

        List<String> circles = new ArrayList<>();
        for (int a = 0; a < width; a++) {
            for (int b = 0; b < height; b++) {
                for (int r = 10; r < maxRadius; r++) {
                    if (accumulator[a][b][r] > 10) {
                        circles.add("Centro: (" + a + ", " + b + "), Radio: " + r);
                    }
                }
            }
        }

        System.out.println("Circunferencias detectadas:");
        for (String circle : circles) {
            System.out.println(circle);
        }
    }
}
