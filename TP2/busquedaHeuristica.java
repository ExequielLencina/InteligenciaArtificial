package TP2;

public class busquedaHeuristica {
	    static int posicionInicial = 0;
	    static int posicionObjetivo = 5;

	    public static void main(String[] args) {
	        busquedaHeuristica();
	    }

	    public static void busquedaHeuristica() {
	        int posicionActual = posicionInicial;

	        while (posicionActual != posicionObjetivo) {
	          
	            if (posicionActual < posicionObjetivo) {
	                posicionActual++;
	            } else {
	                posicionActual--;
	            }

	            System.out.println("Moviéndose a la posición: " + posicionActual);
	        }

	        System.out.println("Posición encontrada en: " + posicionActual);
	    }
	}