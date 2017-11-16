/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtablelab;

import java.util.Scanner;

/**
 *
 * @author h63z978
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of hash table: ");
        int size = scn.nextInt();
        System.out.println("Enter initial number of items: ");
        int numItems = scn.nextInt();
        HashTable HT = new HashTable(size, numItems);
        HT.construct();
        String in;
        do{
            System.out.println("Enter first letter of show, insert, or find: ");
            in = scn.next();
            if(in.equals("s")){
                
            }
            else if(in.equals("i")){
                
            }
            else if(in.equals("f")){
                
            }
            
                
            
        }while (in != "0");
    }
    
}
