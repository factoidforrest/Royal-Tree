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
                Node last = null;
                ageLoop:
                for (Node x = parent.child; true; x = x.sibling) {

                    if (x.birthday < added.birthday) {//encounters a node with a lower birthday
                        if (x == parent.child) {//added is the highest node
                            added.sibling = parent.child;
                            parent.child = added;
                            break ageLoop;
                        } else {//added is in the middle somewhere. siblings were found with both lower and higher birthdays
                            last.sibling = added;
                            added.sibling = x;
                            break ageLoop;
                        }

                    } else if (x.sibling == null) {//added is the lowest node
                        x.sibling = added;
                        break ageLoop;
                    }
                    last = x;
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
