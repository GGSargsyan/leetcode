int timer = 0;
    int[] ids;
    int[] low;
    boolean[] visited;
    List<Integer> res;
    List<Integer>[] graph;

    Set<Integer> hs;
    int[] parent;
    private List<Integer> getCriticalNodes(List<List<Integer>> connections, int n) {
        hs = new HashSet<>();
        ids = new int[n];
        low = new int[n];
        visited = new boolean[n];
        res = new ArrayList<>();
        parent = new int[n];
        Arrays.fill(parent, -1);

        graph = new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                dfs(i, parent);
            }
        }
        for (Integer i : hs) {
            res.add(i);
        }
        return res;
    }

    private void dfs(int cur, int[] parent) {
        low[cur] = ids[cur] = timer++;
        visited[cur] = true;
        int children = 0;

        for(int to : graph[cur]) {
            if (to == parent[cur]) {
                continue;
            }
            if(visited[to] == false) {
                children++;
                parent[to] = cur;
                dfs(to, parent);
                low[cur] = Math.min(low[cur], low[to]);
                if (parent[cur] != -1) {
                    if (low[to] >= ids[cur] || children > 1) {
                        hs.add(cur);
                    }
                }
            } else {
                low[cur] = Math.min(low[cur], ids[to]);
            }
        }
    }