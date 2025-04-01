/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.SistemaMatrizBinaria;
import vista.Consola;
/**
 *
 * @author Miguel Angel
 */

public class TestSistemaMatriz {
    public static void main(String[] args) {
        Consola c = new Consola();
        
        try {
            c.imprimir("Ingrese filas de M1:");
            int filasM1 = c.leerEntero();
            
            c.imprimir("Ingrese columnas de M1:");
            int colsM1 = c.leerEntero();
            
            c.imprimir("Ingrese filas de M2:");
            int filasM2 = c.leerEntero();
            
            c.imprimir("Ingrese columnas de M2:");
            int colsM2 = c.leerEntero();
            
            SistemaMatrizBinaria sistema = new SistemaMatrizBinaria(
                filasM1, colsM1, filasM2, colsM2);
            
            boolean[][] resultado = sistema.getMultiplicacion();
            
            // Imprimir resultado
            c.imprimir("\nResultado de la multiplicación:");
            imprimirMatriz(resultado, c);
            
        } catch (IllegalArgumentException e) {
            c.imprimir("Error: " + e.getMessage());
        }
    }
    
    private static void imprimirMatriz(boolean[][] matriz, Consola c) {
        StringBuilder sb = new StringBuilder();
        for (boolean[] fila : matriz) {
            for (boolean valor : fila) {
                sb.append(valor ? "1 " : "0 ");
            }
            sb.append("\n");
        }
        c.imprimir(sb.toString());
    }
}