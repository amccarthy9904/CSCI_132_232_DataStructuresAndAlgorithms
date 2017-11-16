/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;


public class Sorter {
    private int[] array1, array2;
    private int size;
    private static int swaps;
    private double strTime, finTime;
    public Sorter(int size){
        this.size = size;
        this.array1 = new int[size];
        this.array2 = new int[size];
             
    }
    
    public void fillArrays(){
        int i;
        for (i = 0; i < size; i++){
            array1[i] = (int)(Math.random() * 101);
            array2[i] = array1[i];
        }
        double strTime = System.currentTimeMillis();
        bubbleSort();
        double finTime = System.currentTimeMillis();
        System.out.println("The time in milliseconds to sort via bubbleSort " + size + " items is " + (finTime - strTime));
        
        strTime = System.currentTimeMillis();
        selectionSort();
        finTime = System.currentTimeMillis();
        System.out.println("The time in milliseconds to sort via selectionSort " + size + " items is " + (finTime - strTime));

    }
    
        public void bubbleSort(){
            printArray();
            int temp;
            do{
                swaps = 0;
                int i;
                for(i = 1; i < size; i++){
                    if (array1[i - 1] > array1[i]){
                        temp = array1[i-1];
                        array1[i-1] = array1[i];
                        array1[i] = temp;
                        swaps++;
                    }
                }   
            }while(swaps != 0);
            printArray();
            
        }
        
        public void selectionSort(){
            printArray2();
            int out, in, min;
            for (out = 0; out < (size - 1); out++){
                min = out;
                for (in = out + 1; in < size; in++){
                    if (array2[in] < array2[min]){
                        min = in;
                        
                    }
                }
                int temp = array2[out];
                array2[out] = array2[min];
                array2[min] = temp;
                     
            }
            printArray2();
            
        }
        
        public void printArray2(){
            
            int i;
            for(i = 0; i < size; i++){
                System.out.print(array2[i] + " ");
            }
            System.out.println();
    
        }
        
        public void printArray(){
            
            int i;
            for(i = 0; i < size; i++){
                System.out.print(array1[i] + " ");
            }
            System.out.println();
    
        }
}
