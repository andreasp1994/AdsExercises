
public class Node {

    private String element;
    private Node   left;
    private Node   right;
    private Node   parent;
	
    public Node(){this(null,null,null,null);}
	
    public Node(String e, Node left,Node right,Node parent){
	this.element = e;
	this.left    = left;
	this.right   = right;
	this.parent  = parent;
    }

    public String  getElement(){return element;}
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    public Node getParent(){return parent;}

    public void setElement(String e){element = e;}
    public void setLeft(Node node){left = node; if (node != null) node.setParent(this);}
    public void setRight(Node node){right = node; if (node != null) node.setParent(this);}
    public void setParent(Node node){parent = node;}  

    public boolean isRoot(){return parent == null;}
    public boolean isLeaf(){return left == null && right == null;}
    public boolean isInternal(){return left != null && right != null;}
    public boolean isLeftChild(){return parent.getLeft() == this;}
    public boolean isRightChild(){return parent.getRight() == this;}
    public boolean hasLeft(){return left != null;}
    public boolean hasRight(){return right != null;}	
    
    public String toString(){return element.toString();}
}
