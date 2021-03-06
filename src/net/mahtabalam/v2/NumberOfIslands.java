package net.mahtabalam.v2;

public class NumberOfIslands {
	
	public static int numIslands(char[][] grid) {
        // To handle null or empty grid input
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int rows = grid.length;
        int columns = grid[0].length;
        int islands = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == '1'){
                	islands++;
                    traverseIsland(grid, i, j);
                }
            }
        }
        return islands;
        
    }
    
    public static void traverseIsland(char[][] grid, int row, int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||
                grid[row][column] == '0'){
            return;
        }
        //Setting the land to '0'
        grid[row][column] = '0';
    
        traverseIsland(grid, row, column+1); // right cell
        traverseIsland(grid, row, column-1); // left cell
        traverseIsland(grid, row+1, column); // top cell
        traverseIsland(grid, row-1, column); // bottom cell
        
        traverseIsland(grid, row-1, column+1); // diagonally : top-right cell
        traverseIsland(grid, row+1, column-1); // diagonally : bottom-left cell
        traverseIsland(grid, row+1, column+1); // diagonally : bottom-right cell
        traverseIsland(grid, row-1, column-1); // diagonally : top-left cell
        
    }

}
