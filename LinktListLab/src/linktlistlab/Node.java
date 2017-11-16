

package linktlistlab;

/**
 *
 * @author h63z978
 */
public class Node {
    
    private Node next;
    private Student data;
    
    Node(Student s) {
        data = s;
        next = null;    }
    
    public void setNext(Node n){
        
        next = n;
    }
    
    public Node getNext(){
        
        return next;
    }
    
    public void printInfo(){
        
        System.out.println("The student in this node is named " + data.getName() + " and the ID number of the student is " + data.getId()); 
    }
      
    public int getId(){
        
        return data.getId();
    }
    
    public String getName(){
        
        return data.getName();
    }
    
    public Node getInst(){
        
        return this;
    }
}
