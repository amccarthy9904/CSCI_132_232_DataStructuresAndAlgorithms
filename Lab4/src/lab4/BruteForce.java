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
public class BruteForce {
    int[][] mat1, mat2;
    int[][] mat3;
    int n;
    
    BruteForce(int[][] mat1, int[][] mat2, int n){
        this.mat1 = mat1;
        this.mat2 = mat2;
        mat3 = new int [n][n];
        this.n = n;
    }
    
    public void multiply(){
        for(int i = 0; i < n; i++){
            for(int x = 0; x < n; x++){
                
                mat3[i][x] = 0;
                for(int y = 0; y < n; y++){
                    
                    mat3[i][x] += mat1[i][y]*mat2[y][x];
                }
            }
        }
    }
    
    public void print(){
        
        System.out.println("mat1");
        for(int i = 0; i < n; i++){
            for(int x = 0; x < n; x++){
                
                System.out.print(mat1[i][x] + " ");
            }
            System.out.println();
        }
        
        System.out.println("mat2");
        for(int i = 0; i < n; i++){
            for(int x = 0; x < n; x++){
                
                System.out.print(mat2[i][x] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Brute Result");
        for(int i = 0; i < n; i++){
            for(int x = 0; x < n; x++){
                
                System.out.print(mat3[i][x] + " ");
            }
            System.out.println();
        }
    }
}
