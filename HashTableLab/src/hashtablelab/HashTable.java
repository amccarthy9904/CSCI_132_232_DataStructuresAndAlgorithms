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
public class HashTable {
    private int size;
    private int numItems;
    private Node[] hArray;
    
    HashTable(int size, int numItems){
        this.size = size;
        this.numItems = numItems;
        hArray = new Node[size];
    }
    
    public void construct(){
        Scanner scn = new Scanner(System.in);
        for(int i = 0; i < numItems; i++){
            System.out.println("Enter value number " + (i+1) + " ");
            int in = scn.nextInt();
            if (hArray[in%size] == null){
                Node n = new Node(in);
                hArray[in%size] = n;
            }
            else{
                Node n = new Node(in);
                insertNode(hArray[in%size], n);
            }
            
           
        }
        
    }
    
    public void insertNode(Node root, Node in){
        if(in.getWeight() == root.getWeight()){
            System.out.println("You cannot add duplicate keys to the hash table");
        }
        if(in.getWeight() < root.getWeight()){
            if(root.getL() == null){
                root.makeL(in);
            }
            else{
                insertNode(root.getL(), in);
            }
        }
        else if(in.getWeight() > root.getWeight()){
            if(root.getR() == null){
                root.makeR(in);
            }
            else{
                insertNode(root.getR(), in);
            }
        }
    }
    
    
    
}
