public class Main {
    public static void main(String[] args) {
        int[] array = {20, 5, 12, 3, 60, 53, 8, 6, 2, 4, 1, 15, 30};
        BinarySearchTree tree = new BinarySearchTree(array);
        System.out.println(tree.list());
        System.out.println(tree.contains(8));
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.remove(12);
        System.out.println(tree.list());
    }
}
