import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;
    // create empty root (p.80 replacement for null pointer)
    public BinarySearchTree() {}
    public BinarySearchTree(int[] array) {
        for (int i : array) {
            insert(this.root, null, i);
        }
    }

    public Boolean contains(int value) {
        return search(value, root) != null;
        // use the search from node with the value and if it comes back with anything return true/false
    }

    public void insert(int value) {
        insert(root, null, value);
    }

    private void insert(Node node, Node parent, int value) {
        // add null check before this for root
        if (root == null) {
            this.root = new Node();
            root.setData(value);
        } else if (search(value, root) == null) {
            if (node == null) {
                node = new Node();
                node.setData(value);
                node.setParent(parent);
                if (parent != null) {
                    if (parent.getData() > node.getData()) {
                        parent.setLeft(node);
                    } else if (parent.getData() < node.getData()) {
                        parent.setRight(node);
                    }
                }
            } else if (value > node.getData()) {
                insert(node.getRight(), node, value);
            } else if (value < node.getData()) {
                insert(node.getLeft(), node, value);
            }
        }
    }

    public List<Integer> list() {
        List<Integer> returnList = new ArrayList<Integer>();
        traverse(root, returnList);
        return returnList;
    }
    public Integer min(){
        return min(root);
    }
    private Integer min(Node node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() != null) {
            return min(node.getLeft());
        }
        return node.getData();
    }
    public Integer max(){
        return max(root);
    }
    private Integer max(Node node) {
        if (node == null) {
            return null;
        } else if (node.getRight() != null) {
            return max(node.getRight());
        }
        return node.getData();
    }

    public void remove(int value) {
        if ( root == null || value == root.getData()){
            root = null;
        }
        Node node = search(value, root);
        if (node != null) {
            if (node.getRight() == null && node.getLeft() == null) {
                // IF THE NODE DOESN'T HAVE CHILDREN
                if (node.getParent() != null) {
                    if (node.getParent().getData() > node.getData()) {
                        node.getParent().setLeft(null);
                    } else if (node.getParent().getData() < node.getData()) {
                        node.getParent().setRight(null);
                    }
                    node.killNode();
                } else {
                    node.killNode();
                }
            } else if (node.getLeft() != null && node.getRight() == null) {
                // IF THE NODE ONLY HAS 1 CHILD (LEFT)
                if (node.getParent().getData() > node.getData()) {
                    // if parent > node
                    node.getParent().setLeft(node.getLeft());
                    // set parents left to nodes left
                    node.getLeft().setParent(node.getParent());
                    // set nodes lefts parent to nodes parent
                } else if (node.getParent().getData() < node.getData()) {
                    // if parent < node
                    node.getParent().setRight(node.getLeft());
                    // set parents right to nodes left
                    node.getLeft().setParent(node.getParent());
                    // set nodes left parent to nodes parent
                }
                node.killNode();
            } else if (node.getLeft() == null && node.getRight() != null) {
                // IF THE NODE ONLY HAS 1 CHILD (RIGHT)
                if (node.getParent().getData() > node.getData()) {
                    // if parent > node
                    node.getParent().setLeft(node.getRight());
                    // set parents left to nodes right
                    node.getRight().setParent(node.getParent());
                    // set nodes right parent to nodes parent
                } else if (node.getParent().getData() < node.getData()) {
                    // if parent < node
                    node.getParent().setRight(node.getRight());
                    // set parents right to nodes right
                    node.getRight().setParent(node.getParent());
                    // set nodes right parent to nodes parent
                }
                node.killNode();
            } else {
                // IF NODE HAS TWO CHILDREN :(
                int min = min(node.getRight());
                remove(min);
                // kill min node
                node.setData(min);
                // set current node to min
            }
        }
    }

    private void traverse(Node node, List<Integer> list) {
        if (node != null) {
            traverse(node.getLeft(), list);
            list.add(node.getData());
            traverse(node.getRight(), list);
        }
    }

    private Node search(int value, Node node) {
        if (node == null) {
            return null;
        }
        if (node.getData() == null) {
            return null;
        }
        if (node.getData() == value) {
            return node;
        }
        if (node.getData() > value) {
            return search(value, node.getLeft());
        } else {
            return search(value, node.getRight());
        }
    }
}
