

package lab;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 *
 * @author Gauss
 */
public class PriorityQ {
    
    private String preCode;
    private int numItems;
    private Node root;
    private static int tab;
    private char[] charA;
    private String[] codeA;
    
    PriorityQ(){
        
        numItems = 0;
    }
    
    public void menu(){
       
        String in;
        do{
            
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter first letter of enter, show, code, or decode: ");
            in = scn.next();
            if(in.equals("e")){
                enter();
            }
            else if(in.equals("s")){
                show();
            }
            else if(in.equals("c")){
                code(root);
            }
                
            else if(in.equals("d")){
                decode();
            }
        }while (in != "0");
        
    }
    
    public void enter(){
        System.out.println("Enter text lines, terminate with $");
        
        CodeTable CT = new CodeTable();
        Scanner scn = new Scanner(System.in); 
        preCode = scn.nextLine();
        //do{
          // preCode += scn.nextLine();
        //}while(scn.hasNextLine());
        int i = -1;
        char c = 'a';
            do{
                i++;
                if ((int)preCode.charAt(i) != 13){
                    c = preCode.charAt(i);
                    CT.add(c);
                }
            }while (c != '$');
        CT.print();
    }
    
    
    public void code(Node n){
        tab = 0;
        charA = new char[128];
        codeA = new String[128];
        
        
        if(n != null && n.getVal() != '\0'){
            charA[tab] = n.getVal();
            tab++;       
        }
        
        if(n.getL() != null){
            codeA[tab] += "0";
            code(n.getL());
        }
        
        if(n.getR() != null){
            codeA[tab] += "1";
            code(n.getR());
        }
         
        
        
    }
    
    public void show(){        
         root = makeQ();
         //print it
         tab = 0;
         printT(root);
    }
    
    public Node makeQ(){
       PriorityQueue<Node> PQ = new PriorityQueue<Node>();
        for(int i = 0; i < 128; i++){
            if (CodeTable.getVal(i) != 0){
                Node n = new Node((char)i, CodeTable.getVal(i));
                PQ.add(n);
            }
        }
        
        while(PQ.size() > 2){
            PQ.add(new Node(PQ.remove(), PQ.remove()));
        }
        
        return new Node (PQ.remove(), PQ.remove());
                
    }
    
    public void printT(Node n){
        if(n != null){
            tPrint();
            
            if(n.getVal() != '\0'){
                System.out.println(n.getWeight() + " " + n.getVal());
            }
            else{
                System.out.println(n.getWeight());
                
            }
            tab++;       
        }
        if(n.getL() != null){
            printT(n.getL());
        }
        
        if(n.getR() != null){
            printT(n.getR());
        }
        tab--;
        
    }
    
    public void tPrint(){
        for (int i = 0; i < tab; i++){
            System.out.print("    ");
        }
    }
    
    public void decode(){
         System.out.println("decode");
    }
    
}
