

package recursionmazelab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Maze {
    int row, col, hCol, hRow;
    char[][] map;
    String s;
    static Maze maze;
    
    public void Maze(){
        map = new char[12][12];
        try {
            readMap();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readMap() throws FileNotFoundException{
        BufferedReader in = new BufferedReader(new FileReader("Maze.txt"));
        int x, y;
        for(y = 0; y < 12; y++){
            try {
                s = in.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
            }
            char temp[] = makeArray(s);
            for (x = 0; x < 12; x++){
                
                map[x][y] = temp[x];
            }
        }
        printMap();
                
        
    }
    
    public char[] makeArray( String s ) {
        int x = s.length();
        char[] array = new char[x];
        for (int i = 0; i < x ; i++) {
            array[i] = new Character(s.charAt(i));
        }

        return array;
    }
    
    public void printMap(){
        int x, y;
        for(y = 0; y < 12; y++){
            System.out.println("");
            
            for (x = 0; x < 12; x++){
                System.out.print(map[x][y] + " ");
                
               
            }
        }
    }
    
    
    public static void getInstance(){
        maze = new Maze();
    }
}
