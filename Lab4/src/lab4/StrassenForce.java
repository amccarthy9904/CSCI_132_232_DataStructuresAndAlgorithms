/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author h63z978
 */
public class StrassenForce {
    int[][] matrix1, matrix2;
    int[][] matrix3;
    int n;
    static int s;
    
    StrassenForce(int[][] mat1, int[][] mat2, int n, int s){
        this.matrix1 = mat1;
        this.matrix2 = mat2;
        matrix3 = new int [n][n];
        this.n = n;
        this.s = s;
    }
    
   
    
    public int[][] mult(int[][]matA, int[][]matB){
        int len = matA.length;
        int[][]matX = new int [len][len];
        if(len == s){
            matX = BFmult(matA, matB);
            return matX;
        }
        else{
            if(len == 1){
                matX[0][0] = matA[0][0] * matB[0][0];
            }
            else{
                int[][] A00 = new int [len/2][len/2];
                int[][] A01 = new int [len/2][len/2];
                int[][] A10 = new int [len/2][len/2];
                int[][] A11 = new int [len/2][len/2];
                int[][] B00 = new int [len/2][len/2];
                int[][] B01 = new int [len/2][len/2];
                int[][] B10 = new int [len/2][len/2];
                int[][] B11 = new int [len/2][len/2];

                //divide a and b into quarters

                A00 = divide(matA, len, 0, 0);
                A10 = divide(matA, len, len/2, 0);
                A01 = divide(matA, len, 0, len/2);
                A11 = divide(matA, len, len/2, len/2);
                B00 = divide(matB, len, 0, 0);
                B10 = divide(matB, len, len/2, 0);
                B01 = divide(matB, len, 0, len/2);
                B11 = divide(matB, len, len/2, len/2);


                //get all M1, M2 ect
                int[][] M1 = mult(plus(A00, A11, len/2), plus(B00, B11, len/2));
                int[][] M2 = mult(plus(A10,A11,len/2), B00);
                int[][] M3 = mult(A00, minus(B01,B11,len/2));
                int[][] M4 = mult(A11, minus(B10,B00,len/2));
                int[][] M5 = mult(plus(A00, A01,len/2),B11);
                int[][] M6 = mult(minus(A10,A00,len/2),plus(B00,B01,len/2));
                int[][] M7 = mult(minus(A01,A11,len/2),plus(B10,B11,len/2));

                //add Ms into 4 seperate mat.
                int[][] C00 = plus(minus(plus(M1,M4,len/2), M5,len/2), M7, len/2);
                int[][] C01 = plus(M3,M5,len/2);
                int[][] C10 = plus(M2,M4,len/2);
                int[][] C11 = plus(minus(plus(M1,M3,len/2), M2, len/2), M6, len/2);

                //put seperate Cmat into matX
                matX = combine(matX, C00, 0, 0);
                matX = combine(matX, C01, 0, len/2);
                matX = combine(matX, C10, len/2, 0);
                matX = combine(matX, C11, len/2, len/2);
            }
            return matX;
        }   
    }

        public int[][] divide(int[][]matA, int len, int s1, int s2){
            int s11 = s1;
            int s22 = s2;
            int[][] matA00 = new int [len/2][len/2];
            for(int i = 0; i < len/2; i++){
                for(int x = 0; x < len/2; x++){
                    matA00[i][x] = matA[s11][s22];
                    s22++;
                }
                s22 = s2;
                s11++;
            }
            return matA00;
        }

        public int[][] combine(int[][]matA, int[][] matA00, int s1, int s2){
            int s11 = s1;
            int s22 = s2;
            for(int i = 0; i < matA00.length; i++){
                for(int x = 0; x < matA00.length; x++){
                    matA[s11][s22] = matA00[i][x];
                    s22++;
                }
                s22 = s2;
                s11++;
            }
            return matA;
    }
    
    public int[][] minus(int[][]X, int[][]Y, int len){
        int[][]Z = new int[len][len];
        for(int i = 0; i < len; i ++){
            for(int x = 0; x < len; x ++){
                Z[i][x] = X[i][x] - Y[i][x];
            }
            
        }
        return Z;
    }
    
    public int[][] plus(int[][]X, int[][]Y, int len){
        int[][]Z = new int[len][len];
        for(int i = 0; i < len; i ++){
            for(int x = 0; x < len; x ++){
                Z[i][x] = X[i][x] + Y[i][x];
            }
            
        }
        return Z;
    }
    
    public int[][] BFmult(int[][]mat1, int[][]mat2){
        int[][]mat3 = new int[mat1.length][mat1.length];
        for(int i = 0; i < mat1.length; i++){
            for(int x = 0; x < mat1.length; x++){
                mat3[i][x] = 0;
                for(int y = 0; y < mat1.length; y++){
                    
                    mat3[i][x] += mat1[i][y]*mat2[y][x];
                }
            }
        }
        return mat3;
    }
    
    
    
    
    
    public void print(int[][] A, int len){
    System.out.println("Strassen result");
        for(int i = 0; i < len; i++){
            for(int x = 0; x < len; x++){
                
                System.out.print(A[i][x] + " ");
            }
            System.out.println();
        }
    }
}
