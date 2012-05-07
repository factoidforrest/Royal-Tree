/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tree;

import royal.tree.RoyalTree;

/**
 *
 * @author Forrest
 */
public class Que {

    Link pushed;//these are the tails of the que.  Pushed was just pushed, popped is about to be popped.
    Link popped;

    public Que() {
        pushed = null;
        popped = null;
    }

    public void push(RoyalTree.Node insert) {
        
        Link newLink = new Link(insert);
        //System.out.println("Created a link containing: "+ newLink.content.element);
        if (pushed == null) {//empty que
            newLink.next = null;
            pushed = newLink;
            popped = newLink;
        } else {//nonempty que
            pushed.next=newLink;
            
            pushed = newLink;
        }
    }
    public RoyalTree.Node pop(){//check to see if empty or app will crash. TODO: throw error
        Link temp = popped;
        if(pushed == popped){//one node que
            pushed = null;
            popped = null;
            return temp.content;
        }
        else{//multielement que
            popped = popped.next;
            return temp.content;
        }
    }
    public boolean isEmpty(){
        if( popped ==null){
            return true;
        }
        return false;
    }

    public class Link {//objects to fill the list

        public RoyalTree.Node content = null;
        public Link next = null;

        public Link(RoyalTree.Node contentin) {
            content = contentin;
        }
        
    }//end link subclass
}
