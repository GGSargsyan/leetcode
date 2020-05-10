class Solution {
    //Tarjan's Algorithm
    //Change the ListList to an adjacency list
    ArrayList<Integer>[] graph;
    List<List<Integer>> criticalConnections;
    boolean[] visited;
    int[] discovery;
    int[] lowTimes;
    int time;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        criticalConnections = new ArrayList<>();
        discovery = new int[n];
        lowTimes = new int[n];
        time = 0;
        //build adjacency list for our graph
        buildGraph(connections);
        visited = new boolean[n];
        //start at node 0
        dfs(visited, 0, -1);
        return criticalConnections;
    }
    
    private void dfs(boolean[] visited, int currNode, int parentNode){
        visited[currNode] = true;
        discovery[currNode] = time;
        lowTimes[currNode] = time;
        time++;
        
        for(int neighbor : graph[currNode]){
            if(neighbor == parentNode)
                continue;
            if(!visited[neighbor]){
                dfs(visited, neighbor, currNode);
                //Where Tarjan's Algo kicks in
                //Updates the lowTimes if a back edge was discovered
                lowTimes[currNode] = Math.min(lowTimes[currNode], lowTimes[neighbor]);
                if(discovery[currNode] < lowTimes[neighbor])
                    criticalConnections.add(Arrays.asList(currNode, neighbor));
            }
            else{//We found a back edge
                lowTimes[currNode] = Math.min(lowTimes[currNode], discovery[neighbor]);
            }
        }
    }
    
    private void buildGraph(List<List<Integer>> connections){
        for(int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Integer>();
        // [ ArrayList(1, 2) , ArrayList(0, 2, 3) , ArrayList(1, 0) , ArrayList(1) ]
        for(List<Integer> connection : connections){
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}