/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author h63z978
 */
public class Node implements Comparable<Node>{
    private char value;
    private int weight;
    private Node left;
    private Node right;
    
    Node (char c, int w){
        this.value = c;
        this.weight = w;
        this.left = null;
        this.right = null;
    }
    
    Node(Node l, Node r){
        this.value = '\0';
        this.weight = l.weight + r.weight;
        this.left = l;
        this.right = r;
    }
    
    public int compareTo(Node t) {
        return this.weight - t.weight;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public char getVal(){
        return value;
    }
    
    public Node getL(){
        return left;
    }
    
    public Node getR(){
        return right;
    }
}
