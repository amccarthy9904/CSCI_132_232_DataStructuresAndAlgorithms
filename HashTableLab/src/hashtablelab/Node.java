/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtablelab;

public class Node implements Comparable<Node>{
    private int weight;
    private Node left;
    private Node right;
    
    Node (int w){
        this.weight = w;
        this.left = null;
        this.right = null;
    }
    
    public int compareTo(Node t) {
        return this.weight - t.weight;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public Node getL(){
        return left;
    }
    
    public Node getR(){
        return right;
    }
    public void makeL(Node l){
        this.left = l;
    }
    public void makeR(Node r){
        this.right = r;
    }
           
}
