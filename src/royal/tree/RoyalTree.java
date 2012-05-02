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

    static HashMap<String, Node> nodeList = new HashMap<>();//holds the users
    static Node root = null;

    public static void add(String elementin, String parentin, int birthdayin, boolean isRoot) {

        Node added = new Node(elementin, birthdayin);
        nodeList.put(elementin, added);
        if (isRoot) {
            root = added;//set root node
        }

        if (!isRoot) {
            Node parent = null;
            if (nodeList.containsKey(parentin)) {
                parent = nodeList.get(parentin);//fetches parent from hashmap
            } else {
                System.out.println("Cannot find parent");
                System.exit(0);
            }


            if (parent.child == null) {//parent has no children
                parent.child = added;
            } else {//parent has children

                Node last = null;
                ageLoop:
                for (Node x = parent.child; true; x = x.sibling) {

                    if (x.birthday > added.birthday) {//encounters a node with a more recent(larger) birthday
                        if (x == parent.child) {//added is the highest node
                            added.sibling = parent.child;
                            parent.child = added;
                            break ageLoop;
                        } else {//added is going in the middle somewhere. siblings were found with both lower and higher birthdays
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
        System.out.println("Created node containing: " + elementin);
    }

    public static void breadthFirst() {
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while (!que.isEmpty()) {
            Node popped = que.remove();
            System.out.println(popped.element);
            if (popped.child != null) {//if the popped node has children
                childLoop:
                for (Node x = popped.child; true; x = x.sibling) {//loop through them
                    que.add(x);
                    if (x.sibling == null) {
                        break childLoop;
                    }
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
