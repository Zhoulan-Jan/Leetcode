public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        System.out.println(tree.preorderTraversal(root));
        System.out.println(tree.inorderTraversal(root)); //List<Integer>如何整体输出
    }
}
