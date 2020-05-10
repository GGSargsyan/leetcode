/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxSum = 0;
        int maxLevel = 1;
        int levelTracker = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            int levelSum = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode currNode = q.poll();
                levelSum += currNode.val;
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
            }
            if(maxSum < levelSum){
                maxSum = levelSum;
                maxLevel = levelTracker;
            }
            levelTracker++;
        }
        return maxLevel;
    }
}