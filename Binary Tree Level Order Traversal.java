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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> levels = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = nodes.poll();
                levels.add(curr.val);
                if(curr.left != null)
                    nodes.offer(curr.left);
                if(curr.right != null)
                    nodes.offer(curr.right);
            }
            result.add(levels);
        }
        return result;
    }
}