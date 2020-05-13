/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(root == null)
            return results;
        
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0){
                Node curr = nodes.poll();
                if(curr.children.size()>0 || curr.children!=null){
                    for(Node n : curr.children){
                    nodes.add(n);
                    }
                }
                level.add(curr.val);
            }
            results.add(level);
        }
        
        return results; 
    }
}