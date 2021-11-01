/**
 * Created by dakshay on 09/10/2021.
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class ZigZagTraverse {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) {
            return result;
        }
        int level = 1;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> levels = new ArrayList<>();
            level++;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if(level%2!=0) {
                    levels.add(i, node.val);
                } else {
                    levels.add((queueSize-i-1),node.val);
                }
                levels.add(node.val);
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
                if(level%2==0) {
                    Collections.reverse(levels);
                }
            }
            result.add(levels);
        }
        return result;
    }
}
