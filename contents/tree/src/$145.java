import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
二叉树的后序遍历
 */
public class $145 {
    //递归
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

    //非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            //1.cur从根节点出发一直向左保存左子树，直到cur=null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //2.若栈为空，退出循环
            if (stack.isEmpty()) {
                break;
            }

            //3.得到栈顶元素，先不访问（满足条件才可以访问）
            TreeNode tmp = stack.peek();

            //4.若栈顶元素无右子树或者右子树已被访问，则可以访问
            //若prev==tmp.right，则tmp一定是其右子树的根节点。因为此时右子树已访问完毕
            if (tmp.right == null || tmp.right == prev) {
                stack.pop();
                res.add(tmp.val);
                prev = tmp;
            } else { //5.cur指向栈顶元素的右子树
                cur = tmp.right;
            }
        }
        return res;
    }
}
