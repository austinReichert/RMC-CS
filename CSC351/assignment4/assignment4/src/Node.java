public class Node {
    private Integer data;
    Node left, right, parent;
    public Node (){}
    public Integer getData() {
        return data;
    }
    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }
    public void setRight(Node right){
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
    public void killNode(){
        this.data = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}
