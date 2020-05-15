/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            while(size > 0){
                
                Node curr = nodes.poll();
                //Code below is only change to BFS
                Node next = null;
                
                if(size != 1)
                    next = nodes.peek();
                
                curr.next = next; 
                //^^^^^^^^^^^^^^^^^^^^^^//
                if(curr.left != null)
                    nodes.add(curr.left);
                if(curr.right != null)
                    nodes.add(curr.right);
                size--;
            }
        }
        return root;
    }
}