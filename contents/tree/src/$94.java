import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class $94 {
    //递归
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


    //非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            //1.cur从根节点出发，一直向左保存左子树，直到cur=null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2.若栈为空，退出循环
            if (stack.isEmpty()) {
                break;
            }

            //3.出栈
            TreeNode tmp = stack.pop();
            res.add(tmp.val);

            //4.cur指向出栈元素的右子树，
            //若为空则继续出栈，若不为空再继续向左保存子树
            cur = tmp.right;
        }
        return res;
    }
}
