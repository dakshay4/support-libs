package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dakshay on 26/10/2021.
 */


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

public class SumRootToLeaf {
    static int k= 8;
    static List<List<Integer>> res = new ArrayList<>();
    static int fun(TreeNode root, int val) {
        System.out.println("->"+root.val);
        if (root == null) return 0;
        val=(val)+root.val;

        if(val==k) return Integer.MAX_VALUE;
        if(root.left==null && root.right==null) {
            System.out.println("hello"+val);
            return val;
        }
        return fun(root.right,val) + fun(root.left,val);
    }
    public static int sumNumbers(TreeNode root) {
        return fun(root,0);
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode();l1.val=4;TreeNode r1 = new TreeNode();r1.val=5;
        TreeNode l = new TreeNode(2,l1,r1);
        TreeNode r = new TreeNode();r.val=3;
        TreeNode n = new TreeNode(1,l,r);
        System.out.println(sumNumbers(n));


    }
}

//                1
//            2       3
//        4       5
//
//val=0
//124 => 0*10+1 + 1*10 +2 +12*10 +4