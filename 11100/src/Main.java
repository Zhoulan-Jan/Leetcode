import java.util.Scanner;



public class Main {
    //进阶面试题
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    //二叉树遍历
    //根据带空树的前序遍历构建二叉树，并输出中序遍历
    //多组输入
    public static int index = 0;
    //根据前序遍历得到的字符串建树
    public static TreeNode buildTree(String line) {
        index = 0;
        return  createTreePreOrder(line);
    }

    //使用辅助函数完成递归
    public static TreeNode createTreePreOrder(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }

    //输出中序遍历结果
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
           String str = sc.next();
           TreeNode root = buildTree(str);
            inorder(root);
        }
    }
}
