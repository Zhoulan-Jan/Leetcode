import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class $102 {
    //递归
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left,level + 1);
        }
        if (root.right != null) {
            helper(root.right,level + 1);
        }
    }

    //非递归
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        //1.根节点入队列
        queue.offer(root);
        //2.队列不为空
        while (!queue.isEmpty()) {
            //2.1获取当前队列的元素
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //2.1.1出队列，需暂时保存出队元素
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                //2.1.2左右子树不为空的情况下，出队元素的左子树入队，右子树入队
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            //2.2当前队列元素加入到res中
            res.add(level);
        }
        return res;
    }
}
