/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tree;

import java.util.*;

/**
 *
 * @author forrest
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RoyalTree.Node tree = fileReader();
        RoyalTree.breadthFirst();
    }

    public static RoyalTree.Node fileReader() {
        System.out.println("Enter the file name or path");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        RoyalTree.Node tree = null;
        
        FileIO.read(path);
        
        return tree;
    }
}
