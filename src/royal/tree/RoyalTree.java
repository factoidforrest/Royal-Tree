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
public class RoyalTree {

    static HashMap<String, Node> nodeList = new HashMap<>();
    static Node root = null;

    public static void add(String elementin, String parentin, int birthdayin, boolean isRoot) {
        
        Node added = new Node(elementin, birthdayin);
        nodeList.put(elementin, added);
        if (isRoot) {
            root = added;//set root node
        }
        
        if (!isRoot) {
            
            Node parent = nodeList.get(parentin);//fetches parent from hashmap
            
            if (parent.child == null) {//parent has no children
                parent.child = added;
            } else {//parent has children
                Node older = null;//keeps track of the node that is older but least older than added
                Node younger;
                Node visiting = parent.child;
                search:while(true){//loops through the children of a node and finds where to insert node based on birthdate
                    //for(Node x=parent.child;x.sibling!=null;x = x.sibling){
                        
                    //}
                    if(visiting.birthday>added.birthday){
                        older = visiting;
                    }
                    else{
                        break search;
                    }
                    if(visiting.sibling != null){
                        visiting = visiting.sibling;
                    }
                    else{
                        break search;
                    }
                }
                if(older == null){//added is oldest node
                    younger = parent.child;
                    parent.child = added;
                    added.sibling = younger;
                }
                else if(older.sibling !=null){//added is in the middle somewhere
                    younger = older.sibling;
                    older.sibling = added;
                    added.sibling = younger;
                }
                else if(older.sibling==null){//added is the youngest node
                    older.sibling = added;
                    
                }
                    
            }
        }


    }

    /**
     * @param args the command line arguments
     */
  
    public static class Node {

        String element;
        int birthday;
        Node child;
        Node sibling;

        Node(String elementin, int birthdayin) {
            element = elementin;
            birthday = birthdayin;

        }
    }

    public RoyalTree() {
        root = null;
    }

    public void empty() {
        root = null;
    }
}
