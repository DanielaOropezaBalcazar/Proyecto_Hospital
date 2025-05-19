package Clases;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GrafoConsultas grafoConsultas = new GrafoConsultas();
        Map<String, List<Arista>> grafo = grafoConsultas.construirGrafo();

        for (String nodo : grafo.keySet()) {
            System.out.println(nodo + ", tiene conexiones con:");
            for (Arista arista : grafo.get(nodo)) {
                System.out.println("  -> " + arista.getDestino() + " [precio: " + arista.getPeso() + "]");
            }
            System.out.println();
        }
    }
}
