import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTree {
    //建树
    public void build(TreeNode root) {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
        root.right = two;
        two.left = three;
    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
            return result;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
            return result;
    }

    //相同的树  //值相同？
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //都是空树
        if (p == null && q == null) {
            return true;
        }
        //只有一个空树
        if (p == null || q == null) {
            return false;
        }
        //都不为空树
        //a)先比较根节点是否相同，不相同返回false
        //b)左子树 和 右子树递归比较
        if (p.val != q.val) {
            return false;  //相同返回true错误
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean res = false;
        //比较根节点是否相等，相等的话，比较s t是否为相同的树
        //不相等的话，比较s的左右子树是否包含t
        if (s.val == t.val) {
            res = isSameTree(s,t);
        }
        if (!res) {
            res = isSubtree(s.left,t);
        }
        if (!res) {
            res = isSubtree(s.right,t);
        }
        return res;
    }

    //求二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        //左右子树高度差值是否<=1
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return false;
        }
        //递归判定左右子树
        return isBalanced(root.left) && isBalanced(root.right);
    }

}
