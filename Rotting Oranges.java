class Solution {
    public int orangesRotting(int[][] grid) {
        
        Set<String> rotten = new HashSet<String>();
        Set<String> fresh  = new HashSet<String>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rotten.add("" + i + j);
                }
                else if(grid[i][j] == 1){
                    fresh.add("" + i + j);
                }
            }
        }
        
        int time = 0;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        
        while(fresh.size() > 0){
            Set<String> infected  = new HashSet<String>();
            for(String s : rotten){
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for(int[] direction : directions){
                    int newI = i + direction[0];
                    int newJ = j + direction[1];
                    if(fresh.contains("" + newI + newJ)){
                        infected.add("" + newI + newJ);
                        fresh.remove("" + newI + newJ);
                    }
                }
            }
            
            if(infected.size() == 0)
                return -1;
            time++;
            rotten = infected;
        }
        return time;
    }
}