/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Scanner;

/**
 *
 * @author oopl
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("what is n? ");
        int n = scn.nextInt();
        System.out.println("what is s? ");
        int s = scn.nextInt();
        long[] times = new long[20];
        for(int i = 0; i < 20; i++ ){
            MatrixGen mg = new MatrixGen(n);
            int [][] matrix1 = mg.make();
            int [][] matrix2 = mg.make();
            //BruteForce bf = new BruteForce(matrix1, matrix2, matrix1.length);
            //bf.multiply();
            //bf.print();
            StrassenForce sf = new StrassenForce(matrix1, matrix2, matrix1.length, s);
            int[][] X = new int[n][n];

            long start = System.nanoTime();
            X = sf.mult(matrix1, matrix2);
            long end = System.nanoTime();
            times[i] = end - start;
        }
            //sf.print(X, matrix1.length);
        long total = 0;
        for (int i = 0; i < times.length; i++){
            total += times[i];
        }
        System.out.println("average time for s size" + s + " is" + total/20);
            
        
        
        
        
    }
    
}
