
package linktlistlab;

import static com.sun.imageio.plugins.jpeg.JPEG.names;
import java.util.Scanner;

/**
 *
 * @author Aaron McCarthy
 */
public class Driver {
    
    //static int length;
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        int[] ids = {1111, 2222, 3333, 4444, 5555};
        String[] names = {"Hunter", "Marge", "Homer", "Bart", "Lisa"};
        //length = names[].getLength;
        for (String i : names){
            
            int x = 0;
            list.add(new Node (new Student (ids[x], i)));
            x++;
        }
        
        LinkedList x = new LinkedList();
        
        
        
    }
    
}
