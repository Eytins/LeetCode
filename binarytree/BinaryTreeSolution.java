import java.util.*;

public class BinaryTreeSolution {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(1);
        stack.addLast(2);
        stack.addLast(3);
        int v = stack.removeFirst();
        System.out.println(stack);
        System.out.println(v);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        List<Integer> list = new ArrayList<>();
    }


    class Solution {
        public List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            checkFun(root, 0);
            return resList;
        }

        public void checkFun(TreeNode node, Integer deep) {
            String s  = new String();
            s.getBytes();
            byte[] nums;
            Deque<TreeNode> queue = new LinkedList<>();
            if (node == null) {
                return;
            }
            deep++;
            if (resList.size() < deep) {
                List<Integer> item = new ArrayList<>();
                resList.add(item);
            }
            resList.get(deep - 1).add(node.val);
            checkFun(node.left, deep);
            checkFun(node.right, deep);
        }
    }
}
