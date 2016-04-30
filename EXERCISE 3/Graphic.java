
public class Graphic {
    private BSTree tree;
    private Node root;

    public Graphic(BSTree tree){
	this.tree = tree;
	root = tree.root();
    }

    private void draw(Node node,double x,double xLow,double xHi,double y,double dY){
	StdDraw.filledCircle(x,y,0.001);
	double xLeft  = (xLow + x)/2.0;
	double xRight = (x + xHi)/2.0;
	if (node.hasLeft()){
	    StdDraw.line(x,y,xLeft,y+dY);
	    draw(node.getLeft(),xLeft,xLow,x,y+dY,dY);
	}
	if (node.hasRight()){
	    StdDraw.line(x,y,xRight,y+dY);
	    draw(node.getRight(),xRight,x,xHi,y+dY,dY);
	}
    }

    public void draw(){
	StdDraw.clear();
	root = tree.root();
	if (root != null){
	    int h = height(tree.root());
	    double dY = -1.0 / (double)h;
	    draw(root,0.5,0.0,1.0,1.0,dY);
	}
	else StdDraw.filledCircle(0.5,1.0,0.00);
    }
    //
    // rescales y-delta for height
    //
    
    private int height(Node node){
	if (node == null) return -999;
	if (node.isLeaf()) return 0;
	return 1 + Math.max(height(node.getLeft()),height(node.getRight()));
    }

}
