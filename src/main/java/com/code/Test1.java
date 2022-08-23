package com.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {

    @Test
    public void test() {


    }

    private List<List<Integer>> zigTravel(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queues = new LinkedList<>();
        queues.add(root);

        boolean isLeftToRight = true;

        while (!queues.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int leverSize = queues.size();
            for (int i = 0; i < leverSize; i++) {
                TreeNode node = queues.remove();
                if (isLeftToRight) {
                    tempList.add(node.val);
                } else {
                    tempList.add(0, node.val);
                }
                if (node.left != null) queues.add(node.left);
                if (node.right != null) queues.add(node.right);
            }
            res.add(tempList);
            isLeftToRight = !isLeftToRight;
        }

        return res;
    }
}
