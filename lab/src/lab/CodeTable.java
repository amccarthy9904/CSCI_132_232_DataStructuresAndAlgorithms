/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.PriorityQueue;

/**
 *
 * @author h63z978
 */
public class CodeTable {
    private static int[] cTable;
    
    CodeTable(){
        cTable = new int[128];
        for (int i = 0 ; i < 128; i++){
            cTable[i] = 0;
        }
    }
    
    public void add(char c){
        cTable[(int)c]++;   
    }
    
    public int get(int i){
        return cTable[i];
    }
    
    public void print(){
        for (int i = 0 ; i < 128; i++){
            System.out.print(cTable[i] + " ");
            if(i%7 == 0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
    
    public static int getVal(int i){
        return cTable[i];
    }
    
}
