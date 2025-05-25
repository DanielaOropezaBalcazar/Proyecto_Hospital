package Clases;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    	/*
        GrafoConsultas grafoConsultas = new GrafoConsultas();
        Map<String, List<Arista>> grafo = grafoConsultas.construirGrafo();

        for (String nodo : grafo.keySet()) {
            System.out.println(nodo + ", tiene conexiones con:");
            for (Arista arista : grafo.get(nodo)) {
                System.out.println("  -> " + arista.getDestino() + " [precio: " + arista.getPeso() + "]");
            }
            System.out.println();
        }
        */
    	
        String fecha = "2025-01-10";
        
        System.out.println();
        HashMap<Integer, doctor> doctores = ConsultaDAO.obtenerDoctoresPorFecha(fecha);
        
        System.out.println("Doctores que atendieron el " + fecha + ":");
        for (Map.Entry<Integer, doctor>entry : doctores.entrySet()) {
            System.out.println("Codigo: "+entry.getKey()+"  ->  Nombre: "+entry.getValue().getNombre());
        }
        
    }
}
	