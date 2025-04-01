/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Miguel Angel
 */
public class SistemaMatrizBinaria {
    
    private boolean[][] m1;
    private boolean[][] m2;
    
     public SistemaMatrizBinaria(int filasM1, int colsM1, int filasM2, int colsM2) 
        throws IllegalArgumentException {
        
        if (colsM1 != filasM2) {
            throw new IllegalArgumentException(
                "Las dimensiones de las matrices no son compatibles para multiplicación");
        }
        
        // Validar tamaño máximo según bits
        int maxFilasM1 = 1 << colsM1;
        int maxFilasM2 = 1 << colsM2;
        
        if (filasM1 > maxFilasM1 || filasM2 > maxFilasM2) {
            throw new IllegalArgumentException(
                "Número de filas excede el máximo posible para el número de bits");
        }
        
        this.m1 = generarMatrizBinaria(filasM1, colsM1);
        this.m2 = generarMatrizBinaria(filasM2, colsM2);
    }
    
    private boolean[][] generarMatrizBinaria(int filas, int columnas) {
        boolean[][] matriz = new boolean[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ((i >> (columnas - 1 - j)) & 1) == 1;
            }
        }
        return matriz;
    }
    
    public boolean[][] getMultiplicacion() {
        int filasM1 = m1.length;
        int columnasM1 = m1[0].length;
        int columnasM2 = m2[0].length;
        
        boolean[][] resultado = new boolean[filasM1][columnasM2];
        
        // Optimización: usar palabras enteras para procesar múltiples bits
        for (int i = 0; i < filasM1; i++) {
            for (int j = 0; j < columnasM2; j++) {
                int suma = 0;
                for (int k = 0; k < columnasM1; k++) {
                    if (m1[i][k] && m2[k][j]) {
                        suma ^= 1;
                    }
                }
                resultado[i][j] = (suma == 1);
            }
        }
        return resultado;
    }

    public boolean[][] getM1() {
        return m1;
    }

    public void setM1(boolean[][] m1) {
        this.m1 = m1;
    }

    public boolean[][] getM2() {
        return m2;
    }

    public void setM2(boolean[][] m2) {
        this.m2 = m2;
    }
    
    
}
