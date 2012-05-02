/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tree;

import java.io.*;

/**
 *
 * @author forrest
 */
public class FileIO {

    public static void read(String path) {
        System.out.println("FileIO is looking for:" + path);


        File inputFile = new File(path);
        String line = null;
        BufferedReader input = null;
        RoyalTree.Node root = null;
        try {
            input = new BufferedReader(new FileReader(inputFile));

        } catch (Exception IOException) {
            System.out.println("Cannot find file.  Try again");
            IOException.printStackTrace();
            
        }
        try{
        while ((line = input.readLine()) != null) {//constructs objects for each line
        
            boolean isroot = false;


            String[] lineArray = line.split("\\s+");
            System.out.println("The line is: "+line);
            
            if (lineArray.length < 3) {//line is root node
                isroot = true;
                RoyalTree.add(lineArray[0], null, Integer.parseInt(lineArray[1]), isroot);
            } else {//line is not root node
                RoyalTree.add(lineArray[1], lineArray[0], Integer.parseInt(lineArray[2]), isroot);
            }
        }
        }catch(IOException e){
            System.out.println("Linereader exception thrown");
            e.printStackTrace();
        }




        
    }
}