/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author oopl
 */
public class MatrixGen {
    private int n;
    
    MatrixGen(int n){
        this.n = n;
    }
    
    public int[][] make(){
        
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int x = 0; x < n; x++){
                matrix[i][x] =  (int)(11 * Math.random());
            }
        }
        if(!checkpwr2(n)){  //in case n is not a power of 2, s
            int n2 = n;     //finds closest power of 2 makes another array of that size and fils blanks with zeroes
            do{
                n2++;
            }while(!checkpwr2(n2));
            
            int[][]matrix2 = new int[n2][n2];
            for(int i = 0; i < n2; i++){
                for(int x = 0; x < n2; x++){
                matrix2[i][x] = 0;
                }
            }
            for(int i = 0; i < n; i ++){
                for(int x = 0; x < n; x ++){
                    matrix2[i][x] = matrix[i][x];
                }
            }
            return matrix2;    
        }
        return matrix;
    }
    
    
    
    public boolean checkpwr2(int n){
        if((n & (n-1)) == 0){
            return true;
        }
        else{
            return false;
        }
    }
    

}
