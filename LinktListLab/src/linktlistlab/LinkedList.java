

package linktlistlab;

import java.util.Scanner;

/**
 *
 * @author h63z978
 */
public class LinkedList {
    
    private Node first, last;
    
    LinkedList(){
        
        first = last = null;
        menu();
    }
    
    public void menu(){
        
        int in = 0;
        do{
            
            Scanner scn = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to add an item");
            System.out.println("Press 2 to print the list");
            System.out.println("Press 3 to search the list");
            System.out.println("Press 4 to delete an item");
            System.out.println("Press 5 to clear the whole list");
            System.out.println("Press -1 to exit\n");
            in = scn.nextInt();
            
            if(in == 1){
                
                String name;
                int id;
                System.out.println("Enter the name of the Student :");
                name = scn.next();
                System.out.println("Enter the id of the Student :");
                id = scn.nextInt();
                Student y = new Student(id, name);
                Node x = new Node(y);
                add(x);
            }
            
            else if(in == 2){
               
                print();
            }
            
            else if(in == 3){
                
                String name;
                System.out.println("Enter the name of the Student you would like to search for:");
                name = scn.next();
                int id = searchList(name);
                if (searchList(name) == 0)
                    System.out.println("Sorry. No students by that name were found./n");
                else 
                        System.out.println("The id of " + name + "is " + id);
            }
            
            else if(in == 4){
                
                String name;
                System.out.println("Enter the name of the Student you would like to delete:");
                name = scn.next();
                remove(name);
                System.out.println(name +" has been deleted\n");
                
            }
            else if(in == 5){
                
                clearList();
            }
            
            else if(in == -1){
                
                ;
            }
            
            else {
                
                System.out.println("Please enter  one of the following integers 1, 2, 3, 4, 5, -1\n");
            }
            
        }while (in != -1);
    }
    

    
    public void remove(String input){
        
        Node iter = first;
        Node lag = first;
        
        while(iter != null){
            
            if (input.equals(iter.getName())){
                
                if (iter == first)
                    first = first.getNext();
                else
                    lag.setNext(iter.getNext());
                iter.setNext(null);
                
             
            }
            
            else{
                
                lag = iter;
                iter = iter.getNext();
            }
        }
    
    }

    public void add(Node input) {
        
        if (first == null){
          
          first = input;
          last = first;
        }
        
        else{
            last.setNext(input);
            last = last.getNext();
        }
    }
    
    public void print(){
        Node iter = first;
        while(iter != null){
            
            iter.printInfo();
            iter = iter.getNext();
        }
    }
    
    public int searchList(String name){
        
        Node iter = first;
        while(iter != null){
            if (iter.getName().equals(name))
                return iter.getId();
            iter = iter.getNext();
            }
        return 0;
    }
    
    public void clearList(){
        
    first = last = null;
    }   
    
}   
