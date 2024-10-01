package TP2;


public class busquedaExhaustiva {
	    static int posicionInicial = 0;
	    static int posicionObjetivo = 5;

	    public static void main(String[] args) {
	        busquedaExhaustiva();
	    }

	    public static void busquedaExhaustiva() {
	        int posicionActual = posicionInicial;
	        boolean encontrada = false;

	        int paso = 1;

	        while (!encontrada) {
	            int posicionDerecha = posicionInicial + paso;
	            if (posicionDerecha == posicionObjetivo) {
	                System.out.println("Posición encontrada en: " + posicionDerecha);
	                encontrada = true;
	                break;
	            }

	            int posicionIzquierda = posicionInicial - paso;
	            if (posicionIzquierda == posicionObjetivo) {
	                System.out.println("Posición encontrada en: " + posicionIzquierda);
	                encontrada = true;
	                break;
	            }

	            paso++;
	        }
	    }
	}


