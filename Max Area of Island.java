class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1)
					maxSize = Math.max(sink(grid, i, j), maxSize);
			}
		}
		return maxSize;
  }
	
	public int sink(int[][] matrix, int i, int j){
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0)
			return 0;
		
		matrix[i][j] = 0;
		int count = 1;
		count += sink(matrix, i+1, j);
		count += sink(matrix, i-1, j);
		count += sink(matrix, i, j+1);
		count += sink(matrix, i, j-1);
		return count;
    }
}