import java.util.Scanner;

public class Main {
    //进阶面试题
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }
    }
    //根据先序遍历创建树，再得到中序遍历结果
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String intput = sc.next();
            TreeNode root = build(intput);
            inorder(root);
        }
    }

    //根据先序遍历创建树
    static int index = 0;
    public static TreeNode build(String str) {
        char c = str.charAt(index);
        if (c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = build(str);
        index++;
        root.right = build(str);
        return root;
    }

    //输出中序遍历结果
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+ " ");
        inorder(root.right);
    }
}
