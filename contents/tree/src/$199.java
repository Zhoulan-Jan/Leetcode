import java.util.*;

public class $199 {
    //深度优先搜索
    public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>(); //深度 -- 节点值
        int maxDepth = -1;
        Stack<TreeNode> nodeStack = new Stack<>(); //存放结点的栈
        Stack<Integer> depthStack = new Stack<>(); //存放深度的栈
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                if (!map.containsKey(depth)) {
                    map.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int depth = 0; depth <= maxDepth; depth++) {
            res.add(map.get(depth));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        root.left = two;
        root.right = three;
        two.left = four;
        four.right = seven;

        List<Integer> t = rightSideView(root);
        for (int i = 0; i < t.size(); i++) {
            System.out.print(t.get(i) + " ");
        }
    }
}
